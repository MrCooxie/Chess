package com.example.chessgame.backend.MoveStrategy;

import com.example.chessgame.backend.ChessBoard;
import com.example.chessgame.backend.piece.Piece;

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
