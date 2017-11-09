package view;

import javafx.geometry.Insets;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;


public class RightSidePane {

    // TODO Create a rightside pane that holds score and the next piece.

    public VBox initialize(){

        VBox vbox = new VBox();

        HBox score = new HBox();

        Label label = new Label("Score: ");
        TextField text = new TextField("0");

        score.getChildren().addAll(label, text);
        score.setSpacing(10);

        StackPane piece = new StackPane();

        Canvas canvas = new Canvas();

        canvas.setWidth(100);
        canvas.setHeight(100);

        piece.getChildren().add(canvas);

        GraphicsContext context = canvas.getGraphicsContext2D();

        context.setFill(Color.RED);
        context.fillRect(20,20,100,100);
        piece.setMargin(canvas, new Insets(0,0,200,0));


        vbox.getChildren().addAll(piece, score);
        vbox.setStyle("-fx-background-color: green");

        return vbox;

    }
}
