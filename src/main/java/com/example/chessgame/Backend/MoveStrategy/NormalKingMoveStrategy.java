/*
package com.example.chessgame.Backend.MoveStrategy;

import com.example.chessgame.Backend.ChessBoard;
import com.example.chessgame.Backend.Piece.Piece;

import java.util.ArrayList;

public class NormalKingMoveStrategy extends NormalStrategy {
    public NormalKingMoveStrategy(ChessBoard chessBoard, Piece piece) {
        super(chessBoard, piece);
    }

    @Override
    public ArrayList<Move> getAllPossibleMoves() {
        //TODO implement castle rights
        return (turn.equals(pieceColor)) ? getAllPossibleMoves(1, 1, 1, 1, 1, 1, 1, 1) : new ArrayList<>();
    }
}
*/
