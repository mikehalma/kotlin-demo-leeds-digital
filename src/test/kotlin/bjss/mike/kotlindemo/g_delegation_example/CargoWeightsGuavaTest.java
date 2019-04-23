package bjss.mike.kotlindemo.g_delegation_example;

import bjss.mike.kotlindemo.examples.g_delegation_example.CargoWeightsGuava;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class CargoWeightsGuavaTest {

    @Test
    public void java_guavaForwardingList() {
        CargoWeightsGuava<Integer> cargoWeights = new CargoWeightsGuava<>();
        cargoWeights.add(new Integer(1));
        cargoWeights.add(new Integer(1001));

        assertThat(cargoWeights.get(0)).isEqualTo(1);
        assertThat(cargoWeights.get(1)).isEqualTo(1001);

        assertThat(cargoWeights.getOverweightCargo().get(0)).isEqualTo(1001);
    }

}
