package test.backend.strategy.normalstrategies;

import test.backend.ChessBoard;
import test.backend.piece.Piece;
import test.backend.strategy.Move;
import test.backend.strategy.Strategy;
import test.backend.strategy.StrategyExtras;
import test.backend.strategy.eachpiecestrategy.KnightStrategy;

import java.util.ArrayList;

public class NormalKnightStrategy extends KnightStrategy implements StrategyExtras {
    @Override
    public ArrayList<Move> getPossibleMoves(Piece piece, ChessBoard chessBoardClass) {
        ArrayList<Move> allPossibleMoves = new ArrayList<>();
        if (isRightTurn(chessBoardClass.getTurn(), piece.getPieceColor())) {
            Piece[][] chessBoard = chessBoardClass.getChessBoard();

            int row = piece.getRow();
            int col = piece.getCol();
            Move[] moves = new Move[]{new Move(row - 2, col - 1), new Move(row - 2, col + 1), new Move(row + 2, col - 1), new Move(row + 2, col + 1),
                    new Move(row - 1, col - 2), new Move(row + 1, col - 2), new Move(row - 1, col + 2), new Move(row + 1, col + 2)};
            for (Move move : moves) {
                if (isInChessBoard(move.row(), move.col()) && (isEmpty(chessBoard[move.row()][move.col()]) || (!isEmpty(chessBoard[move.row()][move.col()]) && isOppositeColor(chessBoard[move.row()][move.col()].getPieceColor(), piece.getPieceColor())))) {
                    allPossibleMoves.add(move);
                }
            }
        }
        return allPossibleMoves;
    }

    @Override
    public boolean move(Piece piece, ChessBoard chessBoard, int rowToMoveTo, int colToMoveTo) {
        ArrayList<Move> allPossibleMoves = piece.getAllPossibleMove();
        for(Move move : allPossibleMoves){
            if(move.row() == rowToMoveTo && move.col() == colToMoveTo){
                piece.setHasMoved(true);
                chessBoard.getChessBoard()[piece.getRow()][piece.getCol()] = null;
                piece.setRow(rowToMoveTo);
                piece.setCol(colToMoveTo);
                chessBoard.getChessBoard()[rowToMoveTo][colToMoveTo] = piece;
                chessBoard.nextTurn();
                return true;
            }
        }
        return false;
    }
}
