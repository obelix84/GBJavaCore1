package ru.gb.java1;

public class Plate {
    private final int capacity;
    private int food;

    //будем считать, что все тарелки разного размера
    public Plate(int capacity) {
        this.capacity = capacity;
        this.food = capacity;
    }

    public int getCapacity() {
        return capacity;
    }

    public boolean decrease(int amount) {
        if (amount <= food) {
            food -= amount;
            return true;
        }
        return false;
    }

    public void fill(int amount) {
        food = Math.min(food + amount, capacity);
    }

    @Override
    public String toString() {
        return "Plate{" +
                "capacity=" + capacity +
                ", food=" + food +
                '}';
    }
}
