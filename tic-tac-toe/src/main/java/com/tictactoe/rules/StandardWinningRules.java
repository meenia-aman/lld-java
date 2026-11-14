package com.tictactoe.rules;

import com.tictactoe.enums.WinningRulesType;
import com.tictactoe.models.Board;

public class StandardWinningRules implements WiningRules {
    public StandardWinningRules() {

    }

    @Override
    public boolean isWinner(Board board, char symbol, int row, int col) {

        // Check Column
        int idx = 0;
        while (idx < board.getCols() && board.cellSymbolSame(row, idx, symbol)) {
            idx++;
        }
        if (idx >= board.getCols()) {
            return true;
        }

        // Check Row
        idx = 0;
        while (idx < board.getRow() && board.cellSymbolSame(idx, col, symbol)) {
            idx++;
        }
        if (idx >= board.getRow()) {
            return true;
        }

        // Check diagonal
        int x = 0, y = 0;
        while (x < board.getRow() && y < board.getCols() && board.cellSymbolSame(x, y, symbol)) {
            System.out.println("Diagonal cehceking " + x + " y " + y);
            x++;
            y++;
        }
        if (x == board.getRow()) return true;

        x = 0;
        y = board.getCols() - 1;
        while (x < board.getCols() && board.cellSymbolSame(x, y, symbol)) {
            x++;
            y--;
        }
        if (x == board.getRow()) return true;

        return false;
    }

    @Override
    public WinningRulesType getType() {
        return WinningRulesType.STANDARD;
    }
}
