package general.practice

import kotlin.math.sqrt

fun main() {

// println(plusOne(intArrayOf(9,9,9,9)).contentToString())
//    println(plusOne(intArrayOf(4,9,9)).contentToString())
//    println(plusOne(intArrayOf(1,0,9,9,9)).contentToString())

    //val num = 0%10

    val d = sqrt(8.0).toInt()
    println(d)

val s = StringBuilder()
    s.apply{
        append("1")
        append("0")
        append("1")
        append("0")
    }

    //println(s.toString().reversed())
}

fun plusOne(digits: IntArray) : IntArray {
    for (i in digits.indices.reversed()) {
        if (digits[i] < 9) {
            digits[i]++
            return digits
        }
        digits[i] = 0
    }

    return IntArray(digits.size+1).also { digits ->
        digits[0] = 1
    }
}



