package bin.strategy.piecestrategy;

import bin.chessboard.ChessBoard;
import bin.piece.Bishop;
import bin.piece.Piece;
import bin.piece.Queen;
import bin.piece.Rook;

import java.util.ArrayList;

public class BishopStrategy extends PieceStrategy {
    public BishopStrategy(Piece piece, ChessBoard chessBoardClass) {
        super(piece, chessBoardClass);
    }

    @Override
    public ArrayList<int[]> getAllPossibleMoves() {
        ArrayList<int[]> allPossibleMoves = new ArrayList<>();
        if (piece.getPieceColor().equals(turn)) {
            allPossibleMoves.addAll(checkAngle(-1,-1));
            allPossibleMoves.addAll(checkAngle(-1, 1));
            allPossibleMoves.addAll(checkAngle(1, -1));
            allPossibleMoves.addAll(checkAngle(1, 1));
        }
        return allPossibleMoves;
    }

    private ArrayList<int[]> checkAngle(int rowIncrease, int colIncrease) {
        ArrayList<int[]> allPossibleMoves = new ArrayList<>();
        for (int i = 1; isInChessBoard(rowIncrease * i, colIncrease * i) && chessBoard[rowIncrease * i][colIncrease * i].getPieceColor().equals(turn); i++) {
            if (chessBoard[rowIncrease * i][colIncrease * i] == null) {
                allPossibleMoves.add(new int[]{rowIncrease * i, colIncrease * i});
            } else {
                allPossibleMoves.add(new int[]{rowIncrease * i, colIncrease * i});
                break;
            }
        }
        return allPossibleMoves;
    }
}
