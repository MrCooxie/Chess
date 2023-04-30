package Test.Backend.Strategy.NormalStrategies;

import Test.Backend.ChessBoard;
import Test.Backend.Piece.Piece;
import Test.Backend.Piece.PieceColor;
import Test.Backend.Strategy.Move;
import Test.Backend.Strategy.Strategy;
import Test.Backend.Strategy.StrategyExtras;

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
