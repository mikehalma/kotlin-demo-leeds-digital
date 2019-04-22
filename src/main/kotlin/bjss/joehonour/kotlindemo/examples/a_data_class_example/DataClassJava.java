package bjss.joehonour.kotlindemo.examples.a_data_class_example;

import java.util.Objects;

public class DataClassJava {

    public final class Engine {

        private long id;
        private int size;
        private String name;

        public Engine(long id, int size, String name) {
            this.id = id;
            this.size = size;
            this.name = name;
        }

        public long getId() {
            return id;
        }

        public int getSize() {
            return size;
        }

        public String getName() {
            return name;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Engine engine = (Engine) o;
            return id == engine.id &&
                    size == engine.size &&
                    Objects.equals(name, engine.name);
        }

        @Override
        public int hashCode() {
            return Objects.hash(id, size, name);
        }
    }
}
