package test.backend.strategy.normalstrategies;

import test.backend.ChessBoard;
import test.backend.piece.King;
import test.backend.piece.Piece;
import test.backend.piece.Rook;
import test.backend.strategy.Move;
import test.backend.strategy.Strategy;
import test.backend.strategy.StrategyExtras;
import test.backend.strategy.eachpiecestrategy.KingStrategy;

import java.util.ArrayList;

public class NormalKingStrategy extends KingStrategy implements StrategyExtras {

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
            if (!piece.hasMoved()) {
                if (chessBoard[row][0] instanceof Rook) {
                    if (!chessBoard[row][0].hasMoved()) {
                        if (isEmpty(chessBoard[row][1]) && isEmpty(chessBoard[row][2]) && isEmpty(chessBoard[row][3])) {
                            Move move = new Move(row, 2);
                            move.setSpecial(true);
                            allPossibleMoves.add(move);
                        }
                    }
                }
                if (chessBoard[row][7] instanceof Rook) {
                    if (!chessBoard[row][7].hasMoved()) {
                        if (isEmpty(chessBoard[row][5]) && isEmpty(chessBoard[row][6])) {
                            Move move = new Move(row, 6);
                            move.setSpecial(true);
                            allPossibleMoves.add(move);
                        }
                    }
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

