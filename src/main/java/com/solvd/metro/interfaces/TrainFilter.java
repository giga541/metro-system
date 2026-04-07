package com.solvd.metro.interfaces;
import com.solvd.metro.model.Train;

@FunctionalInterface
public interface TrainFilter {

    boolean filter(Train train);
}