package com.example.formula_one;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.animation.*;
import javafx.fxml.FXML;
import javafx.scene.image.ImageView;
import javafx.util.Duration;

public class HelloController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private ImageView bg1, bg2, opponent, player;

    private final int BG_WIDTH = 856;

    private ParallelTransition parallelTransition;

    public static boolean right = false;
    public static boolean left = false;
    public static boolean forward = false;
    public static boolean back = false;
    private int player_speed = 3;
    private int opponent_speed = 3;

    AnimationTimer timer = new AnimationTimer() {
        @Override
        public void handle(long l) {
            // выполняется данный метод постоянно
            if (forward)
                player.setLayoutX(player.getLayoutX() - player_speed);
            if (back)
                player.setLayoutX(player.getLayoutX() + player_speed);
            if (right)
                if (player.getLayoutY() != opponent.getLayoutY())
                    player.setLayoutY(player.getLayoutY() + player_speed);
            if (left)
                player.setLayoutY(player.getLayoutY() - player_speed);
        }
    };

    @FXML
    void initialize() {
        TranslateTransition bgOneTransition = new TranslateTransition(Duration.millis(5000), bg1);
        bgOneTransition.setFromX(0);
        bgOneTransition.setToX(BG_WIDTH * -1);
        bgOneTransition.setInterpolator(Interpolator.LINEAR);

        TranslateTransition bgTwoTransition = new TranslateTransition(Duration.millis(5000), bg2);
        bgTwoTransition.setFromX(0);
        bgTwoTransition.setToX(BG_WIDTH * -1);
        bgTwoTransition.setInterpolator(Interpolator.LINEAR);

        parallelTransition = new ParallelTransition(bgOneTransition, bgTwoTransition);
        parallelTransition.setCycleCount(Animation.INDEFINITE);
        parallelTransition.play();

        timer.start();
    }

}
