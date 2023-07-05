package by.itstep.strs;



public class MutableStringTest {
    public static void main(String[] args) {
        StringBuffer sBuff;
        StringBuilder sBuild = new StringBuilder();
        sBuild.append("Hello");
        String str = null;
        sBuild.append(str).append(123).append(" World!! ");
        System.out.println(sBuild);

        StringBuilder sBuild2 = new StringBuilder(1024);
        sBuild2.append("Hello world!");
        sBuild2.append("Hello world!");
        sBuild2.append("Hello world!");
        System.out.println(sBuild2);

        StringBuilder sBuild3 = new StringBuilder("1024");
        StringBuilder sBuild4 = new StringBuilder(sBuild.append(sBuild2));
        System.out.println(sBuild4);
        System.out.println(sBuild4.reverse());
        System.out.println("capacity :" + sBuild4.capacity());
        System.out.println("length :" + sBuild4.length());
        System.out.println("free :" + (sBuild4.capacity()-sBuild4.length()));
        String [] words = sBuild4.toString().split(" ");
        for (String word : words) {
            System.out.println(word);
        }
        HTMLTableBuilder html = new HTMLTableBuilder();
        html.addHeaders("ID","Name", "AVG");
        html.addStudents(new Student(1, "Ivan", "", 5, 5),
                new Student(2, "John", "", 4, 4));
        System.out.println(html.build());
    }
}

