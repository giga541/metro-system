package main.java.com.example.metro.model;

public abstract class Vehicle {

    protected String model;
    protected Speed speed;

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

//    public Speed getSpeed() {
//        return speed;
//    }

    public abstract String getType();
}