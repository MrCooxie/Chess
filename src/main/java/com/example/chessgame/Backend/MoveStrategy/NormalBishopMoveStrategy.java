package com.example.chessgame.Backend.MoveStrategy;

import com.example.chessgame.Backend.ChessBoard;
import com.example.chessgame.Backend.Piece.Piece;

import java.util.ArrayList;

public class NormalBishopMoveStrategy extends Strategy {
    public NormalBishopMoveStrategy(ChessBoard chessBoard, Piece piece) {
        super(chessBoard, piece);
    }

    @Override
    public ArrayList<Move> getAllPossibleMoves() {
        ArrayList<Move> allPossibleMoves = new ArrayList<>();
        boolean[] blockingPieces = new boolean[]{false, false, false, false};
        for (int i = 1; i < 8; i++) {
            getDiagonals(allPossibleMoves, blockingPieces, 0, row - i, col + i);// Top Left
            getDiagonals(allPossibleMoves, blockingPieces, 1, row - i, col - i);// Top right
            getDiagonals(allPossibleMoves, blockingPieces, 2, row + i, col + i);//Bot right
            getDiagonals(allPossibleMoves, blockingPieces, 3, row + i, col - i);//Bot left
        }
        return allPossibleMoves;
    }

    private void getDiagonals(ArrayList<Move> allPossibleMoves, boolean[] blockingPieces, int blockingPiecesIndex, int rowToCheck, int colToCheck) {
        if (!blockingPieces[blockingPiecesIndex]) {
            if (isInChessBoard(rowToCheck, colToCheck)) {
                Piece temp = chessBoard[rowToCheck][colToCheck];
                if (isEmpty(temp)) allPossibleMoves.add(new Move(temp.getRow(), temp.getCol()));
                if (!isEmpty(temp) && isOppositeColor(temp)) {
                    allPossibleMoves.add(new Move(temp.getRow(), temp.getCol()));
                    blockingPieces[blockingPiecesIndex] = true;
                }
                if (!isEmpty(temp) && !isOppositeColor(temp)) blockingPieces[blockingPiecesIndex] = true;

            } else {
                blockingPieces[blockingPiecesIndex] = true;
            }
        }
    }
}
