package case_study.models;

public class Villa extends Facility {
    private String standardRoom;
    private Float areaPool;
    private int numberOfFloors;

    public Villa() {
    }

    public Villa(String standardRoom, Float areaPool, int numberOfFloors) {
        this.standardRoom = standardRoom;
        this.areaPool = areaPool;
        this.numberOfFloors = numberOfFloors;
    }

    public Villa(String name, Float area, double price, int amount, String typeRents, String standardRoom, Float areaPool, int numberOfFloors) {
        super(name, area, price, amount, typeRents);
        this.standardRoom = standardRoom;
        this.areaPool = areaPool;
        this.numberOfFloors = numberOfFloors;
    }

    public String getStandardRoom() {
        return standardRoom;
    }

    public void setStandardRoom(String standardRoom) {
        this.standardRoom = standardRoom;
    }

    public Float getAreaPool() {
        return areaPool;
    }

    public void setAreaPool(Float areaPool) {
        this.areaPool = areaPool;
    }

    public int getNumberOfFloors() {
        return numberOfFloors;
    }

    public void setNumberOfFloors(int numberOfFloors) {
        this.numberOfFloors = numberOfFloors;
    }

    @Override
    public String toString() {
        return "Villa{" +
                "standardRoom='" + standardRoom + '\'' +
                ", areaPool=" + areaPool +
                ", numberOfFloors=" + numberOfFloors +
                '}' + ", which is a subclass of " +
                super.toString();
    }
}
