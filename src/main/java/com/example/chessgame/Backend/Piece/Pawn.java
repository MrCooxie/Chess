package com.example.chessgame.Backend.Piece;

import com.example.chessgame.Backend.ChessBoard;
import com.example.chessgame.Backend.MoveStrategy.Move;
import com.example.chessgame.Backend.MoveStrategy.NormalPawnMoveStrategy;

import java.util.ArrayList;

public class Pawn extends Piece{

    public Pawn(PieceColor pieceColor, int row, int col ){
        super(pieceColor,PieceType.PAWN, row,col);
    }

    @Override
    public ArrayList<Move> getAllPossibleMoves(ChessBoard chessBoard) {
        return new NormalPawnMoveStrategy(chessBoard, chessBoard.getChessBoard()[row][col]).getAllPossibleMoves();
    }
}
