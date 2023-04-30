package Test.Backend.Strategy;

import Test.Backend.Piece.Piece;

import java.util.ArrayList;

public interface AngleCalculation extends StrategyExtras {
    default ArrayList<Move> getAllPossibleMoves(int topLeftAmount, int topAmount, int topRightAmount, int midLeftAmount, int midRightAmount, int botLeftAmount, int botAmount, int botRightAmount, Piece piece, Piece[][] chessBoard){
        boolean[] blockingPieces = new boolean[]{false, false, false, false, false, false, false, false};
        ArrayList<Move> allPossibleMoves = new ArrayList<>();
        for (int i = 1; i < topLeftAmount + 1; i++) { //Top Left
            allPossibleMoves.addAll(getMovesOnAngle(-1 * i, -1 * i, blockingPieces, 0,piece, chessBoard));
        }
        for (int i = 1; i < topAmount + 1; i++) {
            allPossibleMoves.addAll(getMovesOnAngle(-1 * i, 0, blockingPieces, 1, piece, chessBoard));
        }
        for (int i = 1; i < topRightAmount + 1; i++) {
            allPossibleMoves.addAll(getMovesOnAngle(-1 * i, i, blockingPieces, 2, piece, chessBoard));
        }
        for (int i = 1; i < midLeftAmount + 1; i++) {
            allPossibleMoves.addAll(getMovesOnAngle(0, -1 * i, blockingPieces, 3, piece, chessBoard));
        }
        for (int i = 1; i < midRightAmount + 1; i++) {
            allPossibleMoves.addAll(getMovesOnAngle(0, i, blockingPieces, 4,piece, chessBoard));
        }
        for (int i = 1; i < botLeftAmount + 1; i++) {
            allPossibleMoves.addAll(getMovesOnAngle(i, -1 * i, blockingPieces, 5, piece, chessBoard));
        }
        for (int i = 1; i < botAmount + 1; i++) {
            allPossibleMoves.addAll(getMovesOnAngle(i, 0, blockingPieces, 6, piece, chessBoard));
        }
        for (int i = 1; i < botRightAmount + 1; i++) {
            allPossibleMoves.addAll(getMovesOnAngle(i, i, blockingPieces, 7, piece, chessBoard));
        }
        return allPossibleMoves;
    }

    default ArrayList<Move> getMovesOnAngle(int rowIncrease, int colIncrease, boolean[] blockingPieces, int blockingPiecesIndex, Piece piece, Piece[][] chessBoard){
        ArrayList<Move> allPossibleMoves = new ArrayList<>();
        if (!blockingPieces[blockingPiecesIndex] && isInChessBoard(piece.getRow() + rowIncrease, piece.getCol() + colIncrease)) {
            int rowToCheck = piece.getRow() + rowIncrease;
            int colToCheck = piece.getCol() + colIncrease;
            if (isEmpty(chessBoard[rowToCheck][colToCheck])) {
                allPossibleMoves.add(new Move(rowToCheck, colToCheck));
            } else if (!isEmpty(chessBoard[rowToCheck][colToCheck]) && isOppositeColor(chessBoard[rowToCheck][colToCheck], piece.getPieceColor())) {
                allPossibleMoves.add(new Move(rowToCheck, colToCheck));
                blockingPieces[blockingPiecesIndex] = true;
            } else {
                blockingPieces[blockingPiecesIndex] = true;
            }
        }
        return allPossibleMoves;
    }
}
