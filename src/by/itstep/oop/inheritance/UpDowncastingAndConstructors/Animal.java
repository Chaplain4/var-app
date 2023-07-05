package by.itstep.oop.inheritance.UpDowncastingAndConstructors;

class Animal {
    private int age;
    private String name;

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Animal(int age, String name) {
        this.age = age;
        this.name = name;
    }

    public Animal(String name) {
        this.name = name;
    }

    public Animal() {
        this.name = "Stray";
    }

    @Override
    public String toString() {
        return "Animal{" +
                "age=" + age +
                ", name='" + name + '\'' +
                '}';
    }

    void move() {
        System.out.println(this.getClass() + " named " + this.getName() + " is now moving");
    }
}

class Cat extends Animal {

    private boolean isDead;
    private byte lives;

    public boolean isDead() {
        return isDead;
    }

    public byte getLives() {
        return lives;
    }

    public void setLives(byte lives) {
        this.lives = lives;
    }

    public Cat(int age, String name, byte lives) {
        super(age, name);
        this.lives = lives;
    }

    public Cat(String name, byte lives) {
        super(name);
        this.lives = lives;
    }

    public Cat(String name) {
        super(name);
        this.lives = 9;
    }

    public Cat() {
        this.setName("Stray Cat");
        this.lives = 9;
    }

    @Override
    void move() {
        if (!(isDead)) {
            System.out.println("Cat named " + this.getName() + " is now moving");
        }
    }

    @Override
    public String toString() {
        return "Cat{" +
                "isDead=" + isDead +
                ", lives=" + lives +
                ", age=" + getAge() +
                ", name='" + getName() + '\'' +
                "} ";
    }

    /**
     * У кота 50% шанс удрать. Если кот не удрал - пёс снимает 1 усталости, кот теряет 1 жизнь (по умолчанию 9).
     * Когда жизней не остаётся, кот погибает. Съеденного кота конструктором или сеттером создать нельзя.
     *
     * @param dog - пёс, который гонится за котом;
     */
    void runFromDog(Dog dog) {
        if (!(isDead)) {
            System.out.println("Cat named " + this.getName() + " is now running away from Dog named " + dog.getName());
            if (Math.random() < 0.5) {
                this.lives--;
                System.out.println("Unlucky! Cat named " + this.getName() + " now has " + this.getLives() + " lives left!");
                if (lives < 1) {
                    this.isDead = true;
                }
            }
        }
    }
}

class Dog extends Animal {
    private byte fatigue;
    private boolean isTired;

    public byte getFatigue() {
        return fatigue;
    }

    public void setFatigue(byte fatigue) {
        this.fatigue = fatigue;
    }

    public boolean isTired() {
        return isTired;
    }

    public Dog(int age, String name, byte fatigue) {
        super(age, name);
        this.fatigue = fatigue;
    }

    public Dog(String name, byte fatigue) {
        super(name);
        this.fatigue = fatigue;
    }

    public Dog(String name) {
        super(name);
        this.fatigue = 1;
    }

    public Dog() {
        this.setName("Stray Dog");
        this.fatigue = 1;
    }

    public void setTired(boolean tired) {
        isTired = tired;
    }

    @Override
    public String toString() {
        return "Dog{" +
                "fatigue=" + fatigue +
                ", isTired=" + isTired +
                ", age=" + getAge() +
                ", name='" + getName() + '\'' +
                "} ";
    }

    @Override
    void move() {
        if (!(isTired)) {
            System.out.println("Dog named " + this.getName() + " is now moving");
        }
    }

    /**
     * Пёс может погнаться за несъеденным котом. При этом он имеет 50% шанс увеличить усталость на 1 (по умолчанию - 1).
     * Если усталость достигла 9 - пёс измотан и перестаёт есть котов. Клиент не может измотать пса генератором.
     *
     * @param cat выбранный псом кот
     */
    void runAfterCat(Cat cat) {
        if (!(this.isTired) && (!(cat.isDead()))) {
            System.out.println("Dog named " + this.getName() + " is now running after Cat named " + cat.getName());
            if (this.getFatigue() > 0) {
                cat.runFromDog(this);
            } else if (!(cat.isDead())) {
                System.out.println("Dog named " + this.getName() + " and Cat named " + cat.getName() + "are playing together");
            }
            if (Math.random() < 0.5) {
                this.fatigue++;
                if (this.fatigue > 8) {
                    this.isTired = true;
                }
            }
        }
    }
}

class Duck extends Animal {
    private boolean isAirborne = true;

    public boolean isAirborne() {
        return isAirborne;
    }

    public Duck(int age, String name) {
        super(age, name);
    }

    public Duck(String name) {
        super(name);
    }

    public Duck() {
        this.setName("Stray Duck");
    }

    @Override
    public String toString() {
        return "Duck{" +
                ", age=" + getAge() +
                ", name='" + getName() + '\'' +
                "isAirborne=" + isAirborne +
                "} ";
    }

    @Override
    void move() {
        if (this.isAirborne) {
            System.out.println("Duck named " + this.getName() + " remains airborne");
        }
    }

    /**
     * Для летящих уток опасность представляют и коты, и недомашние псы.
     * Пока все коты не будут съедены, или пона все псы не измотаются, утка не будет приземляться.
     *
     * @param animals
     */
    void evaluate(Animal[] animals) {
        if (this.isAirborne) {
            int dogCounter = 0;
            int catCounter = 0;
            for (Animal animal : animals) {
                if (animal instanceof Dog) {
                    if (!(((Dog) animal).isTired())) {
                        dogCounter++;
                    }
                }
                if (animal instanceof Cat) {
                    if (!(((Cat) animal).isDead())) {
                        catCounter++;
                    }
                }
            }
            if ((catCounter == 0)||(dogCounter == 0)) {
                this.isAirborne = false;
                System.out.println("Duck named " + this.getName() + " has landed");
            }
        }
    }
}

class PetDog extends Dog {
    short cuteness;

    public short getCuteness() {
        return cuteness;
    }

    public void setCuteness(short cuteness) {
        this.cuteness = cuteness;
    }

    public PetDog(int age, String name, byte fatigue, short cuteness) {
        super(age, name, fatigue);
        this.cuteness = cuteness;
    }

    public PetDog(String name, byte fatigue, short cuteness) {
        super(name, fatigue);
        this.cuteness = cuteness;
    }

    public PetDog(String name, short cuteness) {
        super(name);
        this.cuteness = cuteness;
    }

    public PetDog(String name) {
        super(name);
    }

    public PetDog() {
        this.setName("Stray PetDog");
    }

    @Override
    void move() {
        if (!(isTired())) {
            System.out.println("Pet dog named " + this.getName() + " is now moving");
        }
    }

    @Override
    public String toString() {
        return "PetDog{" +
                "fatigue=" + getFatigue() +
                ", isTired=" + isTired() +
                ", age=" + getAge() +
                ", name='" + getName() + '\'' +
                "cuteness=" + cuteness +
                "} ";
    }

    /**
     * Ручная собачка не станет съедать кота, а будет играть с ним. Если кот жив - это мило. Если мёртв - не очень.
     *
     * @param cat выбранный псом кот
     */
    @Override
    void runAfterCat(Cat cat) {
        if (!(this.isTired())) {
            if (!(cat.isDead())) {
                System.out.println("Dog named " + this.getName() + " and Cat named " + cat.getName() + " are playing together");
                this.cuteness++;
            } else {
                System.out.println("Dog named " + this.getName() + " and Cat named " + cat.getName() + " are playing together");
                this.cuteness--;
            }
            if (Math.random() < 0.5) {
                this.setFatigue((byte) (getFatigue() + 1));
                if (this.getFatigue() > 8) {
                    this.setTired(true);
                }
            }
        }
    }
}

class Spaniel extends Dog {
    short fluffiness;

    public short getFluffiness() {
        return fluffiness;
    }

    public void setFluffiness(short fluffiness) {
        this.fluffiness = fluffiness;
    }

    public Spaniel(int age, String name, byte fatigue, short fluffiness) {
        super(age, name, fatigue);
        this.fluffiness = fluffiness;
    }

    public Spaniel(String name, byte fatigue, short fluffiness) {
        super(name, fatigue);
        this.fluffiness = fluffiness;
    }

    public Spaniel(String name, short fluffiness) {
        super(name);
        this.fluffiness = fluffiness;
    }

    public Spaniel(String name) {
        super(name);
    }

    public Spaniel() {
        this.setName("Stray Spaniel");
    }

    @Override
    void move() {
        if (!((isTired()) || (fluffiness > 9))) {
            System.out.println("Spaniel named " + this.getName() + " is now moving");
            this.fluffiness++;
        }
    }

    @Override
    public String toString() {
        return "PetDog{" +
                "fatigue=" + getFatigue() +
                ", isTired=" + isTired() +
                ", age=" + getAge() +
                ", name='" + getName() + '\'' +
                "fluffiness=" + fluffiness +
                "} ";
    }

    /**
     * Спаниэль - хоть и домашний, но все же охотничий пес, и не станет играть с дохлым котом.
     *
     * @param cat выбранный псом кот
     */
    @Override
    void runAfterCat(Cat cat) {
        if (!(this.isTired())) {
            if (!(cat.isDead())) {
                System.out.println("Dog named " + this.getName() + " and Cat named " + cat.getName() + " are playing together");
            }
            if (Math.random() < 0.5) {
                this.setFatigue((byte) (getFatigue() + 1));
                if (this.getFatigue() > 8) {
                    this.setTired(true);
                }
            }
        }
    }
}


class Farm {
    public static String generateCatName() {
        String[] names = {"Barsik", "Murzik", "Kisa", "Pirat", "Pushok", "Leopold", "Garfield", "Abrikos", "Knopka", "Kasper",
                "Tigr"};
        String name = names[(int) ((Math.random() * (names.length)))];
        return name;
    }

    public static String generateDogName() {
        String[] names = {"Tuzik", "Rex", "Laika", "Belka", "Muhtar", "Iskra", "Pepsi", "Zefir", "Alf", "Focus",
                "Altai"};
        String name = names[(int) ((Math.random() * (names.length)))];
        return name;
    }
    public static Animal[] randomAnimalArrayGenerator(int arrayLength) {
        Animal[] animals = new Animal[arrayLength];
        for (int a = 0, b = 0; a < animals.length; a++) {
            b = (int) ((Math.random() * 10) + 1);
            if (b < 3) {
                animals[a] = new Cat(generateCatName());
            } else if (b < 5) {
                animals[a] = new Dog(generateDogName());
            } else if (b < 7) {
                animals[a] = new PetDog(generateDogName());
            } else if (b < 9) {
                animals[a] = new Spaniel(generateDogName());
            } else {
                animals[a] = new Duck();
            }
        }
        return animals;
    }

    public static void main(String[] args) {
        Animal[] animals = randomAnimalArrayGenerator(5);
        int dogCounter = 0;
        int catCounter = 0;
        int duckCounter = 0;
        for (Animal animal : animals) {
            animal.move();
            if (animal instanceof Cat) {
                catCounter++;
            }
            if (animal instanceof Dog) {
                dogCounter++;
            }
            if (animal instanceof Duck) {
                duckCounter++;
            }
        }
        int[] catIndexes = new int[catCounter];
        int[] dogIndexes = new int[dogCounter];
        int[] duckIndexes = new int[duckCounter];
        for (int i = 0, a = 0, b = 0, c = 0; i < animals.length; i++) {
            if (animals[i] instanceof Cat) {
                catIndexes[a] = i;
                a++;
            }
            if (animals[i] instanceof Dog) {
                dogIndexes[b] = i;
                b++;
            }
            if (animals[i] instanceof Duck) {
                duckIndexes[c] = i;
                c++;
            }
        }
        boolean endCycle = false;
        while (!(endCycle)) {
            if (catCounter == 0) {
                break;
            }
            if (duckCounter == 0) {
                break;
            }
            for (Animal animal : animals) {
                if (animal instanceof Dog) {
                    ((Dog) animal).runAfterCat((Cat) animals[catIndexes[(int) ((Math.random() * (catIndexes.length)))]]);
                }
                if (animal instanceof Duck) {
                    animal.move();
                    ((Duck) animal).evaluate(animals);
                    if (!(((Duck) animal).isAirborne())) {
                        endCycle = true;
                    }
                }
            }
        }
        for (Animal animal : animals) {
            System.out.println(animal.toString());
        }
    }
}