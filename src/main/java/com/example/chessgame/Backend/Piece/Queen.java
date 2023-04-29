package com.example.chessgame.Backend.Piece;

import com.example.chessgame.Backend.ChessBoard;
import com.example.chessgame.Backend.MoveStrategy.Move;
import com.example.chessgame.Backend.MoveStrategy.NormalQueenMoveStrategy;

import java.util.ArrayList;

public class Queen extends Piece{
    public Queen(PieceColor pieceColor, int row, int col){
        super(pieceColor, PieceType.QUEEN,row,col);
    }
    @Override
    public ArrayList<Move> getAllPossibleMoves(ChessBoard chessBoard) {
        return new NormalQueenMoveStrategy(chessBoard, chessBoard.getChessBoard()[row][col]).getAllPossibleMoves();
    }
}
