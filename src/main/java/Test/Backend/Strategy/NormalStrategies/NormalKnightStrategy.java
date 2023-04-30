package Test.Backend.Strategy.NormalStrategies;

import Test.Backend.ChessBoard;
import Test.Backend.Piece.Piece;
import Test.Backend.Strategy.Move;
import Test.Backend.Strategy.Strategy;
import Test.Backend.Strategy.StrategyExtras;

import java.util.ArrayList;

public class NormalKnightStrategy extends Strategy implements StrategyExtras {
    @Override
    public ArrayList<Move> getPossibleMoves(Piece piece, ChessBoard chessBoardClass) {
        ArrayList<Move> allPossibleMoves = new ArrayList<>();
        if(chessBoardClass.getTurn().equals(piece.getPieceColor())) {
            Piece[][] chessBoard = chessBoardClass.getChessBoard();

            int row = piece.getRow();
            int col = piece.getCol();
            Move[] moves = new Move[]{new Move(row - 2, col - 1), new Move(row - 2, col + 1), new Move(row + 2, col - 1), new Move(row + 2, col + 1),
                    new Move(row - 1, col - 2), new Move(row + 1, col - 2), new Move(row - 1, col + 2), new Move(row + 1, col + 2)};
            for (Move move : moves) {
                if (isInChessBoard(move.row(), move.col()) && (isEmpty(chessBoard[move.row()][move.col()]) || (!isEmpty(chessBoard[move.row()][move.col()]) && isOppositeColor(chessBoard[move.row()][move.col()], piece.getPieceColor())))) {
                    allPossibleMoves.add(move);
                }
            }
        }
        return allPossibleMoves;
    }
}
