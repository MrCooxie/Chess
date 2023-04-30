package Test.Backend.Strategy.NormalStrategies;

import Test.Backend.ChessBoard;
import Test.Backend.Piece.Piece;
import Test.Backend.Strategy.AngleCalculation;
import Test.Backend.Strategy.Move;
import Test.Backend.Strategy.Strategy;

import java.util.ArrayList;

public class NormalQueenStrategy extends Strategy implements AngleCalculation {


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
            return getAllPossibleMoves(Math.min(squaresToGoUp, squaresToGoLeft), squaresToGoUp, Math.min(squaresToGoUp, squaresToGoRight), squaresToGoLeft, squaresToGoRight, Math.min(squaresToGoDown, squaresToGoLeft), squaresToGoDown, Math.min(squaresToGoDown, squaresToGoRight), piece, chessBoard);

        }
        return new ArrayList<>();
    }
}
