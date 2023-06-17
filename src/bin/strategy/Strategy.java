package bin.strategy;


import bin.chessboard.ChessBoard;
import bin.piece.Piece;

import java.util.ArrayList;

public abstract class Strategy {
        public boolean move(Piece piece, int row, int col, ArrayList<int[]> allPossibleMoves, Piece[][] chessBoard){
            for(int[] move : allPossibleMoves){
                if(move[0] == row && move[1] == col){
                    useStrategy(piece,row, col, chessBoard);
                    return true;
                }
            }
            return false;
        }
        public abstract void useStrategy(Piece piece, int row, int col, Piece[][] chessBoard);
}
