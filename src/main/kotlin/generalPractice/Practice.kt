package generalPractice
import java.lang.Math.pow
import kotlin.math.pow
fun main() {
//    println("split by spaces".mySplit(","))
//    println(" ".mySplit(','))
//    println("a,b,c,d".mySplit(","))
    //println("a,b,c;d,f,;e".mySplit(','))
    val amount = 100

}

// implement split function of string without using it

fun String.mySplit(c: String): List<String> {
    val result = mutableListOf<String>()
        var currentIndex = 0
        var nextIndex = indexOf(c, currentIndex)
        while (nextIndex != -1) {
            result.add(substring(currentIndex, nextIndex))
            currentIndex = nextIndex + (c.length)
            nextIndex = indexOf(c, currentIndex)
        }

        result.add(substring(currentIndex, length))
    return result.toList()
}

fun String.mySplit(c : Char) : List<String> = mySplit(c.toString())