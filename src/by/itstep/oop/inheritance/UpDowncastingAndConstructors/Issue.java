package by.itstep.oop.inheritance.UpDowncastingAndConstructors;

import by.itstep.oop.casting.JavaProgrammer;

public class Issue {
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Issue(String name) {
        this.name = name;
    }

    public Issue() {
        this.name = "Mysterious Issue";
    }
}

class Book extends Issue {
    private String authors;

    public String getAuthors() {
        return authors;
    }

    public void setAuthors(String authors) {
        this.authors = authors;
    }

    public Book(String name, String authors) {
        super(name);
        this.authors = authors;
    }

    public Book(String name) {
        super(name);
    }

    public Book() {
        this.setName("Mysterious book");
    }

    @Override
    public String toString() {
        return "Book{" +
                "authors='" + authors + '\'' +
                ", name='" + getName() + '\'' +
                "} ";
    }
}

class Newspaper extends Issue {
    int issueNumber;

    public int getIssueNumber() {
        return issueNumber;
    }

    public void setIssueNumber(int issueNumber) {
        this.issueNumber = issueNumber;
    }

    public Newspaper(String name, int issueNumber) {
        super(name);
        this.issueNumber = issueNumber;
    }

    public Newspaper(String name) {
        super(name);
    }

    public Newspaper() {
        this.setName("Mysterious Newspaper");
    }

    @Override
    public String toString() {
        return "Newspaper{" +
                "issueNumber=" + issueNumber +
                ", name='" + getName() + '\'' +
                "} ";
    }
}

class Journal extends Issue {
    String format;

    public String getFormat() {
        return format;
    }

    public void setFormat(String format) {
        this.format = format;
    }

    public Journal(String name, String format) {
        super(name);
        this.format = format;
    }

    public Journal(String name) {
        super(name);
    }

    public Journal() {
        this.setName("Mysterious Journal");
    }

    @Override
    public String toString() {
        return "Journal{" +
                "format='" + format +
                ", name='" + getName() + '\'' +
                "} ";
    }
}

class Edition {
    public static String generateName() {
        String[] names = {"Ivan", "John", "Juan", "Joseph", "Alex", "Maxim", "Victor", "Benjamin", "Vladimir", "Peter",
                "Oleg", "Charles", "George", "David", "Franz", "Fritz", "Albert", "Roman", "Julio", "Tony"};
        String name = names[(int) ((Math.random() * (names.length)))];
        return name;
    }

    public static String generateLastName() {
        String[] lastNames = {"Ivanov", "Weiss", "Smith", "Petrov", "Bykov", "Meyer", "Bruno", "Katz", "Osipov", "Becker",
                "Bauer", "Colbert", "Armand", "Lambert", "Blanchet", "Rossi", "Colombo", "Stafford", "Fischer", "Serov"};
        String lastName = lastNames[(int) ((Math.random() * (lastNames.length)))];
        return lastName;
    }

    public static String generateAuthors() {
        String author = generateLastName() + " " + generateName();
        return author;
    }

    public static String generateBookName() {
        String[] bookNames = {"Java for beginners", "Algorythms", "Applied Mathematics", "Learn C++ today", "Basic logic",
                "Computer Science", "Advanced Algebra", "Databases"};
        String bookName = bookNames[(int) ((Math.random() * (bookNames.length)))] + " part " + (int) ((Math.random() * 10) + 1);
        return bookName;
    }

    public static String generateFormat() {
        String[] formats = {"A4", "A5"};
        String format = formats[(int) ((Math.random() * (formats.length)))];
        return format;
    }

    public static void main(String[] args) {
        Issue[] catalog = new Issue[]{new Journal("People", "A4"), new Newspaper("Из рук в руки",749), new Book("Война и мир", "Л.Толстой"),};
        for (int i = 0; i < catalog.length; i++) {
            if (catalog[i] instanceof Book) {
                Book a = (Book) catalog[i];
                System.out.println(a.toString());
            }
            if (catalog[i] instanceof Journal) {
                Journal a = (Journal) catalog[i];
                System.out.println(a.toString());
            }
            if (catalog[i] instanceof Newspaper) {
                Newspaper a = (Newspaper) catalog[i];
                System.out.println(a.toString());
            }
        }
        System.out.println();
        System.out.println("Now using .getClass():");
        System.out.println();
        for (int i = 0; i < catalog.length; i++) {
            if (catalog[i].getClass() == Book.class) {
                Book a = (Book) catalog[i];
                System.out.println(a.toString());
            }
            if (catalog[i].getClass() == Journal.class) {
                Journal a = (Journal) catalog[i];
                System.out.println(a.toString());
            }
            if (catalog[i].getClass() == Newspaper.class) {
                Newspaper a = (Newspaper) catalog[i];
                System.out.println(a.toString());
            }
        }

    }
}