package bjss.mike.kotlindemo.g_delegation_example

import bjss.mike.kotlindemo.examples.g_delegation_example.CargoWeightsKotlin
import org.assertj.core.api.Assertions.assertThat
import org.junit.Test

class CargoWeightsKotlinTest {

    @Test
    fun `kotlin - with delegation`() {
        val cargoWeights = CargoWeightsKotlin()
        cargoWeights.add(1)
        cargoWeights.add(1001)

        assertThat(cargoWeights[0]).isEqualTo(1)
        assertThat(cargoWeights[1]).isEqualTo(1001)

        assertThat(cargoWeights.overweightCargo[0]).isEqualTo(1001)
    }
}