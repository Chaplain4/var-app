package by.itstep.oop.casting;

public abstract class JavaProgrammer {
    abstract void makeCode();

    public void playTennis() {
        System.out.println("Playing tennis...");
    }
}

class MiddleJavaDeveloper extends JavaProgrammer {
    @Override
    void makeCode() {
        System.out.println("Writing some good code...");
        playTennis();
    }
}

class JuniorJavaDeveloper extends JavaProgrammer {

    @Override
    void makeCode() {
        System.out.println("Writing some bad code...");
        playTennis();
    }
}

class SeniorJavaDeveloper extends JavaProgrammer {

    @Override
    void makeCode() {
        System.out.println("Writing some perfect code...");
        playTennis();
    }

    void interviewJunior(JuniorJavaDeveloper junior) {
        System.out.println("Interviewing some " + junior.toString());
        junior.makeCode();
    }
}

class Company {
    public static void main(String[] args) {
        JuniorJavaDeveloper junior = new JuniorJavaDeveloper();
        JavaProgrammer programmer = junior; // upcasting
        Object o = (Object) new SeniorJavaDeveloper();
        Object o2 = (Object) (JavaProgrammer) new MiddleJavaDeveloper();
        JavaProgrammer jp = new MiddleJavaDeveloper();
        //
        JavaProgrammer[] programmers = {junior, (JavaProgrammer) o, (JavaProgrammer) o2, jp};
        System.out.println("programmers : " + programmers.length);
        for (JavaProgrammer i : programmers) {
            i.makeCode();
        }
    }
}