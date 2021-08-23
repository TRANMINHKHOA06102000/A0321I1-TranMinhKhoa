package case_study.services;

import case_study.models.Employee;

import java.util.ArrayList;
import java.util.Scanner;

public class EmployeeServiceImpl implements EmployeeService {
    private static ArrayList<Employee> employeeArrayList;
    static Scanner scanner = new Scanner(System.in);

    static {
        employeeArrayList = new ArrayList<>();
    }

    @Override
    public void display() {
        System.out.println("--Danh sách nhân viên--\n");
        for (Employee employee : employeeArrayList) {
            System.out.println(employee);
        }
    }

    public Employee searchById(String id) {
        for (Employee employee : employeeArrayList) {
            if (employee.getId().equals(id)) {
                return employee;
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
        System.out.println("Input name employee: ");
        String name = scanner.nextLine();
        System.out.println("Input dateOfBirth employee: ");
        String dateOfBirth = scanner.nextLine();
        System.out.println("Input gender employee: ");
        String gender = scanner.nextLine();
        System.out.println("Input number CMND employee: ");
        int numberCMND = scanner.nextInt();
        scanner.skip("\\R");
        System.out.println("Input phone employee: ");
        int phone = scanner.nextInt();
        scanner.skip("\\R");
        System.out.println("Input email employee: ");
        String email = scanner.nextLine();
        System.out.println("Input level employee: ");
        String level = scanner.nextLine();
        System.out.println("Input location employee: ");
        String location = scanner.nextLine();
        System.out.println("Input salary employee: ");
        double salary = scanner.nextDouble();
        Employee employee = new Employee(id, name, dateOfBirth, gender, numberCMND, phone, email, level, location, salary);
        employeeArrayList.add(employee);
        System.out.println("Add " + employee + " successful");
    }

    @Override
    public void edit() {
        System.out.println("Input id to edit: ");
        String id;
        id = scanner.nextLine();
        Employee employee = searchById(id);
        if (employee == null) {
            System.out.println("Id does not exist");
        } else {
            int choice;
            do {
                System.out.println("Menu Edit");
                System.out.println("1.Edit name employee");
                System.out.println("2.Edit dateOfBirth employee");
                System.out.println("3.Edit gender employee");
                System.out.println("4.Edit numberCMND employee");
                System.out.println("5.Edit phone employee");
                System.out.println("6.Edit email employee");
                System.out.println("7.Edit level employee");
                System.out.println("8.Edit location employee");
                System.out.println("9.Edit salary employee");
                System.out.println("choose: ");
                choice = scanner.nextInt();
            } while (choice < 1 || choice > 9);
            switch (choice) {
                case 1:
                    scanner.skip("\\R");
                    System.out.println("Input new name employee: ");
                    String newName = scanner.nextLine();
                    employee.setName(newName);
                    System.out.println("Edit " + employee + " successful");
                    break;
                case 2:
                    scanner.skip("\\R");
                    System.out.println("Input new dateOfBirth employee: ");
                    String newDateOfBirth = scanner.nextLine();
                    employee.setDateOfBirth(newDateOfBirth);
                    System.out.println("Edit " + employee + " successful");
                    break;
                case 3:
                    scanner.skip("\\R");
                    System.out.println("Input new gender employee: ");
                    String newGender = scanner.nextLine();
                    employee.setGender(newGender);
                    System.out.println("Edit " + employee + " successful");
                    break;
                case 4:
                    scanner.skip("\\R");
                    System.out.println("Input new numberCMND employee: ");
                    int newNumberCMND = scanner.nextInt();
                    employee.setNumberCMND(newNumberCMND);
                    System.out.println("Edit " + employee + " successful");
                    break;
                case 5:
                    scanner.skip("\\R");
                    System.out.println("Input new phone employee: ");
                    int newPhone = scanner.nextInt();
                    employee.setPhone(newPhone);
                    System.out.println("Edit " + employee + " successful");
                    break;
                case 6:
                    scanner.skip("\\R");
                    System.out.println("Input new email employee: ");
                    String newEmail = scanner.nextLine();
                    employee.setEmail(newEmail);
                    System.out.println("Edit " + employee + " successful");
                    break;
                case 7:
                    scanner.skip("\\R");
                    System.out.println("Input new level employee: ");
                    String newLevel = scanner.nextLine();
                    employee.setLevel(newLevel);
                    System.out.println("Edit " + employee + " successful");
                    break;
                case 8:
                    scanner.skip("\\R");
                    System.out.println("Input new location employee: ");
                    String newLocation = scanner.nextLine();
                    employee.setLocation(newLocation);
                    System.out.println("Edit " + employee + " successful");
                    break;
                case 9:
                    scanner.skip("\\R");
                    System.out.println("Input new salary employee: ");
                    double newSalary = scanner.nextDouble();
                    employee.setSalary(newSalary);
                    System.out.println("Edit " + employee + " successful");
                    break;
                default:
                    System.out.println("Please enter options: 1 -> 9");
            }
        }
    }
}
