package com.example.chessgame.Backend.MoveStrategy;

import com.example.chessgame.Backend.ChessBoard;
import com.example.chessgame.Backend.Piece.Piece;

import java.util.ArrayList;

public class NormaRookMoveStrategy extends Strategy{
    public NormaRookMoveStrategy(ChessBoard chessBoard, Piece piece){
        super(chessBoard,piece);
    }

    @Override
    public ArrayList<Move> getAllPossibleMoves() {
        ArrayList<Move> allPossibleMoves = new ArrayList<>();
        if(turn.equals(pieceColor)) {
            boolean[] blockingPieces = new boolean[]{false, false, false, false};
            for (int i = 1; i < 8; i++) {
                getLines(allPossibleMoves, blockingPieces, 0, row - i, col); // Top
                getLines(allPossibleMoves,blockingPieces,1,row + i, col);// Bottom
                getLines(allPossibleMoves,blockingPieces,2,row,col - i);//Left
                getLines(allPossibleMoves,blockingPieces,3,row,col +i);//Right
            }
        }
        return allPossibleMoves;
    }
    private void getLines(ArrayList<Move> allPossibleMoves, boolean[] blockingPieces, int blockingPiecesIndex, int rowToCheck, int colToCheck){
        if(!blockingPieces[blockingPiecesIndex]) {
            if (isInChessBoard(rowToCheck, colToCheck)) {
                Piece temp = chessBoard[rowToCheck][colToCheck];
                if (isEmpty(temp)) {
                    allPossibleMoves.add(new Move(temp.getRow(), temp.getCol()));
                } else if (isOppositeColor(temp)) {
                    allPossibleMoves.add(new Move(temp.getRow(), temp.getCol()));
                    blockingPieces[blockingPiecesIndex] = true;
                } else {
                    blockingPieces[blockingPiecesIndex] = true;
                }
            } else {
                blockingPieces[blockingPiecesIndex] = true;
            }
        }
    }
}
