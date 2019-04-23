package bjss.mike.kotlindemo.a_data_class_eample;

import bjss.mike.kotlindemo.examples.a_data_class_example.EngineJava;
import org.junit.Test;

import static org.assertj.core.api.Java6Assertions.assertThat;

public class EngineJavaTest {

    @Test
    public void requiredArgsConstructor_and_getters() {
        final EngineJava engineJava = new EngineJava(1L, 1000, "Small EngineJava");

        assertThat(engineJava.getId()).isEqualTo(1L);
        assertThat(engineJava.getSize()).isEqualTo(1000);
        assertThat(engineJava.getName()).isEqualTo("Small EngineJava");
    }

    @Test
    public void equals_and_hashcode() {
        final EngineJava engineJava = new EngineJava(1L, 1000, "Small EngineJava");
        final EngineJava engineJava2 = new EngineJava(1L, 1000, "Small EngineJava");

        assertThat(engineJava).isEqualTo(engineJava2);
        assertThat(engineJava.hashCode()).isEqualTo(engineJava2.hashCode());
    }
}
