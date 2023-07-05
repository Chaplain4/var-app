package by.itstep.swing;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.util.Date;

public class Test {
    public static void main(String[] args) {
        JFrame frame = new JFrame();
        frame.setTitle("My app");

        frame.setSize(512, 512);
        frame.setBackground(Color.RED);
        frame.setLayout(null);
        JButton button = new JButton();
        button.setVisible(true);
        button.setText("Push me");
        button.setSize(200, 40);
        button.setLocation(100, 260);
        JTextField jTextField = new JTextField();
        JLabel jLabel = new JLabel("Name");
        frame.add(jLabel);
        jLabel.setBounds(100, 220, 250, 50);
        jTextField.setBounds(100, 306, 200, 40);
        frame.add(jTextField);

        frame.add(button);
        button.setBackground(Color.YELLOW);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        jTextField.setVisible(true);
        frame.setVisible(true);
        button.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {

                jLabel.setText(new Date() + ": click");
                String name = jTextField.getText();
                jLabel.setText("Hello " + name);
            }
        });
    }


}
