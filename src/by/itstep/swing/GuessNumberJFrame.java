package by.itstep.swing;

import javax.swing.*;
import java.awt.event.ActionEvent;

public class GuessNumberJFrame extends JFrame {
    public static int[] createIntArray(int arrayLength, int minValue, int maxValue) {
        if (minValue > maxValue) {
            System.out.println("Invalid Min/Max Values!");
        }
        int array[] = new int[arrayLength];
        if (minValue >= 0) {
            for (int n = 0; n < arrayLength; n++) {
                array[n] = (int) ((Math.random() * (maxValue - minValue + 1) + minValue));
            }
        } else if (maxValue >= 0) {
            for (int n = 0; n < arrayLength; n++) {
                array[n] = (int) ((Math.random() * (maxValue - minValue + 2) + minValue - 1));
            }
        } else {
            for (int n = 0; n < arrayLength; n++) {
                array[n] = (int) ((Math.random() * -1 * (minValue - (maxValue + 1)) + (minValue - 1)));
            }
        }
        return array;
    }

    public GuessNumberJFrame() {
        setTitle("Guess Number Game");
        setLayout(null);

        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setSize(1300, 800);
        JTextField from = new JTextField();
        JTextField to = new JTextField();
        JTextField guesses = new JTextField();
        JTextField newGuess = new JTextField();
        newGuess.setVisible(false);
        newGuess.setBounds(800, 400, 200, 40);
        JLabel result = new JLabel();
        JLabel fromLabel = new JLabel("From: ");
        JLabel toLabel = new JLabel("To: ");
        JLabel guessesLabel = new JLabel("Number of guesses: ");
        fromLabel.setBounds(100, 200, 200, 40);
        toLabel.setBounds(400, 200, 200, 40);
        guessesLabel.setBounds(700, 200, 200, 40);
        from.setBounds(100, 240, 200, 40);
        to.setBounds(400, 240, 200, 40);
        guesses.setBounds(700, 240, 200, 40);
        result.setBounds(400, 400, 300, 40);
        JButton button = new JButton();
        button.setBounds(100, 400, 100, 40);
        result.setText("Result : ");
        button.setText("Generate!");
        JButton takeAGuess = new JButton();
        takeAGuess.setText("Try this!");
        takeAGuess.setVisible(false);
        takeAGuess.setBounds(100, 400, 100, 40);
        final int[] result1 = new int[1];
        final int[] guess1 = new int[1];
        button.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                guess1[0] = Integer.parseInt(guesses.getText());
                result1[0] = createIntArray(1, Integer.parseInt(from.getText()), Integer.parseInt(to.getText()))[0];
                result.setText("Result : ?");
                fromLabel.setText("From: " + from.getText());
                toLabel.setText("To: " + to.getText());
                guessesLabel.setText("Number of guesses: " + guess1[0]);
                if (Integer.parseInt(guesses.getText()) < 1) {
                    guesses.setText("1");
                }
                button.setVisible(false);
                guesses.setVisible(false);
                to.setVisible(false);
                from.setVisible(false);
                takeAGuess.setVisible(true);
                newGuess.setVisible(true);
            }
        });
        takeAGuess.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                guesses.setText(String.valueOf(Integer.parseInt(guesses.getText()) - 1));
                guessesLabel.setText("Number of guesses: " + guesses.getText());
                if (Integer.parseInt(newGuess.getText()) == result1[0]) {
                    result.setText("Result : You win!");
                    button.setVisible(true);
                    guesses.setVisible(true);
                    to.setVisible(true);
                    from.setVisible(true);
                    takeAGuess.setVisible(false);
                    newGuess.setVisible(false);
                } else if (Integer.parseInt(guesses.getText()) == 0) {
                    result.setText("Result : You lose!");
                    button.setVisible(true);
                    guesses.setVisible(true);
                    to.setVisible(true);
                    from.setVisible(true);
                    takeAGuess.setVisible(false);
                    newGuess.setVisible(false);
                } else if (Integer.parseInt(newGuess.getText()) > result1[0]) {
                    result.setText("Result : Too big!");
                } else if (Integer.parseInt(newGuess.getText()) < result1[0]) {
                    result.setText("Result : Too small!");
                }
            }
        });
        add(takeAGuess);
        add(from);
        add(fromLabel);
        add(to);
        add(toLabel);
        add(button);
        add(result);
        add(guesses);
        add(guessesLabel);
        add(takeAGuess);
        add(newGuess);
        setVisible(true);
    }
}

class Player {
    public static void main(String[] args) {
        Authorization authorization = new Authorization();
    }
}