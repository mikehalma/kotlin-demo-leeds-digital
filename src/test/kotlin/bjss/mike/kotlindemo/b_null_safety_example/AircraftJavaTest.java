package bjss.mike.kotlindemo.b_null_safety_example;

import bjss.mike.kotlindemo.examples.a_data_class_example.EngineJava;
import bjss.mike.kotlindemo.examples.b_null_safety_example.AircraftJava;
import org.junit.Test;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

public class AircraftJavaTest {

    @Test
    public void nullable_exists() {
        EngineJava engine = new EngineJava(1, 1000, "Small Engine");
        AircraftJava aircraftWithEngine = new AircraftJava(2, engine, "Aircraft with engine");

        Optional<EngineJava> existingEngine = aircraftWithEngine.getEngine();

        EngineJava testEngine = null;
        if (existingEngine.isPresent()) {
            testEngine = existingEngine.get();
        }

        assertThat(testEngine).isEqualTo(engine);
    }

    @Test
    public void nullable_missing() {
        AircraftJava aircraftWithoutEngine = new AircraftJava(3, "Useless aircraft");

        Optional<EngineJava> nonexistingEngine = aircraftWithoutEngine.getEngine();

        EngineJava testEngine = null;
        if (nonexistingEngine.isPresent()) {
            testEngine = nonexistingEngine.get(); // this code is not run
        }

        assertThat(testEngine).isNull();
    }
}
