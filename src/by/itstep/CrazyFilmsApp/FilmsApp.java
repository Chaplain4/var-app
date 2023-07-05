package by.itstep.CrazyFilmsApp;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.util.Calendar;
import java.util.Date;
import java.util.Properties;

public class FilmsApp extends JFrame {
    private static Film[] db = new Film[128];

    private int selectedFilm = 0;
    private int filmsStored = 0;

    public void setSelectedFilm(int selectedFilm) {
        this.selectedFilm = selectedFilm;
    }

    public int getSelectedFilm() {
        return selectedFilm;
    }

    public int getFilmsStored() {
        filmsStored = 0;
        for (int i = 0; i < db.length; i++) {
            if (db[i] == null) {
                break;
            } else filmsStored++;
        }
        return filmsStored;
    }

    static {
        Actor actor1 = new Actor(1, "Will Smith");
        Actor actor2 = new Actor(2, "Martin lawrence");
        Actor actor3 = new Actor(3, "Lisa Boyle");
        Actor[] actors = {actor1, actor2, actor3};
        Film film1 = new Film((long) 1, "Bad Boys", new String[]{"Action", "Comedy"}, 7.6, new Date(95, Calendar.APRIL, 7), actors);
        Actor[] actors2 = {actor1, actor2};
        Film film2 = new Film((long) 2, "Bad Boys 2", new String[]{"Action", "Comedy"}, 7.1, new Date(103, Calendar.JULY, 18), actors2);
        Film film3 = new Film((long) 3, "Titanic", new String[]{"Drama", "Disaster movie"}, 7.9, new Date(97, Calendar.DECEMBER, 19), new Actor[]{new Actor(4, "Leonardo Di Caprio")});
        db[0] = film1;
        db[1] = film2;
        db[2] = film3;
    }

    public void setDb(Film[] db) {
        this.db = db;
    }

    public FilmsApp() {
        setTitle("FilmsApp");
        setLayout(null);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setSize(600, 600);
        for (int i = 0; i < db.length; i++) {
            if (db[i] == null) {
                break;
            } else filmsStored++;
        }
        JLabel uidlbl = new JLabel("Unique ID : ");
        JLabel imdbRatelbl = new JLabel("IMDB Rate : ");
        JLabel namelbl = new JLabel("Name : ");
        JLabel genreslbl = new JLabel("Genres : ");
        JLabel datelbl = new JLabel("Release date : ");
        JLabel actorslbl = new JLabel("Stars : ");
        JLabel headsUplbl = new JLabel("Selected film : " + (getSelectedFilm() + 1) + " / " + getFilmsStored());

        JTextField uidText = new JTextField();
        JTextField imdbText = new JTextField();
        JTextField nameText = new JTextField();
        JTextField genresText = new JTextField();
        JTextField dateText = new JTextField();
        JTextField actorsText = new JTextField();
        JTextField searchText = new JTextField();
        JTextArea searchResultText = new JTextArea();

        JButton next = new JButton("Next");
        JButton previous = new JButton("Previous");
        JButton add = new JButton("Add");
        JButton remove = new JButton("Remove");
        JButton update = new JButton("Update");
        JButton search = new JButton("Search");

        uidlbl.setBounds(20, 45, 120, 20);
        imdbRatelbl.setBounds(20, 65, 120, 20);
        namelbl.setBounds(20, 85, 120, 20);
        genreslbl.setBounds(20, 105, 120, 20);
        datelbl.setBounds(20, 125, 120, 20);
        actorslbl.setBounds(20, 145, 120, 20);
        headsUplbl.setBounds(100, 25, 160, 20);

        uidText.setBounds(160, 45, 120, 20);
        imdbText.setBounds(160, 65, 120, 20);
        nameText.setBounds(160, 85, 120, 20);
        genresText.setBounds(160, 105, 120, 20);
        dateText.setBounds(160, 125, 120, 20);
        actorsText.setBounds(160, 145, 120, 20);
        searchText.setBounds(290, 25, 160, 20);
        searchResultText.setBounds(290, 45, 280, 400);

        previous.setBounds(20, 485, 120, 20);
        next.setBounds(140, 485, 120, 20);
        add.setBounds(360, 485, 120, 20);
        remove.setBounds(300, 465, 120, 20);
        update.setBounds(420, 465, 120, 20);
        search.setBounds(450, 25, 120, 20);

        boarding(uidlbl, imdbRatelbl, namelbl, genreslbl, datelbl, actorslbl, headsUplbl,
                uidText, imdbText, nameText, genresText, dateText, actorsText, searchText,
                searchResultText, previous, next, add, remove, update, search);

        //load first film

        uidText.setText(String.valueOf(db[getSelectedFilm()].getId()));
        imdbText.setText(String.valueOf(db[getSelectedFilm()].getImdbRating()));
        nameText.setText(db[getSelectedFilm()].getName());
        genresText.setText(db[getSelectedFilm()].getGenresString());
        dateText.setText(db[getSelectedFilm()].getReleaseDate().getYear() + 1900 + "/" +
                (db[getSelectedFilm()].getReleaseDate().getMonth() + 1) + "/" + db[getSelectedFilm()].getReleaseDate().getDate());
        actorsText.setText(db[getSelectedFilm()].getActorsString());

        //добавить кнопки вперед назад
        next.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (db[getSelectedFilm() + 1] == null) {
                    setSelectedFilm(0);
                } else {
                    setSelectedFilm(getSelectedFilm() + 1);
                }
                uidText.setText(String.valueOf(db[getSelectedFilm()].getId()));
                imdbText.setText(String.valueOf(db[getSelectedFilm()].getImdbRating()));
                nameText.setText(db[getSelectedFilm()].getName());
                genresText.setText(db[getSelectedFilm()].getGenresString());
                dateText.setText(db[getSelectedFilm()].getReleaseDate().getYear() + 1900 + "/" +
                        (db[getSelectedFilm()].getReleaseDate().getMonth() + 1) + "/" + db[getSelectedFilm()].getReleaseDate().getDate());
                actorsText.setText(db[getSelectedFilm()].getActorsString());
                headsUplbl.setText("Selected film : " + (getSelectedFilm() + 1) + " / " + getFilmsStored());
            }
        });
        previous.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (getSelectedFilm() == 0) {
                    setSelectedFilm(getFilmsStored() - 1);
                } else {
                    setSelectedFilm(getSelectedFilm() - 1);
                }
                uidText.setText(String.valueOf(db[getSelectedFilm()].getId()));
                imdbText.setText(String.valueOf(db[getSelectedFilm()].getImdbRating()));
                nameText.setText(db[getSelectedFilm()].getName());
                genresText.setText(db[getSelectedFilm()].getGenresString());
                dateText.setText(db[getSelectedFilm()].getReleaseDate().getYear() + 1900 + "/" +
                        (db[getSelectedFilm()].getReleaseDate().getMonth() + 1) + "/" + db[getSelectedFilm()].getReleaseDate().getDate());
                actorsText.setText(db[getSelectedFilm()].getActorsString());
                headsUplbl.setText("Selected film : " + (getSelectedFilm() + 1) + " / " + getFilmsStored());
            }
        });
        //добаавить кнопку добавить
        add.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (filmsStored < db.length) {
                    String[] newgenres = new String[1];
                    newgenres[0] = "";
                    Actor[] newActors = new Actor[1];
                    newActors[0] = new Actor(0, "");
                    db[filmsStored] = new Film(db[filmsStored - 1].getId() + 1, "", newgenres, 0.0, new Date(0, Calendar.JANUARY, 1), newActors);
                    selectedFilm = filmsStored;
                    filmsStored++;
                    uidText.setText(db[filmsStored - 1].getId() + "");
                    imdbText.setText(String.valueOf(db[getSelectedFilm()].getImdbRating()));
                    nameText.setText(db[getSelectedFilm()].getName());
                    genresText.setText(db[getSelectedFilm()].getGenresString());
                    dateText.setText(db[getSelectedFilm()].getReleaseDate().getYear() + 1900 + "/" +
                            (db[getSelectedFilm()].getReleaseDate().getMonth() + 1) + "/" + db[getSelectedFilm()].getReleaseDate().getDate());
                    actorsText.setText(db[getSelectedFilm()].getActorsString());
                    headsUplbl.setText("Selected film : " + (getSelectedFilm() + 1) + " / " + getFilmsStored());
                }
            }
        });
        //изменить
        update.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //ID пользователю менять не даём. Все остальные данные берем из полей слева.
                db[getSelectedFilm()].setImdbRating(Double.valueOf(imdbText.getText()));
                db[getSelectedFilm()].setName(nameText.getText());
                db[getSelectedFilm()].setGenres(genresText.getText().split(", |.$"));
                String[] dateString = dateText.getText().split("/");
                int[] newDatearr = {Integer.valueOf(dateString[0]), Integer.valueOf(dateString[1]), Integer.valueOf(dateString[2])};
                Date date = new Date();
                date.setYear(newDatearr[0] - 1900);
                date.setMonth(newDatearr[1] - 1);
                date.setDate(newDatearr[2]);
                db[getSelectedFilm()].setReleaseDate(date);
                String[] newActors = actorsText.getText().split(", |.$");
                Actor[] newActorsArray = new Actor[newActors.length];
                for (int i = 0; i < newActors.length; i++) {
                    newActorsArray[i] = new Actor(0, "");
                }
                db[getSelectedFilm()].setActors(newActorsArray);
                boolean isNew;
                for (int n = 0; n < newActors.length; n++) {
                    isNew = true;
                    int a = 1;
                    for (int i = 0; i < getFilmsStored(); i++) {
                        for (int j = 0; j < db[i].getActors().length; j++) {
                            a++;
                            if (db[i].getActors()[j].getName().equals(newActors[n])) {
                                newActorsArray[n] = db[i].getActors()[j];
                                isNew = false;
                            }
                        }
                    }
                    if (isNew) {
                        newActorsArray[n] = new Actor(a, newActors[n]);
                    }
                }
                db[getSelectedFilm()].setActors(newActorsArray);
                uidText.setText(String.valueOf(db[getSelectedFilm()].getId()));
                imdbText.setText(String.valueOf(db[getSelectedFilm()].getImdbRating()));
                nameText.setText(db[getSelectedFilm()].getName());
                genresText.setText(db[getSelectedFilm()].getGenresString());
                dateText.setText(db[getSelectedFilm()].getReleaseDate().getYear() + 1900 + "/" +
                        (db[getSelectedFilm()].getReleaseDate().getMonth() + 1) + "/" + db[getSelectedFilm()].getReleaseDate().getDate());
                actorsText.setText(db[getSelectedFilm()].getActorsString());
                headsUplbl.setText("Updated film : " + (getSelectedFilm() + 1));
            }
        });
        //удалить фильм (с полями и лейблами)
        remove.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (getFilmsStored() > 1) {
                    int a = selectedFilm;
                    for (int i = 0; i < (getFilmsStored() - getSelectedFilm() - 1); i++) {
                        db[getSelectedFilm() + i] = db[getSelectedFilm() + i + 1];
                    }
                    db[filmsStored - 1] = null;
                    filmsStored = filmsStored - 1;
                    if (getSelectedFilm() == 0) {
                        setSelectedFilm(getFilmsStored() - 1);
                    } else {
                        setSelectedFilm(getSelectedFilm() - 1);
                    }
                    uidText.setText(String.valueOf(db[getSelectedFilm()].getId()));
                    imdbText.setText(String.valueOf(db[getSelectedFilm()].getImdbRating()));
                    nameText.setText(db[getSelectedFilm()].getName());
                    genresText.setText(db[getSelectedFilm()].getGenresString());
                    dateText.setText(db[getSelectedFilm()].getReleaseDate().getYear() + 1900 + "/" +
                            (db[getSelectedFilm()].getReleaseDate().getMonth() + 1) + "/" + db[getSelectedFilm()].getReleaseDate().getDate());
                    actorsText.setText(db[getSelectedFilm()].getActorsString());
                    headsUplbl.setText("Removed film : " + (a + 1));
                }
            }
        });

        //добавить поиск по полям
        search.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String result = "";
                int a = 0;
                for (int i = 0; i < filmsStored; i++) {
                    if (db[i].getName().toLowerCase().startsWith(searchText.getText().toLowerCase())) {
                        result += db[i].getId() + " : " + db[i].getName() + "; ";
                        a++;
                    }
                }
                searchResultText.setText(result);
                headsUplbl.setText(a + " result(s) found.");
            }
        });
        setVisible(true);
    }

    private void boarding(Component... components) {
        for (Component component : components) {
            add(component);
        }
    }
}

class Register extends JFrame {

    private static Account[] accounts = new Account[5];
    private int accountCounter;
    private String currentCode = "";
    public void setCurrentCode(String currentCode) {
        this.currentCode = currentCode;
    }

    public String getCurrentCode() {
        return currentCode;
    }

    public int getAccountCounter() {
        return accountCounter;
    }

    public void setAccountCounter(int accountCounter) {
        this.accountCounter = accountCounter;
    }

    static {
        Account account1 = new Account(1, "Admin", "1", "Chaplain04@gmail.com");
        accounts[0] = account1;
    }

    public void sendMail(String to, String subject, String text) {
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
        try {
            Session session = Session.getDefaultInstance(props,
                    new Authenticator() {
                        protected PasswordAuthentication getPasswordAuthentication() {
                            return new PasswordAuthentication(username, password);
                        }
                    });
            Message msg = new MimeMessage(session);
            msg.setFrom(new InternetAddress("Chaplain04@gmail.com"));
            msg.setRecipients(Message.RecipientType.TO,
                    InternetAddress.parse(to, false));
            msg.setSubject(subject);
            msg.setText(text);
            msg.setSentDate(new Date());
            Transport.send(msg);
            System.out.println("Message sent.");
        } catch (MessagingException e) {
            System.out.println("Cause: " + e);
        }
    }

    public Register() {
        setTitle("FilmApp Launcher");
        setLayout(null);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setSize(600, 600);
        JLabel loginlbl = new JLabel("Login : ");
        JLabel passwordlbl = new JLabel("Password : ");
        JLabel repeatpasswordlbl = new JLabel("Repeat password : ");
        JLabel emaillbl = new JLabel("Email : ");
        JLabel headsuplbl = new JLabel("Login / Register");
        JLabel secretlabel = new JLabel("Secret code");

        JTextField loginText = new JTextField();
        JPasswordField passwordText = new JPasswordField();
        JPasswordField repeatText = new JPasswordField();
        JTextField emailText = new JTextField();
        JTextField secretText = new JTextField("");

        JButton login = new JButton("Log in");
        JButton register = new JButton("Register");
        JButton forgotPassword = new JButton("Forgot my PW");
        JButton confirm = new JButton("Confirm");

        loginlbl.setBounds(20, 45, 120, 20);
        passwordlbl.setBounds(20, 65, 120, 20);
        repeatpasswordlbl.setBounds(20, 85, 120, 20);
        emaillbl.setBounds(20, 105, 120, 20);
        headsuplbl.setBounds(80, 25, 120, 20);
        secretlabel.setBounds(20, 125, 120, 20);

        loginText.setBounds(160, 45, 120, 20);
        passwordText.setBounds(160, 65, 120, 20);
        repeatText.setBounds(160, 85, 120, 20);
        emailText.setBounds(160, 105, 120, 20);
        secretText.setBounds(160, 125, 120, 20);

        login.setBounds(20, 145, 120, 20);
        forgotPassword.setBounds(160, 145, 120, 20);
        register.setBounds(20, 165, 120, 20);
        confirm.setBounds(160, 165, 120, 20);


        confirm.setVisible(false);
        emaillbl.setVisible(false);
        emailText.setVisible(false);
        repeatpasswordlbl.setVisible(false);
        repeatText.setVisible(false);
        secretText.setVisible(false);
        secretlabel.setVisible(false);
        confirm.setVisible(false);

        login.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                for (int i = 0; accounts[i] != null && i < accounts.length; i++) {
                    if (loginText.getText().equals(accounts[i].getLogin())) {
                        if (passwordText.getText().equals(accounts[i].getPassword())) {
                            FilmsApp filmsApp = new FilmsApp();
                            setVisible(false);
                        } else headsuplbl.setText("Wrong password");
                    } else {
                        headsuplbl.setText("No such account");
                    }
                }
            }
        });

        forgotPassword.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                for (int i = 0; accounts[i] != null && i < accounts.length; i++) {
                    if (loginText.getText().equals(accounts[i].getLogin())) {
                        String newPassword = "";
                        for (int j = 0; j < 10; j++) {
                            newPassword += (char) ((int) (Math.random() * 93) + 33);
                        }
                        accounts[i].setPassword(newPassword);
                        sendMail(accounts[i].getEmail(), "Your new password", "Your new password is: " + newPassword);
                    } else {
                        headsuplbl.setText("No such account");
                    }
                }
            }
        });

        register.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                confirm.setVisible(true);
                emaillbl.setVisible(true);
                emailText.setVisible(true);
                repeatpasswordlbl.setVisible(true);
                repeatText.setVisible(true);
                login.setVisible(false);
                forgotPassword.setVisible(false);
                register.setVisible(false);
            }
        });

        confirm.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String secretCode = "";
                for (int j = 0; j < 10; j++) {
                    secretCode += (char) ((int) (Math.random() * 93) + 33);
                }
                if (secretText.getText().equals("")) {
                    for (int i = 0; accounts[i] != null && i < accounts.length; i++) {
                        if (loginText.getText().equals(accounts[i].getLogin()) || emailText.getText().equals(accounts[i].getEmail())) {
                            headsuplbl.setText("Existing account");
                        } else if (!(passwordText.getText().equals(repeatText.getText()))) {
                            headsuplbl.setText("Wrong password");
                        } else {
                            secretlabel.setVisible(true);
                            secretText.setVisible(true);
                            sendMail(emailText.getText(), "Secret code", "Input this secret code in designated launcher field: " + secretCode);
                            setCurrentCode(secretCode);
                        }
                    }
                } else if (secretText.getText().equals(getCurrentCode())) {
                    for (int j = 0; j < accounts.length; j++) {
                        if (accounts[j] == null) {
                            accounts[j] = new Account(j, loginText.getText(), passwordText.getText(), emailText.getText());
                        }
                    }
                    headsuplbl.setText("Account created");
                    emaillbl.setVisible(false);
                    emailText.setVisible(false);
                    repeatpasswordlbl.setVisible(false);
                    repeatText.setVisible(false);
                    login.setVisible(true);
                    forgotPassword.setVisible(true);
                    register.setVisible(true);
                    secretText.setVisible(false);
                    secretlabel.setVisible(false);
                    confirm.setVisible(false);
                } else {
                    secretText.setText("");
                    headsuplbl.setText("Wrong code");
                    emaillbl.setVisible(false);
                    emailText.setVisible(false);
                    repeatpasswordlbl.setVisible(false);
                    repeatText.setVisible(false);
                    login.setVisible(true);
                    forgotPassword.setVisible(true);
                    register.setVisible(true);
                    secretText.setVisible(false);
                    secretlabel.setVisible(false);
                    confirm.setVisible(false);
                }

            }
        });



        boarding(confirm, loginlbl, loginText, passwordlbl, passwordText, repeatText, repeatpasswordlbl, emailText, emaillbl,
                login, register, forgotPassword, headsuplbl, secretlabel, secretText);

        setVisible(true);
    }

    private void boarding(Component... components) {
        for (Component component : components) {
            add(component);
        }
    }
}

class Film {
    private long id;
    private String name;
    private String[] genres;
    private double imdbRating;
    private Date releaseDate;
    private Actor[] actors;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String[] getGenres() {
        return genres;
    }

    public void setGenres(String[] genres) {
        this.genres = genres;
    }

    public double getImdbRating() {
        return imdbRating;
    }

    public void setImdbRating(double imdbRating) {
        this.imdbRating = imdbRating;
    }

    public Date getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(Date releaseDate) {
        this.releaseDate = releaseDate;
    }

    public Actor[] getActors() {
        return actors;
    }

    public String getActorsString() {
        String actorsString = "";
        for (Actor actor : actors) {
            actorsString += actor.getName() + ", ";
        }
        actorsString = actorsString.replaceFirst(", $", ".");
        return actorsString;
    }

    public String getGenresString() {
        String genresString = "";
        for (String string : genres) {
            genresString += string + ", ";
        }
        genresString = genresString.replaceFirst(", $", ".");
        return genresString;
    }

    public void setActors(Actor[] actors) {
        this.actors = actors;
    }

    public Film(long id, String name, String[] genres, double imdbRating, Date releaseDate, Actor[] actors) {
        this.id = id;
        this.name = name;
        this.genres = genres;
        this.imdbRating = imdbRating;
        this.releaseDate = releaseDate;
        this.actors = actors;
    }
}

class Account {
    private long id;
    private String login;
    private String password;
    private String email;
    private String secretCode;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSecretCode() {
        return secretCode;
    }

    public void setSecretCode(String secretCode) {
        this.secretCode = secretCode;
    }

    public Account(long id, String login, String password, String email) {
        this.id = id;
        this.login = login;
        this.password = password;
        this.email = email;
    }
}

class Actor {
    private long id;
    private String name;

    @Override
    public String toString() {
        return id + " : " + name;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Actor(long id, String name) {
        this.id = id;
        this.name = name;
    }
}

class User {

    public static void main(String[] args) {
        Register register = new Register();
    }
}