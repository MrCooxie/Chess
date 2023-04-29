package com.example.chessgame.Backend.Piece;

import com.example.chessgame.Backend.ChessBoard;
import com.example.chessgame.Backend.MoveStrategy.Move;
import com.example.chessgame.Backend.MoveStrategy.NormaRookMoveStrategy;

import java.util.ArrayList;

public class Rook extends Piece{
    public Rook(PieceColor pieceColor, int row, int col){
        super(pieceColor, PieceType.ROOK,row,col);
    }

    @Override
    public ArrayList<Move> getAllPossibleMoves(ChessBoard chessBoard) {
        return new NormaRookMoveStrategy(chessBoard,chessBoard.getChessBoard()[row][col]).getAllPossibleMoves();
    }
}
