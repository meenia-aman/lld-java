package org.example.strategy.pricingStrategy;

import org.example.enums.PricingStrategyType;
import org.example.enums.VehicleType;
import org.example.models.ticket.Ticket;

public interface PricingStrategy {
    double getPrice(VehicleType type, Ticket ticket);
    PricingStrategyType getType();
}
