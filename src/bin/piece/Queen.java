package bin.piece;

import bin.chessboard.ChessBoard;
import bin.strategy.Strategy;
import bin.strategy.piecestrategy.QueenStrategy;

public class Queen extends Piece{

    public Queen(int row, int col, Strategy strategy, ChessBoard chessBoardClass) {
        super(row, col, strategy, chessBoardClass);
        pieceStrategy = new QueenStrategy(this, chessBoardClass);

    }
    @Override
    public char getLetter() {
        return 'Q';
    }

}