package org.example.models;

import org.example.enums.ButtonType;

import java.util.UUID;

public class Button {
    private  String id;
    private  String name;
    private  boolean pressed;
    private ButtonType type;
    private int floorId;

    public Button(String name, ButtonType type, int floorId){
        this.id = UUID.randomUUID().toString();
        this.name = name;
        this.type = type;
        this.floorId = floorId;
    }

    boolean pressButton(){
        return   pressed = !pressed;
    }

    public String getId() {
        return id;
    }

    public boolean isPressed() {
        return pressed;
    }

    public String getName() {
        return name;
    }

    public ButtonType getType() {
        return type;
    }

    public int getFloorId() {
        return floorId;
    }
}
