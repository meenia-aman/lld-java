package org.example.models;

import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class Board {
    private  final int row_size;
    private final int col_size;
    private Map<Integer,BoardElement> boardElements = new HashMap<>();
    private  boolean isBuild = false;

    public  Board(int row_size, int col_size){
        this.row_size = row_size;
        this.col_size = col_size;
    }

    public  void build(){
        this.isBuild = true;
    }

    public  boolean addBoardElements(BoardElement boardElement){
        if(isBuild){
            System.out.println("Elements can't be set, once board is build");
        return false;
        }

        int size  = this.row_size * this.col_size;
        if(boardElement.getStartCell()<=0 || boardElement.getStartCell()>size || boardElement.getEndCell()<=0 || boardElement.getEndCell()>size){
            throw new IllegalArgumentException("Please enter the valid BoarElements values according to board dimension");
        }

        if(boardElements.containsKey(boardElement.getStartCell())){
            System.out.println("Another boardElement is already at same startposition");
            return false;
        }
        boardElements.put(boardElement.getStartCell(),boardElement);
        return true;
    }

    public Map<Integer, BoardElement> getBoardElements() {
        return Collections.unmodifiableMap(this.boardElements);
    }
    public int getRowSize(){
        return this.row_size;
    }
    public  int getColSize(){
        return this.col_size;
    }

    public  boolean isWinner(int current_pos){
        if(current_pos==(row_size*col_size)) {
            return true;
        }
        return false;
    }

    public  boolean isValid(int new_pos){
        if(new_pos<=(row_size*col_size)) return true;
        return false;

    }
}
