package by.itstep.oop.inheritance;

import by.itstep.oop.Cat;

//Класс Child расширяет (наследует) класс Parent
//'IS-A' relationship. Наследник есть родитель.
public class Child extends Parent {


    //'HAS - A' relationship
    private Cat cat;

    private int iq;

    public int getIq() {
        return iq;
    }

    public void setIq(int iq) {
        this.iq = iq;
    }
    public void jump(){
        System.out.println("jumping " + getName());
    }

    public void setCat(Cat cat) {
        this.cat = cat;
    }

    public Cat getCat() {
        return cat;
    }

    //переопределение (Overriding) - способность изменить функционал, который был в базовом классе.
    //аннотация нужна чтобы выдавать ошибку если переопределение сделано неверно (сигнатуры не совпали)
    @Override
    public void sayMyName () {
        //super это ссылка на суперкласс
        super.sayMyName();
        System.out.println("My name is ****" + getName());
    }
}
