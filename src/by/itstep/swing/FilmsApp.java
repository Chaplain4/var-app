package by.itstep.swing;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.util.Calendar;
import java.util.Date;

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
        FilmsApp filmsApp = new FilmsApp();
        Register register = new Register();
    }
}