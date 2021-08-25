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
            System.out.println("Service "+ facilityIntegerEntry.getKey()+ "number of times rented"+ facilityIntegerEntry.getValue());
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

    @Override
    public void addNewRoom() {
        String id;
        do {
            System.out.println("Input Id: ");
            id = scanner.nextLine();
            if (searchById(id) != null) {
                System.out.println("id already exists");
            }
        } while (searchById(id) != null);
        System.out.println("Input name: ");
        String name = scanner.nextLine();
        System.out.println("Input area: ");
        int area = Integer.parseInt(scanner.nextLine());
        System.out.println("Input price: ");
        double price = Double.parseDouble(scanner.nextLine());
        System.out.println("Input amount: ");
        int amount = Integer.parseInt(scanner.nextLine());
        System.out.println("Input typeRents(Year/Month/Day/Hour): ");
        String typeRents = scanner.nextLine();
        System.out.println("Input freeService: ");
        String freeService = scanner.nextLine();
        Room room = new Room(id,name, area, price, amount, typeRents, freeService);

        facilityIntegerMap.put(room, 0);
        System.out.println("Add " + room + " successful");
    }

    @Override
    public void addNewHouse() {
        String id;
        do {
            System.out.println("Input Id: ");
            id = scanner.nextLine();
            if (searchById(id) != null) {
                System.out.println("id already exists");
            }
        } while (searchById(id) != null);
        System.out.println("Input name: ");
        String name = scanner.nextLine();
        System.out.println("Input area: ");
        int area = Integer.parseInt(scanner.nextLine());
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
        House house = new House(id,name, area, price, amount, typeRents, standardRoom, numberOfFloors);

        facilityIntegerMap.put(house, 0);
        System.out.println("Add " + house + " successful");
    }

    @Override
    public void addNewVilla() {
        String id;
        do {
            System.out.println("Input Id: ");
            id = scanner.nextLine();
            if (searchById(id) != null) {
                System.out.println("id already exists");
            }
        } while (searchById(id) != null);
        System.out.println("Input name: ");
        String name = scanner.nextLine();
        System.out.println("Input area: ");
        int area = Integer.parseInt(scanner.nextLine());
        System.out.println("Input price: ");
        double price = Double.parseDouble(scanner.nextLine());
        System.out.println("Input amount: ");
        int amount = Integer.parseInt(scanner.nextLine());
        System.out.println("Input typeRents(Year/Month/Day/Hour): ");
        String typeRents = scanner.nextLine();
        System.out.println("Input standardRoom: ");
        String standardRoom = scanner.nextLine();
        System.out.println("Input areaPool: ");
        int areaPool = Integer.parseInt(scanner.nextLine());
        System.out.println("Input numberOfFloors: ");
        int numberOfFloors = Integer.parseInt(scanner.nextLine());
        Villa villa = new Villa(id,name, area, price, amount, typeRents, standardRoom, areaPool, numberOfFloors);
        facilityIntegerMap.put(villa, 0);
        System.out.println("Add " + villa + " successful");
    }
    public Facility searchById(String id) {
        for (Map.Entry<Facility,Integer> facilityIntegerEntry: facilityIntegerMap.entrySet()) {
            if (id.equals(facilityIntegerEntry.getKey().getId())) {
                return facilityIntegerEntry.getKey();
            }
        }
        return null;
    }
    @Override
    public void edit() {

    }

    @Override
    public void displayFacilityNeedingMaintenance() {
        System.out.println("--List Facility Needing Maintenance--");
        for (Map.Entry<Facility, Integer> facilityIntegerEntry : facilityIntegerMap.entrySet()) {
            if (facilityIntegerEntry.getValue() == 5) {
                System.out.println("Service "+ facilityIntegerEntry.getKey()+ "number of times rented"+ facilityIntegerEntry.getValue());
            }
        }
    }
}