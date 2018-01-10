package com.covesta.technical.domain;

public class State {

    private char x;
    private char y;
    private char direction;

    public State (char x, char y, char direction) {
        this.x = x;
        this.y = y;
        this.direction = direction;
    }

    public char getX() {
        return x;
    }

    public char getY() {
        return y;
    }

    public char getDirection() {
        return direction;
    }

    public String toString() {
        return x + " " + y + " " + direction;
    }

}
