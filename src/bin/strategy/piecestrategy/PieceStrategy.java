package bin.strategy.piecestrategy;

import bin.chessboard.ChessBoard;
import bin.chessboard.PieceColor;
import bin.piece.*;

import java.util.ArrayList;

public abstract class PieceStrategy {
    protected final Piece piece;
    protected final ChessBoard chessBoardClass;
    protected PieceColor turn;
    protected Piece[][] chessBoard;

    public PieceStrategy(Piece piece, ChessBoard chessBoardClass) {
        this.piece = piece;
        this.chessBoardClass = chessBoardClass;
        turn = chessBoardClass.getTurn();
        chessBoard = chessBoardClass.getChessBoard();
    }

    public abstract ArrayList<int[]> getAllPossibleMoves();

    protected boolean isInChessBoard(int row, int col) {
        return !(row > 7 || row < 0 || col > 7 || col < 0);
    }

    protected boolean isChecked(int row, int col) {
        Piece takenPiece = move(row, col);
        int[] locOfKing = getLocOfKing();
        boolean knight = isAttackedByKnight(locOfKing);
        boolean top_left = checkAngle(-1, -1 , locOfKing, AngleType.DIAGONAL);
        boolean top  = checkAngle(-1, 0 , locOfKing, AngleType.STRAIGHT);
        boolean top_right = checkAngle(-1, 1 , locOfKing, AngleType.DIAGONAL);
        boolean mid_left = checkAngle(0, -1 , locOfKing, AngleType.STRAIGHT);
        boolean mid_right = checkAngle(0, 1 , locOfKing, AngleType.STRAIGHT);
        boolean bot_left = checkAngle(1, -1 , locOfKing, AngleType.DIAGONAL);
        boolean bot = checkAngle(1, 0 , locOfKing, AngleType.STRAIGHT);
        boolean bot_right = checkAngle(1, 1 , locOfKing, AngleType.DIAGONAL);
        reverseMove(takenPiece,row,col);
        return (knight || top_left || top || top_right || mid_right || mid_left || bot_left || bot || bot_right);
    }

    private Piece move(int row, int col) {
        chessBoard[piece.getRow()][piece.getCol()] = null;
        Piece takenPiece = chessBoard[row][col];
        chessBoard[row][col] = piece;
        return takenPiece;
    }
    private void reverseMove(Piece takenPiece, int row, int col){
        Piece movedPiece = chessBoard[row][col];
        chessBoard[movedPiece.getRow()][movedPiece.getCol()] = movedPiece;
        chessBoard[row][col] = takenPiece;
    }

    private int[] getLocOfKing() {
        for (int row = 0; row < 8; row++) {
            for (int col = 0; col < 8; col++) {
                if (chessBoard[row][col] instanceof King king) {
                    if (king.getPieceColor().equals(turn)) {
                        return new int[]{row, col};
                    }
                }
            }
        }
        throw new RuntimeException("King not found");
    }

    private boolean isAttackedByKnight(int[] locOfKing) {
        int row = locOfKing[0];
        int col = locOfKing[1];
        int[][] knightAttacks = new int[][]{{row + 2, col + 1}, {row + 2, col - 1}, {row - 2, col + 1}, {row - 2, col - 1}, {row + 1, col + 2}, {row + 1, col - 2}, {row - 1, col + 2}, {row - 1, col - 2}};
        for(int[] move : knightAttacks){
            if(isInChessBoard(move[0],move[1]) && chessBoard[move[0]][move[1]] instanceof Knight knight){
                if (!knight.getPieceColor().equals(turn)){
                    return true;
                }
            }
        }
        return false;
    }

    private boolean checkAngle(int rowIncrease, int colIncrease, int[] locOfKing, AngleType angleType){
        for(int i = 1; isInChessBoard(rowIncrease * i, colIncrease * i) && chessBoard[rowIncrease * i][colIncrease * i].getPieceColor().equals(turn); i++){
            if(angleType.equals(AngleType.DIAGONAL) && (chessBoard[rowIncrease * i][colIncrease * i] instanceof Bishop || chessBoard[rowIncrease * i][colIncrease * i] instanceof Queen)){
                return true;
            } else if(angleType.equals(AngleType.STRAIGHT) && (chessBoard[rowIncrease * i][colIncrease * i] instanceof Rook || chessBoard[rowIncrease * i][colIncrease * i] instanceof Queen)){
                return true;
            }

        }
        return false;
    }
}
