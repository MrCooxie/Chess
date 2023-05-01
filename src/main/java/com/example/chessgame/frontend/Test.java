package com.example.chessgame.frontend;

import com.example.chessgame.backend.ChessBoard;
import com.example.chessgame.backend.GameMode;
import com.example.chessgame.backend.MoveStrategy.Move;

import java.util.ArrayList;


public class Test {
    public static void main(String[] args) {
        ChessBoard chessboard = new ChessBoard(GameMode.NORMAL);
        chessboard.printChessBoard();
        chessboard.move(6, 4, 5, 4);
        chessboard.printChessBoard();
        ArrayList<Move> allPossibleMoves = chessboard.getChessBoard()[6][3].getAllPossibleMoves();
        for(Move move : allPossibleMoves){
            System.out.println(move.row() + " " + move.col());
        }
    }
}
