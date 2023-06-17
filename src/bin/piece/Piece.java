package bin.piece;


import bin.chessboard.ChessBoard;
import bin.chessboard.PieceColor;
import bin.strategy.Strategy;
import bin.strategy.piecestrategy.PieceStrategy;

public abstract class Piece{
    protected int row;
    protected int col;
    protected final ChessBoard chessBoardClass;

    protected final Strategy strategy;
    protected final PieceColor pieceColor;
    protected PieceStrategy pieceStrategy;
    public Piece(int row, int col, Strategy strategy, ChessBoard chessBoardClass){
        this.row = row;
        this.col = col;
        this.chessBoardClass = chessBoardClass;
        this.strategy = strategy;
        pieceColor = (row < 2) ? PieceColor.BLACK : PieceColor.WHITE;
    }
    public void move(int row, int col) {
        boolean result = strategy.move(this,row,col,pieceStrategy.getAllPossibleMoves(), chessBoardClass.getChessBoard());
        if(result){
            chessBoardClass.nextTurn();
        }
    }
    public PieceColor getPieceColor() {
        return pieceColor;
    }

    public int getRow() {
        return row;
    }

    public int getCol() {
        return col;
    }

    public void setRow(int row) {
        this.row = row;
    }

    public void setCol(int col) {
        this.col = col;
    }
}
