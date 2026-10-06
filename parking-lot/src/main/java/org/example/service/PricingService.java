package org.example.service;

import org.example.enums.PricingStrategyType;
import org.example.enums.VehicleType;
import org.example.models.ticket.Ticket;
import org.example.strategy.pricingStrategy.HourlyPricingStrategy;
import org.example.strategy.pricingStrategy.PricingStrategy;

public class PricingService {

    PricingStrategy getPricingStrategy(PricingStrategyType type){
        return new HourlyPricingStrategy();

    }

    double getTotalPrice(VehicleType type , Ticket ticket, PricingStrategyType pricingStrategyType){
        PricingStrategy pricingStrategy = getPricingStrategy(pricingStrategyType);
    return  pricingStrategy.getPrice(type,ticket);
    }


}
