package bjss.joehonour.kotlindemo.examples.f_advanced_functional

import bjss.joehonour.kotlindemo.examples.a_data_class_example.Aircraft
import bjss.joehonour.kotlindemo.examples.a_data_class_example.Engine

fun executeIfAircraftExists(id: Long): Engine? {
    executeIfAircraftExists(id) {
        return it.engineType
    }

    throw IllegalArgumentException("id was null")
}

// as this is inline, the function executes directly in the calling method
private inline fun executeIfAircraftExists(aircraftId: Long?, exists: (Aircraft) -> Unit) {
    val aircraft = TestAircraft.getAircraft().firstOrNull { it.id == aircraftId }
    when(aircraft) {
        null -> return
        else -> exists(aircraft)
    }
}



































// test data (ignored)
object TestAircraft{

    fun getAircraft() = listOf(
            Aircraft(2, Engine(1, 1000, "Rolls Royce"), "TornadoGR4"))

}