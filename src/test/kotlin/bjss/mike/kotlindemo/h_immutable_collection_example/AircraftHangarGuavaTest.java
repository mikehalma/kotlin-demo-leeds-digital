package bjss.mike.kotlindemo.h_immutable_collection_example;

import bjss.mike.kotlindemo.examples.b_null_safety_example.AircraftJava;
import bjss.mike.kotlindemo.examples.h_immutable_collections_example.AircraftHangarGuava;
import com.google.common.collect.ImmutableList;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class AircraftHangarGuavaTest {

    private final AircraftJava aircraft1 = new AircraftJava(1, "any aircraft");
    private final AircraftJava aircraft2 = new AircraftJava(2, "another aircraft");
    private final AircraftJava aircraft3 = new AircraftJava(3, "yet another aircraft");

    @Test
    public void immutableList_stillOnlyThrowsRuntimeException_butDeprecationGiveYouAClue() {
        ImmutableList<AircraftJava> allAircraft = ImmutableList.of(aircraft1, aircraft2);
        AircraftHangarGuava aircraftHangar = new AircraftHangarGuava(allAircraft);

        assertThatThrownBy(() -> aircraftHangar.getAllAircraft().add(aircraft3))
                .isInstanceOf(UnsupportedOperationException.class);
    }


}
