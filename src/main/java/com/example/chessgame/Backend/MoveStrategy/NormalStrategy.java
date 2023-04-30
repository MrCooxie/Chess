package com.example.chessgame.Backend.MoveStrategy;

import com.example.chessgame.Backend.ChessBoard;
import com.example.chessgame.Backend.Piece.Piece;
import com.example.chessgame.Backend.Piece.PieceColor;

import java.util.ArrayList;

public abstract class NormalStrategy {
    protected final int row;
    protected final int col;
    protected final Piece[][] chessBoard;
    protected final PieceColor pieceColor;
    protected PieceColor turn;

    public NormalStrategy(ChessBoard chessBoard, Piece piece) {
        this.chessBoard = chessBoard.getChessBoard();
        turn = chessBoard.getTurn();
        row = piece.getRow();
        col = piece.getCol();
        pieceColor = piece.getPieceColor();
    }

    public abstract ArrayList<Move> getAllPossibleMoves();

    protected ArrayList<Move> getAllPossibleMoves(int topLeftAmount, int topAmount, int topRightAmount, int midLeftAmount, int midRightAmount, int botLeftAmount, int botAmount, int botRightAmount) {
        boolean[] blockingPieces = new boolean[]{false, false, false, false, false, false, false, false};
        ArrayList<Move> allPossibleMoves = new ArrayList<>();
        for (int i = 1; i < topLeftAmount + 1; i++) { //Top Left
            allPossibleMoves.addAll(getMovesOnAngle(-1 * i, -1 * i, blockingPieces, 0));
        }
        for (int i = 1; i < topAmount + 1; i++) {
            allPossibleMoves.addAll(getMovesOnAngle(-1 * i, 0, blockingPieces, 1));
        }
        for (int i = 1; i < topRightAmount + 1; i++) {
            allPossibleMoves.addAll(getMovesOnAngle(-1 * i, i, blockingPieces, 2));
        }
        for (int i = 1; i < midLeftAmount + 1; i++) {
            allPossibleMoves.addAll(getMovesOnAngle(0, -1 * i, blockingPieces, 3));
        }
        for (int i = 1; i < midRightAmount + 1; i++) {
            allPossibleMoves.addAll(getMovesOnAngle(0, i, blockingPieces, 4));
        }
        for (int i = 1; i < botLeftAmount + 1; i++) {
            allPossibleMoves.addAll(getMovesOnAngle(i, -1 * i, blockingPieces, 5));
        }
        for (int i = 1; i < botAmount + 1; i++) {
            allPossibleMoves.addAll(getMovesOnAngle(i, 0, blockingPieces, 6));
        }
        for (int i = 1; i < botRightAmount + 1; i++) {
            allPossibleMoves.addAll(getMovesOnAngle(i, i, blockingPieces, 7));
        }
        return allPossibleMoves;
    }

    private ArrayList<Move> getMovesOnAngle(int rowIncrease, int colIncrease, boolean[] blockingPieces, int blockingPiecesIndex) {
        ArrayList<Move> allPossibleMoves = new ArrayList<>();
        if (!blockingPieces[blockingPiecesIndex]) {
            int rowToCheck = row + rowIncrease;
            int colToCheck = col + colIncrease;
            if (isEmpty(chessBoard[rowToCheck][colToCheck])) {
                allPossibleMoves.add(new Move(rowToCheck, colToCheck));
            } else if (isLegalMove(rowToCheck, colToCheck)) {
                allPossibleMoves.add(new Move(rowToCheck, colToCheck));
                blockingPieces[blockingPiecesIndex] = true;
            } else {
                blockingPieces[blockingPiecesIndex] = true;
            }
        }
        return allPossibleMoves;
    }

    protected boolean isEmpty(Piece piece) {
        return piece == null;
    }

    protected boolean isOppositeColor(Piece piece) {
        return !piece.getPieceColor().equals(pieceColor);
    }

    protected boolean isInChessBoard(int row, int col) {
        return !(row < 0 || row > 7 || col < 0 || col > 7);
    }

    protected boolean isLegalMove(int row, int col) {
        return (isInChessBoard(row, col) && !isEmpty(chessBoard[row][col]) && isOppositeColor(chessBoard[row][col]));
    }
}
