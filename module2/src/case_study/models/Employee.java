package case_study.models;

public class Employee extends Person {
    private String level;
    private String location;
    private String salary;

    public Employee() {
    }

    public Employee(String level, String location, String salary) {
        this.level = level;
        this.location = location;
        this.salary = salary;
    }

    public Employee(String id, String name, String dateOfBirth, String gender, int numberCMND, int phone, String email, String level, String location, String salary) {
        super(id, name, dateOfBirth, gender, numberCMND, phone, email);
        this.level = level;
        this.location = location;
        this.salary = salary;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getSalary() {
        return salary;
    }

    public void setSalary(String salary) {
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "level='" + level + '\'' +
                ", location='" + location + '\'' +
                ", salary='" + salary + '\'' +
                '}' + ", which is a subclass of " +
                super.toString();
    }
}
