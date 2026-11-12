package org.example.models;

import java.util.Random;

public class Dice {
    private  int end_val;
    Random random = new Random();

    public  Dice(int end_val){
        this.end_val = end_val;
    }

    public  int rollDice(){
        return  random.nextInt(end_val)+1;
    }

}
