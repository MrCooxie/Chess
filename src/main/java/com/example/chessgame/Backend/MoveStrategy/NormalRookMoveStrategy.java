package com.example.chessgame.Backend.MoveStrategy;

import com.example.chessgame.Backend.ChessBoard;
import com.example.chessgame.Backend.Piece.Piece;

import java.util.ArrayList;

public class NormalRookMoveStrategy extends NormalStrategy {
    public NormalRookMoveStrategy(ChessBoard chessBoard, Piece piece) {
        super(chessBoard, piece);
    }

    @Override
    public ArrayList<Move> getAllPossibleMoves() {
        int squaresToGoUp = row;
        int squaresToGoDown = 7 - row;
        int squaresToGoLeft = col;
        int squaresToGoRight = 7 - col;
        return getAllPossibleMoves(0,squaresToGoUp,0,squaresToGoLeft,squaresToGoRight,0,squaresToGoDown,0);

    }
}
