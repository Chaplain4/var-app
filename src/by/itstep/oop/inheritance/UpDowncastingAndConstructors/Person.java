package by.itstep.oop.inheritance.UpDowncastingAndConstructors;

class Person {
    private String name;
    private double money;
    private byte happiness;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getMoney() {
        return money;
    }

    public void setMoney(double money) {
        this.money = money;
    }

    public byte getHappiness() {
        return happiness;
    }

    public void setHappiness(byte happiness) {
        this.happiness = happiness;
    }

    public Person(String name, double money, byte happiness) {
        this.name = name;
        this.money = money;
        this.happiness = happiness;
    }

    public Person(String name, double money) {
        this.name = name;
        this.money = money;
    }

    public Person(String name) {
        this.name = name;
    }

    public Person() {
        this.name = "Stranger";
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", money=" + money +
                ", happiness=" + happiness +
                '}';
    }

    void spendMoney() {
        if (this.getMoney() > 0) {
            setMoney(this.getMoney() - 1);
            setHappiness((byte) (this.getHappiness() + 1));
            System.out.println(this.getName() + " indulges into pleasures of the flesh.");
        } else {
            setHappiness((byte) (getHappiness() - 1));
            System.out.println(this.getName() + " has no money to spend and is growing unhappy!");
        }
    }
}

class Employee extends Person {
    private int salary;

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public Employee(String name, double money, byte happiness, int salary) {
        super(name, money, happiness);
        this.salary = salary;
    }

    public Employee(String name, double money, int salary) {
        super(name, money);
        this.salary = salary;
    }

    public Employee(String name, int salary) {
        super(name);
        this.salary = salary;
    }

    public Employee(int salary) {
        this.salary = salary;
        setName("Stranger");
    }

    public Employee() {
        setName("Stranger");
    }

    @Override
    public String toString() {
        return "Employee{" +
                "name='" + getName() + '\'' +
                ", money=" + getMoney() +
                ", happiness=" + getMoney() +
                "salary=" + getSalary() +
                "} ";
    }
}

class Manager extends Employee {

    public Manager(String name, double money, byte happiness, int salary) {
        super(name, money, happiness);
        this.setSalary(salary);
    }

    public Manager(String name, double money, int salary) {
        super(name, (int) money);
        this.setSalary(salary);
    }

    public Manager(String name, int salary) {
        this.setName(name);
        this.setSalary(salary);
    }

    public Manager(int salary) {
        this.setSalary(salary);
        setName("Stranger");
    }

    void allocateTask(Clerk clerk, Task task) {
        this.paySalary(clerk, clerk.completeTask(this, task));
    }

    void paySalary(Clerk clerk, double quotaMet) {
        if (this.getMoney() > clerk.getSalary() * quotaMet) {
            clerk.setMoney(clerk.getMoney() + (clerk.getSalary() * quotaMet));
            this.setMoney(this.getMoney() - (clerk.getSalary() * quotaMet));
        } else {
            clerk.setHappiness((byte) (clerk.getHappiness() - 1));
        }
    }

    @Override
    public String toString() {
        return "Manager{" +
                "name='" + getName() + '\'' +
                ", money=" + getMoney() +
                ", happiness=" + getMoney() +
                "salary=" + getSalary() +
                "} ";
    }
}

class Clerk extends Employee {

    public Clerk(String name, double money, byte happiness, int salary) {
        super(name, money, happiness);
        this.setSalary(salary);
    }

    public Clerk(String name, double money, int salary) {
        super(name, (int) money);
        this.setSalary(salary);
    }

    public Clerk(String name, int salary) {
        this.setName(name);
        this.setSalary(salary);
    }

    public Clerk(int salary) {
        this.setSalary(salary);
        setName("Stranger");
    }

    double completeTask(Manager manager, Task task) {
        double quotaMet = Math.random() / task.getDifficulty();
        manager.setMoney(manager.getMoney() + (task.getPayoff() * quotaMet));
        return quotaMet;
    }

    @Override
    public String toString() {
        return "Clerk{" +
                "name='" + getName() + '\'' +
                ", money=" + getMoney() +
                ", happiness=" + getMoney() +
                "salary=" + getSalary() +
                "} ";
    }
}

class Task {
    private double difficulty;
    private double payoff;

    public double getDifficulty() {
        return difficulty;
    }

    public void setDifficulty(double difficulty) {
        this.difficulty = difficulty;
    }

    public double getPayoff() {
        return payoff;
    }

    public void setPayoff(double payoff) {
        this.payoff = payoff;
    }

    @Override
    public String toString() {
        return "Task{" +
                "difficulty=" + difficulty +
                ", payoff=" + payoff +
                '}';
    }

    public Task(double difficulty, double payoff) {
        this.difficulty = difficulty;
        this.payoff = payoff;
    }

    public Task(double difficulty) {
        this.difficulty = difficulty;
    }

    public Task() {
    }
}

class Business {
    public static String generateName() {
        String[] names = {"Ivan", "John", "Juan", "Joseph", "Alex", "Maxim", "Victor", "Benjamin", "Vladimir", "Peter",
                "Oleg", "Charles", "George", "David", "Franz", "Fritz", "Albert", "Roman", "Julio", "Tony"};
        String name = names[(int) ((Math.random() * (names.length)))];
        return name;
    }

    public static Employee generateEmployee() {
        Employee employee = new Employee(generateName(), 5.0, (byte) 5, 1);
        return employee;
    }

    public static Manager generateManager() {
        Manager employee = new Manager(generateName(), 5.0, (byte) 5, 1);
        return employee;
    }

    public static Clerk generateClerk() {
        Clerk employee = new Clerk(generateName(), 5.0, (byte) 5, 1);
        return employee;
    }

    public static Task generateTask() {
        Task task = new Task(Math.random(), Math.random() + 1);
        return task;
    }


    public static void main(String[] args) {
        Employee[] employees = new Employee[3];
        employees[0] = generateManager();
        employees[1] = generateClerk();
        employees[2] = generateClerk();
        Manager manager;
        Clerk clerk;
        for (Employee employee : employees) {
            if (employee.getClass() == Manager.class) {
                manager = (Manager) employee;
                System.out.println(manager.toString());
            }
            if (employee.getClass() == Clerk.class) {
                clerk = (Clerk) employee;
                System.out.println(clerk.toString());
            }
        }
        while (employees[0].getHappiness() < 10) {
            for (Employee employee : employees) {
                if (employee.getClass() == Manager.class) {
                    manager = (Manager) employee;
                    for (Employee employee2 : employees) {
                        if (employee2.getClass() == Clerk.class) {
                            manager.allocateTask((Clerk) employee2, generateTask());
                        }
                    }
                }
            }
            for (Employee employee : employees) {
                employee.spendMoney();
            }
        }
        System.out.println("Now with object array");
        Object[] objects = new Object[3];
        objects[0] = generateManager();
        objects[1] = generateClerk();
        objects[2] = generateClerk();
        int k = 1;
        for (Object object : objects) {
            if (object.getClass() == Manager.class) {
                employees[0] = (Employee) object;
            }
            if (object.getClass() == Clerk.class) {
                employees[k] = (Employee) object;
                k++;
            }
        }
        for (Employee employee : employees) {
            if (employee.getClass() == Manager.class) {
                manager = (Manager) employee;
                System.out.println(manager.toString());
            }
            if (employee.getClass() == Clerk.class) {
                clerk = (Clerk) employee;
                System.out.println(clerk.toString());
            }
        }
        while (employees[0].getHappiness() < 10) {
            for (Employee employee : employees) {
                if (employee.getClass() == Manager.class) {
                    manager = (Manager) employee;
                    for (Employee employee2 : employees) {
                        if (employee2.getClass() == Clerk.class) {
                            manager.allocateTask((Clerk) employee2, generateTask());
                        }
                    }
                }
            }
            for (Employee employee : employees) {
                employee.spendMoney();
            }
        }
    }
}