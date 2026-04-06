package main.java.com.example.metro.interfaces;
import main.java.com.example.metro.model.Train;

@FunctionalInterface
public interface TrainFilter {

    boolean filter(Train train);
}