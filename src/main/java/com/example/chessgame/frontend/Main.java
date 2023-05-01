
package com.example.chessgame.frontend;

import com.example.chessgame.backend.ChessBoard;
import com.example.chessgame.backend.GameMode;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class Main extends Application {
    @Override
    public void start(Stage stage) {
        GraphicalChessBoard chessBoard = new GraphicalChessBoard(112, new ChessBoard(GameMode.NORMAL));
        StackPane root = chessBoard.createBoard();
        stage.setScene(new Scene(root));
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}
