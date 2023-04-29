package com.example.chessgame.Backend.MoveStrategy;

import com.example.chessgame.Backend.ChessBoard;
import com.example.chessgame.Backend.Piece.Piece;

import java.util.ArrayList;

public class NormalKnightMoveStrategy extends Strategy {

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
                if (isInChessBoard(move.row(), move.col()) && (isEmpty(chessBoard[move.row()][move.col()]) || isOppositeColor(chessBoard[move.row()][move.col()]))) {
                    allPossibleMoves.add(move);
                }
            }
        }
        return allPossibleMoves;
    }
}