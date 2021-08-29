package case_study.services;

import case_study.models.Booking;
import case_study.models.Customer;
import case_study.utils.BookingComparator;

import java.util.*;

public class PromotionServiceImpl implements PromotionService {
    Scanner scanner = new Scanner(System.in);
    BookingServiceImpl bookingService = new BookingServiceImpl();
    CustomerServiceImpl customerService = new CustomerServiceImpl();
    private static Set<Booking> bookingSet = new TreeSet<>(new BookingComparator());

    @Override
    public void displayListCustomersUseService() {
        bookingSet = bookingService.sendBooking();
        System.out.println("Input year:");
        int year = Integer.parseInt(scanner.nextLine());
        System.out.println("List customer use service in " + year);
        for (Booking booking : bookingSet) {
            if (Integer.parseInt(booking.getStartDay().substring(6)) == year) {
                customerInfomation(booking.getIdCustomer());
            }
        }
    }

    public void customerInfomation(String idCustomer) {
        List<Customer> customerList = customerService.getCustomer();
        for (Customer customer : customerList) {
            if (customer.getId().equals(idCustomer)) {
                System.out.println(customer.toString());
            }
        }
    }

    @Override
    public void displayListCustomersGetVoucher() {

    }
}
