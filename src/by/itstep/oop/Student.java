package by.itstep.oop;

public class Student {


    private String name;
    private double averageMark;
    private University university;

    public Student(String name, double averageMark, University university) {
        this.name = name;
        this.averageMark = averageMark;
        this.university = university;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getAverageMark() {
        return averageMark;
    }

    public void setAverageMark(double averageMark) {
        this.averageMark = averageMark;
    }

    public University getUniversity() {
        return university;
    }

    public void setUniversity(University university) {
        this.university = university;
    }
}

class University {

    private String name;
    private String location;
    private int numberOfStudents;
    private Student[] students = new Student[numberOfStudents];
    private Teacher[] teachers;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public int getNumberOfStudents() {
        return numberOfStudents;
    }

    public void setNumberOfStudents(int numberOfStudents) {
        this.numberOfStudents = numberOfStudents;
    }

    public Student[] getStudents() {
        return students;
    }

    public void setStudents(Student[] students) {
        this.students = students;
    }

    public Teacher[] getTeachers() {
        return teachers;
    }

    public void setTeachers(Teacher[] teachers) {
        this.teachers = teachers;
    }
}

class Teacher {
    private String name;
    private int exp;
    private long salary;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getExp() {
        return exp;
    }

    public void setExp(int exp) {
        this.exp = exp;
    }

    public long getSalary() {
        return salary;
    }

    public void setSalary(long salary) {
        this.salary = salary;
    }
}

class UniTest {
    public static void main(String[] args) {
        Teacher t1 = new Teacher();
        t1.setName("John");
        t1.setSalary(2000);
        t1.setExp(5);
        Teacher t2 = new Teacher();
        t2.setName("John");
        t2.setSalary(3000);
        t2.setExp(10);

        Teacher[] teachers = {t1, t2};

        University university1 = new University();
        university1.setName("Oxford");
        university1.setLocation("Great Britain");
        university1.setNumberOfStudents(9000);
        university1.setTeachers(teachers);
        Student st1 = new Student("Valera",7.8,university1);
    }
}