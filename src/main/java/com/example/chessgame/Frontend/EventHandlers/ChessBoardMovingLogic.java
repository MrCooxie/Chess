package com.example.chessgame.Frontend.EventHandlers;

import com.example.chessgame.Backend.ChessBoard;
import com.example.chessgame.Backend.MoveStrategy.Move;
import com.example.chessgame.Backend.Piece.Piece;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.TilePane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

import java.util.ArrayList;

public class ChessBoardMovingLogic {
    private final ChessBoard chessBoard;
    private final StackPane root;

    private final Position posOfPressedEvent = new Position();
    private final int sizeOfSquare;


    public ChessBoardMovingLogic(ChessBoard chessBoard, StackPane root, int sizeOfSquare) {
        this.chessBoard = chessBoard;
        this.root = root;
        this.sizeOfSquare = sizeOfSquare;
    }

    public void onMouseDraggedEvent(MouseEvent mouseEvent) {
        if (isRightButtonPressed(mouseEvent)) {
            if (posOfPressedEvent.getX() != -1 && posOfPressedEvent.getY() != -1) { // -1 are default values of Position so basically checks whether a press wad done on n piece
                ImageView imageOnTile = getImageOnTile(posOfPressedEvent.getRow(), posOfPressedEvent.getCol());
                if (imageOnTile != null) {
                    modifyImage(mouseEvent.getX(), mouseEvent.getY(), imageOnTile);
                    root.getChildren().add(imageOnTile);
                } else {
                    //Means that images has already been removed
                    modifyImage(mouseEvent.getX(), mouseEvent.getY(), (ImageView) root.getChildren().get(1));
                }

            }
        }
    }

    public void onMousePressedEvent(MouseEvent mouseEvent) {
        if (isRightButtonPressed(mouseEvent)) {
            Piece piece = getPieceAtLoc(mouseEvent.getX(), mouseEvent.getY());
            if (piece != null) {
                posOfPressedEvent.setX(mouseEvent.getX());
                posOfPressedEvent.setY(mouseEvent.getY());
                posOfPressedEvent.setRow(piece.getRow());
                posOfPressedEvent.setCol(piece.getCol());
                showHints(piece.getAllPossibleMoves());
            }
        }
    }

    private void showHints(ArrayList<Move> placesToAddHint) {
        for (Move move : placesToAddHint) {
            //Expects that Tile Pane is at 0 index, must fix if I decide to remove the entire Tile Pane from root for some reason
            ((StackPane) ((TilePane) root.getChildren().get(0)).getChildren().get(getLocOfItemInTilePane(move.row(), move.col()))).getChildren().add(new Circle(18.5, Color.rgb(0, 0, 0, 0.1)));
        }
    }

    private Piece getPieceAtLoc(double x, double y) {
        //Returns null if there is no piece at that position
        int row = (int) (y / 112);
        int col = (int) (x / 112);
        return chessBoard.getChessBoard()[row][col];
    }

    private boolean isRightButtonPressed(MouseEvent mouseEvent) {
        return mouseEvent.getButton().equals(MouseButton.PRIMARY);
    }

    private int getLocOfItemInTilePane(int row, int col) {
        return row * 8 + col;
    }

    private ImageView getImageOnTile(int row, int col) {
        //If Image doesn't exist return null otherwise return new Image with same image attribute and remove the old Image.
        StackPane stackPaneToCheck = ((StackPane) ((TilePane) root.getChildren().get(0)).getChildren().get(getLocOfItemInTilePane(row, col)));
        for (int i = 0; i < stackPaneToCheck.getChildren().size(); i++) {
            if (stackPaneToCheck.getChildren().get(i) instanceof ImageView imageView) {
                ImageView newImageView = new ImageView(imageView.getImage());
                stackPaneToCheck.getChildren().remove(i);
                return newImageView;
            }
        }
        return null;
    }

    private void modifyImage(double x, double y, ImageView imageView) {
        imageView.setTranslateX(x - 4 * sizeOfSquare);
        imageView.setTranslateY(y - 4 * sizeOfSquare);
    }
}
