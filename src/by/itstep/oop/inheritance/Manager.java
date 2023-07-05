package by.itstep.oop.inheritance;

public class Manager extends Employee {
    private String department;

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public Manager(int id, String name, String lastName, char gender, long salary, String department) {
        super(id, name, lastName, gender, salary);
        this.department = department;
    }
    @Override
    public String toString() {
        return "Manager{" +
                "id=" + getId() +
                ", name='" + getName() + '\'' +
                ", lastName='" + getLastName() + '\'' +
                ", gender=" + getGender() +
                ", salary=" + getSalary() +
                ", department=" + getDepartment() +
                '}';
    }
}
