package org.example.models;

import org.example.enums.BoardElementType;

public class Snake extends BoardElement{

    public Snake(int start_cell, int end_cell) {
        if(start_cell<=end_cell){
            throw  new IllegalArgumentException("Start cell (Head) of the snake can't be less or equal thatn End cell (Tail) of the snake");
        }
        super(start_cell, end_cell);
    }

    @Override
    public BoardElementType getType() {
        return BoardElementType.SNAKE;
    }

    @Override
    public int getNewPosition(int current_pos) {
        if(this.getStartCell() == current_pos){
        return  this.getEndCell();
        }
        return current_pos;
    }

}
