package org.example.service;

import org.example.enums.BoardElementType;
import org.example.models.BoardElement;

import java.util.HashMap;
import java.util.Map;

public class MoveChecker {

    private Map<Integer,BoardElement> boardElements = new HashMap<>();

    public  MoveChecker( Map<Integer, BoardElement> boardElements){
        this.boardElements= boardElements;
    }

    public  int getNewPosition(int current_pos){
        BoardElement element= boardElements.get(current_pos);
        if(element==null) return current_pos;
        return element.getNewPosition(current_pos);
    }

    public BoardElementType getMoveType(int current_pos){
        BoardElement element= boardElements.get(current_pos);
        if(element==null) return null;
        return element.getType();

    }
}
