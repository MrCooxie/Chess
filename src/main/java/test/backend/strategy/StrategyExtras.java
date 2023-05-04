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
    default boolean isOppositeColor(PieceColor pieceColor1, PieceColor pieceColor2){
        return !pieceColor1.equals(pieceColor2);
    }

    default boolean isRightTurn(PieceColor pieceColor1, PieceColor pieceColor2){
        return pieceColor1.equals(pieceColor2);
    }
}
