package by.itstep.oop.SimpleModels;

/*
Создать классы, спецификации которых приведены ниже. Определить метод в каждом классе showInfo().
 Определить дополнительно методы в классе, создающем массив объектов. Доп задание - Задать
 критерий выбора данных и вывести эти данные на консоль.
*/


import java.util.Arrays;
import java.util.Objects;
import java.util.Scanner;

class Entity {
    private int id;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Entity(int id) {
        this.id = id;
    }

    public Entity() {
    }

    @Override
    public String toString() {
        return "Entity{" +
                "id=" + id +
                '}';
    }
}

class Goods extends Entity {
    private int price;

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public Goods(int id, int price) {
        super(id);
        this.price = price;
    }

    public Goods(int price) {
        this.price = price;
    }

    public Goods() {
    }

    @Override
    public String toString() {
        return "Goods{" +
                "id=" + getId() + '\'' +
                "price=" + price + '\'' +
                '}';
    }
}

class Human extends Entity {
    private String lastName;
    private String name;
    private String patronym;
    private String address;

    public Human() {
    }

    public Human(int id) {
        super(id);
    }

    public Human(int id, String lastName) {
        super(id);
        this.lastName = lastName;
    }

    public Human(int id, String lastName, String name, String patronym) {
        super(id);
        this.lastName = lastName;
        this.name = name;
        this.patronym = patronym;
    }

    public Human(int id, String lastName, String name) {
        super(id);
        this.lastName = lastName;
        this.name = name;
    }

    public Human(int id, String lastName, String name, String patronym, String address) {
        super(id);
        this.lastName = lastName;
        this.name = name;
        this.patronym = patronym;
        this.address = address;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPatronym() {
        return patronym;
    }

    public void setPatronym(String patronym) {
        this.patronym = patronym;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "Human{" +
                "id=" + getId() + '\'' +
                "lastName='" + lastName + '\'' +
                ", name='" + name + '\'' +
                ", patronym='" + patronym + '\'' +
                ", address='" + address + '\'' +
                '}';
    }
}

class Student extends Human {
    /*
    Id, фамилия, имя, отчество, дата рождения, адрес, телефон, факультет, курс, группа. Создать Getters & Setters.
     Создать Методы «Учиться», «Прогуливать», «Сдавать Экзамен» и т.д. Создать 10 объектов и запустить все методы.
     *Создать массив объектов. Вывести:
    a) список студентов заданного факультета
    b) список студентов для каждого факультета и курса
    c) список студентов родившихся после заданного года
    d) список учебной группы
    */
    private byte dayOfBirth;
    private byte monthOfBirth;
    private short yearOfBirth;
    //    private String address;
    private String phoneNumber;
    private String faculty;
    private byte yearOfStudy;
    private int studyGroup;

    //вместо ShowInfo
    @Override
    public String toString() {
        return "Student{" +
                "id=" + +getId() + '\'' +
                ", lastName='" + getLastName() + '\'' +
                ", name='" + getName() + '\'' +
                ", patronym='" + getPatronym() + '\'' +
                ", dayOfBirth=" + dayOfBirth +
                ", monthOfBirth=" + monthOfBirth +
                ", yearOfBirth=" + yearOfBirth +
                ", address='" + getAddress() + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", faculty='" + faculty + '\'' +
                ", yearOfStudy=" + yearOfStudy +
                ", studyGroup=" + studyGroup +
                '}';
    }

    //метод для выборочного вывода данных в консоль
    public void selectiveOutput() {

        String[] fields = {"ID", "last name", "name", "patronym", "day of birth", "month of birth", "year of birth",
                "address", "phone number", "faculty", "year of study", "study group"};
        boolean[] checklist = new boolean[fields.length];

        Scanner sc = new Scanner(System.in);
        for (int i = 0; i < fields.length; i++) {
            System.out.println("Show " + fields[i] + "? Y - yes.");
            char input = sc.next().charAt(0);
            if (input == 'y' || input == 'Y') {
                checklist[i] = true;
            } else checklist[i] = false;
        }
        for (int i = 0; i < fields.length; i++) {
            if (checklist[i] == true) {
                switch (i) {
                    case 0:
                        System.out.println(fields[i] + ": " + getId());
                        break;
                    case 1:
                        System.out.println(fields[i] + ": " + getLastName());
                        break;
                    case 2:
                        System.out.println(fields[i] + ": " + getName());
                        break;
                    case 3:
                        System.out.println(fields[i] + ": " + getPatronym());
                        break;
                    case 4:
                        System.out.println(fields[i] + ": " + getDayOfBirth());
                        break;
                    case 5:
                        System.out.println(fields[i] + ": " + getMonthOfBirth());
                        break;
                    case 6:
                        System.out.println(fields[i] + ": " + getYearOfBirth());
                        break;
                    case 7:
                        System.out.println(fields[i] + ": " + getAddress());
                        break;
                    case 8:
                        System.out.println(fields[i] + ": " + getPhoneNumber());
                        break;
                    case 9:
                        System.out.println(fields[i] + ": " + getFaculty());
                        break;
                    case 10:
                        System.out.println(fields[i] + ": " + getYearOfStudy());
                        break;
                    default:
                        System.out.println(fields[i] + ": " + getStudyGroup());
                        break;
                }
            }
        }
    }

    public void study() {
        System.out.println(getName() + " is studying " + faculty + " for " + yearOfStudy + " years.");
    }

    public void skipClasses() {
        System.out.println(getName() + " is absent in " + studyGroup + " study group! Time to make him a phone call: " + phoneNumber + " or send a runner to " + getAddress());
    }

    public void passingExams() {
        System.out.println(getName() + " is passing exams to get to " + (yearOfStudy + 1) + " year of study");
    }

    public Student() {
    }

    public Student(int id, byte dayOfBirth) {
        super(id);
        this.dayOfBirth = dayOfBirth;
    }

    public Student(int id, String lastName, byte dayOfBirth) {
        super(id, lastName);
        this.dayOfBirth = dayOfBirth;
    }

    public Student(int id, String lastName, String name, String patronym, byte dayOfBirth) {
        super(id, lastName, name, patronym);
        this.dayOfBirth = dayOfBirth;
    }

    public Student(int id, String lastName, String name, byte dayOfBirth) {
        super(id, lastName, name);
        this.dayOfBirth = dayOfBirth;
    }

    public Student(int id, String lastName, String name, String patronym, String address, byte dayOfBirth, byte monthOfBirth,
                   short yearOfBirth, String phoneNumber, String faculty, byte yearOfStudy, int studyGroup) {
        super(id, lastName, name, patronym, address);
        this.dayOfBirth = dayOfBirth;
        this.monthOfBirth = monthOfBirth;
        this.yearOfBirth = yearOfBirth;
        this.phoneNumber = phoneNumber;
        this.faculty = faculty;
        this.yearOfStudy = yearOfStudy;
        this.studyGroup = studyGroup;
    }

    public Student(int id, String lastName, String name, String patronym, String address, byte dayOfBirth) {
        super(id, lastName, name, patronym, address);
        this.dayOfBirth = dayOfBirth;
    }

    public byte getDayOfBirth() {
        return dayOfBirth;
    }

    public void setDayOfBirth(byte dayOfBirth) {
        this.dayOfBirth = dayOfBirth;
    }

    public byte getMonthOfBirth() {
        return monthOfBirth;
    }

    public void setMonthOfBirth(byte monthOfBirth) {
        this.monthOfBirth = monthOfBirth;
    }

    public short getYearOfBirth() {
        return yearOfBirth;
    }

    public void setYearOfBirth(short yearOfBirth) {
        this.yearOfBirth = yearOfBirth;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getFaculty() {
        return faculty;
    }

    public void setFaculty(String faculty) {
        this.faculty = faculty;
    }

    public byte getYearOfStudy() {
        return yearOfStudy;
    }

    public void setYearOfStudy(byte yearOfStudy) {
        this.yearOfStudy = yearOfStudy;
    }

    public int getStudyGroup() {
        return studyGroup;
    }

    public void setStudyGroup(int studyGroup) {
        this.studyGroup = studyGroup;
    }
}

class Customer extends Human {

    /*
    id, Фамилия, Имя, Отчество, Адрес, Номер кредитной карточки, Номер банковского счета.
    Создать Getters & Setters. Создать Методы «Работать», «Оформлять больничный», «Идти на тимбилдинг (корпоратив)» и т.д.
    Создать 10 объектов и запустить все методы. Создать массив объектов. Вывести: a) список покупателей в алфавитном
     порядке по фамилии; b) список покупателей в алфавитном порядке по имени; c) список покупателей, у которых номер
     кредитной карточки находится в заданном интервале.
    */

    private long creditCardNumber;
    private String bankAccountNumber;

    public Customer(long creditCardNumber, String bankAccountNumber) {
        this.creditCardNumber = creditCardNumber;
        this.bankAccountNumber = bankAccountNumber;
    }

    public Customer(int id, long creditCardNumber, String bankAccountNumber) {
        super(id);
        this.creditCardNumber = creditCardNumber;
        this.bankAccountNumber = bankAccountNumber;
    }

    public Customer(int id, String lastName, long creditCardNumber, String bankAccountNumber) {
        super(id, lastName);
        this.creditCardNumber = creditCardNumber;
        this.bankAccountNumber = bankAccountNumber;
    }

    public Customer(int id, String lastName, String name, String patronym, long creditCardNumber, String bankAccountNumber) {
        super(id, lastName, name, patronym);
        this.creditCardNumber = creditCardNumber;
        this.bankAccountNumber = bankAccountNumber;
    }

    public Customer(int id, String lastName, String name, long creditCardNumber, String bankAccountNumber) {
        super(id, lastName, name);
        this.creditCardNumber = creditCardNumber;
        this.bankAccountNumber = bankAccountNumber;
    }

    public Customer(int id, String lastName, String name, String patronym, String address, long creditCardNumber, String bankAccountNumber) {
        super(id, lastName, name, patronym, address);
        this.creditCardNumber = creditCardNumber;
        this.bankAccountNumber = bankAccountNumber;
    }

    public Customer() {
    }

    public void goesToWork() {
        System.out.println(getName() + " is working to fill his " + bankAccountNumber + " bankAccount");
    }

    public void fellIll() {
        System.out.println(getName() + " has fallen ill. He'll be staying at  " + getAddress() + " for a while!");
    }

    public void goesToParty() {
        System.out.println(getName() + " is going to party with his colleagues! Time to spend some money from his " + getCreditCardNumber() + " credit card!");
    }

    //вместо ShowInfo
    @Override
    public String toString() {
        return "Customer{" +
                "id=" + getId() +
                ", lastName='" + getLastName() + '\'' +
                ", name='" + getName() + '\'' +
                ", patronym='" + getPatronym() + '\'' +
                ", address='" + getAddress() + '\'' +
                ", creditCardNumber=" + creditCardNumber +
                ", bankAccountNumber='" + bankAccountNumber + '\'' +
                '}';
    }

    //метод для выборочного вывода данных в консоль
    public void selectiveOutput() {

        String[] fields = {"ID", "last name", "name", "patronym", "address", "creditCardNumber", "bankAccountNumber"};
        boolean[] checklist = new boolean[fields.length];
        Scanner sc = new Scanner(System.in);
        for (int i = 0; i < fields.length; i++) {
            System.out.println("Show " + fields[i] + "? Y - yes.");
            char input = sc.next().charAt(0);
            if (input == 'y' || input == 'Y') {
                checklist[i] = true;
            }
        }
        for (int i = 0; i < fields.length; i++) {
            if (checklist[i] == true) {
                switch (i) {
                    case 0:
                        System.out.println(fields[i] + ": " + getId());
                        break;
                    case 1:
                        System.out.println(fields[i] + ": " + getLastName());
                        break;
                    case 2:
                        System.out.println(fields[i] + ": " + getName());
                        break;
                    case 3:
                        System.out.println(fields[i] + ": " + getPatronym());
                        break;
                    case 4:
                        System.out.println(fields[i] + ": " + getAddress());
                        break;
                    case 5:
                        System.out.println(fields[i] + ": " + getCreditCardNumber());
                        break;
                    default:
                        System.out.println(fields[i] + ": " + getBankAccountNumber());
                        break;
                }
            }
        }
    }

    public long getCreditCardNumber() {
        return creditCardNumber;
    }

    public void setCreditCardNumber(long creditCardNumber) {
        this.creditCardNumber = creditCardNumber;
    }

    public String getBankAccountNumber() {
        return bankAccountNumber;
    }

    public void setBankAccountNumber(String bankAccountNumber) {
        this.bankAccountNumber = bankAccountNumber;
    }
}

class Book extends Goods {
    /*
    id, Название, Автор (ы), Издательство, Год издания, Количество стра-ниц, Контент, Цена, Тип переплета.
     Создать Методы «Печать контента в консоль», «Печать авторов в консоль», «Дописать/Переписать»,
     «Добавить Автора» и т.д. Создать 10 объектов и запустить все методы.
    Создать Getters & Setters. Создать 10 объектов. Создать массив объектов.
     Вывести: a) список книг заданного автора;
     b) список книг, выпущенных заданным издательством;
     c) список книг, выпущенных после заданного года.
    */
    private String name;
    private Human[] authors;
    private String publisher;
    private short yearOfCreation;
    private int numberOfPages;
    private String content;
    private String bookbinding;

    public void addNewAuthorFromConsole() {
        Scanner sc = new Scanner(System.in);
        Human[] newAuthorArray = new Human[this.authors.length + 1];
        for (int i = 0; i < this.authors.length; i++) {
            newAuthorArray[i] = this.authors[i];
        }
        newAuthorArray[newAuthorArray.length - 1] = new Human();
        System.out.println("input author #" + newAuthorArray.length + " name:");
        newAuthorArray[newAuthorArray.length - 1].setName(sc.next());
        System.out.println("input author #" + newAuthorArray.length + " last name:");
        newAuthorArray[newAuthorArray.length - 1].setLastName(sc.next());
        System.out.println("input author #" + newAuthorArray.length + " patronym:");
        newAuthorArray[newAuthorArray.length - 1].setPatronym(sc.next());
        this.setAuthors(newAuthorArray);
    }

    public void setAuthorsFromConsole() {
        Scanner sc = new Scanner(System.in);
        for (int i = 0; i < this.authors.length; i++) {
            System.out.println("input author #" + (i + 1) + " name:");
            String name = sc.next();
            this.authors[i].setName(name);
        }
        for (int i = 0; i < this.authors.length; i++) {
            System.out.println("input author #" + (i + 1) + " last name:");
            String lastName = sc.next();
            this.authors[i].setLastName(lastName);
        }
        for (int i = 0; i < this.authors.length; i++) {
            System.out.println("input author #" + (i + 1) + " patronym:");
            String patronym = sc.next();
            this.authors[i].setPatronym(patronym);
        }
    }

    public void setContentFromConsole() {
        Scanner sc = new Scanner(System.in);
        System.out.println("input content : ");
        String content = sc.next();
        this.content = content;
    }

    public Book(int id, int price, String name, Human[] authors, String publisher, short yearOfCreation, int numberOfPages, String content, String bookbinding) {
        super(id, price);
        this.name = name;
        this.authors = authors;
        this.publisher = publisher;
        this.yearOfCreation = yearOfCreation;
        this.numberOfPages = numberOfPages;
        this.content = content;
        this.bookbinding = bookbinding;
    }

    public Book(int price, String name, Human[] authors, String publisher, short yearOfCreation, int numberOfPages, String content, String bookbinding) {
        super(price);
        this.name = name;
        this.authors = authors;
        this.publisher = publisher;
        this.yearOfCreation = yearOfCreation;
        this.numberOfPages = numberOfPages;
        this.content = content;
        this.bookbinding = bookbinding;
    }

    public Book(String name, Human[] authors, String publisher, short yearOfCreation, int numberOfPages, String content, String bookbinding) {
        this.name = name;
        this.authors = authors;
        this.publisher = publisher;
        this.yearOfCreation = yearOfCreation;
        this.numberOfPages = numberOfPages;
        this.content = content;
        this.bookbinding = bookbinding;
    }

    public Book(String name, Human[] authors, String publisher, short yearOfCreation, int numberOfPages, String content) {
        this.name = name;
        this.authors = authors;
        this.publisher = publisher;
        this.yearOfCreation = yearOfCreation;
        this.numberOfPages = numberOfPages;
        this.content = content;
    }

    public Book(String name, Human[] authors, String publisher, short yearOfCreation, int numberOfPages) {
        this.name = name;
        this.authors = authors;
        this.publisher = publisher;
        this.yearOfCreation = yearOfCreation;
        this.numberOfPages = numberOfPages;
    }

    public Book(String name, Human[] authors, String publisher, short yearOfCreation) {
        this.name = name;
        this.authors = authors;
        this.publisher = publisher;
        this.yearOfCreation = yearOfCreation;
    }

    public Book(String name, Human[] authors, String publisher) {
        this.name = name;
        this.authors = authors;
        this.publisher = publisher;
    }

    public Book(String name, Human[] authors) {
        this.name = name;
        this.authors = authors;
    }

    public Book(String name) {
        this.name = name;
    }

    public Book() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Human[] getAuthors() {
        return authors;
    }

    public void setAuthors(Human[] authors) {
        this.authors = authors;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public short getYearOfCreation() {
        return yearOfCreation;
    }

    public void setYearOfCreation(short yearOfCreation) {
        this.yearOfCreation = yearOfCreation;
    }

    public int getNumberOfPages() {
        return numberOfPages;
    }

    public void setNumberOfPages(int numberOfPages) {
        this.numberOfPages = numberOfPages;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getBookbinding() {
        return bookbinding;
    }

    public void setBookbinding(String bookbinding) {
        this.bookbinding = bookbinding;
    }

    //вместо ShowInfo
    @Override
    public String toString() {
        return "Book{" +
                "id='" + getId() + '\'' +
                ", price=" + getPrice() + '\'' +
                ", name='" + name + '\'' +
                ", authors=" + Arrays.toString(authors) +
                ", publisher='" + publisher + '\'' +
                ", yearOfCreation=" + yearOfCreation +
                ", numberOfPages=" + numberOfPages +
                ", content='" + content + '\'' +
                ", bookbinding='" + bookbinding + '\'' +
                "} ";
    }

    //метод для выборочного вывода данных в консоль
    public void selectiveOutput() {

        String[] fields = {"ID", "price", "name", "authors", "publisher", "yearOfCreation", "numberOfPages", "content", "bookbinding"};
        boolean[] checklist = new boolean[fields.length];
        Scanner sc = new Scanner(System.in);
        for (int i = 0; i < fields.length; i++) {
            System.out.println("Show " + fields[i] + "? Y - yes.");
            char input = sc.next().charAt(0);
            if (input == 'y' || input == 'Y') {
                checklist[i] = true;
            }
        }
        for (int i = 0; i < fields.length; i++) {
            if (checklist[i] == true) {
                switch (i) {
                    case 0:
                        System.out.println(fields[i] + ": " + getId());
                        break;
                    case 1:
                        System.out.println(fields[i] + ": " + getPrice());
                        break;
                    case 2:
                        System.out.println(fields[i] + ": " + getName());
                        break;
                    case 3:
                        System.out.println(fields[i] + ": " + Arrays.toString(authors));
                        break;
                    case 4:
                        System.out.println(fields[i] + ": " + getPublisher());
                        break;
                    case 5:
                        System.out.println(fields[i] + ": " + getYearOfCreation());
                        break;
                    case 6:
                        System.out.println(fields[i] + ": " + getNumberOfPages());
                        break;
                    case 7:
                        System.out.println(fields[i] + ": " + getContent());
                        break;
                    default:
                        System.out.println(fields[i] + ": " + getBookbinding());
                        break;
                }
            }
        }
    }
}

class House extends Goods {
    /*
    id, Номер квартиры, Площадь, Этаж, Количество комнат, Улица, Тип здания, Срок эксплуатации. Создать Getters & Setters.
     Создать Методы «Включить / Выключить Электричество», «Проветриваться», «Перекрыть воду», и т.д. Создать 10 объектов
     и запустить все методы. Создать массив объектов. Вывести:
     a) список квартир, имеющих заданное число комнат;
     b) список квартир, имеющих заданное число комнат и расположенных на этаже, который находится в заданном промежутке;
     c) список квартир, имеющих площадь, превосходящую заданную.
    */
    private short apartmentNumber;
    private short area;
    private short floor;
    private short numberOfRooms;
    private String address;
    private String buildingType;
    private short yearOfConstruction;

    public void turnOffWater () {
        System.out.println("Running water is turned off at " + getAddress());
    }

    public void ventilate() {
        System.out.println(getNumberOfRooms() + " rooms with an area of " + getArea() + " are being ventilated at " + getAddress());
    }

    public void turnOn220 () {
        System.out.println("Electricity is turned on at " + getAddress());
    }

    public void turnOff220 () {
        System.out.println("Electricity is turned off at " + getAddress());
    }

    //вместо ShowInfo
    @Override
    public String toString() {
        return "House{" +
                "id='" + getId() + '\'' +
                ", price=" + getPrice() + '\'' +
                "apartmentNumber=" + apartmentNumber +
                ", area=" + area +
                ", floor=" + floor +
                ", numberOfRooms=" + numberOfRooms +
                ", address='" + address + '\'' +
                ", buildingType='" + buildingType + '\'' +
                ", yearOfConstruction=" + yearOfConstruction +
                "} ";
    }

    //метод для выборочного вывода данных в консоль
    public void selectiveOutput() {

        String[] fields = {"ID", "price", "apartmentNumber", "area", "floor", "numberOfRooms", "address", "buildingType", "yearOfConstruction"};
        boolean[] checklist = new boolean[fields.length];
        Scanner sc = new Scanner(System.in);
        for (int i = 0; i < fields.length; i++) {
            System.out.println("Show " + fields[i] + "? Y - yes.");
            char input = sc.next().charAt(0);
            if (input == 'y' || input == 'Y') {
                checklist[i] = true;
            }
        }
        for (int i = 0; i < fields.length; i++) {
            if (checklist[i] == true) {
                switch (i) {
                    case 0:
                        System.out.println(fields[i] + ": " + getId());
                        break;
                    case 1:
                        System.out.println(fields[i] + ": " + getPrice());
                        break;
                    case 2:
                        System.out.println(fields[i] + ": " + getApartmentNumber());
                        break;
                    case 3:
                        System.out.println(fields[i] + ": " + getArea());
                        break;
                    case 4:
                        System.out.println(fields[i] + ": " + getFloor());
                        break;
                    case 5:
                        System.out.println(fields[i] + ": " + getNumberOfRooms());
                        break;
                    case 6:
                        System.out.println(fields[i] + ": " + getAddress());
                        break;
                    case 7:
                        System.out.println(fields[i] + ": " + getBuildingType());
                        break;
                    default:
                        System.out.println(fields[i] + ": " + getYearOfConstruction());
                        break;
                }
            }
        }
    }

    public short getApartmentNumber() {
        return apartmentNumber;
    }

    public void setApartmentNumber(short apartmentNumber) {
        this.apartmentNumber = apartmentNumber;
    }

    public short getArea() {
        return area;
    }

    public void setArea(short area) {
        this.area = area;
    }

    public short getFloor() {
        return floor;
    }

    public void setFloor(short floor) {
        this.floor = floor;
    }

    public short getNumberOfRooms() {
        return numberOfRooms;
    }

    public void setNumberOfRooms(short numberOfRooms) {
        this.numberOfRooms = numberOfRooms;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getBuildingType() {
        return buildingType;
    }

    public void setBuildingType(String buildingType) {
        this.buildingType = buildingType;
    }

    public short getYearOfConstruction() {
        return yearOfConstruction;
    }

    public void setYearOfConstruction(short yearOfConstruction) {
        this.yearOfConstruction = yearOfConstruction;
    }

    public House(int id, int price, short apartmentNumber, short area, short floor, short numberOfRooms, String address, String buildingType, short yearOfConstruction) {
        super(id, price);
        this.apartmentNumber = apartmentNumber;
        this.area = area;
        this.floor = floor;
        this.numberOfRooms = numberOfRooms;
        this.address = address;
        this.buildingType = buildingType;
        this.yearOfConstruction = yearOfConstruction;
    }

    public House(int price, short apartmentNumber, short area, short floor, short numberOfRooms, String address, String buildingType, short yearOfConstruction) {
        super(price);
        this.apartmentNumber = apartmentNumber;
        this.area = area;
        this.floor = floor;
        this.numberOfRooms = numberOfRooms;
        this.address = address;
        this.buildingType = buildingType;
        this.yearOfConstruction = yearOfConstruction;
    }

    public House(short apartmentNumber, short area, short floor, short numberOfRooms, String address, String buildingType, short yearOfConstruction) {
        this.apartmentNumber = apartmentNumber;
        this.area = area;
        this.floor = floor;
        this.numberOfRooms = numberOfRooms;
        this.address = address;
        this.buildingType = buildingType;
        this.yearOfConstruction = yearOfConstruction;
    }

    public House(short apartmentNumber, short area, short floor, short numberOfRooms, String address, String buildingType) {
        this.apartmentNumber = apartmentNumber;
        this.area = area;
        this.floor = floor;
        this.numberOfRooms = numberOfRooms;
        this.address = address;
        this.buildingType = buildingType;
    }

    public House(short apartmentNumber, short area, short floor, short numberOfRooms, String address) {
        this.apartmentNumber = apartmentNumber;
        this.area = area;
        this.floor = floor;
        this.numberOfRooms = numberOfRooms;
        this.address = address;
    }

    public House(short apartmentNumber, short area, short floor, short numberOfRooms) {
        this.apartmentNumber = apartmentNumber;
        this.area = area;
        this.floor = floor;
        this.numberOfRooms = numberOfRooms;
    }

    public House(short apartmentNumber, short area, short floor) {
        this.apartmentNumber = apartmentNumber;
        this.area = area;
        this.floor = floor;
    }

    public House(short apartmentNumber, short area) {
        this.apartmentNumber = apartmentNumber;
        this.area = area;
    }

    public House(short apartmentNumber) {
        this.apartmentNumber = apartmentNumber;
    }

    public House() {
    }
}

class Patient extends Human {
    /*
    id, Фамилия, Имя, Отчество, Адрес, Телефон, Номер медицинской карты, Диагноз.
    Создать Getters & Setters. Создать Методы «Болеть», «Выздаравливать», «Сбежать из больницы» и т.д.
     Создать 10 объектов и запустить все методы. Создать массив объектов. Вывести: Создать массив объектов.
     Вывести:
     a) список пациентов, имеющих данный диагноз;
     b) список пациентов, номер медицинской карты у которых находится в заданном интервале
    */

    private String phoneNumber;
    private long medicalCardNumber;
    private String diagnosis;

    void fellIll() {
        System.out.println(getName() + " has fallen ill with " + getDiagnosis());
    }

    void recovery() {
        System.out.println(getName() + " is no longer ill! He can now return back home: " + getAddress());
        setDiagnosis("");
    }

    void escape() {
        System.out.println(getName() + " has escaped from hospital while recovering from " + getDiagnosis() + "!");
    }

    //вместо ShowInfo
    @Override
    public String toString() {
        return "Patient{" +
                "id=" + getId() +
                ", lastName='" + getLastName() + '\'' +
                ", name='" + getName() + '\'' +
                ", patronym='" + getPatronym() + '\'' +
                ", address='" + getAddress() + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", medicalCardNumber=" + medicalCardNumber +
                ", diagnosis='" + diagnosis + '\'' +
                '}';
    }

    public Patient() {
    }

    public Patient(String phoneNumber, long medicalCardNumber, String diagnosis) {
        this.phoneNumber = phoneNumber;
        this.medicalCardNumber = medicalCardNumber;
        this.diagnosis = diagnosis;
    }

    public Patient(int id, String phoneNumber, long medicalCardNumber, String diagnosis) {
        super(id);
        this.phoneNumber = phoneNumber;
        this.medicalCardNumber = medicalCardNumber;
        this.diagnosis = diagnosis;
    }

    public Patient(int id, String lastName, String phoneNumber, long medicalCardNumber, String diagnosis) {
        super(id, lastName);
        this.phoneNumber = phoneNumber;
        this.medicalCardNumber = medicalCardNumber;
        this.diagnosis = diagnosis;
    }

    public Patient(int id, String lastName, String name, String patronym, String phoneNumber, long medicalCardNumber, String diagnosis) {
        super(id, lastName, name, patronym);
        this.phoneNumber = phoneNumber;
        this.medicalCardNumber = medicalCardNumber;
        this.diagnosis = diagnosis;
    }

    public Patient(int id, String lastName, String name, String phoneNumber, long medicalCardNumber, String diagnosis) {
        super(id, lastName, name);
        this.phoneNumber = phoneNumber;
        this.medicalCardNumber = medicalCardNumber;
        this.diagnosis = diagnosis;
    }

    public Patient(int id, String lastName, String name, String patronym, String address, String phoneNumber, long medicalCardNumber, String diagnosis) {
        super(id, lastName, name, patronym, address);
        this.phoneNumber = phoneNumber;
        this.medicalCardNumber = medicalCardNumber;
        this.diagnosis = diagnosis;
    }

    //метод для выборочного вывода данных в консоль
    void selectiveOutput() {

        String[] fields = {"ID", "last name", "name", "patronym", "address", "phoneNumber", "medicalCardNumber", "diagnosis"};
        boolean[] checklist = new boolean[fields.length];
        Scanner sc = new Scanner(System.in);
        for (int i = 0; i < fields.length; i++) {
            System.out.println("Show " + fields[i] + "? Y - yes.");
            char input = sc.next().charAt(0);
            if (input == 'y' || input == 'Y') {
                checklist[i] = true;
            }
        }
        for (int i = 0; i < fields.length; i++) {
            if (checklist[i] == true) {
                switch (i) {
                    case 0:
                        System.out.println(fields[i] + ": " + getId());
                        break;
                    case 1:
                        System.out.println(fields[i] + ": " + getLastName());
                        break;
                    case 2:
                        System.out.println(fields[i] + ": " + getName());
                        break;
                    case 3:
                        System.out.println(fields[i] + ": " + getPatronym());
                        break;
                    case 4:
                        System.out.println(fields[i] + ": " + getAddress());
                        break;
                    case 5:
                        System.out.println(fields[i] + ": " + getPhoneNumber());
                        break;
                    case 6:
                        System.out.println(fields[i] + ": " + getMedicalCardNumber());
                        break;
                    default:
                        System.out.println(fields[i] + ": " + getDiagnosis());
                        break;
                }
            }
        }
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public long getMedicalCardNumber() {
        return medicalCardNumber;
    }

    public void setMedicalCardNumber(long medicalCardNumber) {
        this.medicalCardNumber = medicalCardNumber;
    }

    public String getDiagnosis() {
        return diagnosis;
    }

    public void setDiagnosis(String diagnosis) {
        this.diagnosis = diagnosis;
    }
}


class SimpleModelTester {
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

    //отчества не везде распространены
    public static String generatePatronym() {
        String[] patronyms = {"Ivanovich", "Vladimirovich", "Stanislavovich", "Konstantinovich", "Viktorovich"};
        String patronym;
        int i = (int) ((Math.random() * (20)));
        if (i < patronyms.length) {
            patronym = patronyms[i];
        } else patronym = "";

        return patronym;
    }

    public static String generateAddress() {
        String[] addresses = {"Minsk, Lenina st., 1", "Minsk, Shirokaya st., 10", "Minsk, Kolasa st., 5",
                "Minsk, Kulman st., 15", "Minsk, Saperov st., 14"};
        String address = addresses[(int) ((Math.random() * (addresses.length)))];
        return address;
    }

    public static String generateFaculty() {
        String[] faculties = {"Law", "History", "Journalism"};
        String faculty = faculties[(int) ((Math.random() * (faculties.length)))];
        return faculty;
    }

    public static Student[] generateStudentArray(int studentNumber) {
        Student[] students = new Student[studentNumber];
        for (int i = 0; i < studentNumber; i++) {
            students[i] = new Student(i, generateLastName(), generateName(), generatePatronym(), generateAddress(),
                    (byte) ((Math.random() * (29)) + 1), (byte) ((Math.random() * (12)) + 1),
                    (short) ((Math.random() * (5)) + 1999),
                    "+375 29" + (int) ((Math.random() * (8999999)) + 1000000), generateFaculty(),
                    (byte) ((Math.random() * (5)) + 1), (int) ((Math.random() * (3)) + 1));
        }
        return students;
    }

    public static void printStudentArray(Student[] students) {
        for (int i = 0; i < students.length; i++) {
            System.out.println(students[i].toString());
        }
    }

    public static void printStudentsByFaculty(Student[] students) {
        String[] faculties = new String[students.length];
        for (int i = 0, n = 0; i < students.length; i++) {
            boolean isNewFaculty = true;
            for (int j = 0; j < students.length; j++) {
                if (students[i].getFaculty() == faculties[j]) {
                    isNewFaculty = false;
                }
            }
            if (isNewFaculty) {
                faculties[n] = students[i].getFaculty();
                n++;
            }
        }
        for (int i = 0; i < faculties.length; i++) {
            if (faculties[i] == null) {
                break;
            } else
                System.out.println("Students from " + faculties[i] + " faculty:");
            for (int j = 0; j < students.length; j++) {
                if (faculties[i] == students[j].getFaculty()) {
                    System.out.println(students[j].toString());
                }
            }
        }
    }

    public static void printStudentsByYearOfStudy(Student[] students) {
        byte[] schoolYears = new byte[students.length];
        for (int i = 0, n = 0; i < students.length; i++) {
            boolean isNewSchoolYear = true;
            for (int j = 0; j < students.length; j++) {
                if (students[i].getYearOfStudy() == schoolYears[j]) {
                    isNewSchoolYear = false;
                }
            }
            if (isNewSchoolYear) {
                schoolYears[n] = students[i].getYearOfStudy();
                n++;
            }
        }
        for (int i = 0; i < schoolYears.length; i++) {
            if (schoolYears[i] == 0) {
                break;
            } else
                System.out.println("Students from " + schoolYears[i] + " year of study:");
            for (int j = 0; j < students.length; j++) {
                if (schoolYears[i] == students[j].getYearOfStudy()) {
                    System.out.println(students[j].toString());
                }
            }
        }
    }

    public static void printStudentsByYearOfBirth(Student[] students, short designatedYearOfBirth) {
        System.out.println("Students born after year " + designatedYearOfBirth + ":");
        for (int i = 0; i < students.length; i++) {
            if (students[i].getYearOfBirth() > designatedYearOfBirth) {
                System.out.println(students[i].toString());
            }
        }
    }

    public static void printStudentsByStudyGroup(Student[] students, int designatedStudyGroup) {
        System.out.println("Students assigned to " + designatedStudyGroup + " study group:");
        for (int i = 0; i < students.length; i++) {
            if (students[i].getStudyGroup() == designatedStudyGroup) {
                System.out.println(students[i].toString());
            }
        }
    }

    public static Customer[] generateCustomerArray(int customerNumber) {
        Customer[] customers = new Customer[customerNumber];
        for (int i = 0; i < customerNumber; i++) {
            customers[i] = new Customer(i, generateLastName(), generateName(), generatePatronym(), generateAddress(),
                    (long) ((Math.random() * (9999999999999999L))), "40817840" + (long) ((Math.random() * (999999999999L))));
        }
        return customers;
    }

    public static void printCustomerArray(Customer[] customers) {
        for (int i = 0; i < customers.length; i++) {
            System.out.println(customers[i].toString());
        }
    }

    public static Customer[] arrangeCustomersByLastName(Customer[] customers) {
        int counter = -1;
        Customer c1 = new Customer();
        Customer c2 = new Customer();
        while (!(counter == 0)) {
            counter = 0;
            for (int i = 0; i < customers.length - 1; i++) {
                if (customers[i].getLastName() == customers[i + 1].getLastName()) {
                } else if (customers[i].getLastName().length() > customers[i + 1].getLastName().length()) {
                    for (int j = 0; j < customers[i + 1].getLastName().length() - 1; j++) {
                        if (customers[i].getLastName().charAt(j) == customers[i + 1].getLastName().charAt(j)) {
                        } else if (customers[i].getLastName().charAt(j) < customers[i + 1].getLastName().charAt(j)) {
                            break;
                        } else if (customers[i].getLastName().charAt(j) > customers[i + 1].getLastName().charAt(j)) {
                            c1 = customers[i];
                            c2 = customers[i + 1];
                            customers[i] = c2;
                            customers[i + 1] = c1;
                            counter++;
                            break;
                        }
                    }
                } else for (int j = 0; j < customers[i].getLastName().length() - 1; j++) {
                    if (customers[i].getLastName().charAt(j) == customers[i + 1].getLastName().charAt(j)) {
                    } else if (customers[i].getLastName().charAt(j) < customers[i + 1].getLastName().charAt(j)) {
                        break;
                    } else if (customers[i].getLastName().charAt(j) > customers[i + 1].getLastName().charAt(j)) {
                        c1 = customers[i];
                        c2 = customers[i + 1];
                        customers[i] = c2;
                        customers[i + 1] = c1;
                        counter++;
                        break;
                    }
                }
            }
        }
        return customers;
    }

    public static Customer[] arrangeCustomersByName(Customer[] customers) {
        int counter = -1;
        Customer c1 = new Customer();
        Customer c2 = new Customer();
        while (!(counter == 0)) {
            counter = 0;
            for (int i = 0; i < customers.length - 1; i++) {
                if (customers[i].getName() == customers[i + 1].getName()) {
                } else if (customers[i].getName().length() > customers[i + 1].getName().length()) {
                    for (int j = 0; j < customers[i + 1].getName().length() - 1; j++) {
                        if (customers[i].getName().charAt(j) == customers[i + 1].getName().charAt(j)) {
                        } else if (customers[i].getName().charAt(j) < customers[i + 1].getName().charAt(j)) {
                            break;
                        } else if (customers[i].getName().charAt(j) > customers[i + 1].getName().charAt(j)) {
                            c1 = customers[i];
                            c2 = customers[i + 1];
                            customers[i] = c2;
                            customers[i + 1] = c1;
                            counter++;
                            break;
                        }
                    }
                } else for (int j = 0; j < customers[i].getName().length() - 1; j++) {
                    if (customers[i].getName().charAt(j) == customers[i + 1].getName().charAt(j)) {
                    } else if (customers[i].getName().charAt(j) < customers[i + 1].getName().charAt(j)) {
                        break;
                    } else if (customers[i].getName().charAt(j) > customers[i + 1].getName().charAt(j)) {
                        c1 = customers[i];
                        c2 = customers[i + 1];
                        customers[i] = c2;
                        customers[i + 1] = c1;
                        counter++;
                        break;
                    }
                }
            }
        }
        return customers;
    }

    public static Customer[] creditCardNumberRangeList(Customer[] customers, long num1, long num2) {
        int validCustomersLength = 0;
        if (num1 > num2) {
            for (int i = 0; i < customers.length; i++) {
                if (customers[i].getCreditCardNumber() >= num2 && customers[i].getCreditCardNumber() <= num1) {
                    validCustomersLength++;
                }
            }
        } else {
            for (int i = 0; i < customers.length; i++) {
                if (customers[i].getCreditCardNumber() <= num2 && customers[i].getCreditCardNumber() >= num1) {
                    validCustomersLength++;
                }
            }
        }
        Customer[] validCustomers = new Customer[validCustomersLength];
        if (num1 > num2) {
            for (int i = 0, j = 0; i < customers.length; i++) {
                if (customers[i].getCreditCardNumber() >= num2 && customers[i].getCreditCardNumber() <= num1) {
                    validCustomers[j] = customers[i];
                    j++;
                }
            }
        } else {
            for (int i = 0, j = 0; i < customers.length; i++) {
                if (customers[i].getCreditCardNumber() <= num2 && customers[i].getCreditCardNumber() >= num1) {
                    validCustomers[j] = customers[i];
                    j++;
                }
            }
        }
        return validCustomers;
    }

    public static String generateDiagnosis() {
        String[] diagnoses = {"Schizophrenia", "Delirium", "Dementia", "Obsessive–compulsive disorder", "Generalized anxiety disorder",
                "Amnesia", "Post-traumatic stress disorder"};
        String diagnosis = diagnoses[(int) ((Math.random() * (diagnoses.length)))];
        return diagnosis;
    }

    public static Patient[] generatePatientArray(int patientNumber) {
        Patient[] patients = new Patient[patientNumber];
        for (int i = 0; i < patientNumber; i++) {
            patients[i] = new Patient(i, generateLastName(), generateName(), generatePatronym(), generateAddress(),
                    "+375 29" + (int) ((Math.random() * (8999999)) + 1000000),
                    (long) ((Math.random() * (99999999999L))), generateDiagnosis());
        }
        return patients;
    }

    public static void printPatientArray(Patient[] patients) {
        for (int i = 0; i < patients.length; i++) {
            System.out.println(patients[i].toString());
        }
    }

    public static Patient[] patientsDiagnosisList(Patient[] patients, String diagnosis) {
        int validCustomersLength = 0;
        for (int i = 0; i < patients.length; i++) {
            if (patients[i].getDiagnosis() == diagnosis) {
                validCustomersLength++;
            }
        }
        Patient[] validPatients = new Patient[validCustomersLength];
        for (int i = 0, j = 0; i < patients.length; i++) {
            if (patients[i].getDiagnosis() == diagnosis) {
                validPatients[j] = patients[i];
                j++;
            }
        }
        return validPatients;
    }

    public static Patient[] medicalCardNumberRangeList(Patient[] patients, long num1, long num2) {
        int validPatientsLength = 0;
        if (num1 > num2) {
            for (int i = 0; i < patients.length; i++) {
                if (patients[i].getMedicalCardNumber() >= num2 && patients[i].getMedicalCardNumber() <= num1) {
                    validPatientsLength++;
                }
            }
        } else {
            for (int i = 0; i < patients.length; i++) {
                if (patients[i].getMedicalCardNumber() <= num2 && patients[i].getMedicalCardNumber() >= num1) {
                    validPatientsLength++;
                }
            }
        }
        Patient[] validPatients = new Patient[validPatientsLength];
        if (num1 > num2) {
            for (int i = 0, j = 0; i < patients.length; i++) {
                if (patients[i].getMedicalCardNumber() >= num2 && patients[i].getMedicalCardNumber() <= num1) {
                    validPatients[j] = patients[i];
                    j++;
                }
            }
        } else {
            for (int i = 0, j = 0; i < patients.length; i++) {
                if (patients[i].getMedicalCardNumber() <= num2 && patients[i].getMedicalCardNumber() >= num1) {
                    validPatients[j] = patients[i];
                    j++;
                }
            }
        }
        return validPatients;
    }

    public static String generateBookName() {
        String[] bookNames = {"Java for beginners", "Algorythms", "Applied Mathematics", "Learn C++ today", "Basic logic",
                "Computer Science", "Advanced Algebra", "Databases"};
        String bookName = bookNames[(int) ((Math.random() * (bookNames.length)))] + " part " + (int) ((Math.random() * 10) + 1);
        return bookName;
    }

    public static Human[] generateAuthorArray(int maxAuthorNumber) {
        int authorNumber = (int) (Math.random() * (maxAuthorNumber)) + 1;
        Human[] authors = new Human[authorNumber];
        for (int i = 0; i < authorNumber; i++) {
            authors[i] = new Human((int) (Math.random() * 9999), generateLastName(), generateName(), generatePatronym());
        }
        return authors;
    }

    public static String generatePublisher() {
        String[] publisherNames = {"STEM Publishing", "IT press", "Mathlete & partners", "Programmer's Library", "Techbook"};
        String publisherName = publisherNames[(int) ((Math.random() * (publisherNames.length)))];
        return publisherName;
    }

    public static String generateContent() {
        String[] contentArray = {"Textbook", "Encyclopedia", "Pop science", "Research"};
        String content = contentArray[(int) ((Math.random() * (contentArray.length)))];
        return content;
    }

    public static String generateBookbinding() {
        String[] bindingArray = {"Hardcover", "Comb binding", "Paperback", "Stitched"};
        String binding = bindingArray[(int) ((Math.random() * (bindingArray.length)))];
        return binding;
    }

    public static Book[] generateBookArray(int bookNumber) {
        Book[] books = new Book[bookNumber];
        for (int i = 0; i < bookNumber; i++) {
            books[i] = new Book(i, (int) ((Math.random() * 100) + 25), generateBookName(), generateAuthorArray(3),
                    generatePublisher(), (short) ((Math.random() * 25) + 1996), (int) ((Math.random() * 1000) + 25),
                    generateContent(), generateBookbinding());
        }
        return books;
    }

    public static void printBookArray(Book[] books) {
        for (int i = 0; i < books.length; i++) {
            System.out.println(books[i].toString());
        }
    }

    public static void printBooksByAuthor(Book[] books, String authorName, String authorLastName, String authorPatronym) {
        System.out.println("Books by " + authorName + " " + authorPatronym + " " + authorLastName + " :");
        int BooksByAuthorCounter = 0;
        for (int i = 0; i < books.length; i++) {
            for (int j = 0; j < books[i].getAuthors().length; j++) {
                if ((Objects.equals(authorName, books[i].getAuthors()[j].getName())) &&
                        (Objects.equals(authorLastName, books[i].getAuthors()[j].getLastName())) &&
                        (Objects.equals(authorPatronym, books[i].getAuthors()[j].getPatronym()))) {
                    BooksByAuthorCounter++;
                }
            }
        }
        Book[] booksByAuthor = new Book[BooksByAuthorCounter];
        for (int i = 0, n = 0; i < books.length; i++) {
            for (int j = 0; j < books[i].getAuthors().length; j++) {
                if ((Objects.equals(authorName, books[i].getAuthors()[j].getName())) &&
                        (Objects.equals(authorLastName, books[i].getAuthors()[j].getLastName())) &&
                        (Objects.equals(authorPatronym, books[i].getAuthors()[j].getPatronym()))) {
                    booksByAuthor[n] = books[i];
                    n++;
                }
            }
        }
        printBookArray(booksByAuthor);
    }

    public static void printBooksByPublisher(Book[] books, String publisher) {
        System.out.println("Books by " + publisher + " :");
        int booksByPublisherCounter = 0;
        for (int i = 0; i < books.length; i++) {
            if (Objects.equals(books[i].getPublisher(), publisher)) {
                booksByPublisherCounter++;
            }
        }
        Book[] booksByPublisher = new Book[booksByPublisherCounter];
        for (int i = 0, j = 0; i < books.length; i++) {
            if (Objects.equals(books[i].getPublisher(), publisher)) {
                booksByPublisher[j] = books[i];
                j++;
            }
        }
        printBookArray(booksByPublisher);
    }

    public static void printBooksByYearOfCreation(Book[] books, short designatedYearOfCreation) {
        System.out.println("Books published after year " + designatedYearOfCreation + ":");
        for (int i = 0; i < books.length; i++) {
            if (books[i].getYearOfCreation() > designatedYearOfCreation) {
                System.out.println(books[i].toString());
            }
        }
    }

    public static String generateBuildingType() {
        String[] buildingTypeArray = {"Panel building", "Brick building", "Cast-in-place concrete building", "Townhouse",
                "Prefabricated blocks"};
        String binding = buildingTypeArray[(int) ((Math.random() * (buildingTypeArray.length)))];
        return binding;
    }

    public static House[] generateHouseArray(int houseNumber) {
        House[] houses = new House[houseNumber];
        for (int i = 0; i < houseNumber; i++) {
            houses[i] = new House(i, (int) ((Math.random() * 10) * 20000), (short) (Math.random() * 200),
                    (short) ((Math.random() * 10) * 15), (short) ((Math.random() * 10) + 1),
                    (short) ((Math.random() * 4) + 1), generateAddress(), generateBuildingType(), (short) ((Math.random() * 55) + 1956));
        }
        return houses;
    }

    public static void printHouseArray(House[] houses) {
        for (int i = 0; i < houses.length; i++) {
            System.out.println(houses[i].toString());
        }
    }

    public static void printHouseByNumberOfRooms(House[] houses, short designatedNumberOfRooms) {
        System.out.println("Houses with " + designatedNumberOfRooms + " rooms:");
        for (int i = 0; i < houses.length; i++) {
            if (houses[i].getNumberOfRooms() == designatedNumberOfRooms) {
                System.out.println(houses[i].toString());
            }
        }
    }

    public static void printHouseByNumberOfRoomsAndFloors(House[] houses, short designatedNumberOfRooms,
                                                          short floorNumber1, short floorNumber2) {
        System.out.println("Houses between " + floorNumber1 + " floor and " + floorNumber2 + " floor  with " + designatedNumberOfRooms + " rooms:");
        int validHousesLength = 0;
        if (floorNumber1 > floorNumber2) {
            for (int i = 0; i < houses.length; i++) {
                if (houses[i].getFloor() >= floorNumber2 && houses[i].getFloor() <= floorNumber1 && houses[i].getNumberOfRooms() == designatedNumberOfRooms) {
                    validHousesLength++;
                }
            }
        } else {
            for (int i = 0; i < houses.length; i++) {
                if (houses[i].getFloor() <= floorNumber2 && houses[i].getFloor() >= floorNumber1 && houses[i].getNumberOfRooms() == designatedNumberOfRooms) {
                    validHousesLength++;
                }
            }
        }
        House[] validHouses = new House[validHousesLength];
        if (floorNumber1 > floorNumber2) {
            for (int i = 0, j = 0; i < houses.length; i++) {
                if (houses[i].getFloor() >= floorNumber2 && houses[i].getFloor() <= floorNumber1 && houses[i].getNumberOfRooms() == designatedNumberOfRooms) {
                    validHouses[j] = houses[i];
                    j++;
                }
            }
        } else {
            for (int i = 0, j = 0; i < houses.length; i++) {
                if (houses[i].getFloor() <= floorNumber2 && houses[i].getFloor() >= floorNumber1 && houses[i].getNumberOfRooms() == designatedNumberOfRooms) {
                    validHouses[j] = houses[i];
                    j++;
                }
            }
        }
        printHouseArray(validHouses);
    }

    public static void printHousesByArea(House[] houses, short designatedArea) {
        System.out.println("Houses with area greater than " + designatedArea + ":");
        for (int i = 0; i < houses.length; i++) {
            if (houses[i].getArea() > designatedArea) {
                System.out.println(houses[i].toString());
            }
        }
    }

    public static void main(String[] args) {
/*
     *Создать массив объектов. Вывести:
    a) список студентов заданного факультета
    b) список студентов для каждого факультета и курса
    c) список студентов родившихся после заданного года
    d) список учебной группы
*/
        System.out.println("Beginning task one");
        Student[] students = generateStudentArray(10);
        printStudentArray(students);
        students[(int) ((Math.random() * (students.length)))].passingExams();
        students[(int) ((Math.random() * (students.length)))].study();
        students[(int) ((Math.random() * (students.length)))].skipClasses();
        students[(int) ((Math.random() * (students.length)))].selectiveOutput();
        printStudentsByFaculty(students);
        printStudentsByYearOfStudy(students);
        printStudentsByYearOfBirth(students, (short) 2000);
        printStudentsByStudyGroup(students, 1);
        System.out.println("Finishing task one");
/*
        *Создать массив объектов. Вывести:
        a) список покупателей в алфавитном порядке по фамилии;
        b) список покупателей в алфавитном порядке по имени;
        c) список покупателей, у которых номер кредитной карточки находится в заданном интервале.
*/
        System.out.println("Beginning task two");
        Customer[] customers = generateCustomerArray(10);
        printCustomerArray(customers);
        customers[(int) ((Math.random() * (customers.length)))].fellIll();
        customers[(int) ((Math.random() * (customers.length)))].goesToWork();
        customers[(int) ((Math.random() * (customers.length)))].goesToParty();
        customers[(int) ((Math.random() * (customers.length)))].selectiveOutput();
        printCustomerArray(arrangeCustomersByLastName(customers));
        System.out.println();
        printCustomerArray(arrangeCustomersByName(customers));
        System.out.println();
        printCustomerArray(creditCardNumberRangeList(customers, 1111111111111111L, 5555555555555555L));
        System.out.println("Finishing task two");
/*
        Создать массив объектов. Вывести:
        a) список пациентов, имеющих данный диагноз;
        b) список пациентов, номер медицинской карты у которых находится в заданном интервале
*/
        System.out.println("Beginning task three");
        Patient[] patients = generatePatientArray(10);
        patients[(int) ((Math.random() * (patients.length)))].fellIll();
        patients[(int) ((Math.random() * (patients.length)))].escape();
        patients[(int) ((Math.random() * (patients.length)))].recovery();
        patients[(int) ((Math.random() * (patients.length)))].recovery();
        patients[(int) ((Math.random() * (patients.length)))].recovery();
        patients[(int) ((Math.random() * (patients.length)))].selectiveOutput();
        printPatientArray(patients);
        System.out.println();
        // вывдем в консоль пациентов, случайным образом вылеченных методом recovery()
        printPatientArray(patientsDiagnosisList(patients, ""));
        System.out.println();
        printPatientArray(medicalCardNumberRangeList(patients, 51111111111L, 99999999999L));
        System.out.println("Finishing task three");
        /*
        Создать 10 объектов. Создать массив объектов.
        Вывести:
        a) список книг заданного автора;
        b) список книг, выпущенных заданным издательством;
        c) список книг, выпущенных после заданного года.
        */
        System.out.println("Beginning task four");
        Book[] books = generateBookArray(10);
        printBookArray(books);
        books[(int) ((Math.random() * (books.length)))].setContentFromConsole();
        books[(int) ((Math.random() * (books.length)))].setAuthorsFromConsole();
        books[(int) ((Math.random() * (books.length)))].addNewAuthorFromConsole();
        books[(int) ((Math.random() * (books.length)))].selectiveOutput();
        printBookArray(books);
        printBooksByAuthor(books, "Ivan", "Ivanov", "Ivanovich");
        printBooksByPublisher(books, "Programmer's Library");
        printBooksByYearOfCreation(books, (short) 2000);
        System.out.println("Finishing task four");
        /*
        Создать массив объектов. Вывести:
         a) список квартир, имеющих заданное число комнат;
         b) список квартир, имеющих заданное число комнат и расположенных на этаже, который находится в заданном промежутке;
         c) список квартир, имеющих площадь, превосходящую заданную.
        */
        System.out.println("Beginning task five");
        House[] houses = generateHouseArray(10);
        printHouseArray(houses);
        houses[(int) ((Math.random() * (houses.length)))].turnOn220();
        houses[(int) ((Math.random() * (houses.length)))].turnOff220();
        houses[(int) ((Math.random() * (houses.length)))].turnOffWater();
        houses[(int) ((Math.random() * (houses.length)))].ventilate();
        houses[(int) ((Math.random() * (houses.length)))].selectiveOutput();
        printHouseByNumberOfRooms(houses,(short) 2);
        printHouseByNumberOfRoomsAndFloors(houses,(short) 2, (short) 2, (short) 5);
        printHousesByArea(houses,(short) 35);
        System.out.println("Finishing task five");
    }
}
