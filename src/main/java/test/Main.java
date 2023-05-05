package test;

import test.backend.ChessBoard;
import test.backend.GameMode;
import test.backend.strategy.Move;

import java.util.ArrayList;


public class Main {
    public static void main(String[] args) {
        ChessBoard chessBoard = new ChessBoard(GameMode.NORMAL);
        chessBoard.printChessBoard();
        chessBoard.move(6, 4, 4, 4);
        chessBoard.printChessBoard();
        chessBoard.move(1, 3, 3, 3);
        chessBoard.printChessBoard();
        chessBoard.move(7,5,5,3);
        chessBoard.printChessBoard();
        chessBoard.move(0,3,2,3);
        chessBoard.printChessBoard();
        chessBoard.move(7,6,5,5);
        chessBoard.printChessBoard();
        chessBoard.move(0,2,2,4);
        chessBoard.printChessBoard();
        printMoves(chessBoard.getChessBoard()[7][4].getAllPossibleMove());

    }

    public static void printMoves(ArrayList<Move> moves) {
        for (Move move : moves) {
            System.out.println(move.row() + " " + move.col() + " " + move.isSpecial());
        }

    }
}
