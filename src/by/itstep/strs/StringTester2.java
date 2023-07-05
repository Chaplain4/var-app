package by.itstep.strs;

import java.util.Locale;
import java.util.StringTokenizer;

public class StringTester2 {
    public static void main(String[] args) {
        // String Pool

        String s1 = "Java";
        String s2 = "Java";
        String s3 = "Java";
        System.out.println(s1 == s3);
        System.out.println(s2 == s3);
        System.out.println(s2 == s1);
        //Heap (Not string pool)
        String s4 = new String("Java");
        System.out.println(s4);
        System.out.println(s1 == s4);
        System.out.println(s2 == s4);
        System.out.println(s3 == s4);
        String s5 = new String("Java");
        System.out.println(s5 == s4);
        String s6 = "Java";
        System.out.println(s1 == s6);
        String text = "Java is a programming language originally developed by Sun Microsystems and released " +
                "in 1995 as a core component of Sun's Java platform. The language derives much of its Syntax from " +
                "C and C++ but has a simpler object model and fewer low-level facilities. Java applications are " +
                "typically compiled to bytecode which can run on any Java virtual machine (JVM) regardless of computer architecture.\n" +
                "\n" +
                "The original and reference implementation Java compilers, virtual machines, and class" +
                " libraries were developed by Sun from 1995. As of May 2007, in compliance with the specifications of the Java Community Process," +
                " Sun made available most of their Java technologies as Virtual Machine under the GNU General Public License. " +
                "Others have also developed alternative implementations of these Sun technologies, " +
                "such as the GNU Compiler for Java and GNU Classpath.\n" +
                "\n" +
                "Java's design, industry backing and portability have made Java one of the fastest-growing and" +
                " most widely used programming languages in the modern computing industry.Template:Fact";
        int wordscount = 0;
        for (String word : text.replace("\n", "\\s+").split(" ")){
            System.out.println(word);
            wordscount++;
        }
        System.out.println(wordscount);
        StringTokenizer stringTokenizer = new StringTokenizer(text);

        System.out.println(stringTokenizer.countTokens());

        //count specific words

        int javaCount = 0;
        for (String string : text.toLowerCase().split("\\s+")) {
            if (string.startsWith("java")) {
                javaCount++;
            }
        }
        System.out.println(javaCount);

        //replace
        text = text.replace("Java","C++");
        System.out.println(text);
        System.out.println("____________________");
        System.out.println(text.substring(44));
        System.out.println("____________________");
        System.out.println(text.substring(10,15));
        System.out.println("____________________");
        String subtext = text.substring(text.indexOf("C++")+"C++".length());
        System.out.println(subtext);
        System.out.println("____________________");
        subtext = subtext.substring(subtext.indexOf("C++")+"C++".length());
        System.out.println(subtext);
        System.out.println("____________________");
        subtext = subtext.substring(subtext.indexOf("C++")+"C++".length());
        System.out.println(subtext);
    }
}
