package model;

public abstract class Vehicle {

    private String model;
    private Speed speed;

    public String getModel() { return model; }
    public void setModel(String model) { this.model = model; }

    public Speed getSpeed() { return speed; }

    public abstract String getType();
}