/*
package com.example.chessgame.Backend.Piece;

import com.example.chessgame.Backend.ChessBoard;
import com.example.chessgame.Backend.GameMode;
import com.example.chessgame.Backend.MoveStrategy.Move;
import com.example.chessgame.Backend.MoveStrategy.NormalPawnMoveStrategy;

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
*/
