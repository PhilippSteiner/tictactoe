package com.steiner_consult.tictactoe.models;

/**
 * Created by Philipp on 06.05.15.
 */
public class Point {

    int x, y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public String toString() {
        return "[" + x + ", " + y + "]";
    }
}
