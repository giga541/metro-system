public class Speed {
    private int trainSpeed;
    private String trainModel;

    Speed(String trainModel, int trainSpeed){
        this.trainSpeed = trainSpeed;
        this.trainModel = trainModel;
    }

    int getTrainSpeed(){
        return this.trainSpeed;
    }

    // making it accessable and readable for Main class
    String getTrainModel(){
        return this.trainModel;
    }

    // setting speed to change speed from Main class
    void setSpeed(int trainSpeed){
        this.trainSpeed = trainSpeed;
    }
}
