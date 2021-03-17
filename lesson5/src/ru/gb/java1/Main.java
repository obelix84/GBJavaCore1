package ru.gb.java1;

public class Main {

    public static void main(String[] args) {
	    Employee[] persons = new Employee[5];
	    persons[0] = new Employee("Иванов Иван", "сантехник", "iivanov@mail.ru", "+712345678",
                100_000, 55);
        persons[1] = new Employee("Петров Петр", "продавец", "ppetrov@mail.ru", "+723456781",
                200_000, 40);
        persons[2] = new Employee("Сергеев Сергей", "менеджер", "ssergeev@mail.ru", "+734567812",
                300_000, 60);
        persons[3] = new Employee("Дмитриев Дмитрий", "администратор", "ddmitriev@mail.ru", "+745678123",
                400_000, 41);
        persons[4] = new Employee("Андреев Андрей", "программист", "aandreev@mail.ru", "+756781234",
                500_000, 35);

//        5. С помощью цикла вывести информацию только о сотрудниках старше 40 лет.
        for (int i = 0; i < persons.length; i++) {
            if (persons[i].getAge() > 40) {
                persons[i].printData();
            }
        }

    }
}
