package case_study.services;


import case_study.models.Booking;
import case_study.models.Contract;

import java.util.*;

public class ContractServiceImpl implements ContractService {
    static List<Contract> contractList = new ArrayList<>();
    static Scanner scanner = new Scanner(System.in);

    @Override
    public void addNew() {
        Queue<Booking> bookingQueue = new LinkedList<>();
        Set<Booking> bookingSet = new BookingServiceImpl().sendBooking();

        for (Booking booking : bookingSet) {
            bookingQueue.add(booking);
        }
        while (!bookingQueue.isEmpty()) {
            Booking booking = bookingQueue.poll();
            String customer = booking.getIdCustomer();

            System.out.println("creating contract for booking with information: " + booking.toString());
            System.out.println("creating contract for customer with information: " + customer.toString());

            System.out.println("input numberContracts:");
            int numberContracts = Integer.parseInt(scanner.nextLine());
            System.out.println("input advanceDepositAmount:");
            double advanceDepositAmount = Double.parseDouble(scanner.nextLine());
            System.out.println("input totalPaymentAmount:");
            double totalPaymentAmount = Double.parseDouble(scanner.nextLine());
            Contract contract = new Contract(numberContracts, booking.toString(), advanceDepositAmount, totalPaymentAmount, customer);
            contractList.add(contract);
            System.out.println("Add " + contract + " successful");
        }
    }

    @Override
    public void display() {
        for (Contract contract : contractList) {
            System.out.println(contract.toString());
        }
    }

    @Override
    public void edit() {

    }
}
