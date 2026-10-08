package org.example.service;

import org.example.models.Building;
import org.example.models.Elevator;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

import java.util.List;

public class SimulationEngine {

   private List<Building> buildings;

public    SimulationEngine(List<Building> buildings){
    this.buildings = buildings;
}

    public void startSimulation() {
        // 1. Create a scheduler thread pool
        ScheduledExecutorService scheduler = Executors.newSingleThreadScheduledExecutor();

        // 2. Schedule your run() method to execute every 1 second
        // Parameters: (Runnable task, initialDelay, period, timeUnit)
        scheduler.scheduleAtFixedRate(this::run, 0, 1, TimeUnit.SECONDS);
    }


    void run(){



    for(Building it:buildings){

        for(Elevator elevator:it.getElevators()){
            elevator.getTick();
        }

    }

 }

}
