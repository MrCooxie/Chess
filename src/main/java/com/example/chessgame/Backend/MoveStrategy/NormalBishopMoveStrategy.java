package com.example.chessgame.Backend.MoveStrategy;

import com.example.chessgame.Backend.ChessBoard;
import com.example.chessgame.Backend.Piece.Piece;

import java.util.ArrayList;

public class NormalBishopMoveStrategy extends NormalStrategy {
    public NormalBishopMoveStrategy(ChessBoard chessBoard, Piece piece) {
        super(chessBoard, piece);
    }

    @Override
    public ArrayList<Move> getAllPossibleMoves() {
        int squaresToGoUp = row;
        int squaresToGoDown = 7 - row;
        int squaresToGoLeft = col;
        int squaresToGoRight = 7 - col;
        return getAllPossibleMoves(Math.min(squaresToGoUp, squaresToGoLeft), 0, Math.min(squaresToGoUp, squaresToGoRight), 0, 0, Math.min(squaresToGoDown, squaresToGoLeft), 0, Math.min(squaresToGoDown, squaresToGoRight));


    }
}
