package test;

import test.backend.ChessBoard;
import test.backend.GameMode;
import test.backend.strategy.Move;

import java.util.ArrayList;


public class Main {
    public static void main(String[] args){
        ChessBoard chessBoard = new ChessBoard(GameMode.NORMAL);
        chessBoard.printChessBoard();
        chessBoard.move(6,4,5,4);
        chessBoard.printChessBoard();
        chessBoard.move(0,1,2,2);
        chessBoard.printChessBoard();
        chessBoard.move(6,3,4,3);
        chessBoard.printChessBoard();
        chessBoard.move(2,2,4,3);
        chessBoard.printChessBoard();
        chessBoard.move(7,3,4,3);
        chessBoard.printChessBoard();
        chessBoard.move(0,0,0,1);
        chessBoard.printChessBoard();
        chessBoard.move(7,2,6,3);
        chessBoard.printChessBoard();
        chessBoard.move(1,1,2,1);
        chessBoard.printChessBoard();
        chessBoard.move(7,4,6,4);
        chessBoard.printChessBoard();
    }
    public static void printMoves(ArrayList<Move> moves){
        for(Move move : moves){
            System.out.println(move.row() + " " + move.col());
        }

    }
}
