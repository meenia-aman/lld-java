package org.example.models;

import org.example.enums.ButtonType;
import org.example.service.ElevatorService;

import java.util.List;

public class InternalPannel {
    private  List<Button> buttons;
    private  String buildingId;
    private  Elevator elevator;
    private  ElevatorService elevatorService;


    public InternalPannel(List<Button> buttons, String buildingId, Elevator elevator, ElevatorService elevatorService){
        this.buttons = buttons;
        this.buildingId = buildingId;
        this.elevator = elevator;
        this.elevatorService = elevatorService;

    }

    void addButton(Button button){
        buttons.add(button);
    }

    public List<Button> getButtons() {
        return buttons;
    }

    public void pressButton(String buttonId){

        Button button= null;
        for(Button it:buttons){
            if(it.getName().equals(buttonId)){
                button = it;
                break;
            }
        }

        if(button==null) return;


        boolean state =  button.pressButton();

        if(state){
            System.out.println(" =================== NEW INTERNAL REQUEST ================");

            System.out.println("Button "+button.getName() +"pressed successfully");
            if(button.getType()== ButtonType.Floor){
                elevatorService.createInternalRequest(this,button.getFloorId());
            }
        }else{
            System.out.println("Button "+button.getName()+ "unpressed successfully");
        }
        System.out.println(" =======================================================");
        System.out.println("");

    }

    public Elevator getElevator() {
        return elevator;
    }

    public String getBuildingId() {
        return buildingId;
    }
}
