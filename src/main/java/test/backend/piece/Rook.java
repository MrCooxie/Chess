package test.backend.piece;

import test.backend.ChessBoard;
import test.backend.strategy.Move;
import test.backend.strategy.Strategy;
import test.backend.strategy.eachpiecestrategy.RookStrategy;

import java.util.ArrayList;

public class Rook extends Piece {

    public Rook(RookStrategy strategy, PieceColor pieceColor, int row, int col, ChessBoard chessBoard) {
        super(strategy, pieceColor, row, col, chessBoard);
    }

    @Override
    public boolean move(int rowToMoveTo, int colToMoveTo) {
        return strategy.move(this, chessBoard, rowToMoveTo,colToMoveTo);
    }
    @Override
    public ArrayList<Move> getAllPossibleMove() {
        return strategy.getPossibleMoves(this, chessBoard);
    }

    @Override
    public String getLetter() {
        return "R";
    }
}
