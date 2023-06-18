package bin.chessboard;

import bin.piece.*;
import bin.strategy.AtomicStrategy;
import bin.strategy.NormalStrategy;
import bin.strategy.Strategy;

public class ChessBoard {
    private final Piece[][] chessBoard = new Piece[8][8];
    private PieceColor turn;
    private final Strategy strategy;
    public ChessBoard(GameMode gameMode) {
        strategy = updateStrategy(gameMode);
        turn = PieceColor.WHITE;
        createChessBoard(chessBoard);
    }
    private void createChessBoard(Piece[][] methodChessBoard) {
        for (int row = 0; row < 8; row++) {
            for (int col = 0; col < 8; col++) {
                if (row == 0 || row == 7) {
                    switch (col) {
                        case 0, 7 -> methodChessBoard[row][col] = new Rook(row, col, strategy, this);
                        case 1, 6 -> methodChessBoard[row][col] = new Knight(row, col, strategy,this);
                        case 2, 5 -> methodChessBoard[row][col] = new Bishop(row, col, strategy, this);
                        case 3 -> methodChessBoard[row][col] = new Queen(row, col, strategy, this);
                        case 4 -> methodChessBoard[row][col] = new King(row, col, strategy, this);
                    }
                } else if (row == 1 || row == 6) {
                    methodChessBoard[row][col] = new Pawn(row, col, strategy, this);
                } else {
                    methodChessBoard[row][col] = null;
                }
            }
        }
    }

    private Strategy updateStrategy(GameMode gameMode) {
        switch (gameMode) {
            case NORMAL -> {
                return new NormalStrategy();
            }
            case ATOMIC -> {
                return new AtomicStrategy();
            }
        }
        throw new RuntimeException();
    }
    public void printChessBoard(){
        for(int row = 0; row < 8; row++){
            System.out.print("[");
            for(int col = 0; col < 8; col++){
                if(chessBoard[row][col] == null){
                    System.out.print("-, ");
                } else {
                    System.out.print(chessBoard[row][col].getLetter() + ", ");
                }
            }
            System.out.print("]\n");
        }
        System.out.println();
    }
    public void move(int row1, int col1, int row2, int col2){
        chessBoard[row1][col1].move(row2,col2);
    }

    public PieceColor getTurn() {
        return turn;
    }

    public Piece[][] getChessBoard() {
        return chessBoard;
    }
    public void nextTurn(){
        turn = (turn.equals(PieceColor.WHITE)) ? PieceColor.BLACK : PieceColor.WHITE;
    }


}
