package com.example.chessgame.Backend.Piece;

import com.example.chessgame.Backend.ChessBoard;
import com.example.chessgame.Backend.MoveStrategy.Move;
import com.example.chessgame.Backend.MoveStrategy.NormalKnightMoveStrategy;

import java.util.ArrayList;

public class Knight extends Piece{
    public Knight(PieceColor pieceColor, int row, int col){
        super(pieceColor, PieceType.KNIGHT,row,col);
    }

    @Override
    public ArrayList<Move> getAllPossibleMoves(ChessBoard chessBoard) {
        return new NormalKnightMoveStrategy(chessBoard, chessBoard.getChessBoard()[row][col]).getAllPossibleMoves();
    }
}
