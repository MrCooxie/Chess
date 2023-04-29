package com.example.chessgame.Backend.Piece;

import com.example.chessgame.Backend.ChessBoard;

import java.util.ArrayList;

public class Queen extends Piece{
    public Queen(PieceColor pieceColor, int row, int col){
        super(pieceColor, PieceType.QUEEN,row,col);
    }
    @Override
    public ArrayList<int[]> getAllPossibleMoves(ChessBoard chessBoard) {
        return null;
    }
}
