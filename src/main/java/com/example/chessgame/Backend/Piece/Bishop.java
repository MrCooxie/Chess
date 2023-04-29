package com.example.chessgame.Backend.Piece;

import com.example.chessgame.Backend.ChessBoard;

import java.util.ArrayList;

public class Bishop extends Piece{
    public Bishop(PieceColor pieceColor, int row, int col){
        super(pieceColor, PieceType.BISHOP,row,col);
    }

    @Override
    public ArrayList<int[]> getAllPossibleMoves(ChessBoard chessBoard) {
        return null;
    }
}
