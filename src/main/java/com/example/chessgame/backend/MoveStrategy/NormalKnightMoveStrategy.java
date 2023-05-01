package com.example.chessgame.backend.MoveStrategy;

import com.example.chessgame.backend.ChessBoard;
import com.example.chessgame.backend.piece.Piece;

import java.util.ArrayList;

public class NormalKnightMoveStrategy extends NormalStrategy {

    public NormalKnightMoveStrategy(ChessBoard chessBoard, Piece piece) {
        super(chessBoard, piece);
    }

    @Override
    public ArrayList<Move> getAllPossibleMoves() {
        ArrayList<Move> allPossibleMoves = new ArrayList<>();
        if (turn.equals(pieceColor)) {
            Move[] moves = new Move[]{
                    new Move(row + 2, col - 1), new Move(row + 2, col + 1),
                    new Move(row - 2, col - 1), new Move(row - 2, col + 1),
                    new Move(row + 1, col - 2), new Move(row - 1, col - 2),
                    new Move(row + 1, col + 2), new Move(row - 1, col + 2)
            };
            for (Move move : moves) {
                if (isLegalMove(move.row(), move.col()) || (isInChessBoard(move.row(), move.col()) && isEmpty(chessBoard[move.row()][move.col()]))) {
                    allPossibleMoves.add(move);
                }
            }
        }
        return allPossibleMoves;
    }
}
