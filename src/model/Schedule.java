package model;

import exception.TrainNotFoundException;
import records.TrainSchedule;

import java.util.ArrayList;
import java.util.List;

public class Schedule {

    private List<TrainSchedule> trainSchedules = new ArrayList<>();

    public void addTrainSchedule(TrainSchedule trainSchedule) {
        trainSchedules.add(trainSchedule);
    }

    public TrainSchedule findByTrain(int trainNumber) throws exception.TrainNotFoundException {
        return trainSchedules.stream()
                .filter(ts -> ts.train().getTrainNumber() == trainNumber)
                .findFirst()
                .orElseThrow(() -> new TrainNotFoundException("Train " + trainNumber + " not found!"));
    }

    public List<TrainSchedule> getTrainSchedules() { return trainSchedules; }
}