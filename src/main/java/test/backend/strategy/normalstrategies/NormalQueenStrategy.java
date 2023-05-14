package test.backend.strategy.normalstrategies;

import test.backend.ChessBoard;
import test.backend.piece.Piece;
import test.backend.strategy.Move;
import test.backend.strategy.Strategy;
import test.backend.strategy.eachpiecestrategy.QueenStrategy;

import java.util.ArrayList;

public class NormalQueenStrategy extends QueenStrategy {


    @Override
    public ArrayList<Move> getPossibleMoves(Piece piece, ChessBoard chessBoardClass) {
        ArrayList<Move> allPossibleMoves = new ArrayList<>();
        allPossibleMoves.addAll(new NormalBishopStrategy().getPossibleMoves(piece, chessBoardClass));
        allPossibleMoves.addAll(new NormalRookStrategy().getPossibleMoves(piece, chessBoardClass));
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
