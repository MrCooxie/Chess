package com.example.chessgame.Backend;

import com.example.chessgame.Backend.Piece.*;

public class ChessBoard {
    private final GameMode gameMode;
    private final Piece[][] chessBoard;

    public ChessBoard(GameMode gameMode) {
        this.gameMode = gameMode;
        chessBoard = createChessBoard();
    }

    private PieceColor turn = PieceColor.WHITE;

    private Piece[][] createChessBoard() {
        Piece[][] methodChessBoard = new Piece[8][8];
        for (int row = 0; row < 8; row++) {
            for (int col = 0; col < 8; col++) {
                if (row == 0 || row == 7 || row == 1 || row == 6) {
                    PieceColor color = (row < 2) ? PieceColor.BLACK : PieceColor.WHITE;
                    if (row == 0 || row == 7) {
                        switch (col) {
                            case 0, 7 -> methodChessBoard[row][col] = new Rook(color, row, col, gameMode, this);
                            case 1, 6 -> methodChessBoard[row][col] = new Knight(color, row, col, gameMode, this);
                            case 2, 5 -> methodChessBoard[row][col] = new Bishop(color, row, col, gameMode, this);
                            case 3 -> methodChessBoard[row][col] = new Queen(color, row, col, gameMode, this);
                            case 4 -> methodChessBoard[row][col] = new King(color, row, col, gameMode, this);
                        }
                    } else {
                        methodChessBoard[row][col] = new Pawn(color, row, col, gameMode, this);
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

    public boolean move(int rowOfPieceToMove, int colOfPieceToMove, int rowToMoveTo, int colToMoveTo) {
        return chessBoard[rowOfPieceToMove][colOfPieceToMove].move(rowToMoveTo, colToMoveTo);
    }

    public PieceColor getTurn() {
        return turn;
    }

    public void nextTurn() {
        if (turn.equals(PieceColor.WHITE)) {
            turn = PieceColor.BLACK;
        } else {
            turn = PieceColor.WHITE;
        }
    }

    public void printChessBoard() {
        for (Piece[] piecesArr : chessBoard) {
            System.out.print("[");
            for (Piece piece : piecesArr) {
                System.out.print(" " + ((piece == null) ? "-" : piece));
            }
            System.out.println(" ]");
        }
        System.out.println();
    }
}
