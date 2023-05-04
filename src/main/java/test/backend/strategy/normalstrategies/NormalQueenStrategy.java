package test.backend.strategy.normalstrategies;

import test.backend.ChessBoard;
import test.backend.piece.Piece;
import test.backend.strategy.Move;
import test.backend.strategy.Strategy;

import java.util.ArrayList;

public class NormalQueenStrategy extends Strategy {


    @Override
    public ArrayList<Move> getPossibleMoves(Piece piece, ChessBoard chessBoardClass) {
        ArrayList<Move> allPossibleMoves = new ArrayList<>();
        allPossibleMoves.addAll(new NormalBishopStrategy().getPossibleMoves(piece, chessBoardClass));
        allPossibleMoves.addAll(new NormalRookStrategy().getPossibleMoves(piece, chessBoardClass));
        return allPossibleMoves;
    }
}
