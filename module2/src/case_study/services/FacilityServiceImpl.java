package case_study.services;

import case_study.models.*;
import case_study.utils.ReadAndWriter;
import case_study.utils.RegexData;

import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class FacilityServiceImpl implements FacilityService {
    private static Map<Facility, Integer> facilityIntegerMap;
    static Scanner scanner = new Scanner(System.in);
    String pathFileVilla = "D:\\A0321I1-TranMinhKhoa\\module2\\src\\case_study\\data\\villa.csv";
    String pathFileHouse = "D:\\A0321I1-TranMinhKhoa\\module2\\src\\case_study\\data\\house.csv";
    String pathFileRoom = "D:\\A0321I1-TranMinhKhoa\\module2\\src\\case_study\\data\\room.csv";

    private static final String REGEX_AGE_DATEOFBIRTH = "/^(0?[1-9]|1[012])[- /.](0?[1-9]|[12][0-9]|3[01])[- /.](19|20)?[0-9]{2}$/";

    static {
        facilityIntegerMap = new LinkedHashMap<>();
    }

    @Override
    public void display() {
        facilityIntegerMap = (Map<Facility, Integer>) ReadAndWriter.read(pathFileVilla);
        facilityIntegerMap = (Map<Facility, Integer>) ReadAndWriter.read(pathFileRoom);
        facilityIntegerMap = (Map<Facility, Integer>) ReadAndWriter.read(pathFileHouse);
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
        } while (searchById(id) != null && !RegexData.checkIdVilla(id));

        String name;
        do {
            System.out.println("Input name: ");
            name = scanner.nextLine();
        } while (!RegexData.checkNameAndStandard(name));

        int area = 0;
        do {
            try {
                System.out.println("Input area: ");
                area = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException ex) {
                System.err.println(ex.getMessage());
            }
        } while (!RegexData.checkAreaAndAreaPool(area));

        double price = 0;
        do {
            try {
                System.out.println("Input price: ");
                price = Double.parseDouble(scanner.nextLine());
            } catch (NumberFormatException ex) {
                System.err.println(ex.getMessage());
            }
        } while (!RegexData.checkPrice(price));

        int amount = 0;
        do {
            try {
                System.out.println("Input amount: ");
                amount = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException ex) {
                System.err.println(ex.getMessage());
            }
        } while (!RegexData.checkAmount(amount));

        String typeRents;
        do {
            System.out.println("Input typeRents(Year/Month/Day/Hour): ");
            typeRents = scanner.nextLine();
        } while (!RegexData.checkTypeRent(typeRents));

        System.out.println("Input freeService: ");
        String freeService = scanner.nextLine();

        Room room = new Room(id, name, area, price, amount, typeRents, freeService);
        facilityIntegerMap.put(room, 0);
        System.out.println("Add " + room + " successful");
        ReadAndWriter.write((Collection) facilityIntegerMap, pathFileRoom);
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
        } while (searchById(id) != null && !RegexData.checkIdVilla(id));

        String name;
        do {
            System.out.println("Input name: ");
            name = scanner.nextLine();
        } while (!RegexData.checkNameAndStandard(name));

        int area = 0;
        do {
            try {
                System.out.println("Input area: ");
                area = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException ex) {
                System.err.println(ex.getMessage());
            }
        } while (!RegexData.checkAreaAndAreaPool(area));

        double price = 0;
        do {
            try {
                System.out.println("Input price: ");
                price = Double.parseDouble(scanner.nextLine());
            } catch (NumberFormatException ex) {
                System.err.println(ex.getMessage());
            }
        } while (!RegexData.checkPrice(price));

        int amount = 0;
        do {
            try {
                System.out.println("Input amount: ");
                amount = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException ex) {
                System.err.println(ex.getMessage());
            }
        } while (!RegexData.checkAmount(amount));

        String typeRents;
        do {
            System.out.println("Input typeRents(Year/Month/Day/Hour): ");
            typeRents = scanner.nextLine();
        } while (!RegexData.checkTypeRent(typeRents));

        String standardRoom;
        do {
            System.out.println("Input standardRoom: ");
            standardRoom = scanner.nextLine();
        } while (!RegexData.checkNameAndStandard(standardRoom));

        int numberOfFloors;
        do {
            System.out.print("Input numberOfFloors: ");
            numberOfFloors = Integer.parseInt(scanner.nextLine());
        } while (!RegexData.checkNumberOfFloors(numberOfFloors));

        House house = new House(id, name, area, price, amount, typeRents, standardRoom, numberOfFloors);
        facilityIntegerMap.put(house, 0);
        System.out.println("Add " + house + " successful");
        ReadAndWriter.write((Collection) facilityIntegerMap, pathFileHouse);
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
        } while (searchById(id) != null && !RegexData.checkIdVilla(id));

       /* System.out.println("Input age: ");
        String dateOfBirth=RegexData.regexAge(scanner.nextLine(),REGEX_AGE_DATEOFBIRTH);*/
        String name;
        do {
            System.out.println("Input name: ");
            name = scanner.nextLine();
        } while (!RegexData.checkNameAndStandard(name));

        int area = 0;
        do {
            try {
                System.out.println("Input area: ");
                area = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException ex) {
                System.err.println(ex.getMessage());
            }
        } while (!RegexData.checkAreaAndAreaPool(area));

        double price = 0;
        do {
            try {
                System.out.println("Input price: ");
                price = Double.parseDouble(scanner.nextLine());
            } catch (NumberFormatException ex) {
                System.err.println(ex.getMessage());
            }
        } while (!RegexData.checkPrice(price));

        int amount = 0;
        do {
            try {
                System.out.println("Input amount: ");
                amount = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException ex) {
                System.err.println(ex.getMessage());
            }
        } while (!RegexData.checkAmount(amount));

        String typeRents;
        do {
            System.out.println("Input typeRents(Year/Month/Day/Hour): ");
            typeRents = scanner.nextLine();
        } while (!RegexData.checkTypeRent(typeRents));

        String standardRoom;
        do {
            System.out.println("Input standardRoom: ");
            standardRoom = scanner.nextLine();
        } while (!RegexData.checkNameAndStandard(standardRoom));

        int areaPool;
        do {
            System.out.println("Input areaPool: ");
            areaPool = Integer.parseInt(scanner.nextLine());
        } while (!RegexData.checkAreaAndAreaPool(areaPool));


        int numberOfFloors;
        do {
            System.out.print("Input numberOfFloors: ");
            numberOfFloors = Integer.parseInt(scanner.nextLine());
        } while (!RegexData.checkNumberOfFloors(numberOfFloors));

        Villa villa = new Villa(id, name, area, price, amount, typeRents, standardRoom, areaPool, numberOfFloors);
        facilityIntegerMap.put(villa, 0);
        System.out.println("Add " + villa + " successful");
        ReadAndWriter.write((Collection) facilityIntegerMap, pathFileVilla);
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
        facilityIntegerMap = (Map<Facility, Integer>) ReadAndWriter.read(pathFileVilla);
        facilityIntegerMap = (Map<Facility, Integer>) ReadAndWriter.read(pathFileRoom);
        facilityIntegerMap = (Map<Facility, Integer>) ReadAndWriter.read(pathFileHouse);
        System.out.println("--List Facility Needing Maintenance--\n");
        for (Map.Entry<Facility, Integer> facilityIntegerEntry : facilityIntegerMap.entrySet()) {
            if (facilityIntegerEntry.getValue() == 5) {
                System.out.println("Service " + facilityIntegerEntry.getKey() + "number of times rented" + facilityIntegerEntry.getValue());
            }
        }
    }
}