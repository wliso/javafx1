package sample;

import javafx.animation.PathTransition;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.util.Duration;

import java.awt.*;
import java.util.Random;

//import java.awt.*;

public class Main extends Application {

//    @Override
//    public void start(Stage primaryStage) throws Exception{
//        //Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
//        primaryStage.initStyle(StageStyle.TRANSPARENT);
//        StackPane root = new StackPane();
//        Button btn = new Button();
//        root.getChildren().add(btn);
//        Scene scene = new Scene(root, 300, 275);
//        //scene.setFill(Color.TRANSPARENT);
//        primaryStage.setScene(scene);
//        primaryStage.
//        primaryStage.show();
//    }
private double xOffset = 0;
    private double yOffset = 0;

    @Override
    public void start(Stage stage) throws Exception {
        stage.initStyle(StageStyle.TRANSPARENT);
        Group root = new Group();
        Button btn = new Button();
        btn.setPrefWidth(40);
        btn.setPrefHeight(20);

        btn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                double x = root.getLayoutX();
                double y = root.getLayoutY();
                Random random = new Random();
                double randX = random.nextDouble()*280;
                double randY = random.nextDouble()*230;
                Line line = new Line();
                line.setStartX(btn.getTranslateX()+20);
                line.setStartY(btn.getTranslateY()+10);
                line.setEndX(randX);
                line.setEndY(randY);
                PathTransition transition = new PathTransition();
                transition.setNode(btn);
                transition.setDuration(Duration.seconds(1));
                transition.setPath(line);
                transition.play();
                //btn.relocate(randX, randY);
            }
        });
        root.getChildren().add(btn);
        Scene scene = new Scene(root, 300, 250);
        scene.setFill(Color.TRANSPARENT);
        stage.setScene(scene);

        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
