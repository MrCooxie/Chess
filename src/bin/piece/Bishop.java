package bin.piece;

import bin.chessboard.ChessBoard;
import bin.strategy.Strategy;
import bin.strategy.piecestrategy.BishopStrategy;
import bin.strategy.piecestrategy.PawnStrategy;

public class Bishop extends Piece{

    public Bishop(int row, int col, Strategy strategy, ChessBoard chessBoardClass) {
        super(row, col, strategy, chessBoardClass);
        pieceStrategy = new BishopStrategy(this, chessBoardClass);

    }
    @Override
    public char getLetter() {
        return 'B';
    }

}
