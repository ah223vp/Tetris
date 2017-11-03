package view;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import model.TetrisGame;

public class Window extends Application {

    private int WIDTH = 500;
    private int HEIGHT = 500;


    public void start(Stage primaryStage){



        BorderPane root = new BorderPane();
        Canvas canvas = new Canvas();
        root.setCenter(canvas);

        canvas.setHeight(450);
        canvas.setWidth(250);

        GraphicsContext context = canvas.getGraphicsContext2D();

        initialize(context, canvas);

        Scene scene = new Scene(root, WIDTH,HEIGHT);

        primaryStage.setScene(scene);
        primaryStage.show();

    }
    public void initialize(GraphicsContext context, Canvas canvas){

        TetrisGame tetris = new TetrisGame();
        Painter painter = new Painter(context, tetris.getFactory());
        KeyActions keyActions = new KeyActions(canvas, tetris);

        tetris.getFactory().addSubscriber(painter);
    }

    public static void main(String []args){
        launch(args);
    }
}
