package org.example;

import org.example.models.*;
import org.example.service.GamePlay;

import java.util.ArrayList;
import java.util.List;

public class  Main {
    static void main() {


        System.out.println("===========Snake And Ladder============");

        Player p1 = new Player(1,"Aman Meenia");
        Player p2 = new Player(2,"Rohit Sharma");

        Board board = new Board(10,10);
        BoardElement boardElement1 = new Snake(30,10);
        BoardElement boardElement2 = new Ladder(5,60);
        BoardElement boardElement3  = new Ladder(3,30);
        BoardElement boardElement4 = new Ladder(7,45);
        BoardElement boardElement5 = new Ladder(10,90);
        board.addBoardElements(boardElement1);
        board.addBoardElements(boardElement2);
        board.addBoardElements(boardElement3);
        board.addBoardElements(boardElement4);
        board.addBoardElements(boardElement5);

        board.build();

        List<Player> players = new ArrayList<>(List.of(p1,p2));
        Dice dice = new Dice(6);

        GamePlay gamePlay = new GamePlay(board,players,dice);
        gamePlay.startGame();



    }
}