package bin.main;

import bin.chessboard.ChessBoard;
import bin.chessboard.GameMode;

public class Main {

    public static void main(String[] args){
        ChessBoard chessBoard = new ChessBoard(GameMode.NORMAL);
        chessBoard.printChessBoard();
        chessBoard.move(6,3,4,3);
        chessBoard.printChessBoard();
    }

}
