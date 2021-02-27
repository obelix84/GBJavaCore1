package ru.gb.java1;

public class Main {

    public static void main(String[] args) {
        byte byteVar = 127;
        short shortVar = 32767;
        int intVar = 2^31 - 1;
        long longVar = 2000L;
        float floatVar = 123.4f;
        double doubleVar = 1234.5;
        boolean boolVar = true;
        char charVar = 'c';
        String strVar = "Какая то строка";

        double result = doAll(1.1f,2.2f,3.3f,4.4f);
        System.out.println("a * (b + (c / d)): " + result);
        int a = 5, b = 6;
        System.out.println("Sum a + b = "+ (a + b)+ " is from 10 to 20: " + isFrom10to20(a,b));
        System.out.println("Sum a + b = "+ (--a + --b)+ " is from 10 to 20: " + isFrom10to20(a,b));

        positiveOrNegative(100);
        positiveOrNegative(-100);
        positiveOrNegative(0);

        System.out.println("Negative?: " + isNegative(10));
        System.out.println("Negative?: " + isNegative(0));
        System.out.println("Negative?: " + isNegative(-10));

        helloDude("друже");

        int year = 2021;
        System.out.println(year + " is leap year?: " + isLeapYear(year));
        year = 2020;
        System.out.println(year + " is leap year?: " + isLeapYear(year));
        year = 1900;
        System.out.println(year + " is leap year?: " + isLeapYear(year));
        year = 2000;
        System.out.println(year + " is leap year?: " + isLeapYear(year));
        year = 2100;
        System.out.println(year + " is leap year?: " + isLeapYear(year));
        year = 1996;
        System.out.println(year + " is leap year?: " + isLeapYear(year));
    }

//    3. Написать метод, вычисляющий выражение a * (b + (c / d)) и возвращающий результат,
//    где a, b, c, d – аргументы этого метода, имеющие тип float.
    static double doAll(float a, float b, float c, float d){
        double v = a * (b + (c / d));
        return v;
    }
//  4. Написать метод, принимающий на вход два целых числа и проверяющий, что их сумма лежит в пределах
//  от 10 до 20 (включительно), если да – вернуть true, в противном случае – false.
    static boolean isFrom10to20(int a, int b){
        int sum = a + b;//если а и b очень большие, то нужен long, но оставим int
        return (sum >= 10 && sum <=20);
    }
//    5. Написать метод, которому в качестве параметра передается целое число, метод должен напечатать в консоль,
//    положительное ли число передали или отрицательное. Замечание: ноль считаем положительным числом.
    static void positiveOrNegative(int num) {
        if (num < 0) {
            System.out.println("Negative number!");
        } else {
            System.out.println("Positive number!");
        }
    }
//    6. Написать метод, которому в качестве параметра передается целое число. Метод должен вернуть true,
//    если число отрицательное, и вернуть false если положительное.
    static boolean isNegative(int num) {
        return (num < 0);
    }
//    7. Написать метод, которому в качестве параметра передается строка, обозначающая имя.
//    Метод должен вывести в консоль сообщение «Привет, указанное_имя!».
    static void helloDude(String name) {
        System.out.println("Привет, " + name + "!");
    }
// 8. * Написать метод, который определяет, является ли год високосным, и выводит сообщение в консоль.
//    Каждый 4-й год является високосным, кроме каждого 100-го, при этом каждый 400-й – високосный.
    static boolean isLeapYear(int year) {
        return year % 4 == 0 && year % 100 != 0 || year % 400 == 0;
    }
}
