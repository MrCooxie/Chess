package com.example.chessgame.backend.piece;

import com.example.chessgame.backend.ChessBoard;
import com.example.chessgame.backend.GameMode;
import com.example.chessgame.backend.MoveStrategy.Move;
import com.example.chessgame.backend.MoveStrategy.NormalPawnMoveStrategy;

import java.util.ArrayList;

public class Pawn extends Piece {

    public Pawn(PieceColor pieceColor, int row, int col, GameMode gameMode, ChessBoard chessBoard) {
        super(pieceColor, PieceType.PAWN, row, col, gameMode, chessBoard);
    }

    @Override
    public boolean move(int rowToMoveTo, int colToMoveTo) {
        return move(rowToMoveTo, colToMoveTo, this);
    }

    @Override
    public ArrayList<Move> getAllPossibleMoves() {
        switch (gameMode) {
            case NORMAL -> {
                return new NormalPawnMoveStrategy(chessBoard, this).getAllPossibleMoves();
            }
            default -> {
                return null;
            }
        }
    }
}
