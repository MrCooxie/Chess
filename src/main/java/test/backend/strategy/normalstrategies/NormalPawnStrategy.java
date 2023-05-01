package test.backend.strategy.normalstrategies;

import test.backend.ChessBoard;
import test.backend.piece.Piece;
import test.backend.piece.PieceColor;
import test.backend.strategy.Move;
import test.backend.strategy.Strategy;
import test.backend.strategy.StrategyExtras;

import java.util.ArrayList;

public class NormalPawnStrategy extends Strategy implements StrategyExtras {

    @Override
    public ArrayList<Move> getPossibleMoves(Piece piece, ChessBoard chessBoardClass) {
        ArrayList<Move> allPossibleMoves = new ArrayList<>();
        if(chessBoardClass.getTurn().equals(piece.getPieceColor())) {
            Piece[][] chessBoard = chessBoardClass.getChessBoard();
            int increment = (piece.getPieceColor().equals(PieceColor.WHITE)) ? -1 : 1;
            int row = piece.getRow();
            int col = piece.getCol();

            if (isInChessBoard(row + increment, col) && isEmpty(chessBoard[row + increment][col])) {
                allPossibleMoves.add(new Move(row + increment, col));
                if (isInChessBoard(row + 2 * increment, col) && isEmpty(chessBoard[row + 2 * increment][col])) {
                    allPossibleMoves.add(new Move(row + 2 * increment, col));
                }
            }
            if (isInChessBoard(row + increment, col + 1) && !isEmpty(chessBoard[row + increment][col + 1]) && isOppositeColor(chessBoard[row + increment][col + 1], piece.getPieceColor())) {
                allPossibleMoves.add(new Move(row + increment, col + 1));
            }
            if (isInChessBoard(row + increment, col - 1) && !isEmpty(chessBoard[row + increment][col - 1]) && isOppositeColor(chessBoard[row + increment][col - 1], piece.getPieceColor())) {
                allPossibleMoves.add(new Move(row + increment, col - 1));
            }
        }
        return allPossibleMoves;
    }
}
