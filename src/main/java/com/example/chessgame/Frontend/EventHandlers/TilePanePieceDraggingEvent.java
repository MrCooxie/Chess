package com.example.chessgame.Frontend.EventHandlers;
import com.example.chessgame.Backend.ChessBoard;
import com.example.chessgame.Backend.ChessPiece;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.TilePane;

//Hi
public class TilePanePieceDraggingEvent {
    private final StackPane root;
    private final TilePane tilePane;
    private final int sizeOfSquare;
    public TilePanePieceDraggingEvent(StackPane root, int sizeOfSquare){
        this.sizeOfSquare = sizeOfSquare;
        this.root = root;
        this.tilePane = (TilePane) root.getChildren().get(0);
    }
    ChessBoard chessBoard = new ChessBoard();

    private boolean isPressingOnAPiece = false;
    private int[] posOfMousePressed;
    public void onMouseDraggedEvent(MouseEvent mouseEvent){
        if(isRightButtonPressed(mouseEvent) && isPressingOnAPiece){
            int row = posOfMousePressed[0];
            int col = posOfMousePressed[1];
            ImageView imageView;
            if(tileContainsImage(row,col)) {
                imageView = new ImageView(getImageFromTile(row,col).getImage());
                removeImageFromTile(row, col);
            } else {
                imageView = new ImageView(getImageFromRoot().getImage());
                removeImageFromRoot();
            }
            System.out.println(mouseEvent.getX()+ " " + mouseEvent.getY());
            addImageToRoot(imageView, mouseEvent.getX() - 4 * sizeOfSquare, mouseEvent.getY() - 4 * sizeOfSquare);
        }
    }
    private void removeImageFromRoot(){
        for(int i = 0; i < root.getChildren().size();i++){
            if(root.getChildren().get(i) instanceof ImageView){
                root.getChildren().remove(i);
                break;
            }
        }
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
    public void onMousePressedEvent(MouseEvent mouseEvent){
        if(isRightButtonPressed(mouseEvent)){
            posOfMousePressed = getLocOfCursorInTilePane(mouseEvent.getX(),mouseEvent.getY());
            isPressingOnAPiece = isActionOnTopPiece(mouseEvent.getX(),mouseEvent.getY());
        }
    }
    public void onMouseReleasedEvent(MouseEvent mouseEvent){
        if(isRightButtonPressed(mouseEvent)){
            isPressingOnAPiece = false;
        }
    }
    private boolean isRightButtonPressed(MouseEvent mouseEvent){
        return mouseEvent.getButton().equals(MouseButton.PRIMARY);
    }
    private boolean isActionOnTopPiece(double x, double y){
        //TODO: implement backend
        int row = (int) y / 112;
        int col = (int) x / 112;
       return (!(chessBoard.getChessBoard()[row][col].chessPiece().equals(ChessPiece.EMPTY)));
    }
    private int[] getLocOfCursorInTilePane(double x, double y){
        return new int[]{(int) y/112, (int) x / 112};
    }
}
