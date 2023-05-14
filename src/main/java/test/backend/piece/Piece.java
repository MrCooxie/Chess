package test.backend.piece;

import test.backend.ChessBoard;
import test.backend.strategy.Move;
import test.backend.strategy.Strategy;

import java.util.ArrayList;

public abstract class Piece {
    protected final PieceColor pieceColor;
    protected Strategy strategy;
    protected int row;
    protected int col;
    protected final ChessBoard chessBoard;
    protected boolean hasMoved = false;

    public Piece(Strategy strategy, PieceColor pieceColor, int row, int col, ChessBoard chessBoard) {
        this.pieceColor = pieceColor;
        this.strategy = strategy;
        this.row = row;
        this.col = col;
        this.chessBoard = chessBoard;
    }

    public abstract boolean move(int rowToMoveTo, int colToMoveTo);

    public abstract ArrayList<Move> getAllPossibleMove();

    public PieceColor getPieceColor() {
        return pieceColor;
    }

    public int getRow() {
        return row;
    }

    public int getCol() {
        return col;
    }

    public void setRow(int row) {
        this.row = row;
    }

    public void setCol(int col) {
        this.col = col;
    }

    public abstract String getLetter();

    public boolean hasMoved(){
        return hasMoved;
    }
    public void setHasMoved(boolean hasMoved){
        this.hasMoved = hasMoved;
    }

}
