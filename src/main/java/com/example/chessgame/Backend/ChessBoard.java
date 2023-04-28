package com.example.chessgame.Backend;

import java.util.ArrayList;

public class ChessBoard {
    private final ChessPosition[][] chessBoard = createChessBoard();
    private int row;
    private int col;

    private String turn = "White";

    public void updateChessBoard(int rowToAdd, int colToAdd){
        ChessPosition chessPiece = chessBoard[row][col];
        chessBoard[row][col] = new ChessPosition(ChessPiece.EMPTY,null);
        chessBoard[rowToAdd][colToAdd] = new ChessPosition(chessPiece.chessPiece(),chessPiece.color());
    }

    private ChessPosition[][] createChessBoard(){
        ChessPosition[][] methodChessBoard = new ChessPosition[8][8];
        for(int row = 0; row < 8; row++){
            for(int col = 0; col < 8; col++){
                if(row == 0 || row == 7 || row == 1 || row == 6) {
                    String color = (row < 2) ? "Black" : "White";
                    if (row == 0 || row == 7) {
                        switch (col) {
                            case 0, 7 -> methodChessBoard[row][col] = new ChessPosition(ChessPiece.ROOK, color);
                            case 1, 6 -> methodChessBoard[row][col] = new ChessPosition(ChessPiece.KNIGHT, color);
                            case 2, 5 -> methodChessBoard[row][col] = new ChessPosition(ChessPiece.BISHOP, color);
                            case 3 -> methodChessBoard[row][col] = new ChessPosition(ChessPiece.QUEEN, color);
                            case 4 -> methodChessBoard[row][col] = new ChessPosition(ChessPiece.KING, color);
                        }
                    } else {
                        methodChessBoard[row][col] = new ChessPosition(ChessPiece.PAWN,color);
                    }
                } else {
                    methodChessBoard[row][col] = new ChessPosition(ChessPiece.EMPTY,null);
                }
            }
        }
        return methodChessBoard;
    }

    public ChessPosition[][] getChessBoard() {
        return chessBoard;
    }
    public ArrayList<int[]> getAllPossibleMoves(){
        ChessPosition chessPiece = chessBoard[row][col];
        ChessPiece chessPieceType = chessPiece.chessPiece();
        switch (chessPieceType){
            case PAWN -> {
                return getPossiblePawnMoves();
            }
            case BISHOP ->{
                return getPossibleDiagonals();
            }
            case KNIGHT -> {
                return getPossibleKnightMoves();
            }
            case ROOK -> {

            }
            case QUEEN -> {
                ArrayList<int[]> possibleDiagonals = getPossibleDiagonals();

            }
        }
        return new ArrayList<>();
    }
    private ArrayList<int[]> getPossiblePawnMoves(){
        ArrayList<int[]> allPossibleMoves = new ArrayList<>();
        ChessPosition chessPiece = chessBoard[row][col];
        String color = chessPiece.color();
        int increment = (color.equals("White") ? -1 : 1);
        if(color.equals(turn)) {
            if (isInChessBoard(row + increment, col) && isTileEmpty(chessBoard[row + increment][col])) {
                allPossibleMoves.add(new int[]{row + increment, col});
                if (isInChessBoard(row + increment * 2, col) && ((row == 1 && color.equals("Black")) || (row == 6 && color.equals("White"))) && isTileEmpty(chessBoard[row + increment * 2][col])) {
                    allPossibleMoves.add(new int[]{row + increment * 2, col});
                }
            }
            if (isInChessBoard(row + increment, col - 1) && !(isTileEmpty(chessBoard[row + increment][col - 1])) && !chessBoard[row + increment][col - 1].color().equals(color)) {
                allPossibleMoves.add(new int[]{row + increment, col - 1});
            }
            if (isInChessBoard(row + increment, col + 1) && !(isTileEmpty(chessBoard[row + increment][col + 1])) && !chessBoard[row + increment][col + 1].color().equals(color)) {
                allPossibleMoves.add(new int[]{row + increment, col + 1});
            }
        }
        return allPossibleMoves;
    }
    private ArrayList<int[]> getPossibleDiagonals(){
        ArrayList<int[]> allPossibleMoves = new ArrayList<>();
        boolean[] blockingPieces = new boolean[]{false,false,false,false};
        if(chessBoard[row][col].color().equals(turn)) {
            for (int i = 1; i < 8; i++) {
                getPossibleEveryDiagonal(allPossibleMoves, blockingPieces, 0, -1 * i, i); //Top right
                getPossibleEveryDiagonal(allPossibleMoves, blockingPieces, 1, i, i); //Bot right
                getPossibleEveryDiagonal(allPossibleMoves, blockingPieces, 2, -1 * i, -1 * i);//Top left
                getPossibleEveryDiagonal(allPossibleMoves, blockingPieces, 3, i, -1 * i);//Bot left
            }
        }
        return allPossibleMoves;
    }
    private void getPossibleEveryDiagonal(ArrayList<int[]> allPossibleMoves, boolean[] blockingPiecesArray, int blockingPieceIndex, int rowIncrement, int colIncrement){
        if(!blockingPiecesArray[blockingPieceIndex]){
            if(isInChessBoard(row + rowIncrement, col + colIncrement) && isTileEmpty(chessBoard[row + rowIncrement][col + colIncrement])){
                allPossibleMoves.add(new int[]{row + rowIncrement,col + colIncrement});
            } else if(isInChessBoard(row + rowIncrement,col + colIncrement) && isOppositeColor(chessBoard[row + rowIncrement][col + colIncrement].color(), chessBoard[row][col].color())){
                allPossibleMoves.add(new int[]{row + rowIncrement,col + colIncrement});
                blockingPiecesArray[blockingPieceIndex] = true;
            } else {
                blockingPiecesArray[blockingPieceIndex] = true;
            }
        }
    }
    private ArrayList<int[]> getPossibleKnightMoves(){
        ArrayList<int[]> allPossibleMoves = new ArrayList<>();
        int[][] moves = new int[][]{{row -2, col -1},{row - 2, col +1},{row + 2, col -1},{row + 2, col + 1},{row - 1, col + 2},{row - 1, col - 2}, {row + 1, col + 2},{row + 1,col -2}};
        ChessPosition chessPiece = chessBoard[row][col];
        String color = chessPiece.color();
        if(color.equals(turn)){
            for(int[] move : moves){
                if(isInChessBoard(move[0],move[1])){
                    if(isTileEmpty(chessBoard[move[0]][move[1]]) || isOppositeColor(chessBoard[move[0]][move[1]].color(),color)){
                        allPossibleMoves.add(new int[]{move[0],move[1]});
                    }
                }
            }
        }
        return allPossibleMoves;
    }
    public void nextTurn(){
        turn = (turn.equals("White")) ? "Black" : "White";
    }

    private boolean isOppositeColor(String moveToCheckColor, String originalMoveColor){
        return !originalMoveColor.equals(moveToCheckColor);

    }
    private boolean isInChessBoard(int rowToCheck, int colToCheck){
        return !(rowToCheck < 0 || rowToCheck > 7 || colToCheck < 0 || colToCheck > 7);
    }

    public void printChessBoard(){
        for(int row = 0; row < 8; row++){
            System.out.print("[");
            for(int col = 0; col < 8; col++){
                ChessPosition chessPiece = chessBoard[row][col];
                ChessPiece chessPieceType = chessPiece.chessPiece();
                switch (chessPieceType){
                    case ROOK -> System.out.print(" R");
                    case BISHOP -> System.out.print(" B");
                    case KNIGHT -> System.out.print(" N");
                    case QUEEN -> System.out.print(" Q");
                    case KING -> System.out.print(" K");
                    case PAWN -> System.out.print(" P");
                    case EMPTY -> System.out.print(" -");
                }
            }
            System.out.println(" ]");
        }
    }
    private boolean isTileEmpty(ChessPosition chessPosition){
        return chessPosition.chessPiece().equals(ChessPiece.EMPTY);
    }
    public void setRow(int row){
        this.row = row;
    }
    public void setCol(int col){
        this.col = col;
    }

    public int getRow() {
        return row;
    }

    public int getCol() {
        return col;
    }
}
