package bjss.joehonour.kotlindemo.advanced.pattern_matching_example

// everything is closed for modification, unlike Java (ugh), so we must explicitly open the class for extension
open class BaseType(val baseProperty: String)

class SubTypeOne(baseProperty: String, val subTypeOneProperty: String) : BaseType(baseProperty)
class SubTypeTwo(baseProperty: String, val subTypeTwoProperty: String) : BaseType(baseProperty)

// after it has matched, the element is implicitly casted to the sub type safely, so we can now access child properties of the element, also known as a smart cast
// this can avoid the need for something like the visitor pattern, especially when we are iterating through a collection of BaseType objects
fun superAwesomePatternMatchingCrazyness(matchOn: BaseType) {
    when(matchOn){
        is SubTypeOne -> matchOn.subTypeOneProperty
        is SubTypeTwo -> matchOn.subTypeTwoProperty
        else -> matchOn.baseProperty
    }
}