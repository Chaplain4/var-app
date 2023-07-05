package by.itstep.oop.inheritance;

public class Third extends Child{
    private long id;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void run() {
        System.out.println(getName() + " is running");
    }
}
