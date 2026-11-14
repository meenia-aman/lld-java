package com.tictactoe.rules;

import com.tictactoe.enums.WinningRulesType;
import com.tictactoe.models.Board;

public interface WiningRules {
    boolean isWinner(Board board, char symbol, int row, int col);

    WinningRulesType getType();

}
