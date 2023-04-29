package com.example.chessgame.Backend.MoveStrategy;

import com.example.chessgame.Backend.ChessBoard;
import com.example.chessgame.Backend.Piece.Piece;
import com.example.chessgame.Backend.Piece.PieceColor;

import java.util.ArrayList;

public class NormalPawnMoveStrategy extends Strategy{

    public NormalPawnMoveStrategy(ChessBoard chessBoard, Piece piece) {
        super(chessBoard,piece);
    }

    @Override
    public ArrayList<Move> getAllPossibleMoves() {
        ArrayList<Move> allPossibleMoves = new ArrayList<>();
        int increment = (pieceColor.equals(PieceColor.WHITE)) ? -1: 1;
        if(turn.equals(pieceColor)) {
            if (isEmpty(chessBoard[row + increment][col])) {
                allPossibleMoves.add(new Move(row + increment, col));
                if ((row == 6 && pieceColor.equals(PieceColor.WHITE) || row == 1 && pieceColor.equals(PieceColor.BLACK)) && isEmpty(chessBoard[row + 2 * increment][col])) {
                    allPossibleMoves.add(new Move(row + 2 * increment, col));
                }
            }
            if (!isEmpty(chessBoard[row + increment][col + 1]) && isOppositeColor(chessBoard[row + increment][col + 1])) {
                allPossibleMoves.add(new Move(row + increment, col + 1));
            }
            if (!isEmpty(chessBoard[row + increment][col - 1]) && isOppositeColor(chessBoard[row + increment][col - 1])) {
                allPossibleMoves.add(new Move(row + increment, col - 1));
            }
        }
        return allPossibleMoves;
    }

}
