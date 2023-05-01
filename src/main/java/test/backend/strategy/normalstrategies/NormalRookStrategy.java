package test.backend.strategy.normalstrategies;

import test.backend.ChessBoard;
import test.backend.piece.Piece;
import test.backend.strategy.AngleCalculation;
import test.backend.strategy.Move;
import test.backend.strategy.Strategy;

import java.util.ArrayList;

public class NormalRookStrategy extends Strategy implements AngleCalculation {
    @Override
    public ArrayList<Move> getPossibleMoves(Piece piece, ChessBoard chessBoardClass) {
        if (chessBoardClass.getTurn().equals(piece.getPieceColor())) {
            Piece[][] chessBoard = chessBoardClass.getChessBoard();
            int row = piece.getRow();
            int col = piece.getCol();
            int squaresToGoUp = row;
            int squaresToGoDown = 7 - row;
            int squaresToGoLeft = col;
            int squaresToGoRight = 7 - col;
            return getAllPossibleMoves(0, squaresToGoUp, 0, squaresToGoLeft, squaresToGoRight, 0, squaresToGoDown, 0, piece, chessBoard);
        }
        return new ArrayList<>();
    }
}
