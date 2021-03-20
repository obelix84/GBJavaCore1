package ru.gb.java1;

public class Cat {
    //имя кота
    private final String name;
    //голоден ли кот
    private boolean isFull;
    //сколько кот может съесть за раз
    private final int appetite;

    public Cat(String name, int appetite) {
        this.name = name;
        this.appetite = appetite;
    }

    public boolean isFull() {
        return isFull;
    }
    //чтоб можно было сделать кота голодным
    public void setFull(boolean full) {
        isFull = full;
    }
    //Можно вот так, лучше отражает суть - "сделать кота голодным"
    public void setHungry() {
        isFull = false;
    }

    public void eat(Plate plate) {
        if (!isFull) {
            isFull = plate.decrease(appetite);
        } else {
            System.out.printf("Кот %s не голоден!\n", name);
        }
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "Cat{" +
                "name='" + name + '\'' +
                ", isFull=" + isFull +
                ", appetite=" + appetite +
                '}';
    }
}
