package test.backend.strategy.normalstrategies;

import test.backend.ChessBoard;
import test.backend.piece.Piece;
import test.backend.strategy.Move;
import test.backend.strategy.Strategy;
import test.backend.strategy.StrategyExtras;

import java.util.ArrayList;

public class NormalKingStrategy extends Strategy implements StrategyExtras {

    @Override
    public ArrayList<Move> getPossibleMoves(Piece piece, ChessBoard chessBoardClass) {
        ArrayList<Move> allPossibleMoves = new ArrayList<>();
        if (isRightTurn(chessBoardClass.getTurn(), piece.getPieceColor())) {
            Piece[][] chessBoard = chessBoardClass.getChessBoard();
            int row = piece.getRow();
            int col = piece.getCol();
            Move[] moves = new Move[]{new Move(row - 1, col - 1), new Move(row - 1, col), new Move(row - 1, col + 1),
                    new Move(row, col - 1), new Move(row, col + 1), new Move(row + 1, col - 1), new Move(row + 1, col), new Move(row + 1, col + 1)};
            for (Move move : moves) {
                if (isInChessBoard(move.row(), move.col()) && (isEmpty(chessBoard[move.row()][move.col()]) || isOppositeColor(piece.getPieceColor(), chessBoard[move.row()][move.col()].getPieceColor()))) {
                    allPossibleMoves.add(move);
                }
            }

        }
        return allPossibleMoves;
    }
}
