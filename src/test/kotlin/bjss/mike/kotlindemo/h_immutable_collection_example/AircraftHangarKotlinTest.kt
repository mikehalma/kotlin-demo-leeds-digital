package bjss.mike.kotlindemo.h_immutable_collection_example

import bjss.mike.kotlindemo.examples.b_null_safety_example.AircraftJava
import bjss.mike.kotlindemo.examples.h_immutable_collections_example.AircraftHangarKotlin
import org.assertj.core.api.AssertionsForClassTypes.assertThat
import org.junit.Test

class AircraftHangarKotlinTest {

    private val aircraft1 = AircraftJava(1, "any aircraft")
    private val aircraft2 = AircraftJava(2, "another aircraft")
    private val aircraft3 = AircraftJava(3, "yet another aircraft")

    @Test
    fun `immutable lists by default`() {
        val allAircraft = listOf(aircraft1, aircraft2)
        val aircraftHangarKotlin = AircraftHangarKotlin(allAircraft)

        // The below does not even compile - there is no add method on List
//        aircraftHangarKotlin.allAircraft.add(aircraft3)

        assertThat(allAircraft).isInstanceOf(List::class.java)
    }
}