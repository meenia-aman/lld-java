package org.example.models;

import org.example.enums.ButtonType;

public class FloorButton extends  Button{

    public  FloorButton(String name, int floorId){
             super(name, ButtonType.Floor,floorId);
    }

}
