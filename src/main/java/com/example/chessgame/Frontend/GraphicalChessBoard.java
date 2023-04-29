/*
package com.example.chessgame.Frontend;

import com.example.chessgame.Frontend.EventHandlers.TilePanePieceDraggingEvent;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.TilePane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;

public class GraphicalChessBoard {
    private final int sizeOfSquare;
    private final Color colorOfDarkSquare;
    private final Color colorOfLightSquare;
    private final Color textColorOfDarkSquare;
    private final Color textColorOfLightSquare;

    private final Font textFont = Font.font("Verdana", FontWeight.BOLD, 20);

    public GraphicalChessBoard(int sizeOfSquare, Color colorOfDarkSquare, Color colorOfLightSquare, Color textColorOfDarkSquare, Color textColorOfLightSquare){
    this.sizeOfSquare = sizeOfSquare;
    this.colorOfDarkSquare = colorOfDarkSquare;
    this.colorOfLightSquare = colorOfLightSquare;
    this.textColorOfDarkSquare = textColorOfDarkSquare;
    this.textColorOfLightSquare = textColorOfLightSquare;
    }
    public GraphicalChessBoard(int sizeOfSquare){
        this(sizeOfSquare,Color.rgb(117, 151, 88), Color.rgb(237, 239, 211), Color.rgb(236, 239, 210), Color.rgb(118, 155, 85));
    }
    public StackPane createBoard(){
        StackPane root = new StackPane();
        TilePane entireBoard = createTiles();
        addText(entireBoard);
        addPieces(entireBoard);
        root.getChildren().add(entireBoard);
        addEventHandler(root);
        return root;
    }
    private TilePane createTiles(){
        TilePane tilePane = new TilePane();
        tilePane.setPrefColumns(8);
        tilePane.setPrefRows(8);

        for(int row = 0; row < 8; row++){
            for(int col = 0; col < 8; col++){
                StackPane parentOfRectangle = new StackPane();
                if(((col % 2) == 0 && row % 2 == 0) || col % 2 == 1 && row % 2 == 1){
                    parentOfRectangle.getChildren().add(createTile(colorOfLightSquare));
                }else {
                    parentOfRectangle.getChildren().add(createTile(colorOfDarkSquare));
                }
                tilePane.getChildren().add(parentOfRectangle);
            }
        }
        return tilePane;
    }
    private Rectangle createTile(Color colorOfSquare){
        return  new Rectangle(sizeOfSquare,sizeOfSquare,colorOfSquare);
    }
    private void addText(TilePane tilePane){
        for(int row = 0; row  < 8; row++){
            for(int col = 0; col < 8; col++){
                if(col == 0) addNumberAsText((StackPane) tilePane.getChildren().get(getLocOfItemInTilePane(row,col)), row);
                if(row == 7) addStringAsText((StackPane) tilePane.getChildren().get(getLocOfItemInTilePane(row,col)), col);
            }
        }
    }
    private void addNumberAsText(StackPane rectangle, int row){
        Text text = new Text(String.valueOf(8 - row));
        if(row % 2 == 0) text.setFill(textColorOfLightSquare);
        else text.setFill(textColorOfDarkSquare);
        double pos = (sizeOfSquare / -2.0) + 15;
        text.setTranslateX(pos);
        text.setTranslateY(pos);
        text.setFont(textFont);
        rectangle.getChildren().add(text);
    }
    private void addStringAsText(StackPane rectangle, int col){
        Text text = new Text(String.valueOf((char) (col + 97)));
        if(col % 2 == 0) text.setFill(textColorOfDarkSquare);
        else text.setFill(textColorOfLightSquare);
        double pos = (sizeOfSquare / 2.0) - 15;
        text.setTranslateX(pos);
        text.setTranslateY(pos);
        text.setFont(textFont);
        rectangle.getChildren().add(text);
    }
    private int getLocOfItemInTilePane(int row, int col){
        return row * 8 + col;
    }
    private void addPieces(TilePane tilePane){
        for(int row = 0; row < 8; row++){
            for(int col = 0; col < 8; col++){
                if(row == 7 || row == 0 || row == 1 || row == 6) {
                    String color = (row < 2) ? "Black" : "White";
                    String piece = null;
                    if (row == 7 || row == 0) {
                        switch (col) {
                            case 0, 7 -> piece = "Rook";
                            case 1, 6 -> piece = "Knight";
                            case 2, 5 -> piece = "Bishop";
                            case 3 -> piece = "Queen";
                            case 4 -> piece = "King";
                        }
                    } else {
                        piece = "Pawn";
                    }
                    String entirePiece = color + "_" + piece;
                    ImageView imageView = new ImageView(this.getClass().getResource("/com/example/chessgame/ImagesOfChessPieces/" + entirePiece + ".png").toString());
                    ((StackPane) tilePane.getChildren().get(getLocOfItemInTilePane(row,col))).getChildren().add(imageView);
                }
            }

        }

    }
    private void addEventHandler(StackPane root){
        TilePanePieceDraggingEvent eventHandler = new TilePanePieceDraggingEvent(root, sizeOfSquare);
        root.setOnMouseDragged(eventHandler::onMouseDraggedEvent);
        root.setOnMousePressed(eventHandler::onMousePressedEvent);
        root.setOnMouseReleased(eventHandler::onMouseReleasedEvent);
    }


}
*/
