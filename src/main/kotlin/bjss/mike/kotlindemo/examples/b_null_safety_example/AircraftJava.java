package bjss.mike.kotlindemo.examples.b_null_safety_example;

import bjss.mike.kotlindemo.examples.a_data_class_example.EngineJava;

import java.util.Optional;

public class AircraftJava {
    private final long id;
    private final Optional<EngineJava> engine;
    private final String name;

    public AircraftJava(long id, EngineJava engine, String name) {
        this.id = id;
        this.engine = Optional.ofNullable(engine);
        this.name = name;
    }

    public AircraftJava(long id, String name) {
        this.id = id;
        this.engine = Optional.empty();
        this.name = name;
    }

    public long getId() {
        return id;
    }

    public Optional<EngineJava> getEngine() {
        return engine;
    }

    public String getName() {
        return name;
    }
}
