package io.codeforall.kernelfc;

public class GridPosition {
    private Grid grid;
    private int col;
    private int row;
    private int x;
    private int y;
    private String TheGridPosition;

    public GridPosition(int col, int row) {
        this.grid = grid;
        this.col = col;
        this.row = row;
        this.x = colToX();
        this.y = rowToY();
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getCol() {
        return col;
    }

    public int getRow() {
        return row;
    }

    public void setCol(int col) {
        this.col = col;
    }

    public void setRow(int row) {
        this.row = row;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int colToX() {
        return col * grid.getCellSize();
    }

    public int rowToY() {
        return row * grid.getCellSize();
    }

    public String getGridPosition(){
        TheGridPosition = getCol() + ", " + getRow();
        return TheGridPosition;
    }
}
