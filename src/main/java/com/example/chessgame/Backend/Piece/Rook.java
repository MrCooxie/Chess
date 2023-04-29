package com.example.chessgame.Backend.Piece;

import com.example.chessgame.Backend.ChessBoard;
import com.example.chessgame.Backend.MoveStrategy.Move;
import com.example.chessgame.Backend.MoveStrategy.NormalRookMoveStrategy;

import java.util.ArrayList;

public class Rook extends Piece {
    public Rook(PieceColor pieceColor, int row, int col) {
        super(pieceColor, PieceType.ROOK, row, col);
    }

    @Override
    public boolean move(int rowToMoveTo, int colToMoveTo, ChessBoard chessBoard) {
        return move(rowToMoveTo,colToMoveTo,chessBoard,this);

    }

    @Override
    public ArrayList<Move> getAllPossibleMoves(ChessBoard chessBoard) {
        return new NormalRookMoveStrategy(chessBoard, chessBoard.getChessBoard()[row][col]).getAllPossibleMoves();
    }
}
