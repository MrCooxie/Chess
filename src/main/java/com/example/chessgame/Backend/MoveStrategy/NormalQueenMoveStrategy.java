package com.example.chessgame.Backend.MoveStrategy;

import com.example.chessgame.Backend.ChessBoard;
import com.example.chessgame.Backend.Piece.Piece;

import java.util.ArrayList;

public class NormalQueenMoveStrategy extends NormalStrategy {


    public NormalQueenMoveStrategy(ChessBoard chessBoard, Piece piece) {
        super(chessBoard, piece);
    }

    @Override
    public ArrayList<Move> getAllPossibleMoves() {
        int squaresToGoUp = row;
        int squaresToGoDown = 7 - row;
        int squaresToGoLeft = col;
        int squaresToGoRight = 7 - col;
        return getAllPossibleMoves(Math.min(squaresToGoUp,squaresToGoLeft),squaresToGoUp,Math.min(squaresToGoUp,squaresToGoRight),squaresToGoLeft,squaresToGoRight,Math.min(squaresToGoDown,squaresToGoLeft),squaresToGoDown,Math.min(squaresToGoDown,squaresToGoRight));
    }
}
