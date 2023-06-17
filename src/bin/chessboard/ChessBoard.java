package bin.chessboard;

import bin.piece.*;
import bin.strategy.AtomicStrategy;
import bin.strategy.NormalStrategy;
import bin.strategy.Strategy;

public class ChessBoard {
    private final Piece[][] chessBoard = createChessBoard();
    private final Strategy strategy;
    private PieceColor turn = PieceColor.WHITE;
    public ChessBoard(GameMode gameMode) {
        strategy = updateStrategy(gameMode);
    }
    private Piece[][] createChessBoard() {


        Piece[][] methodChessBoard = new Piece[8][8];
        for (int row = 0; row < 8; row++) {
            for (int col = 0; col < 8; col++) {
                if (row == 0 || row == 7) {
                    switch (col) {
                        case 0, 7 -> methodChessBoard[row][col] = new Rook(row, col, strategy, this);
                        case 1, 6 -> methodChessBoard[row][col] = new Knight(row, col, strategy, this);
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
        return methodChessBoard;
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
