package org.example;

import org.example.models.*;
import org.example.service.ElevatorService;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    static void main() {

        List<Building> buildings = new ArrayList<>();
        Building building = new Building();
        ElevatorService elevatorService = new ElevatorService(buildings);

        ExternalPannel e1 = new ExternalPannel(building.getId(),1,elevatorService);
        ExternalPannel e2 = new ExternalPannel(building.getId(),2,elevatorService);
        ExternalPannel e3 = new ExternalPannel(building.getId(),3,elevatorService);
        ExternalPannel e4 = new ExternalPannel(building.getId(),4,elevatorService);
        ExternalPannel e5 = new ExternalPannel(building.getId(),5,elevatorService);
        ExternalPannel e6 = new ExternalPannel(building.getId(),6,elevatorService);
        ExternalPannel e7 = new ExternalPannel(building.getId(),7,elevatorService);
        ExternalPannel e8 = new ExternalPannel(building.getId(),8,elevatorService);
        ExternalPannel e9 = new ExternalPannel(building.getId(),9,elevatorService);

        Floor f1 = new Floor(1,e1);
        Floor f2 = new Floor(2,e2);
        Floor f3 = new Floor(3,e3);
        Floor f4 = new Floor(4,e4);
        Floor f5 = new Floor(5,e5);
        Floor f6 = new Floor(6,e6);
        Floor f7 = new Floor(7,e7);
        Floor f8 = new Floor(8,e8);
        Floor f9 = new Floor(9,e9);

        building.addFloor(f1);
        building.addFloor(f2);
        building.addFloor(f3);
        building.addFloor(f4);
        building.addFloor(f5);
        building.addFloor(f6);
        building.addFloor(f7);
        building.addFloor(f8);
        building.addFloor(f9);
        buildings.add(building);

        Elevator elevator = new Elevator();

        building.addElevator(elevator);

        List<Button> buttons = new ArrayList<>();
        buttons.add(new FloorButton("1", 1));
        buttons.add(new FloorButton("2", 2));
        buttons.add(new FloorButton("3", 3));
        buttons.add(new FloorButton("4", 4));
        buttons.add(new FloorButton("5", 5));
        buttons.add(new FloorButton("6", 6));
        buttons.add(new FloorButton("7", 7));
        buttons.add(new FloorButton("9", 9));
        buttons.add(new FloorButton("9", 9));
        InternalPannel internalPannel = new InternalPannel(buttons,building.getId(),elevator,elevatorService);
        elevator.setInternalPannel(internalPannel);

//        List<Building> buildingList = elevatorService.getBuildings();
//        Building b1 = buildingList.get(0);
//        List<Floor> floors = b1.getFloors();
//        for(Floor it:floors){
//            System.out.println("Floor Id "+it.getFloorId());
//        }
//
//        List<Elevator> elevators = b1.getElevators();
//
//        for(Elevator it:elevators){
//            System.out.println("Elevator Id "+it.getId());
//        }

       e5.pressDownButton();

        ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(2);

        scheduler.schedule(
                ()-> internalPannel.pressButton("2"),
                3,
                TimeUnit.SECONDS
        );

        internalPannel.pressButton("9");
//        internalPannel.pressButton("2");
//        internalPannel.pressButton("1");
//

    }
}
