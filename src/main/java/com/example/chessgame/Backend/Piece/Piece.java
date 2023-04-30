package com.example.chessgame.Backend.Piece;

import com.example.chessgame.Backend.ChessBoard;
import com.example.chessgame.Backend.GameMode;
import com.example.chessgame.Backend.MoveStrategy.Move;

import java.util.ArrayList;

public abstract class Piece {
    protected final PieceColor pieceColor;
    protected final PieceType pieceType;
    protected int row;
    protected int col;
    protected final GameMode gameMode;
    protected final ChessBoard chessBoard;

    public Piece(PieceColor pieceColor, PieceType pieceType, int row, int col, GameMode gameMode, ChessBoard chessBoard) {
        this.pieceColor = pieceColor;
        this.pieceType = pieceType;
        this.row = row;
        this.col = col;
        this.gameMode = gameMode;
        this.chessBoard = chessBoard;
    }

    public abstract boolean move(int rowToMoveTo, int colToMoveTo);

    public boolean move(int rowToMoveTo, int colToMoveTo, Piece piece) {
        ArrayList<Move> allPossibleMoves = piece.getAllPossibleMoves();
        for (Move move : allPossibleMoves) {
            if (move.row() == rowToMoveTo && move.col() == colToMoveTo) {
                chessBoard.getChessBoard()[row][col] = null;
                chessBoard.getChessBoard()[rowToMoveTo][colToMoveTo] = piece;
                chessBoard.nextTurn();
                piece.setRow(rowToMoveTo);
                piece.setCol(colToMoveTo);
                return true;
            }
        }
        return false;
    }

    public abstract ArrayList<Move> getAllPossibleMoves();

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

    public String toString() {
        switch (pieceType) {
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

    public void setRow(int row) {
        this.row = row;
    }

    public void setCol(int col) {
        this.col = col;
    }
}
