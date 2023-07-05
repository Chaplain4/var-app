package by.itstep.oop;

public class Cat {
    private long id;
    private String name;
    private boolean isCastrated;
    private char gender;
    private int age;
    private Person owner;

    public void setOwner(Person owner) {
        this.owner = owner;
    }

    public Person getOwner() {
        return owner;
    }

    public char getGender() {
        return gender;
    }

    public void setGender(char gender) {
        this.gender = gender;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public boolean getIsCastrated() {
        return isCastrated;
    }

    public void isCastrated(boolean castrated) {
        isCastrated = castrated;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getAge() {
        return age;
    }

    public String getName() {
        return name;
    }

    public void setName(String newName) {
        name = newName;
    }

    void sleep() {
        System.out.println(name + " is sleeping");
    }

    void eat() {
        System.out.println(name + " is eating");
    }
}

class CatTester {


    public static void main(String[] args) {
        Cat cat1 = new Cat();
        Person natasha = new Person();
        cat1.setOwner(natasha);
        cat1.getOwner().sayMyName();

        Cat cats[] = new Cat[10];
        Person owners[] = new Person[cats.length];
        for (int i = 0; i < cats.length; i++) {
            cats[i].setId(i + 1);
        }
        for (int i = 0; i < cats.length; i++) {
            owners[i].age = (int) (Math.random() * 70) + 1;
        }
        for (Person i : owners) {
            System.out.println(i.age);
        }

    }
}
