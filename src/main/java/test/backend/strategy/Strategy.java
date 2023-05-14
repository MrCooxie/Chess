package test.backend.strategy;

import test.backend.ChessBoard;
import test.backend.piece.Piece;

import java.util.ArrayList;

public abstract class Strategy {
    public abstract ArrayList<Move> getPossibleMoves(Piece piece, ChessBoard chessBoardClass);
     public abstract boolean move(Piece piece, ChessBoard chessBoard, int rowToMoveTo,int colToMoveTo);

}
