package org.example.strategy.pricingStrategy;

import org.example.enums.PricingStrategyType;
import org.example.enums.VehicleType;
import org.example.models.Vehicle.Vehicle;
import org.example.models.ticket.Ticket;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

public class HourlyPricingStrategy implements PricingStrategy{
     //TODO: Create a seperate config file for the pricing and use that thing
     private Map<VehicleType,Double> hourlyPricing ;

     public  HourlyPricingStrategy(){
          this.hourlyPricing = Map.of(
                  VehicleType.BIKE,10.0,
                  VehicleType.CAR,20.0,
                  VehicleType.BUS,50.0
          );
     }
     @Override
     public double getPrice(VehicleType type, Ticket ticket) {

          double price = hourlyPricing.get(type);

          Duration total_duration = Duration.between(ticket.getStartTime(), LocalDateTime.now());

          long hours = total_duration.toHours();
          long minutes = total_duration.toMinutesPart();

          if(minutes>0){
               hours+=1;
          }
          if(hours==0) hours=1;

          return (hours*price);
     }

     @Override
     public PricingStrategyType getType() {
          return PricingStrategyType.HourlyPricingStrategy;
     }
}
