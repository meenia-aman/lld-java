package org.example.models;

public class Floor {
    private int floorId;
    private ExternalPannel externalPannel;

    public  Floor(int floorId, ExternalPannel externalPannel){
        this.floorId = floorId;
        this.externalPannel  = externalPannel;
    }

    public  int getFloorId(){
        return this.floorId;
    }

    public  ExternalPannel getExternalPannel(){
        return this.externalPannel;
    }

    }
