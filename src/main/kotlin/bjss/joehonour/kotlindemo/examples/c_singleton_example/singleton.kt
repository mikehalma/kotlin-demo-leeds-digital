package bjss.joehonour.kotlindemo.examples.c_singleton_example

object AircraftBase {
    fun numberOfBasesInUk() = 27
}

data class RafMarhamAircraftBase(val active: Boolean, val currentAircraftType: String) {
    companion object {
        fun hasTornadoAircraft(test: RafMarhamAircraftBase) = test.currentAircraftType == "Tornado GR4"
    }
}

fun exampleOfUsingDataClassSingleton(test: RafMarhamAircraftBase) = RafMarhamAircraftBase.hasTornadoAircraft(test)