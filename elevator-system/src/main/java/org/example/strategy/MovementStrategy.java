package org.example.strategy;

import org.example.models.Request;

import java.util.List;

public interface MovementStrategy  {
    Request getNextRequest(List<Request> requests, int currentFloor);
}
