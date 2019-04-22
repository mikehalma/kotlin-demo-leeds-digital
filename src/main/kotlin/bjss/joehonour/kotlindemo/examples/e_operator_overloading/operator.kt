package bjss.joehonour.kotlindemo.examples.e_operator_overloading

data class EngineFuel(val amount: Int)

// operator overloading
operator fun EngineFuel.plus(other: EngineFuel) = EngineFuel(amount + other.amount)

// adding 2 custom objects together using operator overloading
fun combineEngineFuel(existingFuel: EngineFuel, newFuel: EngineFuel) = existingFuel + newFuel