package com.example.chessgame.Backend.Piece;

import com.example.chessgame.Backend.ChessBoard;

import java.util.ArrayList;

public class Rook extends Piece implements Castleable{
    public Rook(PieceColor pieceColor, int row, int col){
        super(pieceColor, PieceType.ROOK,row,col);
    }

    @Override
    public ArrayList<int[]> getAllPossibleMoves(ChessBoard chessBoard) {
        return null;
    }

    @Override
    public boolean canCastle() {
        return false;
    }
}
