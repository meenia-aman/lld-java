package org.example.models.ticket;

import org.example.models.Vehicle.Vehicle;

import java.time.LocalDateTime;
import java.util.UUID;

public class Ticket {
    private String id;
    private Vehicle vehicle;
    private int slotId;
    private LocalDateTime startTime;
    private boolean isValid;
    private  boolean paymentStatus;

    public Ticket(Vehicle vehicle , int slotId){
       this.vehicle = vehicle;
       this.slotId  = slotId;
       this.id =UUID.randomUUID().toString();
       this.startTime = LocalDateTime.now();
       this.isValid = true;
       this.paymentStatus = false;
    }

    private void make_ticket_invalid(){
        this.isValid =false;
    }

    public  boolean makePayment(){
        if(this.paymentStatus==false){
            this.paymentStatus = true;
            this.make_ticket_invalid();
            return true;
        }
        return  false;
    }

    public String getId(){
        return this.id;
    }

    public  LocalDateTime getStartTime(){
        return  this.startTime;
    }

    public boolean isValid(){
        return this.isValid;
    }

    public int getSlotId(){
        return this.slotId;
    }

}
