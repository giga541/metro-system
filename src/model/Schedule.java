package model;

public class Schedule {

    private TrainSchedule[] trainSchedules = new TrainSchedule[0];

    public void addTrainSchedule(TrainSchedule trainSchedule) {
        TrainSchedule[] newSchedules = new TrainSchedule[trainSchedules.length + 1];
        System.arraycopy(trainSchedules, 0, newSchedules, 0, trainSchedules.length);
        newSchedules[trainSchedules.length] = trainSchedule;
        trainSchedules = newSchedules;
    }

    public TrainSchedule findByTrain(int trainNumber) {
        for (int i = 0; i < trainSchedules.length; i++) {
            if (trainSchedules[i].getTrain().getTrainNumber() == trainNumber) {
                return trainSchedules[i];
            }
        }
        return null;
    }

    public TrainSchedule[] getTrainSchedules() { return trainSchedules; }
}