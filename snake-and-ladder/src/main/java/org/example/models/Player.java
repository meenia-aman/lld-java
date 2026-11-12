package org.example.models;

public class Player {
    private  int id;
    private  String name;
    private  int current_pos;


    public  Player(int id, String name){
        this.id = id;
        this.name = name;
    }

    public int setPos(int newPos){
        this.current_pos = newPos;
        return this.current_pos;
    }

    public  int getPos(){
        return this.current_pos;
    }

    public int getId(){
        return this.id;
    }
    public  String getName(){
        return this.name;
    }

}
