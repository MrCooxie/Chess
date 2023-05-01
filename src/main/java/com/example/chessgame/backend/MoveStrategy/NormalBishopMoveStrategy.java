package com.example.chessgame.backend.MoveStrategy;

import com.example.chessgame.backend.ChessBoard;
import com.example.chessgame.backend.piece.Piece;

import java.util.ArrayList;

public class NormalBishopMoveStrategy extends NormalStrategy {
    public NormalBishopMoveStrategy(ChessBoard chessBoard, Piece piece) {
        super(chessBoard, piece);
    }

    @Override
    public ArrayList<Move> getAllPossibleMoves() {
        if(turn.equals(pieceColor)) {
            int squaresToGoUp = row;
            int squaresToGoDown = 7 - row;
            int squaresToGoLeft = col;
            int squaresToGoRight = 7 - col;
            return getAllPossibleMoves(Math.min(squaresToGoUp, squaresToGoLeft), 0, Math.min(squaresToGoUp, squaresToGoRight), 0, 0, Math.min(squaresToGoDown, squaresToGoLeft), 0, Math.min(squaresToGoDown, squaresToGoRight));
        }
        return new ArrayList<>();
    }
}
