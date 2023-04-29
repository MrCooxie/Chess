package com.example.chessgame.Frontend;

import com.example.chessgame.Backend.ChessBoard;
import com.example.chessgame.Backend.Piece.Piece;


public class Test {
    public static void main(String[] args) {
        ChessBoard chessboard = new ChessBoard();
        Piece piece = chessboard.getChessBoard()[6][4];
        System.out.println(piece.move(5,4,chessboard));
        chessboard.printChessBoard();


    }
}
