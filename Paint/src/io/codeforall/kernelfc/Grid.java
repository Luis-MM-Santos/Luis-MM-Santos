package io.codeforall.kernelfc;

import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;

public class Grid {
    private static int cellSize;
    private int cols;
    private int rows;
    private static int padding;
    public Rectangle[][] cellsArray;
    public Grid() {
        cellSize = 40;
        padding = 10;
        rows = 25;
        cols = 25;
        cellsArray = new Rectangle[cols][rows];
        drawGrid();
    }
    void drawGrid() {
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                cellsArray[row][col] =  new Rectangle(getX(col), getY(row), cellSize, cellSize);
                cellsArray[row][col].setColor(Color.RED);
                cellsArray[row][col].draw();
            }
        }
    }

    public boolean paint(int x, int y) {

        if (cellsArray[x][y].getColor() == Color.WHITE){
            return false;
        }
        cellsArray[x][y].setColor(Color.BLACK);
        cellsArray[x][y].fill();
        return true;
    }


    public static int getX(int col) {
        return padding + col * cellSize;
    }
    public static int getY(int row) {
        return padding + row * cellSize;
    }
    public static int getCellSize() {
        return cellSize;
    }





}
