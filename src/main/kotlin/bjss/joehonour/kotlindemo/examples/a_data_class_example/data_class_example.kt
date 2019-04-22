package bjss.joehonour.kotlindemo.examples.a_data_class_example

data class Engine(val id: Long, val size: Int, val name: String)
data class Aircraft(val id: Long, val engineType: Engine?, val name: String)

fun copyAicraftWithNewId(aircraft: Aircraft, newId: Long) : Aircraft {
    return aircraft.copy(id = newId)
}