package org.example.service;

import org.example.enums.BookingStatus;
import org.example.enums.PaymentType;
import org.example.models.Booking;
import org.example.models.Branch;
import org.example.models.Car;
import org.example.models.Transaction;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CarRentalSystem {
    private BookingService bookingService;
    private Map<String, Branch> branches = new HashMap<>();
    private PaymentService paymentService;


    public CarRentalSystem(List<Branch> branches, BookingService bookingService, PaymentService paymentService) {
        for (Branch b : branches) {
            this.branches.put(b.getId(), b);
        }
        this.bookingService = bookingService;
        this.paymentService = paymentService;
    }

    Branch getBranch(String branchId) {
        return branches.getOrDefault(branchId, null);
    }

    public List<Car> getAvailableCars(String branchId) {

        Branch branch = getBranch(branchId);

        if (branch == null) {
            System.out.println("Please search the valid branch");
            return null;
        }
        return branch.getAllActiveCars();
    }

    public Booking bookCar(String userId, String carId, String
                                   pickupBranchId, String dropBranchId,
                           LocalDate pickupDate,
                           LocalDate returnDate) {
        // check if card is available for that time period or not
        double amount = 100;
        return bookingService.createBooking(userId, carId, pickupBranchId, dropBranchId,
                pickupDate, returnDate, amount);
    }

    public boolean pay(Booking booking, PaymentType type) {
        Transaction transaction = paymentService.createTransaction(booking, type);
        Boolean payment = paymentService.pay(transaction.getId());
        if (payment) {
            bookingService.updateStatus(booking.getId(), BookingStatus.CONFIRMED);
            System.out.println("Booking confirmed for bookingId " + booking.getCarId());

            return true;
        }
        return false;
    }

    public void pickupCar(String bookingId) {

        Booking booking = bookingService.getBookingById(bookingId);

        if (booking == null || booking.getStatus() != BookingStatus.CONFIRMED) {
            System.out.println("No booking found");
            return;
        }

        booking.updateStatus(BookingStatus.PICKUP_UP);
        System.out.println("Car picked up successfully");
    }

    public void returnCar(String bookingId) {
        Booking booking = bookingService.getBookingById(bookingId);

        if (booking == null || booking.getStatus() != BookingStatus.PICKUP_UP) {
            System.out.println("No booking found");
            return;
        }

        booking.updateStatus(BookingStatus.COMPLETED);
        System.out.println("Car Return successfully");

    }


}
