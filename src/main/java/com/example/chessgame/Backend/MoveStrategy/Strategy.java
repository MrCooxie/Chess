package com.example.chessgame.Backend.MoveStrategy;

import com.example.chessgame.Backend.ChessBoard;
import com.example.chessgame.Backend.Piece.Piece;
import com.example.chessgame.Backend.Piece.PieceColor;

import java.util.ArrayList;

public abstract class Strategy {
    protected final int row;
    protected final int col;
    protected final Piece[][] chessBoard;
    protected final PieceColor pieceColor;
    protected PieceColor turn;
    public Strategy(ChessBoard chessBoard, Piece piece) {
        this.chessBoard = chessBoard.getChessBoard();
        turn = chessBoard.getTurn();
        row = piece.getRow();
        col = piece.getCol();
        pieceColor = piece.getPieceColor();
    }

    public abstract ArrayList<Move> getAllPossibleMoves();
    protected boolean isEmpty(Piece piece){
        return piece == null;
    }
    protected  boolean isOppositeColor(Piece piece){
        return !piece.getPieceColor().equals(pieceColor);
    }
    protected boolean isInChessBoard(int row, int col){
        return !(row < 0 || row > 7 || col < 0 || col > 7);
    }
}
