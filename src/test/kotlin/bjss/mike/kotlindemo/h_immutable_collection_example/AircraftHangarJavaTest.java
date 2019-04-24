package bjss.mike.kotlindemo.h_immutable_collection_example;

import bjss.mike.kotlindemo.examples.b_null_safety_example.AircraftJava;
import bjss.mike.kotlindemo.examples.h_immutable_collections_example.AircraftHangarJava;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class AircraftHangarJavaTest {

    private final AircraftJava aircraft1 = new AircraftJava(1, "any aircraft");
    private final AircraftJava aircraft2 = new AircraftJava(2, "another aircraft");
    private final AircraftJava aircraft3 = new AircraftJava(3, "yet another aircraft");

    @Test
    public void asList_isImmutable_butThrowsRuntimeExceptionOnly() {
        List<AircraftJava> allAircraft = Arrays.asList(aircraft1, aircraft2);
        AircraftHangarJava aircraftHangar = new AircraftHangarJava(allAircraft);

        assertThatThrownBy(() -> aircraftHangar.getAllAircraft().add(aircraft3))
                .isInstanceOf(UnsupportedOperationException.class);
    }

}
