package by.itstep.oop.inheritance.task;

public class SuperClient extends Client {
    private String[] functions;

    public String[] getFunctions() {
        return functions;
    }

    public void setFunctions(String[] functions) {
        this.functions = functions;
    }

    public SuperClient() {
        super(0,null,null,null,null,"Admin");
        //this.setRole("admin");
    }
}
