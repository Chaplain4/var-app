package by.itstep.strs;

public class HTMLTableBuilder {
    public static final String TABLE_BEGIN = "<table>";
    public static final String TABLE_END = "</table>";

    public static final String TABLE_ROW_BEGIN = "<tr>";
    public static final String TABLE_ROW_END = "</tr>";

    public static final String TABLE_HEADER_BEGIN = "<th>";
    public static final String TABLE_HEADER_END = "</th>";

    public static final String TABLE_DATA_BEGIN = "<td>";
    public static final String TABLE_DATA_END = "</td>";

    private StringBuilder htmlData = new StringBuilder(); //TODO try to calculate capacity

    public HTMLTableBuilder() {
        htmlData.append(TABLE_BEGIN).append(TABLE_END);
    }

    public String build() {
        return htmlData.toString();
    }

    public void addHeaders(String... headers) {
        StringBuilder headersBuilder = new StringBuilder(20 * headers.length);
        headersBuilder.append(TABLE_ROW_BEGIN);
        for (String string : headers) {
            headersBuilder.append(TABLE_HEADER_BEGIN).append(string).append(TABLE_HEADER_END);
        }
        headersBuilder.append(TABLE_ROW_END);
        htmlData.insert(htmlData.indexOf(TABLE_BEGIN) + TABLE_BEGIN.length(), headersBuilder);
    }

    public void addStudents(Student... students) {
        StringBuilder studentAdder = new StringBuilder(students.toString().length() + 20 * students.length);
        for (Student student : students) {
            studentAdder.append(TABLE_ROW_BEGIN);
            studentAdder.append(TABLE_DATA_BEGIN).append(student.getId()).append(TABLE_DATA_END);
            studentAdder.append(TABLE_DATA_BEGIN).append(student.getName()).append(TABLE_DATA_END);
            studentAdder.append(TABLE_DATA_BEGIN).append(student.getAvg()).append(TABLE_DATA_END);
            studentAdder.append(TABLE_ROW_END);
        }
        htmlData.insert(htmlData.lastIndexOf(TABLE_HEADER_END), studentAdder);

    }

}
