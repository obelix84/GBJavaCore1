package ru.gb.java1;

public class Cat extends Animal{
    public Cat(String name) {
        // У каждого животного есть ограничения на действия (бег: кот 200 м., собака 500 м.;
        // плавание: кот не умеет плавать, собака 10 м.).
        super(name, 200, -1);
    }

    @Override
    void run(int distance) {
        if (distance <= super.getPowerRun()) {
            System.out.printf("Кошка %s пробежала %d!\n", super.getName(), distance);
        } else {
            System.out.printf("Кошка не может пробежать %d за один раз!\n", distance);
        }
    }

    @Override
    void swim(int distance) {
        System.out.printf("Кошки не умеют плавать!\n");
    }
}
