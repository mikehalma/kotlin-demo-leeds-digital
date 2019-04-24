package bjss.mike.kotlindemo.examples.h_immutable_collections_example;

import bjss.mike.kotlindemo.examples.a_data_class_example.EngineJava;
import bjss.mike.kotlindemo.examples.b_null_safety_example.AircraftJava;

import java.util.List;

public class AircraftHangarJava {

    private List<AircraftJava> allAircraft;

    public AircraftHangarJava(List<AircraftJava> allAircraft) {
        this.allAircraft = allAircraft;
    }

    public List<AircraftJava> getAllAircraft() {
        return allAircraft;
    }
}
