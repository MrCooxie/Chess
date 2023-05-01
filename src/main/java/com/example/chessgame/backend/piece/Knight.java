package com.example.chessgame.backend.piece;

import com.example.chessgame.backend.ChessBoard;
import com.example.chessgame.backend.GameMode;
import com.example.chessgame.backend.MoveStrategy.Move;
import com.example.chessgame.backend.MoveStrategy.NormalKnightMoveStrategy;


import java.util.ArrayList;

public class Knight extends Piece {
    public Knight(PieceColor pieceColor, int row, int col, GameMode gameMode, ChessBoard chessBoard) {
        super(pieceColor, PieceType.KNIGHT, row, col, gameMode, chessBoard);
    }

    @Override
    public boolean move(int rowToMoveTo, int colToMoveTo) {
        return move(rowToMoveTo, colToMoveTo, this);

    }

    @Override
    public ArrayList<Move> getAllPossibleMoves() {
        switch (gameMode) {
            case NORMAL -> {
                return new NormalKnightMoveStrategy(chessBoard, this).getAllPossibleMoves();
            }
            default -> {
                return null;
            }
        }
    }
}
