package ru.katiafill.models;

public class Product {
    private static int nextId = 0;
    private final int id;

    public Product() {
        this.id = ++nextId;
    }

    @Override
    public String toString() {
        return "Product " + id;
    }
}
