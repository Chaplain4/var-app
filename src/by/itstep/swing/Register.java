package by.itstep.swing;

import javax.mail.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.util.Date;
import java.util.Properties;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;


public class Register extends JFrame {
    public int sendMail() {
        int sec = (int) (Math.random()*10000);
        final String SSL_FACTORY = "javax.net.ssl.SSLSocketFactory";
        Properties props = System.getProperties();
        props.setProperty("mail.smtp.host", "smtp.gmail.com");
        props.setProperty("mail.smtp.socketFactory.class", SSL_FACTORY);
        props.setProperty("mail.smtp.socketFactory.fallback", "false");
        props.setProperty("mail.smtp.port", "465");
        props.setProperty("mail.smtp.socketFactory.port", "465");
        props.put("mail.smtp.auth", "true");
        props.put("mail.debug", "true");
        props.put("mail.store.protocol", "pop3");
        props.put("mail.transport.protocol", "smtp");
        final String username = "Chaplain04@gmail.com";
        final String password = "bfse xbkc arde xrfr";
        try{
            Session session = Session.getDefaultInstance(props,
                    new Authenticator(){
                        protected PasswordAuthentication getPasswordAuthentication() {
                            return new PasswordAuthentication(username, password);
                        }});
            Message msg = new MimeMessage(session);
            msg.setFrom(new InternetAddress("Chaplain04@gmail.com"));
            msg.setRecipients(Message.RecipientType.TO,
                    InternetAddress.parse("Chaplain04@gmail.com",false));
            msg.setSubject("Hello");
            msg.setText("Secret code is " + sec);
            msg.setSentDate(new Date());
            Transport.send(msg);
            System.out.println("Message sent.");
        }catch (MessagingException e){
            System.out.println("Cause: " + e);
        }
        return sec;
    }

    public Register() {
        setTitle("Authorization");
        setLayout(null);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setSize(600, 600);
        JLabel loginlbl = new JLabel("Login : ");
        JLabel passwordlbl = new JLabel("Password : ");
        JLabel repeatpasswordlbl = new JLabel("Secret code : ");
        JLabel emaillbl = new JLabel("Email : ");

        JTextField loginText = new JTextField();
        JTextField passwordText = new JTextField();
        JTextField repeatText = new JTextField();
        JTextField emailText = new JTextField();

        JButton confirm = new JButton("Confirm");

        loginlbl.setBounds(20, 45, 120, 20);
        passwordlbl.setBounds(20, 65, 120, 20);
        repeatpasswordlbl.setBounds(20, 85, 120, 20);
        emaillbl.setBounds(20, 105, 120, 20);

        loginText.setBounds(160, 45, 120, 20);
        passwordText.setBounds(160, 65, 120, 20);
        repeatText.setBounds(160, 85, 120, 20);
        emailText.setBounds(160, 105, 120, 20);

        confirm.setBounds(280, 105, 120, 20);

        confirm.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                sendMail();
            }
        });
        boarding(confirm, loginlbl, loginText, passwordlbl, passwordText, repeatText, repeatpasswordlbl, emailText, emaillbl);

        setVisible(true);
    }

    private void boarding(Component... components) {
        for (Component component : components) {
            add(component);
        }
    }
}

