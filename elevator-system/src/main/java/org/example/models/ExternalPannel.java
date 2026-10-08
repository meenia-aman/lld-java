package org.example.models;

import org.example.enums.ButtonType;
import org.example.enums.Direction;
import org.example.service.ElevatorService;

import java.util.UUID;

public class ExternalPannel {
    private  String buildingId;
    private String id;
    private  int floorId;
    private  Button upButton;
    private Button downButton;
    private ElevatorService elevatorService;


    public ExternalPannel(String buildingId, int floorId,ElevatorService elevatorService){
        this.id = UUID.randomUUID().toString();
        this.buildingId = buildingId;
        this.floorId = floorId;
        upButton = new NormalButton("Up", ButtonType.UP);
        downButton = new NormalButton("Down", ButtonType.DOWN);
        this.elevatorService  = elevatorService;
    }

   public void pressUpButton(){

       System.out.println(" ======================= NEW EXTERNAL REQUEST ================");
        boolean state = upButton.pressButton();
        if(state) {
            System.out.println("Up button pressed on floor " + floorId + " on building " + buildingId);
            elevatorService.createExternalRequest(this,Direction.UP);
        }else{
            System.out.println("Up button unpressed successfully on floor " + floorId + " on building " + buildingId);
        }

       System.out.println(" ====================================================================");
    }

    public void pressDownButton(){
        System.out.println(" ======================= NEW EXTERNAL REQUEST ================");
        boolean state = downButton.pressButton();
        if(state) {
            System.out.println("Down button pressed on floor " + floorId + " on building " + buildingId);
            elevatorService.createExternalRequest(this, Direction.DOWN);
        }else{
            System.out.println("Down button unpressed successfully on floor " + floorId + " on building " + buildingId);
        }
        System.out.println(" ====================================================================");
    }

    public String getId() {
        return this.id;
    }
    public  int getFloorId(){
        return this.floorId;
    }

    public String getBuildingId() {
        return buildingId;
    }
}
