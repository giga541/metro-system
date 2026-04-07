package com.solvd.metro.model;

import com.solvd.metro.exception.TrainNotFoundException;
import com.solvd.metro.records.TrainSchedule;

import java.util.ArrayList;
import java.util.List;

public class Schedule {

    private List<TrainSchedule> trainSchedules = new ArrayList<>();

    public void addTrainSchedule(TrainSchedule trainSchedule) {
        trainSchedules.add(trainSchedule);
    }

    public TrainSchedule findByTrain(int trainNumber) throws com.solvd.metro.exception.TrainNotFoundException {
        return trainSchedules.stream()
                .filter(ts -> ts.train().getTrainNumber() == trainNumber)
                .findFirst()
                .orElseThrow(() -> new TrainNotFoundException("Train " + trainNumber + " not found!"));
    }

    public List<TrainSchedule> getTrainSchedules() { return trainSchedules; }
}