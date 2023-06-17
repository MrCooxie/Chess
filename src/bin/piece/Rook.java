package bin.piece;

import bin.chessboard.ChessBoard;
import bin.strategy.Strategy;
import bin.strategy.piecestrategy.PawnStrategy;
import bin.strategy.piecestrategy.RookStrategy;

public class Rook extends Piece{
    public Rook(int row, int col, Strategy strategy, ChessBoard chessBoardClass) {
        super(row, col, strategy, chessBoardClass);
        pieceStrategy = new RookStrategy(this, chessBoardClass);

    }
}
