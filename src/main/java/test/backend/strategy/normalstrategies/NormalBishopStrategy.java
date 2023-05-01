package test.backend.strategy.normalstrategies;

import test.backend.ChessBoard;
import test.backend.piece.Piece;
import test.backend.strategy.AngleCalculation;
import test.backend.strategy.Move;
import test.backend.strategy.Strategy;

import java.util.ArrayList;

public class NormalBishopStrategy extends Strategy implements AngleCalculation {
    @Override
    public ArrayList<Move> getPossibleMoves(Piece piece, ChessBoard chessBoardClass) {
        if(chessBoardClass.getTurn().equals(piece.getPieceColor())) {
            Piece[][] chessBoard = chessBoardClass.getChessBoard();
            int row = piece.getRow();
            int col = piece.getCol();
            int squaresToGoUp = row;
            int squaresToGoDown = 7 - row;
            int squaresToGoLeft = col;
            int squaresToGoRight = 7 - col;
            return getAllPossibleMoves(Math.min(squaresToGoUp, squaresToGoLeft), 0, Math.min(squaresToGoUp, squaresToGoRight), 0, 0, Math.min(squaresToGoDown, squaresToGoLeft), 0, Math.min(squaresToGoDown, squaresToGoRight), piece, chessBoard);

        }
        return new ArrayList<>();
    }
}
