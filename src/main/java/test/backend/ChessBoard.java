package test.backend;

import test.backend.piece.*;
import test.backend.strategy.normalstrategies.*;
import test.backend.strategy.Strategy;

public class ChessBoard {
    private GameMode gameMode;

    private Strategy rookStrategy;
    private Strategy pawnStrategy;
    private Strategy knightStrategy;
    private Strategy bishopStrategy;
    private Strategy queenStrategy;
    private Strategy kingStrategy;
    private final Piece[][] chessBoard;

    private PieceColor turn = PieceColor.WHITE;

    public ChessBoard(GameMode gameMode){
        this.gameMode = gameMode;
        updateGameMode(gameMode);
        chessBoard = createChessBoard();
    }
    private Piece[][] createChessBoard(){
        Piece[][] chessBoard = new Piece[8][8];
        for(int row = 0; row < 8; row++){
            for(int col = 0; col < 8; col++){
                if (row == 0 || row == 7 || row == 1 || row == 6) {
                    PieceColor pieceColor = (row < 2) ? PieceColor.BLACK : PieceColor.WHITE;
                    if (row == 0 || row == 7) {
                        switch (col) {
                            case 0, 7 -> chessBoard[row][col] = new Rook(rookStrategy,pieceColor,row,col,this);
                            case 1, 6 -> chessBoard[row][col] = new Knight(knightStrategy,pieceColor,row,col,this);
                            case 2, 5 -> chessBoard[row][col] = new Bishop(bishopStrategy,pieceColor,row,col,this);
                            case 3 -> chessBoard[row][col] = new Queen(queenStrategy,pieceColor,row,col,this);
                            case 4 -> chessBoard[row][col] = new King(kingStrategy,pieceColor,row,col,this);
                        }
                    } else {
                        chessBoard[row][col] = new Pawn(pawnStrategy,pieceColor,row,col,this);
                    }
                } else {
                    chessBoard[row][col] = null;
                }
            }
        }
        return chessBoard;
    }
    public void updateGameMode(GameMode gameMode){
        switch (gameMode){
            case NORMAL -> {
                pawnStrategy = new NormalPawnStrategy();
                bishopStrategy = new NormalBishopStrategy();
                knightStrategy = new NormalKnightStrategy();
                rookStrategy = new NormalRookStrategy();
                queenStrategy = new NormalQueenStrategy();
                kingStrategy = new NormalKingStrategy();
            }
        }
    }
    public void printChessBoard(){
        for(int row = 0; row < 8; row++){
            System.out.print("[");
            for(int col = 0; col < 8; col++){
                if(chessBoard[row][col] == null){
                    System.out.print(" -");
                }else {
                    System.out.print(" " + chessBoard[row][col].getLetter());

                }
            }
            System.out.println(" ]");
        }
        System.out.println();
    }
    public Piece[][] getChessBoard(){
        return chessBoard;
    }
    public void nextTurn(){
        turn = (turn.equals(PieceColor.WHITE)) ? PieceColor.BLACK : PieceColor.WHITE;
    }

    public PieceColor getTurn() {
        return turn;
    }
    public boolean move(int rowOriginalPiece, int colOriginalPiece, int rowNewPiece, int colNewPiece){
        if(chessBoard[rowOriginalPiece][colOriginalPiece] != null){
           return chessBoard[rowOriginalPiece][colOriginalPiece].move(rowNewPiece,colNewPiece);
        }
       return false;
    }
}
