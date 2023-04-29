package com.example.chessgame.Backend.Piece;

import com.example.chessgame.Backend.ChessBoard;

import java.util.ArrayList;

public class Knight extends Piece{
    public Knight(PieceColor pieceColor, int row, int col){
        super(pieceColor, PieceType.KNIGHT,row,col);
    }

    @Override
    public ArrayList<int[]> getAllPossibleMoves(ChessBoard chessBoard) {
        return null;
    }
}
