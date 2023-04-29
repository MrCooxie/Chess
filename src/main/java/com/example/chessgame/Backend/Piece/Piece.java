package com.example.chessgame.Backend.Piece;

import com.example.chessgame.Backend.ChessBoard;
import com.example.chessgame.Backend.MoveStrategy.Move;

import java.util.ArrayList;

public abstract class Piece {
    protected final PieceColor pieceColor;
    protected final PieceType pieceType;
    protected final int row;
    protected final int col;

    public Piece(PieceColor pieceColor, PieceType pieceType, int row, int col){
        this.pieceColor = pieceColor;
        this.pieceType = pieceType;
        this.row = row;
        this.col = col;
    }
    public abstract ArrayList<Move> getAllPossibleMoves(ChessBoard chessBoard);

    public PieceColor getPieceColor() {
        return pieceColor;
    }

    public PieceType getPieceType() {
        return pieceType;
    }

    public int getRow() {
        return row;
    }

    public int getCol() {
        return col;
    }
}
