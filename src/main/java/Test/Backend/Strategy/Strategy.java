package Test.Backend.Strategy;

import Test.Backend.ChessBoard;
import Test.Backend.Piece.Piece;

import java.util.ArrayList;

public abstract class Strategy {
    public abstract ArrayList<Move> getPossibleMoves(Piece piece, ChessBoard chessBoardClass);

}
