package com.solvd.metro.model;

public class Container<T> {

    private T item;
    private String label;

    public Container(String label, T item) {
        this.label = label;
        this.item = item;
    }

    public T getItem() { return item; }
    public void setItem(T item) { this.item = item; }
    public String getLabel() { return label; }

    @Override
    public String toString() {
        return "Container{label=" + label + ", item=" + item + "}";
    }
}