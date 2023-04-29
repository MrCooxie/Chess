package com.example.chessgame.Backend;

import com.example.chessgame.Backend.Piece.*;

import java.util.ArrayList;

public class ChessBoard {
    private final Piece[][] chessBoard = createChessBoard();
    private PieceColor turn = PieceColor.WHITE;

    private Piece[][] createChessBoard(){
        Piece[][] methodChessBoard = new Piece[8][8];
        for(int row = 0; row < 8; row++){
            for(int col = 0; col < 8; col++){
                if(row == 0 || row == 7 || row == 1 || row == 6) {
                    PieceColor color = (row < 2) ? PieceColor.BLACK : PieceColor.WHITE;
                    if (row == 0 || row == 7) {
                        switch (col) {
                            case 0, 7 -> methodChessBoard[row][col] = new Rook(color,row,col);
                            case 1, 6 -> methodChessBoard[row][col] = new Knight(color,row,col);
                            case 2, 5 -> methodChessBoard[row][col] = new Bishop(color,row,col);
                            case 3 -> methodChessBoard[row][col] = new Queen(color,row,col);
                            case 4 -> methodChessBoard[row][col] = new King(color,row,col);
                        }
                    } else {
                        methodChessBoard[row][col] = new Pawn(color, row,col);
                    }
                } else {
                    methodChessBoard[row][col] = null;
                }
            }
        }
        return methodChessBoard;
    }

    public Piece[][] getChessBoard() {
        return chessBoard;
    }

    public PieceColor getTurn() {
        return turn;
    }
    public void nextTurn(){
        if(turn.equals(PieceColor.WHITE)) {
            turn = PieceColor.BLACK;
        } else {
            turn = PieceColor.WHITE;
        }
    }
}
