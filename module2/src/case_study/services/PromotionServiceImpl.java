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

    static Stack<Booking> bookingStack = new Stack<>();

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
        Set<Booking> bookingSet1 = new BookingServiceImpl().sendBooking();
        for (Booking booking : bookingSet1) {
            bookingStack.push(booking);
        }
        try {
            System.out.println("the number of vouchers is: " + bookingStack.size());
            System.out.println("number of vouchers 10%: ");
            int voucher10 = Integer.parseInt(scanner.nextLine());
            System.out.println("number of vouchers 20%: ");
            int voucher20 = Integer.parseInt(scanner.nextLine());
            System.out.println("number of vouchers 50%: " + (bookingStack.size() - (voucher10 + voucher20)));
            int voucher50 = bookingStack.size() - (voucher10 + voucher20);

            System.out.println("list of customers receiving voucher 10%");
            for (int i = 0; i < voucher10; i++) {
                if (bookingStack.isEmpty()) {
                    System.out.println("No booking to use voucher!");
                } else {
                    System.out.println(bookingStack.pop());
                }
            }

            System.out.println("list of customers receiving voucher 20%");
            for (int i = 0; i < voucher20; i++) {
                if (bookingStack.isEmpty()) {
                    System.out.println("No booking to use voucher!");
                } else {
                    System.out.println(bookingStack.pop());
                }
            }

            System.out.println("list of customers receiving voucher 50%");
            for (int i = 0; i < voucher50; i++) {
                if (bookingStack.isEmpty()) {
                    System.out.println("No booking to use voucher!");
                } else {
                    System.out.println(bookingStack.pop());
                }
            }
        } catch (NumberFormatException ex) {
            System.err.println("You entered wrong format!");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
