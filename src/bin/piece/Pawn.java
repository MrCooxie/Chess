package bin.piece;

import bin.chessboard.ChessBoard;
import bin.strategy.Strategy;
import bin.strategy.piecestrategy.PawnStrategy;

public class Pawn extends Piece{
    public Pawn(int row, int col, Strategy strategy, ChessBoard chessBoardClass){
        super(row,col,strategy, chessBoardClass);
        pieceStrategy = new PawnStrategy(this, chessBoardClass);
    }

    @Override
    public char getLetter() {
        return 'P';
    }


}
