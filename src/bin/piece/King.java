package bin.piece;

import bin.chessboard.ChessBoard;
import bin.strategy.Strategy;
import bin.strategy.piecestrategy.KingStrategy;
import bin.strategy.piecestrategy.PawnStrategy;

public class King extends Piece{

    public King(int row, int col, Strategy strategy, ChessBoard chessBoardClass) {
        super(row, col, strategy, chessBoardClass);
        pieceStrategy = new KingStrategy(this, chessBoardClass);

    }
    @Override
    public char getLetter() {
        return 'K';
    }

}
