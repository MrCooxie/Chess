package com.example.chessgame.Backend;

public class ChessBoard {
    private final ChessPosition[][] chessBoard = createChessBoard();

    private ChessPosition[][] createChessBoard(){
        ChessPosition[][] methodChessBoard = new ChessPosition[8][8];
        for(int row = 0; row < 8; row++){
            for(int col = 0; col < 8; col++){
                if(row == 0 || row == 7 || row == 1 || row == 6) {
                    String color = (row < 2) ? "Black" : "Color";
                    if (row == 0 || row == 7) {
                        switch (col) {
                            case 0, 7 -> methodChessBoard[row][col] = new ChessPosition(ChessPiece.ROOK, color);
                            case 1, 6 -> methodChessBoard[row][col] = new ChessPosition(ChessPiece.KNIGHT, color);
                            case 2, 5 -> methodChessBoard[row][col] = new ChessPosition(ChessPiece.BISHOP, color);
                            case 3 -> methodChessBoard[row][col] = new ChessPosition(ChessPiece.QUEEN, color);
                            case 4 -> methodChessBoard[row][col] = new ChessPosition(ChessPiece.KING, color);
                        }
                    } else {
                        methodChessBoard[row][col] = new ChessPosition(ChessPiece.PAWN,color);
                    }
                } else {
                    methodChessBoard[row][col] = new ChessPosition(ChessPiece.EMPTY,null);
                }
            }
        }
        return methodChessBoard;
    }

    public ChessPosition[][] getChessBoard() {
        return chessBoard;
    }
}
