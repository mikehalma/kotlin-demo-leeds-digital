package bjss.mike.kotlindemo.g_delegation_example;

import bjss.mike.kotlindemo.examples.g_delegation_example.CargoWeightsJava;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class CargoWeightsJavaTest {

    @Test
    public void java_manualDelegation() {
        CargoWeightsJava cargoWeights = new CargoWeightsJava();
        cargoWeights.add(new Integer(1));
        cargoWeights.add(new Integer(1001));

        assertThat(cargoWeights.get(0)).isEqualTo(1);
        assertThat(cargoWeights.get(1)).isEqualTo(1001);

        assertThat(cargoWeights.getOverweightCargo().get(0)).isEqualTo(1001);
    }

}
