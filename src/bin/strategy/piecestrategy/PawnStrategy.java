package bin.strategy.piecestrategy;

import bin.chessboard.ChessBoard;
import bin.chessboard.PieceColor;
import bin.piece.Piece;
import bin.strategy.Strategy;

import java.util.ArrayList;

public class PawnStrategy extends PieceStrategy{
    public PawnStrategy(Piece piece, ChessBoard chessBoardClass) {
        super(piece, chessBoardClass);
    }

    @Override
    public ArrayList<int[]> getAllPossibleMoves() {
        ArrayList<int[]> allPossibleMoves = new ArrayList<>();
        if(turn.equals(piece.getPieceColor())){
            int increment = (turn.equals(PieceColor.WHITE)) ? - 1 : 1;
            int row = piece.getRow();
            int col = piece.getCol();
            if(isInChessBoard(row + increment, col) && chessBoard[row + increment][col] == null && !isChecked(row + increment,col)){
                allPossibleMoves.add(new int[]{row + increment,col});
                if(isInChessBoard(row + 2 * increment,col) && chessBoard[row + 2 * increment][col] == null && !isChecked(row + 2 * increment,col)){
                    allPossibleMoves.add(new int[]{row + 2 * increment,col});
                }
            }
            if(isInChessBoard(row + increment, col + 1) && !chessBoard[row + increment][col + 1].getPieceColor().equals(turn) && isChecked(row + increment,col +1)){
                allPossibleMoves.add(new int[]{row + increment, col +1});
            }
            if(isInChessBoard(row + increment, col - 1) && !chessBoard[row + increment][col - 1].getPieceColor().equals(turn) && isChecked(row + increment, col -1)){
                allPossibleMoves.add(new int[]{row + increment, col -1});
            }

        }
        return allPossibleMoves;
    }
}
