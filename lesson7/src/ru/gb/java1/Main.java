package ru.gb.java1;

/**
 * 1. Расширить задачу про котов и тарелки с едой.
 * 2. Сделать так, чтобы в тарелке с едой не могло получиться отрицательного количества еды
 * (например, в миске 10 еды, а кот пытается покушать 15-20).
 * 3. Каждому коту нужно добавить поле сытость (когда создаем котов, они голодны).
 * Если коту удалось покушать (хватило еды), сытость = true.
 * 4. Считаем, что если коту мало еды в тарелке, то он её просто не трогает, то есть не может быть
 * наполовину сыт (это сделано для упрощения логики программы).
 * 5. Создать массив котов и тарелку с едой, попросить всех котов покушать из этой тарелки и потом
 * вывести информацию о сытости котов в консоль.
 * 6. Добавить в тарелку метод, с помощью которого можно было бы добавлять еду в тарелку.
 */

public class Main {

    public static void main(String[] args) {
	    Cat[] cats = {
	            new Cat("Cat1", 10),
	            new Cat("Cat2", 15),
	            new Cat("Cat3", 20),
        };

        Plate plate = new Plate(25);

        for (int i = 0; i < cats.length; i++) {
            System.out.printf("\nКот %s -------------\n", cats[i].getName());
            System.out.println("Кот до кормления: " + cats[i]);
            System.out.println("Состояние тарелки: " + plate);
            cats[i].eat(plate);
            System.out.println("Кот после кормления: " + cats[i]);
            System.out.println("Состояние тарелки: " + plate);
        }
        System.out.printf("\nПоследний кот остался голодным, заполняем тарелку \n");
        plate.fill(10);
        System.out.println("Состояние тарелки: " + plate);
        plate.fill(10);
        System.out.println("Состояние тарелки: " + plate);
        plate.fill(30);
        System.out.println("Состояние тарелки: " + plate);

        cats[2].eat(plate);
        System.out.println("Кот после кормления: " + cats[2]);
        System.out.println("Состояние тарелки: " + plate);

        System.out.printf("\nПопытаемся накормить не голодного кота \n");
        System.out.println("Кот до кормления: " + cats[2]);
        System.out.println("Состояние тарелки: " + plate);
        cats[2].eat(plate);
        System.out.printf("\nСделаем кота голодным и еще раз, тарелку заполним \n");
        cats[2].setFull(false);
        plate.fill(100);
        System.out.println("Кот до кормления: " + cats[2]);
        System.out.println("Состояние тарелки: " + plate);
        cats[2].eat(plate);
        System.out.println("Кот после кормления: " + cats[2]);
        System.out.println("Состояние тарелки: " + plate);


    }
}
