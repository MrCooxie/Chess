package test.backend.strategy;

import test.backend.piece.Piece;
import test.backend.piece.PieceColor;

public interface StrategyExtras {
    default boolean isEmpty(Piece piece){
        return piece == null;
    }
    default boolean isInChessBoard(int row, int col){
        return !(row < 0 || row > 7 || col < 0 || col > 7);
    }
    default boolean isOppositeColor(Piece pieceToCheck, PieceColor originalPieceColor){
        return !pieceToCheck.getPieceColor().equals(originalPieceColor);
    }
}
