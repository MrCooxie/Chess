package test.backend.piece;

import test.backend.ChessBoard;
import test.backend.strategy.Move;
import test.backend.strategy.eachpiecestrategy.KingStrategy;

import java.util.ArrayList;

public class King extends Piece {

    public King(KingStrategy strategy, PieceColor pieceColor, int row, int col, ChessBoard chessBoard) {
        super(strategy, pieceColor, row, col, chessBoard);
    }

    @Override
    public boolean move(int rowToMoveTo, int colToMoveTo) {
        return strategy.move(this, chessBoard, rowToMoveTo, colToMoveTo);
    }

    @Override
    public ArrayList<Move> getAllPossibleMove() {
        return strategy.getPossibleMoves(this, chessBoard);
    }

    @Override
    public String getLetter() {
        return "K";
    }

}
