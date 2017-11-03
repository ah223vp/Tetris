package view;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import model.IObserver;
import model.Shape;
import model.ShapeFactory;

import java.awt.*;
import java.util.ArrayList;


public class Painter implements IObserver {

    GraphicsContext context;
    ShapeFactory shapeFactory;

    private int unit = 10;

    public Painter(GraphicsContext context, ShapeFactory shapeFactory){
        this.context = context;
        this.shapeFactory = shapeFactory;
    }

    public void draw(){

        context.clearRect(0,0,500,500);
        context.setFill(Color.GRAY);
        context.fillRect(0,0,500,500);

        context.setFill(Color.BLACK);

        ArrayList<Shape> objects = shapeFactory.getObjects();

        for(Shape s: objects){
            Point temp = s.getPosition();
            for(int i = 0; i < 4; i++){
                for(int j = 0; j < 4; j++){

                    // Hardcoded, rotations needs to be sent from model.
                    if(s.getShape().get(0)[i][j] == 1){
                        context.fillRect(temp.x + j * unit, temp.y + i * unit, unit, unit );
                    }
                }
            }
        }
    }
}
