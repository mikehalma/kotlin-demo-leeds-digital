package bjss.joehonour.kotlindemo.advanced.object_example

// creates a singleton (look at the java bytecode viewer)
object MySingleton {

    // type inference works on function return types also (though this may not be fantastic)
    fun myFunction() = 1
}

// creates singleton that can be used with this object
data class MyClassThatNeedsFunctions(val property: String, val number: Int)
{
    companion object {

        // does value equality
        fun doesPropertyExist(test: MyClassThatNeedsFunctions) = test.property == "test"
    }
}
fun exampleOfUsingDataClassSingleton(test: MyClassThatNeedsFunctions) = MyClassThatNeedsFunctions.doesPropertyExist(test)