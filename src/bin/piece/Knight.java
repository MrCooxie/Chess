package bin.piece;

import bin.chessboard.ChessBoard;
import bin.strategy.Strategy;
import bin.strategy.piecestrategy.KnightStrategy;
import bin.strategy.piecestrategy.PawnStrategy;

public class Knight extends Piece{

    public Knight(int row, int col, Strategy strategy, ChessBoard chessBoardClass) {
        super(row, col, strategy, chessBoardClass);
        pieceStrategy = new KnightStrategy(this, chessBoardClass);

    }


}
