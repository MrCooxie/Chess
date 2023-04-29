package com.example.chessgame.Backend.MoveStrategy;

import com.example.chessgame.Backend.ChessBoard;
import com.example.chessgame.Backend.Piece.Piece;

import java.util.ArrayList;

public class NormalQueenMoveStrategy extends Strategy {
    private final ChessBoard chessBoardClass;
    private final Piece piece;

    public NormalQueenMoveStrategy(ChessBoard chessBoard, Piece piece) {
        super(chessBoard, piece);
        chessBoardClass = chessBoard;
        this.piece = piece;
    }

    @Override
    public ArrayList<Move> getAllPossibleMoves() {
        ArrayList<Move> allPossibleMoves = new NormalRookMoveStrategy(chessBoardClass, piece).getAllPossibleMoves();
        allPossibleMoves.addAll(new NormalBishopMoveStrategy(chessBoardClass, piece).getAllPossibleMoves());
        return allPossibleMoves;
    }
}
