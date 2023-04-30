/*
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
    private final Position posOfReleasedEvent = new Position();
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
           */
/* System.out.println(piece);
            for(Move move : piece.getAllPossibleMoves()) {
                System.out.println(move.row() + " " + move.col());
            }*//*

            if (piece != null) {
                posOfPressedEvent.setX(mouseEvent.getX());
                posOfPressedEvent.setY(mouseEvent.getY());
                posOfPressedEvent.setRow(piece.getRow());
                posOfPressedEvent.setCol(piece.getCol());
                addHints(piece.getAllPossibleMoves());
            }
        }
    }

    public void onMouseReleasedEvent(MouseEvent mouseEvent) {
        if (isRightButtonPressed(mouseEvent)) {
            if (posOfPressedEvent.getX() != -1 && posOfPressedEvent.getY() != -1) {

                posOfReleasedEvent.setX(mouseEvent.getX());
                posOfReleasedEvent.setY(mouseEvent.getY());
                posOfReleasedEvent.setRow((int) mouseEvent.getY() / 112);
                posOfReleasedEvent.setCol((int) mouseEvent.getX() / 112);

                Piece pieceOnPressed = chessBoard.getChessBoard()[posOfPressedEvent.getRow()][posOfPressedEvent.getCol()];

                boolean legalMove = chessBoard.move(pieceOnPressed.getRow(), pieceOnPressed.getCol(), posOfReleasedEvent.getRow(), posOfReleasedEvent.getCol());
                ImageView imageOfPiece = removeImageFromRoot();
                if (imageOfPiece != null) {
                    if (legalMove) {
                        removeImageFromTile(posOfReleasedEvent.getRow(), posOfReleasedEvent.getCol());
                        addImageToTile(posOfReleasedEvent.getRow(), posOfReleasedEvent.getCol(), imageOfPiece);
                        removeHints();
                    } else {
                        addImageToTile(posOfPressedEvent.getRow(), posOfPressedEvent.getCol(), imageOfPiece);
                    }
                }
            }
        }
    }
    private void removeHints(){
        // Bad performance because checking every tile if it contains hints ._. In the future I will implement a better solution
        TilePane tilePane = (TilePane) root.getChildren().get(0);
        for(int i = 0; i < tilePane.getChildren().size();i++){
            StackPane square = (StackPane) tilePane.getChildren().get(i);
            for(int j = 0; j < square.getChildren().size();j++){
                if(square.getChildren().get(j) instanceof Circle){
                    square.getChildren().remove(j);
                    break;
                }
            }
        }
    }

    private void addHints(ArrayList<Move> placesToAddHint) {
        // Bad performance but checking every tile if it contains hints ._.
        removeHints();

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

    private ImageView removeImageFromTile(int row, int col) {
        StackPane stackPane = ((StackPane) ((TilePane) root.getChildren().get(0)).getChildren().get(getLocOfItemInTilePane(row, col)));
        for (int i = 0; i < stackPane.getChildren().size(); i++) {
            if (stackPane.getChildren().get(i) instanceof ImageView imageView) {
                stackPane.getChildren().remove(i);
                return imageView;
            }
        }
        return null;
    }

    private ImageView removeImageFromRoot() {
        try {
            ImageView imageView = new ImageView(((ImageView) root.getChildren().get(1)).getImage());
            root.getChildren().remove(1);
            return imageView;
        } catch (IndexOutOfBoundsException e){
            //Root doesn't contain imageview
            return null;
        }
    }

    private void addImageToTile(int row, int col, ImageView imageView) {
        ((StackPane) ((TilePane) root.getChildren().get(0)).getChildren().get(getLocOfItemInTilePane(row, col))).getChildren().add(imageView);
    }
}
*/
