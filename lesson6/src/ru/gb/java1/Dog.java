package ru.gb.java1;

public class Dog extends Animal {

    public Dog(String name) {
        // У каждого животного есть ограничения на действия (бег: кот 200 м., собака 500 м.;
        // плавание: кот не умеет плавать, собака 10 м.).
        super(name, 500 , 10);
    }

    @Override
    void run(int distance) {
        if (distance <= super.getPowerRun()) {
            System.out.printf("Собака %s пробежала %d!\n", super.getName(), distance);
        } else {
            System.out.printf("Собака не может пробежать %d за один раз!\n", distance);
        }
    }

    @Override
    void swim(int distance) {
        if (distance <= super.getPowerSwim()) {
            System.out.printf("%s проплыла %d!\n", super.getName(), distance);
        } else {
            System.out.printf("Собака не может проплыть %d за один раз!\n", distance);
        }

    }
}
