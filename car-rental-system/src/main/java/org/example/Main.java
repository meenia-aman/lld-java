package org.example;

import org.example.enums.CarType;
import org.example.enums.PaymentType;
import org.example.models.Booking;
import org.example.models.Branch;
import org.example.models.Car;
import org.example.service.BookingService;
import org.example.service.CarRentalSystem;
import org.example.service.PaymentService;

import java.time.LocalDate;
import java.util.List;

public class Main {
    static void main() {

        System.out.println("============ CAR BOOKING PLATFORM ==================");

        Car car1 = new Car("JK-02-2252", CarType.SUV);
        Car car2 = new Car("JK-01-001", CarType.SEDAN);
        Car car3 = new Car("JK-02-22", CarType.SEDAN);


        List<Car> cars = List.of(car1, car2, car3);

        Branch branch = new Branch("branch-1", cars, "Jammu");

        BookingService bookingService = new BookingService();
        PaymentService paymentService = new PaymentService();
        CarRentalSystem carRentalSystem = new CarRentalSystem(List.of(branch), bookingService, paymentService);

        List<Car> availableCars = carRentalSystem.getAvailableCars("branch-1");

        System.out.println("Availables cars");
        for (Car c : availableCars) {
            System.out.println("Car " + c.getReg_no());
        }

        LocalDate todayDate = LocalDate.now();
        LocalDate pickupDate = todayDate.plusDays(1);
        LocalDate returnDate = todayDate.plusDays(5);


        Booking booking = carRentalSystem.bookCar("user-1", availableCars.get(0).getReg_no(),
                "branch-1", "branch-1", pickupDate, returnDate);

        carRentalSystem.pay(booking, PaymentType.UPI);

        carRentalSystem.pickupCar(booking.getId());
        carRentalSystem.returnCar(booking.getId());
    }
}
