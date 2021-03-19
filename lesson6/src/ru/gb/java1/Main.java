package ru.gb.java1;

public class Main {

    public static void main(String[] args) {
        Animal[] A = {
                new Dog("Бобик"),
                new Cat("Мурзик"),
                new Dog("Шарик"),
                new Cat("Барсик1"),
                new Cat("Барсик2"),
                new Cat("Барсик3")
        };

        for (int i = 0; i < A.length; i++) {
            A[i].run(150);
            A[i].swim(15);
        }
        //Кол-во созданных животных
        A[0].printCount();
    }
}
