package com.example.formula_one;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.input.KeyCode;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.IOException;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("hello-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 856, 290);
        stage.initStyle(StageStyle.UNDECORATED);
        stage.setScene(scene);

        //отслеживаем нажатие клавиш
        scene.setOnKeyPressed(e -> {
            if(e.getCode() == KeyCode.A)
                HelloController.forward = true;

            if (e.getCode() == KeyCode.D)
                HelloController.back = true;

            if (e.getCode() == KeyCode.W)
                HelloController.left = true;

            if (e.getCode() == KeyCode.S)
                HelloController.right = true;
        });

        scene.setOnKeyReleased(e -> {
            if(e.getCode() == KeyCode.A)
                HelloController.forward = false;

            if (e.getCode() == KeyCode.D)
                HelloController.back = false;

            if (e.getCode() == KeyCode.W)
                HelloController.left = false;

            if (e.getCode() == KeyCode.S)
                HelloController.right = false;
        });

        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}