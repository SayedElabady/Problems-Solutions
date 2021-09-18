fun main() {
    var b = "abs"
    var c = "abs"
    println(b == c)
    b += "a"
    println(b == c)
    println(b)
    println(c)

    println((ab as A).y)
}

open class A(x: Int) {
    internal open val y: Int = x
}

interface B { /*...*/ }

val ab = object : A(1) {
    override val y = 15
}