package org.example.strategy;

import org.example.models.Request;

import java.util.List;

public class NearestMovementStrategy implements  MovementStrategy{

    @Override
    public Request getNextRequest(List<Request> requests, int currentFloor) {
        Request request = null;
        for(Request it :requests){
            if(request==null){
              request=  it;
            }else if( Math.abs(request.getDestinationFloor() -currentFloor) >
                    Math.abs(it.getDestinationFloor()-currentFloor)) {
                request= it;

            }
        }

        return request;
    }
}
