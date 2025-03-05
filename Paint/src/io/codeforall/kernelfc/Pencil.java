package io.codeforall.kernelfc;

import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;


public class Pencil {
    Rectangle rectangle;
    GridPosition gridPosition;

    public Pencil() {
        gridPosition = new GridPosition(10, 10);
        rectangle = new Rectangle(10, 10, 40, 40);
        rectangle.setColor(Color.GREEN);
        rectangle.fill();
    }

    public int getX(){
        return gridPosition.getCol();
    }
    public int getY(){
        return gridPosition.getRow();
    }

    public void move(double v, double v1) {
        if (gridPosition.getX() <= 970  && gridPosition.getY() <= 970 ) {
            rectangle.translate(v, v1);
            gridPosition = new GridPosition((int) (gridPosition.getX() + v), (int) (gridPosition.getRow() + v1));
            System.out.println(gridPosition.getGridPosition());
        }
        return;
    }


}