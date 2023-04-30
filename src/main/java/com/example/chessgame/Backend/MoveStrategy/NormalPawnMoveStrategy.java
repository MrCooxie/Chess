package com.example.chessgame.Backend.MoveStrategy;

import com.example.chessgame.Backend.ChessBoard;
import com.example.chessgame.Backend.Piece.Piece;
import com.example.chessgame.Backend.Piece.PieceColor;

import java.util.ArrayList;

public class NormalPawnMoveStrategy extends NormalStrategy {

    public NormalPawnMoveStrategy(ChessBoard chessBoard, Piece piece) {
        super(chessBoard, piece);
    }

    @Override
    public ArrayList<Move> getAllPossibleMoves() {
        int increment = (pieceColor.equals(PieceColor.WHITE)) ? -1 : 1;
        ArrayList<Move> allPossibleMoves;
        int howMuchMoveUp = 1;
        int howMuchRightDiagonal = 0;
        int howMuchLeftDiagonal = 0;

        if (pieceColor.equals(PieceColor.WHITE) && row == 6 || (pieceColor.equals(PieceColor.BLACK)) && row == 2) howMuchMoveUp = 2;
        if (!isEmpty(chessBoard[row + increment][col + 1]) && isOppositeColor(chessBoard[row +increment][col +1])){
            howMuchRightDiagonal = 1;
        }
        if (!isEmpty(chessBoard[row + increment][col - 1]) && isOppositeColor(chessBoard[row + increment][col - 1])) {
            howMuchLeftDiagonal = 1;
        }

        if (pieceColor.equals(PieceColor.WHITE)) {
            allPossibleMoves = getAllPossibleMoves(howMuchLeftDiagonal, howMuchMoveUp, howMuchRightDiagonal, 0, 0, 0, 0, 0);
        } else {
            allPossibleMoves = getAllPossibleMoves(0, 0, 0, 0, 0, howMuchLeftDiagonal, howMuchMoveUp, howMuchRightDiagonal);
        }
        return allPossibleMoves;
    }
}
