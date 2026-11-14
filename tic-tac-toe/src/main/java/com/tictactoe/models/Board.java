package com.tictactoe.models;

import java.util.ArrayList;
import java.util.List;

public class Board {

    private final int row;
    private final int cols;
    private final List<Cell> cells = new ArrayList<>();
    private int cells_filled;
    private char empty_char = '_';

    public Board(int row, int cols) {
        this.row = row;
        this.cols = cols;
        this.cells_filled = 0;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < cols; j++) {
                int id = (i * cols + j + 1);
                Cell cell = new Cell(id, empty_char);
                cells.add(cell);
            }
        }
    }

    public int isValidCell(int row, int col) {
        int id = row * this.cols + col + 1;
        if (row < 0 || row >= this.row || col < 0 || col >= this.cols) {
            return -1;
        }
        return id;
    }

    public boolean placeSymbol(int row, int col, char symbol) {
        int idx = isValidCell(row, col);
        if (idx == -1) {
            return false;
        }
        System.out.println("IDX is " + idx);
        Cell cell = this.cells.get(idx - 1);


        if (empty_char != cell.getSymbol()) {

            return false;
        }
        cell.setSymbol(symbol);
        cells_filled += 1;
        return true;
    }

    public void display() {
        for (int i = 0; i < this.row; i++) {
            for (int j = 0; j < this.cols; j++) {
                int id = (i * cols + j + 1);
                char symbol = this.cells.get(id - 1).getSymbol();
                if (symbol == ' ') {
                    System.out.print("_" + " ");
                } else {
                    System.out.print(symbol + " ");
                }
            }
            System.out.println();
        }
    }

    public boolean isCompletelyFilled() {
        return (this.row * this.cols) == this.cells_filled;
    }

    public int getCols() {
        return cols;
    }

    public int getRow() {
        return row;
    }

    public boolean cellSymbolSame(int row, int col, char symbol) {
        int idx = this.isValidCell(row, col);
        if (idx == -1) return false;
        idx -= 1;
        return cells.get(idx).getSymbol() == symbol;
    }
}

