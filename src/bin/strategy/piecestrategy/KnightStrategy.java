package bin.strategy.piecestrategy;

import bin.chessboard.ChessBoard;
import bin.piece.Piece;

import java.util.ArrayList;

public class KnightStrategy extends PieceStrategy{
    public KnightStrategy(Piece piece, ChessBoard chessBoardClass) {
        super(piece, chessBoardClass);
    }

    @Override
    public ArrayList<int[]> getAllPossibleMoves() {
        ArrayList<int[]> allPossibleMoves = new ArrayList<>();
        if(piece.getPieceColor().equals(turn)){
            int row = piece.getRow();
            int col = piece.getCol();
            int[][] possibleMoves = new int[][]{{row + 2, col + 1}, {row + 2, col - 1}, {row - 2, col + 1}, {row - 2, col - 1}, {row + 1, col + 2}, {row + 1, col - 2}, {row - 1, col + 2}, {row - 1, col - 2}};
            for(int[] move : possibleMoves){
                if(isInChessBoard(move[0], move[1]) && (chessBoard[move[0]][move[1]] == null || !chessBoard[move[0]][move[1]].getPieceColor().equals(turn)) && !isChecked(move[0],move[1])){
                    allPossibleMoves.add(move);
                }
            }
        }
        return allPossibleMoves;
    }


}
