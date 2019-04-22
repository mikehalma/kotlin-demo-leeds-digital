package bjss.joehonour.kotlindemo.examples.b_null_safety_example;

import bjss.joehonour.kotlindemo.examples.a_data_class_example.Aircraft;
import bjss.joehonour.kotlindemo.examples.a_data_class_example.Engine;

import java.util.Optional;

public class NullSafetyJava {

    public static Long getEngineIdOrNull(Aircraft aircraft) {
        return Optional.ofNullable(aircraft.getEngineType())
                .map(Engine::getId)
                .orElse(null);
    }

    public static long getEngineId(Aircraft aircraft) {
        return aircraft.getEngineType().getId();
    }

    public static long getEngineIdOrDefault(Aircraft aircraft) {
        return Optional.ofNullable(aircraft.getEngineType())
                .map(Engine::getId)
                .orElse(0L);
    }
}
