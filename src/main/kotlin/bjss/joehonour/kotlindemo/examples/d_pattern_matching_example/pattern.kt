package bjss.joehonour.kotlindemo.examples.d_pattern_matching_example

import bjss.joehonour.kotlindemo.examples.a_data_class_example.Aircraft

// everything is closed for modification, unlike Java (ugh), so we must explicitly open the class for extension
open class StorageUnit(val name: String)

data class AircraftHangar(val aircraft: List<Aircraft>) : StorageUnit("Aircraft Hangar - East Unit")
data class VehicleDepo(val numberOfFuelingTrucks: Int) : StorageUnit("Fuel Truck Storage - East Unit")

fun countTotalStored(matchOn: List<StorageUnit>) : Int {
    var total = 0

    matchOn.forEach {
        when(it){
            is AircraftHangar -> total += it.aircraft.size
            is VehicleDepo -> total += it.numberOfFuelingTrucks
        }
    }

    return total
}