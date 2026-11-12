package org.example.models;

import org.example.enums.BoardElementType;

public class Ladder extends  BoardElement{
    public Ladder(int start_cell, int end_cell) {
        if(start_cell>=end_cell){
            throw new  IllegalArgumentException("Start of the ladder can't be equal or greater than the end of the ladder");
        }
        super(start_cell, end_cell);
    }


    @Override
    public int getNewPosition(int current_pos) {
        if(this.getStartCell()==current_pos){
            return this.getEndCell();
        }
        return current_pos;
    }

    @Override
    public BoardElementType getType() {
        return BoardElementType.LADDER;
    }
}
