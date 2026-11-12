package  org.example.service;

import org.example.enums.BoardElementType;
import org.example.enums.GameState;
import org.example.models.Board;
import org.example.models.Dice;
import org.example.models.Player;

import java.util.*;

public class GamePlay {

    private final  Board board;
    private Queue<Player> players = new ArrayDeque<>();
    private GameState state;
    private  final Dice dice;
    private  MoveChecker moveChecker;


    Scanner scanner = new Scanner(System.in);

    public  GamePlay (Board board, List<Player> players, Dice dice){

        this.board =board;
        this.state = GameState.PENDING;
        this.dice = dice;
        for(Player it:players){
            this.players.offer(it);
        }
        moveChecker = new MoveChecker(board.getBoardElements());
    }

    int roll_dice(){
        return dice.rollDice();
    }

    void playTurn(Player player){

        int dice_value = this.roll_dice();
        System.out.println("Dice Rolled: "+dice_value);

        players.poll();
        players.offer(player);

        int prevPos = player.getPos();
        int newPos = dice_value+player.getPos();


        if(!board.isValid(newPos)){
            System.out.println("You need smaller value for valid move ");
            return;
        }

        if(this.moveChecker.getNewPosition(newPos)!=newPos){
            BoardElementType type = this.moveChecker.getMoveType(newPos);
            int prev_pos = newPos;
            newPos = this.moveChecker.getNewPosition(newPos);
            System.out.println("You are moving from "+prev_pos + " new position "+newPos + " due to "+type+" at current cell");
        }



        player.setPos(newPos);
        System.out.println("Player "+player.getName() +" moves from "+prevPos+" to "+newPos);
        if(board.isWinner(newPos)){
            System.out.println("Game over and player "+player.getName()+" is the winner");
            this.state = GameState.OVER;
        }
    }

    public void startGame(){
        this.state = GameState.PLAYING;

        while(this.state==GameState.PLAYING){

            Player player = players.peek();
            System.out.println(player.getName() + " It's your turn. For rolling dice, enter you ID");

            int curent_user_id=-1;
            do{
                if(curent_user_id!=-1){
                    System.out.println("Please enter the correct UserID");
                }
                 curent_user_id = scanner.nextInt();
            }while(curent_user_id!=player.getId());

            this.playTurn(player);


       }


    }



}
