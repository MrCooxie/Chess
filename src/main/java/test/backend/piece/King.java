package test.backend.piece;

import test.backend.ChessBoard;
import test.backend.strategy.Move;
import test.backend.strategy.Strategy;

import java.util.ArrayList;

public class King extends Piece {

    private boolean hasMoved = false;
    public King(Strategy strategy, PieceColor pieceColor, int row, int col, ChessBoard chessBoard) {
        super(strategy, pieceColor, row, col, chessBoard);
    }
    @Override
    public ArrayList<Move> getAllPossibleMove() {
        return strategy.getPossibleMoves(this, chessBoard);
    }

    @Override
    public String getLetter() {
        return "K";
    }
    public void setHasMoved(boolean hasMoved){
        this.hasMoved = hasMoved;
    }
    public boolean hasMoved(){
        return hasMoved;
    }


}
