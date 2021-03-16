package ru.gb.java1;

//1. Создать класс "Сотрудник" с полями: ФИО, должность,
//        email, телефон, зарплата, возраст.
public class Employee {
    private String name;
    private String position;
    private String email;
    private String phone;
    private int salary;
    private int age;

    public Employee(String name, String position, String email, String phone, int salary, int age) {
        this.name = name;
        this.position = position;
        this.email = email;
        this.phone = phone;
        this.salary = salary;
        this.age = age;
    }

//    3. Внутри класса «Сотрудник» написать метод, который выводит информацию об объекте в консоль.
    public void printData() {
        System.out.printf("Сотрудник:\n %s, возраст: %d, должность: %s, зарплата: %d\n", this.name, this.age, this.position, this.salary);
        System.out.printf("Контактные данные:\n e-mail: %s, телефон: %s\n\n", this.email, this.phone);

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
