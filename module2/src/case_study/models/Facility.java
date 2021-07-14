package case_study.models;

public abstract class Facility {
    private String name;
    private Float area;
    private double price;
    private int amount;
    private String typeRents;

    public Facility() {
    }

    public Facility(String name, Float area, double price, int amount, String typeRents) {
        this.name = name;
        this.area = area;
        this.price = price;
        this.amount = amount;
        this.typeRents = typeRents;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Float getArea() {
        return area;
    }

    public void setArea(Float area) {
        this.area = area;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public String getTypeRents() {
        return typeRents;
    }

    public void setTypeRents(String typeRents) {
        this.typeRents = typeRents;
    }

    @Override
    public String toString() {
        return "Facility{" +
                "name='" + name + '\'' +
                ", area=" + area +
                ", price=" + price +
                ", amount=" + amount +
                ", typeRents='" + typeRents + '\'' +
                '}';
    }
}
