package ru.gb.java1;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        //В теории работает с любым размером поля
        //после размера 4, ищет 4 совпадения подряд
        //startGame(3);
        //startGame(4);
        startGame(5);

    }

    public static void  startGame(int sizeOfField) {
        //модель 0 - пустое поле, 1 - занято первым игроком, 2 - занятов вторым играком
        byte[][] gameField = new byte [sizeOfField][sizeOfField];

        Scanner sc = new Scanner(System.in);
        System.out.println("Играем в крестики-нолики!");
        int whoIsWin = 0;
        while(true) {
            printGameField(gameField);
            doPlayerMove(gameField, sc);
            if (isDraw(gameField)) {
                System.out.println("Поле заполнено, ничья!");
                break;
            }
            whoIsWin = whoIsWin5CellsOrMore(gameField);
            if (whoIsWin == 1) {
                System.out.println("Ты победил!");
                break;
            }
            doAiMove(gameField);
            if (isDraw(gameField)) {
                System.out.println("Поле заполнено, ничья!");
                break;
            }
            whoIsWin = whoIsWin5CellsOrMore(gameField);
            if (whoIsWin == 2) {
                System.out.println("Победил AI!");
                break;
            }
        }
        sc.close();
    }

    //проверка выйграл ли кто-нибудь
    // если поле свыше 4 клеток для победы нужны 4 занятые клетки подряд
    //0 - никто не победил, 1 - игрок, 2 - комп
    static int whoIsWin5CellsOrMore(byte[][] field) {
        //Метод сдвига окна, по аналогии с БПФ
        //берем все "подквадраты" 4 на 4 и перебираем
        //Хочется взять "подмассив" и сделать рекурсию, like in Perl..
        //Можно заморочиться с arraycopy, но мы идем путем языка СИ
        //ПОЛЕ СТРОГО КВАДРАТНОЕ!
        //сдвиг окна
        int windowShift = 0;
        if (field.length > 4)
            windowShift = field.length - 4;
        //Максимальный поиск по массиву
        int size = Math.min(field.length, 4);

        for (int winX = 0; winX <= windowShift; winX++) {
            for (int winY = 0; winY <= windowShift; winY++) {
                //берем подквадрат и проверяем в нем все
                //проверяем горизонтали
                for (int i = 0; i < size; i++) {
                    boolean full = true;
                    for (int j = 0; j< size; j++) {
                        if (field[winX + i][winY] == 0 || field[winX + i][winY] != field[winX + i][winY + j]) {
                            full = false;
                            break;
                        }
                    }
                    if (full) return field[winX + i][winY];
                }

                //проверяем вертикали
                for (int i = 0; i < size; i++) {
                    boolean full = true;
                    for (int j = 0; j < size; j++) {
                        if (field[winX][winY + i] == 0 || field[winX][winY + i] != field[winX + j][winY + i]) {
                            full = false;
                            break;
                        }
                    }
                    if (full) return field[winX][winY + i];
                }

                //проверяем диагональ слева - направо
                boolean diagon = true;
                for (int i = 0; i < size; i++) {
                    if (field[winX][winY] == 0 || field[winX][winY] != field[winX + i][winY + i]) {
                        diagon = false;
                    }
                }
                if (diagon) return field[winX][winY];
                //проверяем диагональ справа-налево
                diagon = true;
                for (int i = 0; i < size; i++) {
                    if (field[winX][winY + size - 1] == 0 || field[winX][winY + size - 1] != field[winX + i][winY + size - 1 - i]) {
                        diagon = false;
                    }
                }
                if (diagon) return field[winX][winY + size - 1];
            }
        }


        return 0;
    }




    static void doPlayerMove(byte[][] field, Scanner sc) {
        int h = -1, v = -1;
        boolean notCorrectDot = true;
        do {
           System.out.println("H - координата");
           h = getCoordinate(sc, field.length);
           System.out.println("V - координата");
           v = getCoordinate(sc, field[0].length);
           if (!isEmptyDot(field, h, v)){
               System.out.println("Клетка занята!");
           } else {
               notCorrectDot = false;
           }
        } while (notCorrectDot);
        field[h][v] = 1;
    }

    static boolean isEmptyDot(byte[][] field, int h, int v) {
        return field[h][v] == 0;
    }

    static void doAiMove(byte[][] field) {
        int h = -1, v = -1;
        do {
            h = generateRandomInt(0, field.length - 1);
            //а вдруг поле не квадратное?...
            v = generateRandomInt(0, field[0].length - 1);
        } while (!isEmptyDot(field, h, v));
        field[h][v] = 2;
    }

    //заполнено поле или нет?
    static boolean isDraw(byte[][] field) {
        for (int i = 0; i < field.length; i++){
            //вот это field[i].length можно не делать, ибо квадратное поле, но пусть будет
            for (int j = 0; j < field[i].length; j++){
                if (field[i][j] == 0) {
                    return false;
                }
            }
        }
        return true;
    }

    // вспомогательный метод, генерит случайное число в диапазоне
    // [min, max]
    static int generateRandomInt( int min, int max) {
        return (int) (Math.random()*((max-min)+1))+min;
    }


    static int getCoordinate(Scanner sc, int size) {
        int cord = -1;
        do {
            System.out.println("Введите координату хода");
            cord = sc.nextInt() - 1;
        } while (cord < 0 || cord >= size);
        return cord;
    }
    static void printGameField(byte[][] gameField) {
        System.out.print("\n  ");
        //рисуем верхние координаты
        for (int i = 0; i < gameField.length; i++) {
            System.out.print((i+1) + " ");
        }
        System.out.println(" ");
        for (int i = 0; i < gameField.length; i++) {
            System.out.print((i+1) + " ");
            for (int j = 0; j < gameField[i].length; j++) {
                if (gameField[i][j] == 0) {
                    System.out.print("- ");
                } else if (gameField[i][j] == 1){
                    System.out.print("X ");
                } else {
                    System.out.print("O ");
                }
            }
            System.out.print("\n");
        }
    }
}
