package com.tictactoe.service;

import com.tictactoe.enums.GameStatus;
import com.tictactoe.models.Board;
import com.tictactoe.models.Player;
import com.tictactoe.rules.WiningRules;

import java.util.ArrayDeque;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

public class GamePlay {
    private Queue<Player> players = new ArrayDeque<>();
    private final Board board;
    private GameStatus state;
    private List<WiningRules> winingRules;
    Scanner scanner = new Scanner(System.in);

    public GamePlay(Board board, List<WiningRules> winingRules) {
        this.board = board;
        this.state = GameStatus.PENDING;
        this.winingRules = winingRules;
    }

    public void add_player(Player player) {
        if (state != GameStatus.PENDING) {
            System.out.println("You can only add player in pending state only");
            return;
        }
        if (players.size() >= 2) {
            System.out.println("Game can has only two players");
            return;
        }
        players.add(player);
    }

    public void start_game() {
        if (players.size() != 2) {
            System.out.println(" Game requried 2 players to paly");
            return;
        } else if (this.state != GameStatus.PENDING) {
            System.out.println("Game can started only in Pending mode");
            return;
        }
        this.state = GameStatus.PLAYING;
        this.play();
    }


    boolean isWinner(char symbol, int row, int col) {
        for (WiningRules rules : this.winingRules) {
            System.out.println("Winning Condition Called");
            if (rules.isWinner(this.board, symbol, row, col)) {
                return true;
            }
        }
        return false;
    }

    void play() {

        while (this.state == GameStatus.PLAYING) {
            Player player = players.peek();

            System.out.println("Its you turn " + player.getName() + " please select and empty position in board (x,y)");

            int x, y;

            while (true) {
                x = scanner.nextInt();
                y = scanner.nextInt();

                if (board.isValidCell(x, y) != -1 && board.placeSymbol(x, y, player.getSymbol())) {
                    System.out.println("Symbol " + player.getSymbol() + " places at position " + "[" + x + "," + y + "]");
                    board.display();
                    break;
                }
                System.out.println(" Please enter the correct cell values,which is empty");
            }

            players.poll();
            players.offer(player);

            if (this.isWinner(player.getSymbol(), x, y)) {
                System.out.println("Player " + player.getName() + " is winner");
                System.out.println("Game Over");
                this.state = GameStatus.OVER;
                return;
            }

            if (board.isCompletelyFilled()) {
                System.out.println("Board is completely filled. Match Draw");
                System.out.println("Gamer Over");
                this.state = GameStatus.OVER;
                return;
            }


        }

    }


}
