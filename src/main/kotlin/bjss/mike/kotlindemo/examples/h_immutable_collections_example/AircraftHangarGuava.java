package bjss.mike.kotlindemo.examples.h_immutable_collections_example;

import bjss.mike.kotlindemo.examples.b_null_safety_example.AircraftJava;
import com.google.common.collect.ImmutableList;

public class AircraftHangarGuava {

    ImmutableList<AircraftJava> allAircraft;

    public AircraftHangarGuava(ImmutableList<AircraftJava> allAircraft) {
        this.allAircraft = allAircraft;
    }

    public ImmutableList<AircraftJava> getAllAircraft() {
        return allAircraft;
    }
}
