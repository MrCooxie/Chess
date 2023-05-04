package test.backend.strategy.normalstrategies;

import test.backend.ChessBoard;
import test.backend.piece.Piece;
import test.backend.strategy.Move;
import test.backend.strategy.Strategy;
import test.backend.strategy.StrategyExtras;

import java.util.ArrayList;

public class NormalBishopStrategy extends Strategy implements StrategyExtras {
    @Override
    public ArrayList<Move> getPossibleMoves(Piece piece, ChessBoard chessBoardClass) {
        ArrayList<Move> allPossibleMoves = new ArrayList<>();
        if (isRightTurn(chessBoardClass.getTurn(), piece.getPieceColor())) {
            Piece[][] chessBoard = chessBoardClass.getChessBoard();
            boolean[] blockingPieces = new boolean[]{false, false, false, false};
            for (int i = 1; i < 8; i++) {
                if (!blockingPieces[0]) {//Top left
                    if (!isInChessBoard(piece.getRow() - i, piece.getCol() - i)) {
                        blockingPieces[0] = true;
                    } else if (isEmpty(chessBoard[piece.getRow() - i][piece.getCol() - i])) {
                        allPossibleMoves.add(new Move(piece.getRow() - i, piece.getCol() - i));
                    } else if (isOppositeColor(piece.getPieceColor(), chessBoard[piece.getRow() - i][piece.getCol() - i].getPieceColor())) {
                        blockingPieces[0] = true;
                        allPossibleMoves.add(new Move(piece.getRow() - i, piece.getCol() - i));
                    } else {
                        blockingPieces[0] = true;
                    }
                }
                if (!blockingPieces[1]) { //Bot right
                    if (!isInChessBoard(piece.getRow() + i, piece.getCol() + i)) {
                        blockingPieces[1] = true;
                    } else if (isEmpty(chessBoard[piece.getRow() + i][piece.getCol() + i])) {
                        allPossibleMoves.add(new Move(piece.getRow() + i, piece.getCol() + i));
                    } else if (isOppositeColor(piece.getPieceColor(), chessBoard[piece.getRow() + i][piece.getCol() + i].getPieceColor())) {
                        blockingPieces[1] = true;
                        allPossibleMoves.add(new Move(piece.getRow() + i, piece.getCol() + i));
                    } else {
                        blockingPieces[1] = true;
                    }
                }
                if (!blockingPieces[2]) { //Top right
                    if (!isInChessBoard(piece.getRow() - i, piece.getCol() + i)) {
                        blockingPieces[2] = true;
                    } else if (isEmpty(chessBoard[piece.getRow() - i][piece.getCol() + i])) {
                        allPossibleMoves.add(new Move(piece.getRow() - i, piece.getCol() + i));
                    } else if (isOppositeColor(piece.getPieceColor(), chessBoard[piece.getRow() - i][piece.getCol() + i].getPieceColor())) {
                        blockingPieces[2] = true;
                        allPossibleMoves.add(new Move(piece.getRow() - i, piece.getCol() + i));
                    } else {
                        blockingPieces[2] = true;
                    }
                }
                if (!blockingPieces[3]) { //Bot left
                    if (!isInChessBoard(piece.getRow() + i, piece.getCol() - i)) {
                        blockingPieces[3] = true;
                    } else if (isEmpty(chessBoard[piece.getRow() + i][piece.getCol() - i])) {
                        allPossibleMoves.add(new Move(piece.getRow() + i, piece.getCol() - i));
                    } else if (isOppositeColor(piece.getPieceColor(), chessBoard[piece.getRow() + i][piece.getCol() - i].getPieceColor())) {
                        blockingPieces[3] = true;
                        allPossibleMoves.add(new Move(piece.getRow() + i, piece.getCol() - i));
                    } else {
                        blockingPieces[3] = true;
                    }
                }
            }
        }
        return allPossibleMoves;
    }
}

