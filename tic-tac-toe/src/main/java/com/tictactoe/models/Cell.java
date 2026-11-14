package com.tictactoe.models;

public class Cell {
    private final int id;
    private char symbol;

    public Cell(int id, char empty_symbol) {
        this.id = id;
        this.symbol = empty_symbol;
    }

    public void setSymbol(char symbol) {
        this.symbol = symbol;
    }

    public int getId() {
        return this.id;
    }

    public char getSymbol() {
        return symbol;
    }
}
