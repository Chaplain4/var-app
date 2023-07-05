package by.itstep.swing;

import javax.swing.*;
import java.awt.event.ActionEvent;

public class Authorization extends JFrame {
    public Authorization() {
        setTitle("Authorization");
        setLayout(null);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setSize(800, 800);
        JTextField login = new JTextField();
        JTextField password = new JTextField();
        login.setBounds(100, 240, 200, 40);
        password.setBounds(400, 240, 200, 40);
        JLabel loginLabel = new JLabel("Login: ");
        JLabel passwordLabel = new JLabel("Password: ");
        loginLabel.setBounds(100, 200, 200, 40);
        passwordLabel.setBounds(400, 200, 200, 40);
        JButton button = new JButton();
        button.setBounds(100, 400, 200, 40);
        button.setText("Launch game");

        button.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if ((login.getText().toString().equals("Admin") && (password.getText().equals("123")))) {
                    GuessNumberJFrame game = new GuessNumberJFrame();
                    button.setText("Launch game!");
                }
            }
        });
        add(button);
        add(login);
        add(loginLabel);
        add(password);
        add(passwordLabel);
        setVisible(true);
    }
}
