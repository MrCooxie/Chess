package com.example.chessgame.Frontend;

import com.example.chessgame.Backend.ChessBoard;
import com.example.chessgame.Backend.GameMode;


public class Test {
    public static void main(String[] args) {
        ChessBoard chessboard = new ChessBoard(GameMode.NORMAL);
        chessboard.printChessBoard();
        chessboard.move(6,4,5,4);
        chessboard.printChessBoard();
        System.out.println(chessboard.getChessBoard()[0][1]);
        chessboard.move(0,1,2,2);
        chessboard.printChessBoard();

    }
}
