package case_study.services;

import case_study.models.*;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class FacilityServiceImpl implements FacilityService {
    private static final Map<Facility, Integer> facilityIntegerMap;
    static Scanner scanner = new Scanner(System.in);

    static {
        facilityIntegerMap = new LinkedHashMap<>();
    }

    @Override
    public void display() {
        System.out.println("--List Facility--");
        for (Map.Entry<Facility, Integer> facilityIntegerEntry : facilityIntegerMap.entrySet()) {
            System.out.println(facilityIntegerEntry.toString());
        }
    }

    @Override
    public void addNew() {
        System.out.println("---ADD NEW FACILITY---");
        System.out.println("1. Add New Villa");
        System.out.println("2. Add New House");
        System.out.println("3. Add New Room");
        System.out.println("4. Back to menu");
        System.out.println("5. Exit");
        System.out.println("------------------------------");
        System.out.print("Your choose: ");
        String choose = scanner.nextLine();
        switch (choose) {
            case "1":
                addNewVilla();
                break;
            case "2":
                addNewHouse();
                break;
            case "3":
                addNewRoom();
                break;
            case "4":
                addNew();
                break;
            case "5": {
                System.exit(0);
                break;
            }
            default: {
                System.out.println("Fail! Please choose again! Enter to continue.");
                System.out.print("Your choose: ");
                scanner.nextLine();
                addNew();
            }
        }
    }

    public void addNewRoom() {
        System.out.println("Input name: ");
        String name = scanner.nextLine();
        System.out.println("Input area: ");
        float area = Float.parseFloat(scanner.nextLine());
        System.out.println("Input price: ");
        double price = Double.parseDouble(scanner.nextLine());
        System.out.println("Input amount: ");
        int amount = Integer.parseInt(scanner.nextLine());
        System.out.println("Input typeRents(Year/Month/Day/Hour): ");
        String typeRents = scanner.nextLine();
        System.out.println("Input freeService: ");
        String freeService = scanner.nextLine();
        Room room = new Room(name, area, price, amount, typeRents, freeService);

        System.out.print("Enter the number of uses: ");
        int times = Integer.parseInt(scanner.nextLine());
        facilityIntegerMap.put(room, times);
        System.out.println("Add " + room + " successful");
    }

    public void addNewHouse() {
        System.out.println("Input name: ");
        String name = scanner.nextLine();
        System.out.println("Input area: ");
        float area = Float.parseFloat(scanner.nextLine());
        System.out.println("Input price: ");
        double price = Double.parseDouble(scanner.nextLine());
        System.out.println("Input amount: ");
        int amount = Integer.parseInt(scanner.nextLine());
        System.out.println("Input typeRents(Year/Month/Day/Hour): ");
        String typeRents = scanner.nextLine();
        System.out.println("Input standardRoom: ");
        String standardRoom = scanner.nextLine();
        System.out.println("Input numberOfFloors: ");
        int numberOfFloors = Integer.parseInt(scanner.nextLine());
        House house = new House(name, area, price, amount, typeRents, standardRoom, numberOfFloors);

        System.out.print("Enter the number of uses: ");
        int times = Integer.parseInt(scanner.nextLine());
        facilityIntegerMap.put(house, times);
        System.out.println("Add " + house + " successful");
    }

    public void addNewVilla() {
        //\\R để xuống dòng
//        scanner.skip("\\R");
        System.out.println("Input name: ");
        String name = scanner.nextLine();
        System.out.println("Input area: ");
        float area = Float.parseFloat(scanner.nextLine());
        System.out.println("Input price: ");
        double price = Double.parseDouble(scanner.nextLine());
        System.out.println("Input amount: ");
        int amount = Integer.parseInt(scanner.nextLine());
        System.out.println("Input typeRents(Year/Month/Day/Hour): ");
        String typeRents = scanner.nextLine();
        System.out.println("Input standardRoom: ");
        String standardRoom = scanner.nextLine();
        System.out.println("Input areaPool: ");
        float areaPool = Float.parseFloat(scanner.nextLine());
        System.out.println("Input numberOfFloors: ");
        int numberOfFloors = Integer.parseInt(scanner.nextLine());
        Villa villa = new Villa(name, area, price, amount, typeRents, standardRoom, areaPool, numberOfFloors);

        System.out.print("Enter the number of uses: ");
        int times = Integer.parseInt(scanner.nextLine());
        facilityIntegerMap.put(villa, times);
        System.out.println("Add " + villa + " successful");
    }

    @Override
    public void edit() {

    }

    @Override
    public void displayFacilityNeedingMaintenance() {
        System.out.println("--List Facility Needing Maintenance--");
        for (Map.Entry<Facility, Integer> facilityIntegerEntry : facilityIntegerMap.entrySet()) {
            if (facilityIntegerEntry.getValue() == 4) {
                System.out.println(facilityIntegerEntry);
            }
        }
    }
}