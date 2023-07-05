package Homework;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
class Employee {
    private String name;
    private double salary;
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public double getSalary() {
        return salary;
    }
    public void setSalary(double salary) {
        this.salary = salary;
    }
    public Employee(String name, double salary) {
        this.name = name;
        this.salary = salary;
    }
}
public class Strings {
    public static void taskOne(String string) {
/*
1. Напишите метод, который принимает в качестве параметра любую строку,
например “I like Java!!!”.
2. Распечатать последний символ строки. Используем метод String.charAt().
3. Проверить, заканчивается ли ваша строка подстрокой “!!!”. Используем
метод String.endsWith().
4. Проверить, начинается ли ваша строка подстрокой “I like”. Используем
метод String.startsWith().
5. Проверить, содержит ли ваша строка подстроку “Java”. Используем метод
String.contains().
6. Найти позицию подстроки “Java” в строке “I like Java!!!”.
7. Заменить все символы “а” на “о”.
8. Преобразуйте строку к верхнему регистру.
9. Преобразуйте строку к нижнему регистру.
10. Вырезать строку Java c помощью метода String.substring().
*/
        System.out.println("Beginning Task One");
        System.out.print("Last char of the string is : ");
        System.out.println(string.charAt(string.length() - 1));
        System.out.print("String ends with substring “!!!” : ");
        System.out.println(string.endsWith("!!!"));
        System.out.print("String begins with substring “I like” : ");
        System.out.println(string.startsWith("I like"));
        System.out.print("String contains substring “Java” : ");
        System.out.println(string.contains("Java"));
        System.out.print("Substring “Java“ index in string “I like Java” : ");
        System.out.println(string.indexOf("Java"));
        System.out.print("All 'a' chars in string replaced by 'o' : ");
        System.out.println(string.replace('a', 'o'));
        System.out.print("String converted to upper case : ");
        System.out.println(string.toUpperCase());
        System.out.print("String converted to lower case : ");
        System.out.println(string.toLowerCase());
        System.out.print("Substring “Java“ : ");
        System.out.println(string.substring(7, 11));
        System.out.println("Finishing Task One");
    }
    public static void taskTwo(int num1, int num2) {
/*

1. Дано два числа, например 3 и 56, необходимо составить следующие строки:
3 + 56 = 59
3 – 56 = -53
3 * 56 = 168.
Используем метод StringBuilder.append().
2. Замените символ “=” на слово “равно”. Используйте методы StringBuilder.insert(),
StringBuilder.deleteCharAt().
3. Замените символ “=” на слово “равно”. Используйте методы
StringBuilder.replace().
*/
        System.out.println("Beginning Task Two");
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(num1).append(" + ").append(num2).append(" = ").append(num1 + num2).append("\n")
                .append(num1).append(" - ").append(num2).append(" = ").append(num1 - num2).append("\n")
                .append(num1).append(" * ").append(num2).append(" = ").append(num1 * num2);
        System.out.println(stringBuilder);
        int equalsCounter = 0;
        for (int i = 0; i < stringBuilder.length(); i++) {
            if (stringBuilder.charAt(i) == '=') {
                equalsCounter++;
            }
        }
        int[] equalsIndexes = new int[equalsCounter];
        equalsCounter = 0;
        for (int i = 0; i < stringBuilder.length(); i++) {
            if (stringBuilder.charAt(i) == '=') {
                equalsIndexes[equalsCounter] = i;
                equalsCounter++;
            }
        }
        for (int i = 0; i < equalsIndexes.length; i++) {
            stringBuilder.deleteCharAt(equalsIndexes[i] - i);
        }
        for (int i = 0; i < equalsIndexes.length; i++) {
            stringBuilder.insert(equalsIndexes[i] + i * 4, "равно");
        }
        System.out.println(stringBuilder);
//т.к. замена "=" на "равно" уже произведена, произведем вместо этого обратную замену
        for (int i = 0; i < equalsIndexes.length; i++) {
            stringBuilder.replace(equalsIndexes[i], equalsIndexes[i] + 5, "=");
        }
        System.out.println(stringBuilder);
        System.out.println("Finishing Task Two");
    }
    public static void taskThree(String string) {
/*
Напишите метод, заменяющий в строке каждое второе вхождение «object-oriented
programming» (не учитываем регистр символов) на «OOP». Например, строка
"Object-oriented programming is a programming language model organized
around objects rather than "actions" and data rather than logic. Object-oriented
programming blabla. Object-oriented programming bla."
должна быть преобразована в
"Object-oriented programming is a programming language model organized
around objects rather than "actions" and data rather than logic. OOP blabla. Object-oriented
programming bla."
*/
        System.out.println("Beginning Task Three");
        String stringToLowerCase = string.toLowerCase();
        int oopCounter = 0;
        int indexCounter = 0;
        boolean countComplete = false;
        while (!countComplete) {
            indexCounter = stringToLowerCase.indexOf("object-oriented programming", indexCounter) +
                    "object-oriented programming".length() - 1;
            if (!(stringToLowerCase.indexOf("object-oriented programming", indexCounter) == -1)) {
                oopCounter++;
            } else {
                countComplete = true;
                if (oopCounter > 0) {
                    oopCounter++;
                }
            }
        }

        for (int i = 1; i <= oopCounter; i++) {
            if (i % 2 == 0) {
                string = string.replaceFirst("(?i)(object-oriented programming)(?-i)", "OOP");
            } else {
                string = string.replaceFirst("(?i)(object-oriented programming)(?-i)", "Objectt-oriented programming");
            }
        }
        string = string.replaceAll("Objectt-oriented programming", "Object-oriented programming");
        System.out.println(string);
        System.out.println("Finishing Task Three");
    }
    public static void taskFour(String string) {
/*
Даны строки разной длины (длина - четное число), необходимо вернуть ее два
средних знака. Например, если дана строка "string" результат будет "ri", для строки
"code" результат "od", для "Practice" результат "ct".
*/
        System.out.println("Beginning Task Four");
        if (string.length() % 2 == 0) {
            char[] chars = new char[2];
            chars[0] = string.charAt(string.length() / 2);
            chars[1] = string.charAt(string.length() / 2 + 1);
            String result = new String(chars);
            System.out.println(result);
        } else {
            char[] chars = new char[1];
            chars[0] = string.charAt(string.length() / 2);
            String result = new String(chars);
            System.out.println(result);
        }
        System.out.println("Finishing Task Four");
    }
    public static void taskFive(String lastName, String mark, String subject) {
/*
Создать строку, используя форматирование: Студент [Фамилия] получил [оценка] по
[предмету]. Форматирование и вывод строки на консоль написать в отдельном
методе, который принимает фамилию, оценку и название предмета в качестве
параметров. Выделить под фамилию 15 символов, под оценку 3 символа, под
предмет – 10.
Пример вывода:
Студент Иванов получил 5 по Математике
Студент Петрова получил 4 по Физике
Студент Сидорова получил 3 по Программированию
*/
        System.out.printf("%s %-15s %s %-3s %s %-10s %n", "Студент ", lastName, " получил ", mark, " по ",
                subject);
    }
    public static void generateReport() {
/*
1. Создать класс Employee, у которого есть переменные класса - fullname, salary.
2. Создать массив содержащий несколько объектов этого типа.
3. Создать класс Report со статическим методом generateReport, в котором
выводится информация о зарплате всех сотрудников.
4. Используйте форматирование строк. Пусть salary будет выровнено по правому
краю, десятичное значение имеет 2 знака после запятой и можете добавить что-
нибудь свое.
*/
        System.out.println("Beginning Task Six");
        Employee[] employees = {new Employee("Ivan", 10.7894),
                new Employee("Peter", 150.1564),
                new Employee("Igor", 2000.564)};
        for (Employee employee : employees) {
            System.out.printf("%s %-15s %s %10.2f %n", "Name : ", employee.getName(), "Salary : ",
                    employee.getSalary());
        }
        System.out.println("Finishing Task Six");
    }
    public static void taskSeven(String string) {
/*

Изменить регулярное выражение в примере для нахождения
строк cab , ccab , cccab .
*/
        System.out.println("Beginning Task Seven");
        System.out.println(Pattern.matches("c{1,}+ab", string));
        System.out.println(Pattern.matches("c{2,}+ab", string));
        System.out.println(Pattern.matches("c{3,}+ab", string));
        System.out.println("Finishing Task Seven");
    }
    public static void taskEight() {
/*
Изменить регулярное выражение в примере – пусть reference1.org тоже
считается ссылкой.
*/
        System.out.println("Beginning Task Eight");
        System.out.println(Pattern.matches(".+\\.(com|ua|ru|org)", "google.com"));
        System.out.println(Pattern.matches(".+\\.(com|ua|ru|org)", "reference1.ua"));
        System.out.println(Pattern.matches(".+\\.(com|ua|ru|org)", "reference1.org"));
        System.out.println("Finishing Task Eight");
    }
    public static void taskNine(String string) {
/*
Дана строка “Versions: Java 5, Java 6, Java 7, Java 8, Java 12.” Найти все подстроки
"Java X" и распечатать их.
*/
        System.out.println("Beginning Task Nine");
        Pattern pattern = Pattern.compile("Java\\s\\d+");
        Matcher matcher = pattern.matcher(string);
        while (matcher.find()) {
            System.out.println(matcher.group());
        }
        System.out.println("Finishing Task Nine");
    }
    public static void taskTen(String string) {
/*
Найти слово, в котором число различных символов минимально. Слово может
содержать буквы и цифры. Если таких слов несколько, найти первое из них.
Например, в строке "fffff ab f 1234 jkjk" найденное слово должно быть "fffff".
*/
        System.out.println("Beginning Task Ten");
        Pattern pattern = Pattern.compile("\\w+(\\s|$)");
        Matcher matcher = pattern.matcher(string);
        int counter = 0;
        while (matcher.find()) {
            counter++;
        }
        String[] words = new String[counter];
        int[] differentSymbols = new int[counter];
        matcher = pattern.matcher(string);
        while (matcher.find()) {
            words[words.length - counter] = matcher.group().trim();
            counter--;
        }
        for (int i = 0; i < words.length; i++) {
            char[] word = new char[words.length];
            word = words[i].toCharArray();
            for (int j = 0; j < word.length; j++) {
                for (int k = 0; k < word.length; k++) {
                    if ((word[j] == word[k]) && (!(j == k))) {
                        word[k] = ' ';
                    }
                }
            }
            for (int j = 0; j < word.length; j++) {
                if (word[j] == ' ') {
                    counter++;
                }
            }
            differentSymbols[i] = word.length - counter;
            counter = 0;

        }
        int minSymbols = Integer.MAX_VALUE;
        for (int i : differentSymbols) {
            if (i < minSymbols) {
                minSymbols = i;
            }
        }
        for (int i = 0; i < differentSymbols.length; i++) {
            if (differentSymbols[i] == minSymbols) {
                System.out.println(words[i]);
                break;
            }
        }
        System.out.println("Finishing Task Ten");
    }
    public static void taskEleven(String string) {
/*
Предложение состоит из нескольких слов, разделенных пробелами. Например: "One
two three раз два три one1 two2 123 four". Найти количество слов, содержащих только
символы латинского алфавита.
*/
        System.out.println("Beginning Task Eleven");
        Pattern pattern = Pattern.compile("[a-z,A-Z]+(\\s|$)");
        Matcher matcher = pattern.matcher(string);
        int counter = 0;
        while (matcher.find()) {
            System.out.println(matcher.group().trim());
            counter++;
        }
        System.out.println("Number of words containing only latin symbols is " + counter);
        System.out.println("Finishing Task Eleven");
    }
    public static void taskTwelve(String string) {
/*
Предложение состоит из нескольких слов, например: "Если есть хвосты по дз,
начните с 1 не сданного задания. 123 324 111 4554". Среди слов, состоящих только
из цифр, найти слово палиндром.
*/
        System.out.println("Beginning Task Twelve");
        Pattern pattern = Pattern.compile("[0-9]+(\\.?|,?)(\\s|$)");
        Matcher matcher = pattern.matcher(string);
        int counter = 0;
        while (matcher.find()) {
            counter++;
        }
        String[] words = new String[counter];
        boolean[] isPalindrome = new boolean[counter];
        matcher = pattern.matcher(string);
        while (matcher.find()) {
            words[words.length - counter] = matcher.group().trim();
            counter--;
        }
        for (int i = 0; i < words.length; i++) {
            for (int j = 0; j <= (words[i].length() - 1 - j); j++) {
                if (words[i].charAt(j) == words[i].charAt(words[i].length() - 1 - j)) {
                    isPalindrome[i] = true;
                } else {
                    isPalindrome[i] = false;
                    break;
                }
            }
        }
        System.out.print("Palindromes containing only digits are : ");
        for (int i = 0; i < words.length; i++) {
            if (isPalindrome[i]) {
                System.out.print(words[i] + " ");
            }
        }
        System.out.println();
        System.out.println("Finishing Task Twelve");
    }

    public static String[] InputStringsFromConsole() {
        Scanner sc = new Scanner(System.in);
        System.out.println("input number of strings : ");
        String[] strings = new String[sc.nextInt()];
        for (int i = 0; i < strings.length; i++) {
            System.out.println("input string # " + (i + 1) + " : ");
            strings[i] = sc.next();
        }
        return strings;
    }
    public static void taskThirteen() {
/*
Ввести n строк с консоли, найти самую короткую и самую длинную строки.
Вывести найденные строки и их длину.
*/
        System.out.println("Beginning Task Thirteen");
        String[] strings = InputStringsFromConsole();
        int maxLength = Integer.MIN_VALUE;
        int minLength = Integer.MAX_VALUE;
        for (String string : strings) {
            if (string.length() > maxLength) {
                maxLength = string.length();
            }
            if (string.length() < minLength) {
                minLength = string.length();
            }
        }
        for (String string : strings) {
            if (string.length() == maxLength) {
                System.out.println(string + " has maximal length.");
            }
            if (string.length() == minLength) {
                System.out.println(string + " has minimal length.");
            }
        }
        System.out.println("Finishing Task Thirteen");
    }
    public static void taskFourteen() {
/*
Ввести n строк с консоли. Упорядочить и вывести строки в порядке
возрастания (убывания) значений их длины. Вывести на консоль те строки, длина которых
меньше (больше) средней, а также длину.
*/
        System.out.println("Beginning Task Fourteen");
        String[] strings = InputStringsFromConsole();
        int[] stringsLength = new int[strings.length];
        for (int i = 0; i < strings.length; i++) {
            stringsLength[i] = strings[i].length();
        }
        int averageLength = 0;
        for (String string : strings) {
            averageLength += string.length();
        }
        averageLength /= strings.length;
        int counter = 0;
        String str1, str2;
        do {
            counter = 0;
            for (int i = 0; i < (strings.length - 1); i++) {
                if (strings[i].length() < strings[i + 1].length()) {
                    str1 = strings[i];
                    str2 = strings[i + 1];
                    strings[i] = str2;
                    strings[i + 1] = str1;
                    counter++;
                }
            }
        } while (!(counter == 0));
        System.out.println("Strings from longest to shortest : ");
        for (String string : strings) {
            System.out.println(string);
        }

        do {
            counter = 0;
            for (int i = 0; i < (strings.length - 1); i++) {
                if (strings[i].length() > strings[i + 1].length()) {
                    str1 = strings[i];
                    str2 = strings[i + 1];
                    strings[i] = str2;
                    strings[i + 1] = str1;
                    counter++;
                }
            }
        } while (!(counter == 0));
        System.out.println("Strings from shortest to longest: ");
        for (String string : strings) {
            System.out.println(string);
        }
        System.out.println("Strings with below average length: ");
        for (String string : strings) {
            if (string.length() <= averageLength) {
                System.out.println(string + " length : " + string.length());
            }
        }
        System.out.println("Strings with above average length: ");
        for (String string : strings) {
            if (string.length() > averageLength) {
                System.out.println(string + " length : " + string.length());
            }
        }
        System.out.println("Finishing Task Fourteen");
    }
    public static void taskFifteen() {
/*
Ввести n слов с консоли. Найти слово, в котором число различных символов
минимально. Если таких слов несколько, найти первое из них.
*/
        System.out.println("Beginning Task Fifteen");
        String[] strings = InputStringsFromConsole();
        String arrayToStringWithWhitespaces = null;
        for (String string : strings) {
            arrayToStringWithWhitespaces = arrayToStringWithWhitespaces + string + " ";
        }
// с минимальными отличиями используем код из 10 задачи
        Pattern pattern = Pattern.compile("\\w+(\\s|$)");
        Matcher matcher = pattern.matcher(arrayToStringWithWhitespaces);
        int counter = 0;
        while (matcher.find()) {
            counter++;
        }
        String[] words = new String[counter];
        int[] differentSymbols = new int[counter];
        matcher = pattern.matcher(arrayToStringWithWhitespaces);
        while (matcher.find()) {
            words[words.length - counter] = matcher.group().trim();
            counter--;
        }
        for (int i = 0; i < words.length; i++) {
            char[] word = new char[words.length];
            word = words[i].toCharArray();
            for (int j = 0; j < word.length; j++) {
                for (int k = 0; k < word.length; k++) {
                    if ((word[j] == word[k]) && (!(j == k))) {
                        word[k] = ' ';
                    }
                }
            }
            for (int j = 0; j < word.length; j++) {
                if (word[j] == ' ') {
                    counter++;
                }
            }
            differentSymbols[i] = word.length - counter;
            counter = 0;

        }
        int minSymbols = Integer.MAX_VALUE;
        for (int i : differentSymbols) {
            if (i < minSymbols) {
                minSymbols = i;
            }
        }
        for (int i = 0; i < differentSymbols.length; i++) {
            if (differentSymbols[i] == minSymbols) {
                System.out.println(words[i]);
                break;
            }
        }
        System.out.println("Finishing Task Fifteen");
    }
    public static void taskSixteen() {
/*
Ввести n слов с консоли. Найти количество слов, содержащих только
символы латинского алфавита, а среди них – количество слов с равным числом
гласных и согласных букв.
*/
        System.out.println("Beginning Task Sixteen");
        String[] strings = InputStringsFromConsole();
        String arrayToStringWithWhitespaces = "";
        for (String string : strings) {
            arrayToStringWithWhitespaces = arrayToStringWithWhitespaces + string + " ";
        }
        Pattern pattern = Pattern.compile("(\\G|\\s)[a-z,A-Z]+(\\s|$)");
        Matcher matcher = pattern.matcher(arrayToStringWithWhitespaces);
        int counter = 0;
        while (matcher.find()) {
            counter++;
        }
        System.out.println("Number of words with only latin characters is : " + counter);
        String[] words = new String[counter];
        matcher = pattern.matcher(arrayToStringWithWhitespaces);
        while (matcher.find()) {
            words[words.length - counter] = matcher.group().trim();
            counter--;
        }
        int vowelCounter = 0;
        int consonantCounter = 0;
        int equalCounter = 0;
        for (int i = 0; i < words.length; i++) {
            vowelCounter = 0;
            consonantCounter = 0;
            for (int j = 0; j < words[i].length(); j++) {
                if ((words[i].charAt(j) == 'a') || (words[i].charAt(j) == 'A') || (words[i].charAt(j) == 'e')
                        ||
                        (words[i].charAt(j) == 'E') || (words[i].charAt(j) == 'i') || (words[i].charAt(j) ==
                        'I') ||
                        (words[i].charAt(j) == 'o') || (words[i].charAt(j) == 'O') || (words[i].charAt(j) ==
                        'u') ||
                        (words[i].charAt(j) == 'U') || (words[i].charAt(j) == 'y') || (words[i].charAt(j) ==
                        'Y')) {
                    vowelCounter++;
                } else consonantCounter++;
            }
            if (vowelCounter == consonantCounter) {
                equalCounter++;
            }
        }
        System.out.println("Out of them, number of words with equal vowel and consonant characters count is : "
                + equalCounter);
        System.out.println("Finishing Task Sixteen");
    }
    public static void taskSeventeen() {
/*
Ввести n слов с консоли. Найти слово, символы в котором идут в строгом
порядке возрастания их кодов. Если таких слов несколько, найти первое из них.
*/
        System.out.println("Beginning Task Seventeen");

        String[] strings = InputStringsFromConsole();
        String[] stringsWithIncreasingCodes = new String[strings.length];
        int counter = 0;
        int counter2 = 0;
        for (String string : strings) {
            counter = 0;
            for (int i = 0; i < (string.length() - 1); i++) {
                if ((int) string.charAt(i) > (int) string.charAt(i + 1)) {
                    counter++;
                }
            }
            if (counter == 0) {
                stringsWithIncreasingCodes[counter2] = string;
                counter2++;
            }
        }
        System.out.println(stringsWithIncreasingCodes[0]);
        System.out.println("Finishing Task Seventeen");
    }
    public static void taskEighteen() {
/*
18. Ввести n слов с консоли. Найти слово, состоящее только из различных
символов. Если таких слов несколько, найти первое из них.
*/
        System.out.println("Beginning Task Eighteen");
        String[] strings = InputStringsFromConsole();
        String[] stringsWithDifferentCharacters = new String[strings.length];
        int counter = 0;
        int counter2 = 0;
        for (String string : strings) {
            counter = 0;
            for (int i = 0; i < (string.length()); i++) {
                for (int j = 0; j < string.length(); j++) {
                    if (string.charAt(i) == string.charAt(j)) {
                        counter++;
                    }
                }
            }
            if (counter == string.length()) {
                stringsWithDifferentCharacters[counter2] = string;
                counter2++;
            }
        }
        System.out.println(stringsWithDifferentCharacters[0]);
        System.out.println("Finishing Task Eighteen");
    }
    public static void taskNineteen() {
/*
Ввести n слов с консоли. Среди слов, состоящих только из цифр, найти
слово-палиндром. Если таких слов больше одного, найти второе из них.
*/
        System.out.println("Beginning Task Nineteen");
        String[] strings = InputStringsFromConsole();
        String string = null;
        for (String string1 : strings) {
            string = string + string1 + " ";
        }
// с минимальными отличиями используем код из 12 задачи
        Pattern pattern = Pattern.compile("(\\G|\\s)[0-9]+(\\s|$)");
        Matcher matcher = pattern.matcher(string);
        int counter = 0;
        while (matcher.find()) {
            counter++;
        }
        String[] words = new String[counter];
        boolean[] isPalindrome = new boolean[counter];
        matcher = pattern.matcher(string);
        while (matcher.find()) {
            words[words.length - counter] = matcher.group().trim();
            counter--;
        }
        for (int i = 0; i < words.length; i++) {

            for (int j = 0; j <= (words[i].length() - 1 - j); j++) {
                if (words[i].charAt(j) == words[i].charAt(words[i].length() - 1 - j)) {
                    isPalindrome[i] = true;
                } else {
                    isPalindrome[i] = false;
                    break;
                }
            }
            if (isPalindrome[i]) {
                counter++;
            }
        }
        if (counter == 0) {
            System.out.println("No palindromes containing only digits");
        } else if (counter == 1) {
            System.out.print("Palindrome containing only digits : ");
            for (int i = 0; i < words.length; i++) {
                if (isPalindrome[i]) {
                    System.out.print(words[i] + " ");
                }
            }
            System.out.println();
        } else {
            counter = 0;
            System.out.print("Palindrome #2 containing only digits : ");
            for (int i = 0; i < words.length; i++) {
                if (isPalindrome[i]) {
                    counter++;
                    if (counter == 2) {
                        System.out.print(words[i] + " ");
                    }
                }
            }
            System.out.println();
        }
        System.out.println("Finishing Task Nineteen");
    }
    public static void taskTwenty() {
/*
Написать программы решения задач 1–8, осуществляя ввод строк как
аргументов командной строки.
*/
        System.out.println("Beginning Task Twenty");
        Scanner sc = new Scanner(System.in);
        Homework.Strings.taskOne(sc.nextLine());
// во 2 задаче строки не вводятся
        Homework.Strings.taskThree(sc.nextLine());
        Homework.Strings.taskFour(sc.nextLine());
        Homework.Strings.taskFive(sc.nextLine(), sc.nextLine(), sc.nextLine());
// в 6 задаче строки не вводятся
        Homework.Strings.taskSeven(sc.nextLine());
// в 8 задаче строки не вводятся
        System.out.println("Finishing Task Twenty");
    }
    public static void taskTwentyOne(int k) {
/*
Используя оператор switch, написать программу, которая выводит на экран
сообщения о принадлежности некоторого значения k интервалам (-10k, 0], (0,
5], (5, 10], (10, 10k], (-10k, 5], [0, 10], [5, 15], [10, 10k].
*/
        System.out.println("Beginning Task Twenty One");
        int[] arr1 = {-10000, 0, 5, 10, 10000};
        int[] arr2 = {-9999, 0, 5, 10, 15, 10000};
        int[] belongs1 = new int[arr1.length - 1];
        int[] belongs2 = new int[arr2.length];
        for (int i = 0; i < arr1.length - 1; i++) {
            if ((k > arr1[i]) && (k <= arr1[i + 1])) {
                belongs1[i] = 1;
            }
            switch (belongs1[i]) {
                case 1:
                    System.out.println(k + " belongs to (" + arr1[i] + ", " + arr1[i + 1] + "]");

                    break;
                default:
                    System.out.println(k + " doesn't belong to (" + arr1[i] + ", " + arr1[i + 1] + "]");
                    break;
            }
        }
        for (int i = 0; i < arr2.length - 2; i++) {
            if ((k >= arr2[i]) && (k <= arr2[i + 2])) {
                belongs2[i] = 1;
            }
            switch (belongs2[i]) {
                case 1:
                    System.out.println(k + " belongs to [" + arr2[i] + ", " + arr2[i + 2] + "]");
                    break;
                default:
                    System.out.println(k + " doesn't belong to [" + arr2[i] + ", " + arr2[i + 2] + "]");
                    break;
            }
        }
        System.out.println("Finishing Task Twenty One");
    }
    public static void taskTwentyTwo() {
/*
Написать программу, которая выводит числа от 1 до 25 в виде матрицы 5x5
слева направо и сверху вниз.
*/
        System.out.println("Beginning Task Twenty Two");
        int counter = 1;
        for (int i = 1; i < 6; i++) {
            for (int j = 1; j < 6; j++) {
                System.out.print(counter + " ");
                counter++;
            }
            System.out.println();
        }
        System.out.println("Finishing Task Twenty Two");
    }
    public static void taskTwentyThree() {
/*
Написать программу, позволяющую корректно находить корни квадратного
уравнения. Параметры уравнения должны задаваться с командной строки.
*/
        System.out.println("Beginning Task Twenty Three");
        Scanner sc = new Scanner(System.in);
        double a, b, c, d;
        System.out.println("ax2 + bx + c = 0");
        System.out.println("Input a (a≠0)");
        a = sc.nextDouble();
        System.out.println("Input b");
        b = sc.nextDouble();
        System.out.println("Input c");
        c = sc.nextDouble();
        d = Math.pow(b, 2) - 4 * a * c;
        if (d < 0) {
            System.out.println("no real number roots");
        } else if (d == 0) {
            System.out.println("root is " + (-1 * b / (2 * a)));
        } else {
            System.out.println("root 1 is" + ((-1 * (b + Math.sqrt(d))) / (2 * a)));
            System.out.println("root 2 is" + ((-1 * (b - Math.sqrt(d))) / (2 * a)));
        }
        System.out.println("Finishing Task Twenty Three");
    }
    public static void taskTwentyFour() {
/*
Ввести число от 1 до 12. Вывести на консоль название месяца, соответ-
ствующего данному числу. (Осуществить проверку корректности ввода чисел).
*/
        System.out.println("Beginning Task Twenty Four");
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();

        switch (a) {
            case 1:
                System.out.println("January");
                break;
            case 2:
                System.out.println("February");
                break;
            case 3:
                System.out.println("March");
                break;
            case 4:
                System.out.println("April");
                break;
            case 5:
                System.out.println("May");
                break;
            case 6:
                System.out.println("June");
                break;
            case 7:
                System.out.println("July");
                break;
            case 8:
                System.out.println("August");
                break;
            case 9:
                System.out.println("September");
                break;
            case 10:
                System.out.println("October");
                break;
            case 11:
                System.out.println("November");
                break;
            case 12:
                System.out.println("December");
                break;
            default:
                System.out.println("No such month");
                break;
        }
        System.out.println("Finishing Task Twenty Four");
    }
    public static void main(String[] args) {
        Homework.Strings.taskOne("I like Java!!!");
        Homework.Strings.taskTwo(3, 56);
        Homework.Strings.taskThree("Object-oriented programming is a programming language model " +
                "organized around objects rather than \"actions\" and data rather than logic. " +
                "Object-oriented programming blabla. Object-oriented programming bla.");
        Homework.Strings.taskFour("Java");
        System.out.println("Beginning Task Five");
        Homework.Strings.taskFive("Иванов", "5", "Математике");
        Homework.Strings.taskFive("Петрова", "4", "Физике");
        Homework.Strings.taskFive("Сидорова", "3", "Программированию");
        System.out.println("Finishing Task Five");
        Homework.Strings.generateReport();
        Homework.Strings.taskSeven("cccccab");
        Homework.Strings.taskEight();
        Homework.Strings.taskNine("Versions: Java 5, Java 6, Java 7, Java 8, Java 12.");
        Homework.Strings.taskTen("fffff ab f 1234 jkjk");
        Homework.Strings.taskEleven("One two three раз два три one1 two2 123 four");
        Homework.Strings.taskTwelve("Если есть хвосты по дз, начните с 1 не сданного задания. 123 324 111 4554");
                Homework.Strings.taskThirteen();
        Homework.Strings.taskFourteen();
        Homework.Strings.taskFifteen();
        Homework.Strings.taskSixteen();
        Homework.Strings.taskSeventeen();
        Homework.Strings.taskEighteen();
        Homework.Strings.taskNineteen();
        Homework.Strings.taskTwenty();
        Homework.Strings.taskTwentyOne(15);
        Homework.Strings.taskTwentyTwo();
        Homework.Strings.taskTwentyThree();
        Homework.Strings.taskTwentyFour();
    }
}