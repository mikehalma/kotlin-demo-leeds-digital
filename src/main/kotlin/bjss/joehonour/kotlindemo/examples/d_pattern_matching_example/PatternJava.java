package bjss.joehonour.kotlindemo.examples.d_pattern_matching_example;

import java.util.List;

public class PatternJava {

    // could also use visitor pattern here, but we dont own the objects to do that
    public static int countTotalSored(List<StorageUnit> matchOn) {
        int total = 0;

        for (StorageUnit unit : matchOn) {
            if (unit instanceof AircraftHangar) {
                total += ((AircraftHangar) unit).getAircraft().size();
            }
            if(unit instanceof VehicleDepo) {
                total += ((VehicleDepo) unit).getNumberOfFuelingTrucks();
            }
        }

        return total;
    }
}