package by.itstep.strs;

import java.util.Locale;
import java.util.Scanner;

public class Task {
    public static String substring(String source, String search, int count) {
        if (source == null || search == null || count <= 0) {
            return null;
        }
        String substring1 = source.toLowerCase();
        String search1 = search.toLowerCase();
        int indexCounter = 0;
        while (count > 0 && substring1.contains(search1)) {
            indexCounter += substring1.indexOf(search1) + search1.length();
            substring1 = substring1.substring(substring1.indexOf(search1) + search1.length());
            count--;
        }
        substring1 = source.substring(indexCounter-search.length());
        return substring1;
    }

    public static void main(String[] args) {
        String javaInfo = "Java is a programming language originally developed by Sun Microsystems and released in 1995 " +
                "as a core component of Sun's Java platform. The language derives much of its Syntax from C and C++ but " +
                "has a simpler object model and fewer low-level facilities. Java applications are typically compiled to " +
                "bytecode which can run on any Java virtual machine (JVM) regardless of computer architecture.\n" +
                "\n" +
                "The original and reference implementation Java compilers, virtual machines, and class libraries were " +
                "developed by Sun from 1995. As of May 2007, in compliance with the specifications of the Java Community " +
                "Process, Sun made available most of their Java technologies as Virtual Machine under the GNU General Public" +
                " License. Others have also developed alternative implementations of these Sun technologies, such as the " +
                "GNU Compiler for Java and GNU Classpath.";

//        Scanner sc = new Scanner(System.in);
//        System.out.println("Search word is :");
//        String search = sc.next();
//        if (javaInfo.contains(search)) {
//            System.out.println("First occurrence:");
//            System.out.println(javaInfo.indexOf(search));
//            System.out.println("Last occurrence:");
//            System.out.println(javaInfo.lastIndexOf(search));
//        } else System.out.println("No such word is present");
//        if (javaInfo.regionMatches(true,0,search,0,0)) {
//            System.out.println("true");
//        } else System.out.println("false");
        System.out.println(substring(javaInfo, "Java", 2));
    }
}
