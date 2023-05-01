package com.example.chessgame.backend.piece;

import com.example.chessgame.backend.ChessBoard;
import com.example.chessgame.backend.GameMode;
import com.example.chessgame.backend.MoveStrategy.Move;
import com.example.chessgame.backend.MoveStrategy.NormalKingMoveStrategy;

import java.util.ArrayList;

public class King extends Piece {
    public King(PieceColor pieceColor, int row, int col, GameMode gameMode, ChessBoard chessBoard) {
        super(pieceColor, PieceType.KING, row, col, gameMode, chessBoard);
    }

    @Override
    public boolean move(int rowToMoveTo, int colToMoveTo) {
        return move(rowToMoveTo, colToMoveTo, this);

    }

    @Override
    public ArrayList<Move> getAllPossibleMoves() {
        switch (gameMode) {
            case NORMAL -> {
                return new NormalKingMoveStrategy(chessBoard, this).getAllPossibleMoves();
            }
            default -> {
                return null;
            }
        }
    }
}
