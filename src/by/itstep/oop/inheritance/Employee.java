package by.itstep.oop.inheritance;

public class Employee extends Person {
    private long salary;

    public Employee(int id, String name) {
        super(id, name);
    }

    //прежде всего вызывается родительский конструктор чтоб обеспечить инициализацию
    //явный вызов конструктора, иначе вызов произойдет неявно
    //если вызываем конструктор с параметрами, то такой конструктор должен существовать в родительском классе
    public Employee(int id, String name, String lastName, char gender, long salary) {
        super(id, name, lastName, gender);
        this.salary = salary;
    }


    public long getSalary() {
        return salary;
    }

    public void setSalary(long salary) {
        this.salary = salary;
    }



    @Override
    public String toString() {
        return "Employee{" +
                "id=" + getId() +
                ", name='" + getName() + '\'' +
                ", lastName='" + getLastName() + '\'' +
                ", gender=" + getGender() +
                ", salary=" + getSalary() +
                '}';
    }
}
