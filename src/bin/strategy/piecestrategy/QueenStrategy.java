package bin.strategy.piecestrategy;

import bin.chessboard.ChessBoard;
import bin.piece.Piece;

import java.util.ArrayList;

public class QueenStrategy extends PieceStrategy{
    public QueenStrategy(Piece piece, ChessBoard chessBoardClass) {
        super(piece, chessBoardClass);
    }

    @Override
    public ArrayList<int[]> getAllPossibleMoves() {
        ArrayList<int[]> allPossibleMoves = new ArrayList<>();
        allPossibleMoves.addAll(new BishopStrategy(piece,chessBoardClass).getAllPossibleMoves());
        allPossibleMoves.addAll(new RookStrategy(piece,chessBoardClass).getAllPossibleMoves());
        return allPossibleMoves;
    }
}
