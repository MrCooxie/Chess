package com.example.chessgame.Frontend.EventHandlers;
import com.example.chessgame.Backend.ChessBoard;
import com.example.chessgame.Backend.ChessPiece;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.TilePane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

import java.util.ArrayList;

//Hi there
public class TilePanePieceDraggingEvent {
    private final StackPane root;
    private final TilePane tilePane;
    private final int sizeOfSquare;
    private final ChessBoard chessBoard = new ChessBoard();
    private int[] posOfCurrentMousePressed = null;
    private boolean isPressingOnAPiece = false;
    public TilePanePieceDraggingEvent(StackPane root, int sizeOfSquare){
        this.sizeOfSquare = sizeOfSquare;
        this.root = root;
        this.tilePane = (TilePane) root.getChildren().get(0);
    }

    public void onMouseDraggedEvent(MouseEvent mouseEvent){
        if(isRightButtonPressed(mouseEvent) && isPressingOnAPiece){
            int row = posOfCurrentMousePressed[0];
            int col = posOfCurrentMousePressed[1];
            ImageView imageView;
            if(tileContainsImage(row,col)) {
                imageView = new ImageView(getImageFromTile(row,col).getImage());
                removeImageFromTile(row, col);
            } else {
                imageView = new ImageView(getImageFromRoot().getImage());
                removeImageFromRoot();
            }
            addImageToRoot(imageView, mouseEvent.getX() - 4 * sizeOfSquare, mouseEvent.getY() - 4 * sizeOfSquare);
        }
    }
    public void onMousePressedEvent(MouseEvent mouseEvent){
        if(isRightButtonPressed(mouseEvent)) {
            int[] posOfPreviousMousePressed = posOfCurrentMousePressed;
            posOfCurrentMousePressed = getLocOfCursorInTilePane(mouseEvent.getX(), mouseEvent.getY());
            if (isPressedOnTopOfPiece(posOfCurrentMousePressed)) {
                if (posOfPreviousMousePressed == null) {
                    chessBoard.setRow(posOfCurrentMousePressed[0]);
                    chessBoard.setCol(posOfCurrentMousePressed[1]);
                    showHints();
                } else if (isPressedOnDifferentTile(posOfPreviousMousePressed, posOfCurrentMousePressed)) {
                    System.out.println("Here");
                    chessBoard.setRow(posOfPreviousMousePressed[0]);
                    chessBoard.setCol(posOfPreviousMousePressed[1]);
                    removeHints();
                    chessBoard.setRow(posOfCurrentMousePressed[0]);
                    chessBoard.setCol(posOfCurrentMousePressed[1]);
                    showHints();
                }
                isPressingOnAPiece =true;
            }
        }
    }
    public void onMouseReleasedEvent(MouseEvent mouseEvent){
        //TODO: Update backend
        if(isRightButtonPressed(mouseEvent) && isPressingOnAPiece) {
            isPressingOnAPiece = false;
            int[] posOnRelease = getLocOfCursorInTilePane(mouseEvent.getX(), mouseEvent.getY());
            int row = posOnRelease[0];
            int col = posOnRelease[1];
            if (rootContainsImage()) {
                ImageView imageView = new ImageView(getImageFromRoot().getImage());
                removeImageFromRoot();
                if (isLegalMove(row, col)) {
                    removeImageFromTile(row, col);
                    removeImageFromTile(posOfCurrentMousePressed[0], posOfCurrentMousePressed[1]);
                    addImageToTile(row, col, imageView);
                    removeHints();
                    chessBoard.updateChessBoard(row, col);
                    chessBoard.nextTurn();
                } else {
                    addImageToTile(posOfCurrentMousePressed[0], posOfCurrentMousePressed[1], imageView);
                }
            }

        }
    }

    private boolean isPressedOnTopOfPiece(int[] curMove){
        return !(chessBoard.getChessBoard()[curMove[0]][curMove[1]].chessPiece().equals(ChessPiece.EMPTY));
    }
    private boolean isPressedOnDifferentTile(int[] originalPosOfPressed,int[] newPosOfPressed){
        return !(originalPosOfPressed[0] == newPosOfPressed[0] && originalPosOfPressed[1] == newPosOfPressed[1]);
    }
    private void removeImageFromRoot(){
        for(int i = 0; i < root.getChildren().size();i++){
            if(root.getChildren().get(i) instanceof ImageView){
                root.getChildren().remove(i);
                break;
            }
        }
    }
    private boolean rootContainsImage(){
        for(int i = 0; i < root.getChildren().size();i++){
            if(root.getChildren().get(i) instanceof ImageView){
                return true;
            }
        }
        return false;
    }

    private ImageView getImageFromRoot(){
        for(int i = 0; i < root.getChildren().size();i++){
            if(root.getChildren().get(i) instanceof ImageView imageView){
                return imageView;
            }
        }
        return null;
    }
    private boolean tileContainsImage(int row, int col){
        StackPane rectangle = ((StackPane)tilePane.getChildren().get(getLocOfItemInTilePane(row,col)));
        for(int i = 0; i < rectangle.getChildren().size();i++){
            if(rectangle.getChildren().get(i) instanceof ImageView){
                return true;
            }
        }
        return false;
    }
    private void addImageToRoot(ImageView imageView, double x, double y){
        imageView.setTranslateX(x);
        imageView.setTranslateY(y);
        root.getChildren().add(imageView);
    }
    private ImageView getImageFromTile(int row, int col){
        StackPane rectangle = ((StackPane)tilePane.getChildren().get(getLocOfItemInTilePane(row,col)));
        for(int i = 0; i < rectangle.getChildren().size();i++){
            if(rectangle.getChildren().get(i) instanceof ImageView imageView){
                return imageView;
            }
        }
        return null;
    }
    private void removeImageFromTile(int row, int col){
        StackPane rectangle = ((StackPane)tilePane.getChildren().get(getLocOfItemInTilePane(row,col)));
        for(int i = 0; i < rectangle.getChildren().size();i++) {
            if (rectangle.getChildren().get(i) instanceof ImageView ) {
                rectangle.getChildren().remove(i);
                return;
            }
        }
    }
    private int getLocOfItemInTilePane(int row, int col){
        return row * 8 + col;
    }
    private void showHints(){
        ArrayList<int[]> allPossibleMoves = chessBoard.getAllPossibleMoves();
        for(int[] move : allPossibleMoves){
            ((StackPane) tilePane.getChildren().get(getLocOfItemInTilePane(move[0],move[1]))).getChildren().add(new Circle(18.5, Color.rgb(0,0,0,0.1)));
        }

    }
    private void removeHints(){
        ArrayList<int[]> allPossibleMoves = chessBoard.getAllPossibleMoves();
        for(int[] move : allPossibleMoves){
            StackPane rectangle = ((StackPane) tilePane.getChildren().get(getLocOfItemInTilePane(move[0],move[1])));
            for(int i = 0; i < rectangle.getChildren().size();i++){
                if(rectangle.getChildren().get(i) instanceof Circle){
                    rectangle.getChildren().remove(i);
                }
            }
        }
    }
    private boolean isLegalMove(int row, int col){
        System.out.println("Here" + chessBoard.getRow() + " " + chessBoard.getCol());
        //TODO: Row and Col might not be correct
        ArrayList<int[]> allPossibleMoves = chessBoard.getAllPossibleMoves();
        for(int[] moves : allPossibleMoves){
            if(moves[0] == row && moves[1] == col){
                return true;
            }
        }
        return false;
    }
    private void addImageToTile(int tileRow, int tileCol, ImageView imageView){
        StackPane rectangle = (StackPane) tilePane.getChildren().get(getLocOfItemInTilePane(tileRow,tileCol));
        rectangle.getChildren().add(imageView);
    }
    private boolean isRightButtonPressed(MouseEvent mouseEvent){
        return mouseEvent.getButton().equals(MouseButton.PRIMARY);
    }
    private int[] getLocOfCursorInTilePane(double x, double y){
        return new int[]{(int) y/112, (int) x / 112};
    }
}
