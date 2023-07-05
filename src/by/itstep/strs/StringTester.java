package by.itstep.strs;

import java.util.Collection;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StringTester {
    public static void main(String[] args) {
        //String creation
        String str1 = "ABC";
        String str2 = new String("ABC");
        String str3 = new String();
        char[] chars = {'h', 'e', 'l', 'l', 'o'};
        String str4 = new String(chars);
        System.out.println(str4);
        String str5 = new String(chars, 1, 3);
        String str6 = new String("This is String!");
        System.out.println(str6.indexOf((int) 'i', 19));
        str6.toCharArray();
        str6.length();
        System.out.println(str6.toLowerCase());
        System.out.println(str6.toUpperCase());
        System.out.println(str6.equals(str6.toLowerCase()));
        System.out.println(str6.concat(str4));
        String str10 = " Ja" + '\n' + "va 19 ";
        str10 = str10.trim();
        System.out.println(str10);

        String text = "Search the world's information, including webpages," +
                " images, videos and more. Google has many special features" +
                " to help you find exactly what you're looking for.";
        System.out.println(text.contains("what"));
        boolean isContains3 = text.contains("Images");
        System.out.println(isContains3);
        text.charAt(12);
        text.codePointAt(12);
        System.out.println(text.compareTo("test"));
        String test = "test ";
        String test1 = "test1 ";
        System.out.println(test.compareToIgnoreCase(test1));
        System.out.println(test.concat("jvjv"));
        text.endsWith(" ");
        text.startsWith(" ");
        text.replace("564","khg");
        text.isBlank();
        text.isEmpty();

        for (int i = 0; i < text.length(); i = i+3) {
            System.out.print(text.charAt(i) + "  ");
        }
    }
}