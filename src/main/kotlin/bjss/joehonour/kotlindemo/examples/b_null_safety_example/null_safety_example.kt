package bjss.joehonour.kotlindemo.examples.b_null_safety_example

import bjss.joehonour.kotlindemo.examples.a_data_class_example.Aircraft

//can still be null
fun getEngineIdOrNull(aircraft: Aircraft) : Long? {
    return aircraft.engineType?.id
}

// force not null
fun getEngineId(aircraft: Aircraft) : Long {
    return aircraft.engineType!!.id
}

// get value or 0
fun getEngineIdOrDefault(aircraft: Aircraft) : Long {
    return aircraft.engineType?.id ?: 0
}