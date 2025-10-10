package KOTLIN

class Arithmetic : simple() {

    fun minus(a: Int, b: Int): Int {
        return a - b
    }
}

fun main() {
    val obj = Arithmetic()
    println(obj.add(10, 20))   // inherited from Java class
    println(obj.minus(10, 20)) // from Kotlin class
}
