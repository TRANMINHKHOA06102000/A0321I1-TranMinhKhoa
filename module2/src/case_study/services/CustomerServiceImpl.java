package case_study.services;

import case_study.models.Customer;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class CustomerServiceImpl implements CustomerService {
    private static final List<Customer> customerLinkedList;
    static Scanner scanner = new Scanner(System.in);

    static {
        customerLinkedList = new LinkedList<>();
    }

    @Override
    public void display() {
        System.out.println("--List Customer--\n");
        for (Customer customer : customerLinkedList) {
            System.out.println(customer);
        }
    }

    public Customer searchById(String id) {
        for (Customer customer : customerLinkedList) {
            if (customer.getId().equals(id)) {
                return customer;
            }
        }
        return null;
    }

    @Override
    public void addNew() {
        String id;
        do {
            System.out.println("Input Id: ");
            id = scanner.nextLine();
            if (searchById(id) != null) {
                System.out.println("id already exists");
            }
        } while (searchById(id) != null);
        System.out.println("Input name customer: ");
        String name = scanner.nextLine();
        System.out.println("Input dateOfBirth customer: ");
        String dateOfBirth = scanner.nextLine();
        System.out.println("Input gender customer: ");
        String gender = scanner.nextLine();
        int numberCMND = 0;
        int phone = 0;
        try {
            System.out.println("Input number CMND customer: ");
            numberCMND = Integer.parseInt(scanner.nextLine());
            System.out.println("Input phone customer: ");
            phone = Integer.parseInt(scanner.nextLine());
        } catch (NumberFormatException ex) {
            System.err.println(ex.getMessage());
        }
        System.out.println("Input email customer: ");
        String email = scanner.nextLine();
        System.out.println("Input typeOfGuest customer(Diamond, Platinium, Gold, Silver, Member): ");
        String typeOfGuest = scanner.nextLine();
        System.out.println("Input address customer: ");
        String address = scanner.nextLine();
        Customer customer = new Customer(id, name, dateOfBirth, gender, numberCMND, phone, email, typeOfGuest, address);
        customerLinkedList.add(customer);
        System.out.println("Add " + customer + " successful");
    }

    @Override
    public void edit() {
        System.out.println("Input id to edit: ");
        String id;
        id = scanner.nextLine();
        Customer customer = searchById(id);
        if (customer == null) {
            System.out.println("Id does not exist");
        } else {
            int choice = 0;
            try {
                choice = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException ex) {
                System.err.println(ex.getMessage());
            }
            do {
                System.out.println("Menu Edit");
                System.out.println("1.Edit name customer");
                System.out.println("2.Edit dateOfBirth customer");
                System.out.println("3.Edit gender customer");
                System.out.println("4.Edit numberCMND customer");
                System.out.println("5.Edit phone customer");
                System.out.println("6.Edit email customer");
                System.out.println("7.Edit typeOfGuest customer");
                System.out.println("8.Edit address customer");
                System.out.println("choose: ");
            } while (choice < 1 || choice > 8);
            switch (choice) {
                case 1:
                    System.out.println("Input new name customer: ");
                    String newName = scanner.nextLine();
                    customer.setName(newName);
                    System.out.println("Edit " + customer + " successful");
                    break;
                case 2:
                    System.out.println("Input new dateOfBirth customer: ");
                    String newDateOfBirth = scanner.nextLine();
                    customer.setDateOfBirth(newDateOfBirth);
                    System.out.println("Edit " + customer + " successful");
                    break;
                case 3:
                    System.out.println("Input new gender customer: ");
                    String newGender = scanner.nextLine();
                    customer.setGender(newGender);
                    System.out.println("Edit " + customer + " successful");
                    break;
                case 4:
                    System.out.println("Input new numberCMND customer: ");
                    int newNumberCMND = 0;
                    try {
                        newNumberCMND = Integer.parseInt(scanner.nextLine());
                    } catch (NumberFormatException ex) {
                        System.err.println(ex.getMessage());
                    }
                    customer.setNumberCMND(newNumberCMND);
                    System.out.println("Edit " + customer + " successful");
                    break;
                case 5:
                    System.out.println("Input new phone customer: ");
                    int newPhone = 0;
                    try {
                        newPhone = Integer.parseInt(scanner.nextLine());
                    } catch (NumberFormatException ex) {
                        System.err.println(ex.getMessage());
                    }
                    customer.setPhone(newPhone);
                    System.out.println("Edit " + customer + " successful");
                    break;
                case 6:
                    System.out.println("Input new email customer: ");
                    String newEmail = scanner.nextLine();
                    customer.setEmail(newEmail);
                    System.out.println("Edit " + customer + " successful");
                    break;
                case 7:
                    System.out.println("Input new typeOfGuest customer(Diamond, Platinium, Gold, Silver, Member): ");
                    String newTypeOfGuest = scanner.nextLine();
                    customer.setTypeOfGuest(newTypeOfGuest);
                    System.out.println("Edit " + customer + " successful");
                    break;
                case 8:
                    System.out.println("Input new address customer: ");
                    String newAddress = scanner.nextLine();
                    customer.setAddress(newAddress);
                    System.out.println("Edit " + customer + " successful");
                    break;
                default:
                    System.out.println("Please enter options: 1 -> 8");
            }
        }
    }
}
