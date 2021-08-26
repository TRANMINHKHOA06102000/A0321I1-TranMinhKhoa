package case_study.services;

import case_study.models.*;
import case_study.utils.ReadAndWriter;

import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class FacilityServiceImpl implements FacilityService {
    private static Map<Facility, Integer> facilityIntegerMap;
    static Scanner scanner = new Scanner(System.in);
    String pathFileVilla="D:\\A0321I1-TranMinhKhoa\\module2\\src\\case_study\\data\\villa.csv";
    String pathFileHouse="D:\\A0321I1-TranMinhKhoa\\module2\\src\\case_study\\data\\house.csv";
    String pathFileRoom="D:\\A0321I1-TranMinhKhoa\\module2\\src\\case_study\\data\\room.csv";

    static {
        facilityIntegerMap = new LinkedHashMap<>();
    }

    @Override
    public void display() {
        facilityIntegerMap= (Map<Facility, Integer>) ReadAndWriter.read(pathFileVilla);
        facilityIntegerMap= (Map<Facility, Integer>) ReadAndWriter.read(pathFileRoom);
        facilityIntegerMap= (Map<Facility, Integer>) ReadAndWriter.read(pathFileHouse);
        System.out.println("--List Facility--\n");
        for (Map.Entry<Facility, Integer> facilityIntegerEntry : facilityIntegerMap.entrySet()) {
            System.out.println("Service " + facilityIntegerEntry.getKey() + "number of times rented" + facilityIntegerEntry.getValue());
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
        int choose = 0;
        try {
            choose = Integer.parseInt(scanner.nextLine());
        } catch (NumberFormatException ex) {
            System.err.println(ex.getMessage());
        }
        switch (choose) {
            case 1:
                addNewVilla();
                break;
            case 2:
                addNewHouse();
                break;
            case 3:
                addNewRoom();
                break;
            case 4:
                addNew();
                break;
            case 5: {
                System.exit(0);
                break;
            }
            default: {
                System.out.println("Fail! Please choose again! Enter to continue.");
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
        int area = 0;
        double price = 0;
        int amount = 0;
        try {
            System.out.println("Input area: ");
            area = Integer.parseInt(scanner.nextLine());
            System.out.println("Input price: ");
            price = Double.parseDouble(scanner.nextLine());
            System.out.println("Input amount: ");
            amount = Integer.parseInt(scanner.nextLine());
        } catch (NumberFormatException ex) {
            System.err.println(ex.getMessage());
        }
        System.out.println("Input typeRents(Year/Month/Day/Hour): ");
        String typeRents = scanner.nextLine();
        System.out.println("Input freeService: ");
        String freeService = scanner.nextLine();
        Room room = new Room(id, name, area, price, amount, typeRents, freeService);

        facilityIntegerMap.put(room, 0);
        System.out.println("Add " + room + " successful");
        ReadAndWriter.write((Collection) facilityIntegerMap,pathFileRoom);
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
        int area = 0;
        double price = 0;
        int amount = 0;
        try {
            System.out.println("Input area: ");
            area = Integer.parseInt(scanner.nextLine());
            System.out.println("Input price: ");
            price = Double.parseDouble(scanner.nextLine());
            System.out.println("Input amount: ");
            amount = Integer.parseInt(scanner.nextLine());
        } catch (NumberFormatException ex) {
            System.err.println(ex.getMessage());
        }
        System.out.println("Input typeRents(Year/Month/Day/Hour): ");
        String typeRents = scanner.nextLine();
        System.out.println("Input standardRoom: ");
        String standardRoom = scanner.nextLine();
        System.out.println("Input numberOfFloors: ");
        int numberOfFloors = Integer.parseInt(scanner.nextLine());
        House house = new House(id, name, area, price, amount, typeRents, standardRoom, numberOfFloors);

        facilityIntegerMap.put(house, 0);
        System.out.println("Add " + house + " successful");
        ReadAndWriter.write((Collection) facilityIntegerMap,pathFileHouse);
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
        int area = 0;
        double price = 0;
        int amount = 0;
        try {
            System.out.println("Input area: ");
            area = Integer.parseInt(scanner.nextLine());
            System.out.println("Input price: ");
            price = Double.parseDouble(scanner.nextLine());
            System.out.println("Input amount: ");
            amount = Integer.parseInt(scanner.nextLine());
        } catch (NumberFormatException ex) {
            System.err.println(ex.getMessage());
        }
        System.out.println("Input typeRents(Year/Month/Day/Hour): ");
        String typeRents = scanner.nextLine();
        System.out.println("Input standardRoom: ");
        String standardRoom = scanner.nextLine();
        System.out.println("Input areaPool: ");
        int areaPool = Integer.parseInt(scanner.nextLine());
        System.out.println("Input numberOfFloors: ");
        int numberOfFloors = Integer.parseInt(scanner.nextLine());
        Villa villa = new Villa(id, name, area, price, amount, typeRents, standardRoom, areaPool, numberOfFloors);
        facilityIntegerMap.put(villa, 0);
        System.out.println("Add " + villa + " successful");
        ReadAndWriter.write((Collection) facilityIntegerMap,pathFileVilla);
    }

    public Facility searchById(String id) {
        for (Map.Entry<Facility, Integer> facilityIntegerEntry : facilityIntegerMap.entrySet()) {
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
        facilityIntegerMap= (Map<Facility, Integer>) ReadAndWriter.read(pathFileVilla);
        facilityIntegerMap= (Map<Facility, Integer>) ReadAndWriter.read(pathFileRoom);
        facilityIntegerMap= (Map<Facility, Integer>) ReadAndWriter.read(pathFileHouse);
        System.out.println("--List Facility Needing Maintenance--\n");
        for (Map.Entry<Facility, Integer> facilityIntegerEntry : facilityIntegerMap.entrySet()) {
            if (facilityIntegerEntry.getValue() == 5) {
                System.out.println("Service " + facilityIntegerEntry.getKey() + "number of times rented" + facilityIntegerEntry.getValue());
            }
        }
    }
}