package bjss.joehonour.kotlindemo.advanced.operator_overloading

data class ImOverloaded(val property: String, val number: Int)

// operator overloading
operator fun ImOverloaded.plus(other: ImOverloaded) = ImOverloaded(property, number + other.number)

// adding 2 custom objects together using operator overloading
fun canNowIncrementCustomClass(test: ImOverloaded) = test + test