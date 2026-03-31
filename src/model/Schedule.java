package model;

import java.util.ArrayList;
import java.util.List;

public class Schedule {

    private List<TrainSchedule> trainSchedules = new ArrayList<>();

    public void addTrainSchedule(TrainSchedule trainSchedule) {
        trainSchedules.add(trainSchedule);
    }

    public TrainSchedule findByTrain(int trainNumber) throws exception.TrainNotFoundException {
        for (TrainSchedule ts : trainSchedules) {
            if (ts.train().getTrainNumber() == trainNumber) {
                return ts;
            }
        }
        throw new exception.TrainNotFoundException("Train " + trainNumber + " not found in schedule!");
    }

    public List<TrainSchedule> getTrainSchedules() { return trainSchedules; }
}