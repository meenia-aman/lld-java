package org.example.models;

import org.example.enums.BoardElementType;

public abstract class BoardElement {

    private  int start_cell;
    private  int end_cell;

    public  BoardElement(int start_cell, int end_cell){
        this.start_cell = start_cell;
        this.end_cell = end_cell;
    }

   public abstract BoardElementType getType();
   public  abstract  int getNewPosition(int current_pos);

   public int getStartCell(){
      return this.start_cell;
   }
   public  int getEndCell(){
       return this.end_cell;
   }

}
