package Test.Backend.Piece;

import Test.Backend.ChessBoard;
import Test.Backend.Strategy.Move;
import Test.Backend.Strategy.Strategy;

import java.util.ArrayList;

public class Pawn extends Piece {

    public Pawn(Strategy strategy, PieceColor pieceColor, int row, int col, ChessBoard chessBoard){
       super(strategy,pieceColor,row,col, chessBoard);
    }



    @Override
    public ArrayList<Move> getAllPossibleMove() {
       return strategy.getPossibleMoves(this,chessBoard);
    }

    @Override
    public String getLetter() {
        return "P";
    }
}
