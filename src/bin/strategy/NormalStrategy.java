package bin.strategy;

import bin.chessboard.ChessBoard;
import bin.piece.Piece;

public class NormalStrategy extends Strategy{
    @Override
    public void useStrategy(Piece piece, int row, int col, Piece[][] chessBoard) {
        chessBoard[piece.getRow()][piece.getCol()] = null;
        piece.setRow(row);
        piece.setCol(col);
        chessBoard[row][col] = piece;
    }
}
