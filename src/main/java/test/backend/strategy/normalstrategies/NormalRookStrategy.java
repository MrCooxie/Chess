package test.backend.strategy.normalstrategies;

import test.backend.ChessBoard;
import test.backend.piece.Piece;
import test.backend.strategy.Move;
import test.backend.strategy.Strategy;
import test.backend.strategy.StrategyExtras;
import test.backend.strategy.eachpiecestrategy.RookStrategy;

import java.util.ArrayList;

public class NormalRookStrategy extends RookStrategy implements StrategyExtras {
    @Override
    public ArrayList<Move> getPossibleMoves(Piece piece, ChessBoard chessBoardClass) {
        ArrayList<Move> allPossibleMoves = new ArrayList<>();
        if (isRightTurn(chessBoardClass.getTurn(), piece.getPieceColor())) {
            boolean[] blockingPieces = new boolean[]{false, false, false, false};
            Piece[][] chessBoard = chessBoardClass.getChessBoard();
            for (int i = 1; i < 8; i++) {
                if (!blockingPieces[0]) { //Top
                    if (!isInChessBoard(piece.getRow() - i, piece.getCol())) {
                        blockingPieces[0] = true;
                    } else if (isEmpty(chessBoard[piece.getRow() - i][piece.getCol()])) {
                        allPossibleMoves.add(new Move(piece.getRow() - i, piece.getCol()));
                    } else if (isOppositeColor(piece.getPieceColor(), chessBoard[piece.getRow() - i][piece.getCol()].getPieceColor())) {
                        allPossibleMoves.add(new Move(piece.getRow() - i, piece.getCol()));
                        blockingPieces[0] = true;
                    } else {
                        blockingPieces[0] = true;
                    }
                }
                if (!blockingPieces[1]) { //Bot
                    if (!isInChessBoard(piece.getRow() + i, piece.getCol())) {
                        blockingPieces[1] = true;
                    } else if (isEmpty(chessBoard[piece.getRow() + i][piece.getCol()])) {
                        allPossibleMoves.add(new Move(piece.getRow() + i, piece.getCol()));
                    } else if (isOppositeColor(piece.getPieceColor(), chessBoard[piece.getRow() + i][piece.getCol()].getPieceColor())) {
                        allPossibleMoves.add(new Move(piece.getRow() + i, piece.getCol()));
                        blockingPieces[1] = true;
                    } else {
                        blockingPieces[1] = true;
                    }
                }
                if (!blockingPieces[2]) { //Left
                    if (!isInChessBoard(piece.getRow(), piece.getCol() - i)) {
                        blockingPieces[2] = true;
                    } else if (isEmpty(chessBoard[piece.getRow()][piece.getCol() - i])) {
                        allPossibleMoves.add(new Move(piece.getRow(), piece.getCol() - i));
                    } else if (isOppositeColor(piece.getPieceColor(), chessBoard[piece.getRow()][piece.getCol() - i].getPieceColor())) {
                        allPossibleMoves.add(new Move(piece.getRow(), piece.getCol() - i));
                        blockingPieces[2] = true;
                    } else {
                        blockingPieces[2] = true;
                    }
                }
                if (!blockingPieces[3]) { //Right
                    if (!isInChessBoard(piece.getRow(), piece.getCol() + i)) {
                        blockingPieces[3] = true;
                    } else if (isEmpty(chessBoard[piece.getRow()][piece.getCol() + i])) {
                        allPossibleMoves.add(new Move(piece.getRow(), piece.getCol() + i));
                    } else if (isOppositeColor(piece.getPieceColor(), chessBoard[piece.getRow()][piece.getCol() + i].getPieceColor())) {
                        allPossibleMoves.add(new Move(piece.getRow(), piece.getCol() + i));
                        blockingPieces[3] = true;
                    } else {
                        blockingPieces[3] = true;
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
