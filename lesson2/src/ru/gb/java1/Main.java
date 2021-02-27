package ru.gb.java1;

public class Main {

    public static void main(String[] args) {
        // 1 задание
        System.out.println("Task 1:");
        doTask1();
        // 2 задание
        System.out.println("Task 2:");
        doTask2(8);
        // 3 задание
        System.out.println("Task 3:");
        doTask3();
        // 4 задание
        System.out.println("Task 4:");
        doTask4(7);
        // 5 задание
        System.out.println("Task 5:");
        doTask5();
        // 6 задание
        System.out.println("Task 6:");
        doTask6();
        // 7 задание
        System.out.println("Task 7:");
        doTask7();
    }

    // вспомогательные методы
    static void printIntArray(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println(" !");
    }
    // заполнение массива случаными числами в диапазоне
    static void fillIntArray(int[] arr, int max, int min) {
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (int) (Math.random()*((max-min)+1))+min;
        }
    }

        //    1. Задать целочисленный массив, состоящий из элементов 0 и 1. Например: [ 1, 1, 0, 0, 1, 0, 1, 1, 0, 0 ].
//    С помощью цикла и условия заменить 0 на 1, 1 на 0;
    static void doTask1() {
        //можно было циклом numbers[i] = (numbers[i] + 1 ) % 2
        //но написано надо условием
        int[] numbers = {1, 1, 0, 0, 1, 0, 1, 1, 0, 0};
        printIntArray(numbers);
        for (int i = 0; i < numbers.length; i++) {
            switch (numbers[i]) {
                case 1:
                    numbers[i] = 0;
                    break;
                case 0:
                    numbers[i] = 1;
                    break;
            }
        }
        printIntArray(numbers);

    }

    //    2. Задать пустой целочисленный массив размером 8. С помощью цикла заполнить его значениями 0 3 6 9 12 15 18 21;
    static void doTask2(int length) {
        int[] numbers = new int[length];
        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = 3 * i;
        }
        printIntArray(numbers);
    }

    //  3. Задать массив [ 1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1 ] пройти по нему циклом, и
//    числа меньшие 6 умножить на 2;
    static void doTask3() {
        int[] numbers = {1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1};
        printIntArray(numbers);
        for (int i = 0; i < numbers.length; i++) {
            if (numbers[i] < 6) {
                numbers[i] *= 2;
            }
        }
        printIntArray(numbers);
    }

    //    4. Создать квадратный двумерный целочисленный массив (количество строк и столбцов одинаковое)
//    и с помощью цикла(-ов) заполнить его диагональные элементы единицами;
    static void doTask4(int len) {
        int[][] numbers = new int[len][len];
        //заполняем только диагональный эленты
        //диагональю считаем одну диагональ матрицы.. раз не сказано иначе
        for (int i = 0; i < numbers.length; i++) {
            numbers[i][i] = 1;
        }
        for (int i = 0; i < numbers.length; i++) {
            printIntArray(numbers[i]);
        }
    }
    // 5. ** Задать одномерный массив и найти в нем минимальный и максимальный элементы (без помощи интернета);
    static void doTask5() {
        int len = 10; //задаю длинну массива, для удобства не более
        int[] numbers = new int[len];
        fillIntArray(numbers, 100,0);
        printIntArray(numbers);
        int max = numbers[0];
        int min = numbers[0];
        for (int i = 0; i < numbers.length; i++) {
            if ( numbers[i] < min ) {
                min = numbers[i];
            }
            if ( numbers[i] > max ) {
                max = numbers[i];
            }
        }
        System.out.println("Min: " + min + " Max: " + max);
    }

//    6. ** Написать метод, в который передается не пустой одномерный целочисленный массив, метод должен вернуть true,
//    если в массиве есть место, в котором сумма левой и правой части массива равны.
//        Примеры: checkBalance([2, 2, 2, 1, 2, 2, || 10, 1]) → true, checkBalance([1, 1, 1, || 2, 1]) → true,
//    граница показана символами ||, эти символы в массив не входят.
    static boolean checkBalance(int [] arr) {
        int sumRight, sumLeft; //на вход целочисленный массив, отрицательные могут быть?
        for (int i = 0 ; i<arr.length-1; i++) {
            sumRight = 0;
            sumLeft = 0;
            System.out.print("index: " + i);
            for (int j = 0 ; j<=i; j++) {
                sumRight += arr[j];
            }
            System.out.print(" rightSUM: " + sumRight );
            for (int j = arr.length - 1 ; j > i; j--) {
                sumLeft += arr[j];
            }
            System.out.println(" leftSUM: " + sumLeft );
            if (sumLeft == sumRight) {
                return true;
            }
        }
        return false;
    }
    static void doTask6() {
        int[] arr = {2, 3, 2, 1, 1, 1};
        System.out.println(checkBalance(arr));
        int[] arr2 = {1,1};
        System.out.println(checkBalance(arr2));
        int[] arr3 = {};
        System.out.println(checkBalance(arr3));
        int[] arr4 = {1};
        System.out.println(checkBalance(arr4));
    }
//7. **** Написать метод, которому на вход подается одномерный массив и число n (может быть положительным, или
//            отрицательным), при этом метод должен сместить все элементы массива на n позиций.
//    Элементы смещаются циклично. Для усложнения задачи нельзя пользоваться вспомогательными массивами.
//        Примеры: [ 1, 2, 3 ] при n = 1 (на один вправо) -> [ 3, 1, 2 ]; [ 3, 5, 6, 1]
//    при n = -2 (на два влево) -> [ 6, 1, 3, 5 ].
//    При каком n в какую сторону сдвиг можете выбирать сами.

    static void shiftArray(int [] arr, int n) {
        //убираем лишние круги перестановки
        n = n % arr.length;
        if ( n < 0) {
            //переделываем минус в плюс
            n = arr.length + n % arr.length ;
        }
        for (int t = 0; t < n; t++) {
            int last = arr[arr.length - 1];
            for (int i = arr.length - 1; i > 0; i--) {
                arr[i] = arr[i - 1];
            }
            arr[0] = last;
        }
    }

    static void doTask7() {
        int len = 10; //задаю длинну массива, для удобства не более
        int[] numbers = new int[len];
        fillIntArray(numbers, 100,0);
        printIntArray(numbers);
        shiftArray(numbers, -2);
        printIntArray(numbers);
        int[] num = {0,1,2,3,4,5,6,7,8,9};
        printIntArray(num);
        shiftArray(num, 12);
        printIntArray(num);
    }
}
