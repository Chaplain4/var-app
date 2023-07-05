package by.itstep.swing;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.util.Scanner;

public class Mineswinger extends JFrame {
    public Mineswinger() {
        setTitle("Authorization");
        setLayout(null);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setSize(1400, 800);
        JMenuBar menuBar = new JMenuBar();
        menuBar.add(selectDifficultyMenu());
        setJMenuBar(menuBar);
        setVisible(true);
    }

    private JMenu selectDifficultyMenu() {
        JMenu difficulty = new JMenu("Difficulty");
        JRadioButtonMenuItem easy = new JRadioButtonMenuItem("Easy");
        JRadioButtonMenuItem medium = new JRadioButtonMenuItem("Medium");
        JRadioButtonMenuItem hard = new JRadioButtonMenuItem("Hard");
        difficulty.add(easy);
        difficulty.add(medium);
        difficulty.add(hard);
        ButtonGroup difficulties = new ButtonGroup();
        difficulties.add(easy);
        difficulties.add(medium);
        difficulties.add(hard);
        easy.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JButton[][] easy = new JButton[9][9];
                for (int i = 0; i < 9; i++) {
                    for (int j = 0; j < 9; j++) {
                        easy[i][j].setBounds(50+(30*i),50+(30*j),30,30);
                    }
                }
            }
            //    public static int[][] create2dIntArray(int arrayLength, int arrayHeight, int minValue, int maxValue) {
            //        int array[][] = new int[arrayHeight][arrayLength];
            //        int[] nextLine;
            //        for (int m = 0; m < arrayHeight; m++) {
            //            nextLine = Homework.Arrays.createIntArray(arrayLength, minValue, maxValue);
            //            for (int n = 0; n < arrayLength; n++) {
            //                array[m][n] = nextLine[n];
            //            }
            //        }
            //        return array;
            //    }
        });
        medium.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
        hard.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
        return difficulty;
    }

}




class Minesweeper {

    /**
     * Bootleg Microsoft Minesweeper game
     */
    public static void minesweeperGame() {
        System.out.println("E - Easy (9 х 9, 10 mines)");
        System.out.println("M - Medium (16 х 16, 40 mines)");
        System.out.println("H - Hard (16 x 30, 99 mines)");
        System.out.println("any other input - Custom");
        System.out.print("Select difficulty: ");
        int columns, lines, mines;
        boolean gameOver = false;
        Scanner sc = new Scanner(System.in);
        char letter = sc.next().charAt(0);
        if (letter == 'e' || letter == 'E') {
            columns = 9;
            lines = 9;
            mines = 10;
        } else if (letter == 'm' || letter == 'M') {
            columns = 16;
            lines = 16;
            mines = 40;
        } else if (letter == 'h' || letter == 'H') {
            columns = 30;
            lines = 16;
            mines = 99;
        } else {
            System.out.print("Input number of columns: ");
            columns = sc.nextInt();
            do {
                System.out.print("Input number of lines (26 or less): ");
                lines = sc.nextInt();
                if (lines > 26) {
                    System.out.println("Too many lines!");
                }
            } while (lines > 26);
            do {
                System.out.print("Input number of mines: ");
                mines = sc.nextInt();
                if (mines >= lines * columns) {
                    System.out.println("Too many mines!");
                }
            } while (mines > lines * columns);
        }
        char[][] gameField = new char[lines][columns];
        char[][] gameField2 = new char[lines][columns];
        for (int m = 0; m < gameField.length; m++) {
            for (int n = 0; n < gameField[0].length; n++) {
                gameField[m][n] = ' ';
            }
        }
        interesting.Minesweeper.showMinefield(gameField);
        int selectedLine;
        int selectedColumn;
        do {
            System.out.print("Select line using letters (for example, A):  ");
            selectedLine = (int) sc.next().charAt(0);
            if (!(((selectedLine > 64) && (selectedLine <= 64 + lines)) || ((selectedLine > 96) && (selectedLine <= 96 + lines)))) {
                System.out.println("Incorrect line selected!");
            }
        } while (!(((selectedLine > 64) && (selectedLine <= 64 + lines)) || ((selectedLine > 96) && (selectedLine <= 96 + lines))));
        if ((selectedLine > 64) && (selectedLine < 91)) {
            selectedLine -= 65;
        } else if ((selectedLine > 96) && (selectedLine < 123)) {
            selectedLine -= 97;
        }
        do {
            System.out.print("Select column (for example, 1):  ");
            selectedColumn = sc.nextInt();
            if (!((selectedColumn > 0) && (selectedColumn <= columns))) {
                System.out.println("Incorrect column selected!");
            }
        } while (!((selectedColumn > 0) && (selectedColumn <= columns)));
        selectedColumn--;
        while (true) {
            gameField2 = interesting.Minesweeper.createMinefield(columns, lines, mines);
            if (!(gameField2[selectedLine][selectedColumn] == '*')) {
                break;
            }
        }
        interesting.Minesweeper.openCell(gameField, gameField2, selectedLine, selectedColumn);
        interesting.Minesweeper.showMinefield(gameField);
        int selectedAction = 0;
        int mineCounter = 0;
        while (gameOver == false) {
            mineCounter = 0;
            for (int m = 0; m < gameField.length; m++) {
                for (int n = 0; n < gameField[0].length; n++) {
                    if (gameField[m][n] == '⚑') {
                        mineCounter++;
                    }
                }
            }
            System.out.println("There are " + (mines - mineCounter) + "/" + mines + " un-flagged mines remaining!");
            mineCounter = 0;
            do {
                System.out.print("Select line using letters (for example, A):  ");
                selectedLine = (int) sc.next().charAt(0);
                if (!(((selectedLine > 64) && (selectedLine <= 64 + lines)) || ((selectedLine > 96) && (selectedLine <= 96 + lines)))) {
                    System.out.println("Incorrect line selected!");
                }
            } while (!(((selectedLine > 64) && (selectedLine <= 64 + lines)) || ((selectedLine > 96) && (selectedLine <= 96 + lines))));
            if ((selectedLine > 64) && (selectedLine < 91)) {
                selectedLine -= 65;
            } else if ((selectedLine > 96) && (selectedLine < 123)) {
                selectedLine -= 97;
            }
            do {
                System.out.print("Select column (for example, 1):  ");
                selectedColumn = sc.nextInt();
                if (!((selectedColumn > 0) && (selectedColumn <= columns))) {
                    System.out.println("Incorrect column selected!");
                }
            } while (!((selectedColumn > 0) && (selectedColumn <= columns)));
            selectedColumn--;
            System.out.println("Select Action:");
            System.out.println("(1) - open cell");
            System.out.println("(2) - place/remove a flag");
            System.out.println("(3) - open cell and all un-flagged cells adjacent to it");
            System.out.println("Any other input - change selected cell");
            selectedAction = sc.nextInt();
            if (selectedAction == 1) {
                interesting.Minesweeper.openCell(gameField, gameField2, selectedLine, selectedColumn);
                interesting.Minesweeper.showMinefield(gameField);
            } else if (selectedAction == 2) {
                interesting.Minesweeper.placeFlag(gameField, selectedLine, selectedColumn);
                interesting.Minesweeper.showMinefield(gameField);
            } else if (selectedAction == 3) {
                interesting.Minesweeper.openAdjacentCells(gameField, gameField2, selectedLine, selectedColumn);
                interesting.Minesweeper.showMinefield(gameField);
            } else {
            }
            for (int m = 0; m < gameField.length; m++) {
                for (int n = 0; n < gameField[0].length; n++) {
                    if (gameField[m][n] == '*') {
                        gameOver = true;
                        System.out.println("You have lost the game!");
                        System.out.println("Game over!");
                        interesting.Minesweeper.showMinefield(gameField2);
                    }
                }
            }
            if (!(gameOver)) {
                for (int m = 0; m < gameField.length; m++) {
                    for (int n = 0; n < gameField[0].length; n++) {
                        if ((gameField2[m][n] == '*') || (gameField2[m][n] == gameField[m][n])) {
                            mineCounter++;
                        }
                    }
                }
                if (mineCounter == lines * columns) {
                    gameOver = true;
                    System.out.println("You have won the game!");
                    System.out.println("Game over!");
                    interesting.Minesweeper.showMinefield(gameField2);
                }
            }
        }
    }

    /**
     * Opens cell selected by player. If cell returns 0, opens all adjacent cells.
     *
     * @param gameField      minefield as seen by player
     * @param gameField2     minefield with all cells open
     * @param selectedLine   line number selected by player
     * @param selectedColumn column number selected by player
     * @return minefield with selected cell opened
     */
    public static char[][] openCell(char[][] gameField, char[][] gameField2, int selectedLine, int selectedColumn) {
        if ((!(gameField[selectedLine][selectedColumn] == '⚑')) && (gameField2[selectedLine][selectedColumn] == '0') && (!(gameField[selectedLine][selectedColumn] == gameField2[selectedLine][selectedColumn]))) {
            interesting.Minesweeper.openAdjacentCells(gameField, gameField2, selectedLine, selectedColumn);
        } else {
            if ((!((gameField[selectedLine][selectedColumn] == '⚑'))) && !(gameField[selectedLine][selectedColumn] == gameField2[selectedLine][selectedColumn])) {
                gameField[selectedLine][selectedColumn] = gameField2[selectedLine][selectedColumn];
            }
        }
        return gameField;
    }

    /**
     * Opens cell selected by player and all un-flagged cells adjacent to it. If cell returns 0, opens all adjacent cells.
     *
     * @param gameField      minefield as seen by player
     * @param gameField2     minefield with all cells open
     * @param selectedLine   line number selected by player
     * @param selectedColumn column number selected by player
     * @return minefield with selected cell and all un-flagged cells adjacent to it opened
     */
    public static char[][] openAdjacentCells(char[][] gameField, char[][] gameField2, int selectedLine, int selectedColumn) {
        if ((!((gameField[selectedLine][selectedColumn] == '⚑'))) && !(gameField[selectedLine][selectedColumn] == gameField2[selectedLine][selectedColumn])) {
            gameField[selectedLine][selectedColumn] = gameField2[selectedLine][selectedColumn];
        }
        if ((selectedLine + 1) < gameField.length && (selectedColumn + 1) < gameField[0].length) {
            if ((!((gameField[selectedLine + 1][selectedColumn + 1] == '⚑'))) && !(gameField[selectedLine + 1][selectedColumn + 1] == gameField2[selectedLine + 1][selectedColumn + 1])) {
                interesting.Minesweeper.openCell(gameField, gameField2, selectedLine + 1, selectedColumn + 1);
            }
            if ((!((gameField[selectedLine + 1][selectedColumn] == '⚑'))) && !(gameField[selectedLine + 1][selectedColumn] == gameField2[selectedLine + 1][selectedColumn])) {
                interesting.Minesweeper.openCell(gameField, gameField2, selectedLine + 1, selectedColumn);
            }
            if ((!(gameField[selectedLine][selectedColumn + 1] == '⚑')) && !(gameField[selectedLine][selectedColumn + 1] == gameField2[selectedLine][selectedColumn + 1])) {
                interesting.Minesweeper.openCell(gameField, gameField2, selectedLine, selectedColumn + 1);
            }
        }
        if ((selectedLine + 1) < gameField.length && (selectedColumn - 1) >= 0) {
            if ((!(gameField[selectedLine + 1][selectedColumn - 1] == '⚑')) && !(gameField[selectedLine + 1][selectedColumn - 1] == gameField2[selectedLine + 1][selectedColumn - 1])) {
                interesting.Minesweeper.openCell(gameField, gameField2, selectedLine + 1, selectedColumn - 1);
            }
            if ((!((gameField[selectedLine + 1][selectedColumn] == '⚑'))) && !(gameField[selectedLine + 1][selectedColumn] == gameField2[selectedLine + 1][selectedColumn])) {
                interesting.Minesweeper.openCell(gameField, gameField2, selectedLine + 1, selectedColumn);
            }
            if ((!(gameField[selectedLine][selectedColumn - 1] == '⚑')) && !(gameField[selectedLine][selectedColumn - 1] == gameField2[selectedLine][selectedColumn - 1])) {
                interesting.Minesweeper.openCell(gameField, gameField2, selectedLine, selectedColumn - 1);
            }
        }
        if ((selectedLine - 1) >= 0 && (selectedColumn + 1) < gameField[0].length) {
            if ((!(gameField[selectedLine - 1][selectedColumn + 1] == '⚑')) && !(gameField[selectedLine - 1][selectedColumn + 1] == gameField2[selectedLine - 1][selectedColumn + 1])) {
                interesting.Minesweeper.openCell(gameField, gameField2, selectedLine - 1, selectedColumn + 1);
            }
            if ((!(gameField[selectedLine][selectedColumn + 1] == '⚑')) && !(gameField[selectedLine][selectedColumn + 1] == gameField2[selectedLine][selectedColumn + 1])) {
                interesting.Minesweeper.openCell(gameField, gameField2, selectedLine, selectedColumn + 1);
            }
            if ((!(gameField[selectedLine - 1][selectedColumn] == '⚑')) && !(gameField[selectedLine - 1][selectedColumn] == gameField2[selectedLine - 1][selectedColumn])) {
                interesting.Minesweeper.openCell(gameField, gameField2, selectedLine - 1, selectedColumn);
            }
        }
        if ((selectedLine - 1) >= 0 && (selectedColumn - 1) >= 0) {
            if ((!(gameField[selectedLine - 1][selectedColumn - 1] == '⚑')) && !(gameField[selectedLine - 1][selectedColumn - 1] == gameField2[selectedLine - 1][selectedColumn - 1])) {
                interesting.Minesweeper.openCell(gameField, gameField2, selectedLine - 1, selectedColumn - 1);
            }
            if ((!(gameField[selectedLine][selectedColumn - 1] == '⚑')) && !(gameField[selectedLine][selectedColumn - 1] == gameField2[selectedLine][selectedColumn - 1])) {
                interesting.Minesweeper.openCell(gameField, gameField2, selectedLine, selectedColumn - 1);
            }
            if ((!(gameField[selectedLine - 1][selectedColumn] == '⚑')) && !(gameField[selectedLine - 1][selectedColumn] == gameField2[selectedLine - 1][selectedColumn])) {
                interesting.Minesweeper.openCell(gameField, gameField2, selectedLine - 1, selectedColumn);
            }
        }
        return gameField;
    }

    /**
     * Places a flag on empty cell selected by player. If cell returns flag, removes it.
     *
     * @param gameField      minefield as seen by player
     * @param selectedLine   line number selected by player
     * @param selectedColumn column number selected by player
     * @return minefield with selected cell flagged or un-flagged
     */
    public static char[][] placeFlag(char[][] gameField, int selectedLine, int selectedColumn) {
        if (gameField[selectedLine][selectedColumn] == ' ') {
            gameField[selectedLine][selectedColumn] = '⚑';
        } else if (gameField[selectedLine][selectedColumn] == '⚑') {
            gameField[selectedLine][selectedColumn] = ' ';
        }
        return gameField;
    }

    /**
     * Populates the field randomly with mines (*) and correct mine count values (from 0 to 8).
     *
     * @param columns - pre-set width of the minefield
     * @param lines   - pre-set height of the minefield
     * @param mines   - number of mines on the minefield
     * @return fully populated minefield
     */
    public static char[][] createMinefield(int columns, int lines, int mines) {
        char[][] minefield = new char[lines][columns];
        int[] randomCoordinates = new int[2];
        char[] mineCountCheck = new char[8];
        char mineCounter = 0;
        mineCountCheck = new char[]{'0', '0', '0', '0', '0', '0', '0', '0'};
        while (mines > 0) {
            randomCoordinates[0] = (int) (Math.random() * lines);
            randomCoordinates[1] = (int) (Math.random() * columns);
            if (minefield[randomCoordinates[0]][randomCoordinates[1]] == '*') {
            } else {
                minefield[randomCoordinates[0]][randomCoordinates[1]] = '*';
                mines--;
            }
            for (int m = 0; m < minefield.length; m++) {
                for (int n = 0; n < minefield[0].length; n++) {
                    mineCountCheck = new char[]{'0', '0', '0', '0', '0', '0', '0', '0'};
                    mineCounter = 0;
                    if (!(minefield[m][n] == '*')) {
                        if ((m + 1) < minefield.length && (n + 1) < minefield[0].length) {
                            mineCountCheck[1] = minefield[m + 1][n + 1];
                            mineCountCheck[5] = minefield[m + 1][n];
                            mineCountCheck[6] = minefield[m][n + 1];
                        }
                        if ((m + 1) < minefield.length && (n - 1) >= 0) {
                            mineCountCheck[2] = minefield[m + 1][n - 1];
                            mineCountCheck[5] = minefield[m + 1][n];
                            mineCountCheck[7] = minefield[m][n - 1];
                        }
                        if ((m - 1) >= 0 && (n + 1) < minefield[0].length) {
                            mineCountCheck[3] = minefield[m - 1][n + 1];
                            mineCountCheck[6] = minefield[m][n + 1];
                            mineCountCheck[0] = minefield[m - 1][n];
                        }
                        if ((m - 1) >= 0 && (n - 1) >= 0) {
                            mineCountCheck[4] = minefield[m - 1][n - 1];
                            mineCountCheck[7] = minefield[m][n - 1];
                            mineCountCheck[0] = minefield[m - 1][n];
                        }
                        for (char a : mineCountCheck) {
                            if (a == '*') {
                                mineCounter++;
                            }
                        }
                        minefield[m][n] = '0';
                        minefield[m][n] += mineCounter;
                    }
                }
            }

        }
        return minefield;
    }

    /**
     * prints minefield array as a spreadsheet with grid coordinates
     *
     * @param minefield - minefield
     */
    public static void showMinefield(char[][] minefield) {
        char lineCounter = 'A';
        System.out.print("  ");
        for (int n = 0; n < minefield[0].length; n++) {
            if (n + 1 < 10) {
                System.out.print("  " + (n + 1));
            } else System.out.print(" " + (n + 1));

        }
        System.out.println();
        System.out.print("  ");
        for (int n = 0; n < minefield[0].length; n++) {
            System.out.print("===");
        }
        System.out.print("=");
        System.out.println();
        for (int m = 0; m < minefield.length; m++) {
            System.out.print((lineCounter) + " ║");
            lineCounter++;
            for (int n = 0; n < minefield[0].length; n++) {
                System.out.print("[" + minefield[m][n] + "]");
            }
            System.out.println();
        }
        System.out.println();
    }
}

class Player1 {
    public static void main(String[] args) {
        Mineswinger mineswinger = new Mineswinger();
    }
}