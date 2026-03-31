package interfaces;
import model.Train;

@FunctionalInterface
public interface TrainFilter {

    boolean filter(Train train);
}