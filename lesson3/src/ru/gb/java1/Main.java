package ru.gb.java1;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        //Запускать надо по отдельности, если подряд, то падает из-за консоли
        // почему не понял
        //   System.out.println("Первая игра!");
        //   doTaskOne();
        System.out.println("Вторая игра!");
	    doTask2();
    }
    static void doTaskOne() {
        //кол-во попыток
        int times = 3;
        System.out.println("Начинаем игру!");
        Scanner sc = new Scanner(System.in);
        playFirstGame(sc, times);
        sc.close();
}

    static void playFirstGame(Scanner sc, int count) {
        int number = generateRandomInt(0,9);
        boolean win = false;
        System.out.printf("DEBUG: %d \n",number);
        System.out.println("Я загадал число, посмотрим, угадаешь ли его ты :-) ");
        System.out.println("у тебя есть 3 попытки, жду от тебя число:");
        for (int i = 0; i < count; i++) {
            int num = sc.nextInt();
            if (num == number) {
                win = true;
                break;
            } else {
                String message = (number > num) ? "Загаданное число больше!" : "Загаданное число меньше!";
                System.out.println(message);
            }
        }
        if (win) {
            System.out.println("Ты победил!");
        } else {
            System.out.println("Ты проиграл!");
        }
        //Ну вот тут, чтобы ввод был корректным
        //цикл можно убрать, но тогда игра будет заканчиваться по вводу 0,
        // а при всем остальном повторяться заново
        while (true) {
            System.out.println("Повторить игру еще раз? 1 – да / 0 – нет");
            int choose = sc.nextInt();
            if (choose == 0) {
                System.out.println("Как жаль...");
                break;
            } else if (choose == 1) {
                System.out.println("Играем еще раз!");
                playFirstGame(sc, count);
                break;
            }
        }
    }

// вспомогательный метод, генерит случайное число в диапазоне
// [max, min]
    static int generateRandomInt( int max, int min) {
       return (int) (Math.random()*((max-min)+1))+min;
    }

    static void doTask2 () {
        String[] words = {"apple", "orange", "lemon", "banana", "apricot", "avocado", "broccoli", "carrot",
                "cherry", "garlic", "grape", "melon", "leak", "kiwi", "mango", "mushroom", "nut", "olive",
                "pea", "peanut", "pear", "pepper", "pineapple", "pumpkin", "potato"};
        System.out.println("Я загадал слово, угадай его!");
        int remember = generateRandomInt(0, words.length);
        System.out.printf("DEBUG: %s \n", words[remember]);
        //Чтоб не таскать за собой "хвост" words[remember]
        //Для сокращенной записи
        String remWord = words[remember];
        Scanner sc = new Scanner(System.in);
        //переводим в нижний регистр, не заморачиваемся
        remWord.toLowerCase();
//        МОЖНО СДЕЛАТЬ ВОТ ТАК:
//        boolean play = true;
//        do {
//           ...
//            play = false;
//        } while (play)
        while(true) {
            System.out.println("Введи слово:");
            String enterWord = sc.nextLine();
            if (enterWord.equals(words[remember])) {
                System.out.println("Вы угадали слово!");
                break;
            } else {
                System.out.println("Не угадал! Подсказка:");
                String hint = "";
                for (int i = 0; i < Math.min (enterWord.length(), remWord.length()); i++) {
                    if (enterWord.charAt(i) == remWord.charAt(i) ) {
                        hint += enterWord.charAt(i);
                    } else {
                        break;
                    }
                }
                hint = hint.concat("###############").substring(0, 15);
                System.out.println(hint);
            }
        }
        sc.close();
    }
}
