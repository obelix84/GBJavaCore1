package ru.gb.java1;

public abstract class Animal {
    private final String name;
    //Будем считать кол-во животных
    static int count = 0;
    //Ограничение на бег
    private final int powerRun;
    //ограничение на плавание
    private final int powerSwim;

    public Animal(String name, int powerRun, int powerSwim) {
        this.name = name;
        this.powerRun = powerRun;
        this.powerSwim = powerSwim;
        //при создании любого животного делаем увеличиваем кол-во на единицу
        count++;
    }

    void printCount() {
        System.out.println("Всего животных: " + count);
    }

    public String getName() {
        return name;
    }

    public int getPowerRun() {
        return powerRun;
    }

    public int getPowerSwim() {
        return powerSwim;
    }
    //Можно данные методы определить тут, а потом переопределить в наследниках
    //но так интереснее, сделаем их абстрактными
    abstract void run(int distance);
    abstract void swim(int distance);

}
