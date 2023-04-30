package com.example.chessgame.Frontend.EventHandlers;


public class Position {
    private double x;
    private double y;

    private int row;
    private int col;

    public Position(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public Position() {
        this(-1, -1);
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }


    public void setX(double x) {
        this.x = x;
    }

    public void setY(double y) {
        this.y = y;
    }

    public int getRow() {
        return row;
    }

    public int getCol() {
        return col;
    }

    public void setRow(int row) {
        this.row = row;
    }

    public void setCol(int col) {
        this.col = col;
    }
}
