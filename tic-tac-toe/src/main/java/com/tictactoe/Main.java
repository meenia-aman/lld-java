package com.tictactoe;

import com.tictactoe.enums.WinningRulesType;
import com.tictactoe.models.Board;
import com.tictactoe.models.Player;
import com.tictactoe.rules.StandardWinningRules;
import com.tictactoe.rules.WiningRules;
import com.tictactoe.service.GamePlay;

import java.util.ArrayList;
import java.util.List;

public class Main {

    static void main() {
        System.out.println("============ TIC TAC TOE ===============");


        Board board = new Board(3, 3);
        board.display();
        WiningRules rule = new StandardWinningRules();
        List<WiningRules> winingRules = List.of(rule);

        GamePlay gamePlay = new GamePlay(board, winingRules);
        Player p1 = new Player(1, "Aman", 'X');
        Player p2 = new Player(2, "Meenia", 'O');

        gamePlay.add_player(p1);
        gamePlay.add_player(p2);
        gamePlay.start_game();


    }

}
