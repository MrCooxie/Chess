package com.example.chessgame.Backend.Piece;

import com.example.chessgame.Backend.ChessBoard;
import com.example.chessgame.Backend.MoveStrategy.Move;

import java.util.ArrayList;

public abstract class Piece {
    protected final PieceColor pieceColor;
    protected final PieceType pieceType;
    protected final int row;
    protected final int col;

    public Piece(PieceColor pieceColor, PieceType pieceType, int row, int col) {
        this.pieceColor = pieceColor;
        this.pieceType = pieceType;
        this.row = row;
        this.col = col;
    }

    public abstract boolean move(int rowToMoveTo, int colToMoveTo, ChessBoard chessBoard);

    protected boolean move(int rowToMoveTo, int colToMoveTo, ChessBoard chessBoard, Piece piece){
        ArrayList<Move> allPossibleMoves = getAllPossibleMoves(chessBoard);
        for(Move move : allPossibleMoves){
            if(rowToMoveTo == move.row() && colToMoveTo == move.col()){
                chessBoard.getChessBoard()[rowToMoveTo][colToMoveTo] = piece;
                chessBoard.getChessBoard()[row][col] = null;
                chessBoard.nextTurn();
                return true;
            }
        }
        return false;
    }


    public abstract ArrayList<Move> getAllPossibleMoves(ChessBoard chessBoard);

    public PieceColor getPieceColor() {
        return pieceColor;
    }

    public PieceType getPieceType() {
        return pieceType;
    }

    public int getRow() {
        return row;
    }

    public int getCol() {
        return col;
    }

    public String toString(){
        switch (pieceType){
            case KNIGHT -> {
                return "N";
            }
            case PAWN -> {
                return "P";
            }
            case ROOK -> {
                return "R";
            }
            case BISHOP -> {
                return "B";
            }
            case KING -> {
                return "K";
            }
            case QUEEN -> {
                return "Q";
            }
        }
        return "-";
    }
}
