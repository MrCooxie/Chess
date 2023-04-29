package com.example.chessgame.Backend.Piece;

import com.example.chessgame.Backend.ChessBoard;
import com.example.chessgame.Backend.MoveStrategy.Move;
import com.example.chessgame.Backend.MoveStrategy.NormalKingMoveStrategy;

import java.util.ArrayList;

public class King extends Piece{
    public King(PieceColor pieceColor, int row, int col){
        super(pieceColor, PieceType.KING,row,col);
    }
    @Override
    public ArrayList<Move> getAllPossibleMoves(ChessBoard chessBoard) {
        return new NormalKingMoveStrategy(chessBoard,chessBoard.getChessBoard()[row][col]).getAllPossibleMoves();
    }

}
