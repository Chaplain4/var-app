package interesting;

public class Sudoku {

    public static int[][] createSudokuArray() {
        int[][] sudokuArray = new int[9][9];
        for (int m = 0; m < 9; m++) {
            for (int n = 0; n < 9; n++) {
                sudokuArray[n][m] = (int) (Math.random() * 9) + 1;
            }
        }
        return sudokuArray;
    }

    public static int[][] createValidSudokuArray() {
        int[][] sudokuArray = createSudokuArray();
        do {
            sudokuArray = createSudokuArray();
            int counter = 0;
            do {
                for (int n = 0; n < 9; n++) {
                    for (int m = 0; m < 9; m++) {
                        sudokuArray[m][n] = bestVariant(n, m, sudokuArray);
                    }
                }
                counter++;
            } while ((isSudokuValid(sudokuArray) == false) && (counter < 5));
        } while (isSudokuValid(sudokuArray) == false);
        return sudokuArray;
    }

    public static int isRowValid(int line, int table, int[][] array) {
        int repeats = 0;
        for (int a = 0; a < 9; a++) {
            if (array[table][a] == array[table][line]) {
                repeats++;
            }
            if (a == line) {
                repeats--;
            }
        }
        return repeats;
    }

    public static int isLineValid(int line, int table, int[][] array) {
        int repeats = 0;
        for (int a = 0; a < 9; a++) {
            if (array[a][line] == array[table][line]) {
                repeats++;
            }
            if (a == table) {
                repeats--;
            }
        }
        return repeats;
    }

    public static int isBoxValid(int line, int table, int[][] array) {
        int repeats = 0;
        if (((line >= 0) && (line < 3)) && ((table >= 0) && (table < 3))) {
            for (int a = 0; a < 3; a++) {
                for (int b = 0; b < 3; b++) {
                    if ((array[a][b] == array[table][line]) && (!(a == table)) && (!(b == line))) {
                        repeats++;
                    }
                }
            }
        } else if ((((line >= 0) && (line < 3)) && ((table >= 3) && (table < 6)))) {
            for (int a = 3; a < 6; a++) {
                for (int b = 0; b < 3; b++) {
                    if ((array[a][b] == array[table][line]) && (!(a == table)) && (!(b == line))) {
                        repeats++;
                    }
                }
            }
        } else if ((((line >= 0) && (line < 3)) && ((table >= 6)))) {
            for (int a = 6; a < 9; a++) {
                for (int b = 0; b < 3; b++) {
                    if ((array[a][b] == array[table][line]) && (!(a == table)) && (!(b == line))) {
                        repeats++;
                    }
                }
            }
        } else if (((line >= 3) && (line < 6)) && ((table >= 0) && (table < 3))) {
            for (int a = 0; a < 3; a++) {
                for (int b = 3; b < 6; b++) {
                    if ((array[a][b] == array[table][line]) && (!(a == table)) && (!(b == line))) {
                        repeats++;
                    }
                }
            }
        } else if (((line >= 3) && (line < 6)) && ((table >= 3) && (table < 6))) {
            for (int a = 3; a < 6; a++) {
                for (int b = 3; b < 6; b++) {
                    if ((array[a][b] == array[table][line]) && (!(a == table)) && (!(b == line))) {
                        repeats++;
                    }
                }
            }
        } else if (((line >= 3) && (line < 6)) && (table >= 6)) {
            for (int a = 6; a < 9; a++) {
                for (int b = 3; b < 6; b++) {
                    if ((array[a][b] == array[table][line]) && (!(a == table)) && (!(b == line))) {
                        repeats++;
                    }
                }
            }
        } else if ((line >= 6) && ((table >= 0) && (table < 3))) {
            for (int a = 0; a < 3; a++) {
                for (int b = 6; b < 9; b++) {
                    if ((array[a][b] == array[table][line]) && (!(a == table)) && (!(b == line))) {
                        repeats++;
                    }
                }
            }
        } else if ((line >= 6) && ((table >= 3) && (table < 6))) {
            for (int a = 3; a < 6; a++) {
                for (int b = 6; b < 9; b++) {
                    if ((array[a][b] == array[table][line]) && (!(a == table)) && (!(b == line))) {
                        repeats++;
                    }
                }
            }
        } else if ((line >= 6) && (table >= 6)) {
            for (int a = 6; a < 9; a++) {
                for (int b = 6; b < 9; b++) {
                    if ((array[a][b] == array[table][line]) && (!(a == table)) && (!(b == line))) {
                        repeats++;
                    }
                }
            }
        }

        return repeats;
    }

    public static boolean isNumberValid(int line, int table, int[][] array) {
        boolean isValid = false;
        if ((isBoxValid(line, table, array) == 0) && (isLineValid(line, table, array) == 0) && (isRowValid(line, table, array) == 0)) {
            isValid = true;
        }
        return isValid;
    }

    public static boolean isSudokuValid(int[][] array) {
        boolean isValid = false;
        int invalidNumbers = 0;
        for (int m = 0; m < 9; m++) {
            for (int n = 0; n < 9; n++) {
                if ((isNumberValid(n, m, array) == false) || (array[m][n] == 0)) {
                    invalidNumbers++;
                }
            }
        }
        if (invalidNumbers == 0) {
            isValid = true;
        }
        return isValid;
    }

    public static void printSudoku(int[][] array) {
        System.out.println("    A  B  C   D  E  F   G  H  I");
        System.out.println("  ===============================");
        for (int m = 0; m < 9; m++) {
            System.out.print((m + 1) + " ║");
            for (int n = 0; n < 9; n++) {
                System.out.print("[" + array[n][m] + "]");
                if ((n - 2) % 3 == 0) {
                    System.out.print("║");
                }
            }
            System.out.println();
            if ((m - 2) % 3 == 0) {
                System.out.println("  ===============================");
            }
        }
    }

    public static int bestVariant(int line, int table, int[][] array) {
        int variant = 0;
        int placeholder = array[table][line];
        for (int a = 1; a < 10; a++) {
            array[table][line] = a;
            if (isNumberValid(line, table, array)) {
                variant = a;
            }
        }
        array[table][line] = placeholder;
        return variant;
    }

    public static void main(String[] args) {
        int[][] array = createValidSudokuArray();
        printSudoku(array);
    }
}