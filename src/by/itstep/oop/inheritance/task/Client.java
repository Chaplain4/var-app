package by.itstep.oop.inheritance.task;

public class Client {
    //id name email pass1 pass2 role если клиент дефолтный то роль юзер
    int id;
    String name;
    String email;
    String pass1;
    String pass2;
    String role;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPass1() {
        return pass1;
    }

    public void setPass1(String pass1) {
        this.pass1 = pass1;
    }

    public String getPass2() {
        return pass2;
    }

    public void setPass2(String pass2) {
        this.pass2 = pass2;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public Client() {
        this.role = "user";
    }

    public Client(int id, String name, String email) {
        this(id, name, email, null, null, null);
    }

    public Client(int id, String name, String email, String pass1, String pass2, String role) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.pass1 = pass1;
        this.pass2 = pass2;
        this.role = role;
    }

    private static String stars(String pass) {
        String starString = "";
        for (int i = 0; i < pass.length(); i++) {
            starString += "*";
        }
        return starString;
    }


    @Override
    public String toString() {
        return "Client{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", pass1='" + stars(pass1) + '\'' +
                ", pass2='" + stars(pass2) + '\'' +
                ", role='" + role + '\'' +
                '}';
    }
}
