package bjss.mike.kotlindemo.examples.g_delegation_example

class CargoWeightsKotlin(
        private val delegate: MutableList<Int> = mutableListOf(),
        val overweightCargo: MutableList<Int> = mutableListOf()
): MutableList<Int> by delegate {

    private val MAX_WEIGHT = 1000

    override fun add(weight: Int): Boolean {
        if (weight > MAX_WEIGHT) {
            overweightCargo.add(weight)
        }
        return delegate.add(weight)
    }
}