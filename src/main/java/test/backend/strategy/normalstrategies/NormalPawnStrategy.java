package test.backend.strategy.normalstrategies;

import test.backend.ChessBoard;
import test.backend.piece.Pawn;
import test.backend.piece.Piece;
import test.backend.piece.PieceColor;
import test.backend.strategy.Move;
import test.backend.strategy.Strategy;
import test.backend.strategy.StrategyExtras;
import test.backend.strategy.eachpiecestrategy.PawnStrategy;

import java.util.ArrayList;

public class NormalPawnStrategy extends PawnStrategy implements StrategyExtras {
    @Override
    public ArrayList<Move> getPossibleMoves(Piece piece, ChessBoard chessBoardClass) {
        //TODO: Doesn't check whether after the move is it a check
        ArrayList<Move> allPossibleMoves = new ArrayList<>();
        if (isRightTurn(chessBoardClass.getTurn(), piece.getPieceColor()) && !chessBoardClass.isChecked()) {
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
            if (isInChessBoard(row + increment, col + 1) && !isEmpty(chessBoard[row + increment][col + 1]) && isOppositeColor(chessBoard[row + increment][col + 1].getPieceColor(), piece.getPieceColor())) {
                allPossibleMoves.add(new Move(row + increment, col + 1));
            }
            if (isInChessBoard(row + increment, col - 1) && !isEmpty(chessBoard[row + increment][col - 1]) && isOppositeColor(chessBoard[row + increment][col - 1].getPieceColor(), piece.getPieceColor())) {
                allPossibleMoves.add(new Move(row + increment, col - 1));
            }
        }
        return allPossibleMoves;
    }
    @Override
    public boolean move(Piece piece,ChessBoard chessBoard, int rowToMoveTo, int colToMoveTo) {
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
