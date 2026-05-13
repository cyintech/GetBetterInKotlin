package leetcode

fun longestStr(str: String) : String {
    if (str.isEmpty()) return str
    var l = 0
    var start = 0
    var maxLength = 0
    val myMap = mutableMapOf<Char, Int>()

    for ((i,c) in str.withIndex()) {
        if (c in myMap) {
            l = maxOf(myMap[c]!!+1, l)
            myMap[c] = i
        } else {
            myMap[c] = i
        }
        val windowSize = i-l+1
        if (windowSize > maxLength) {
            maxLength = windowSize
            start = l
        }

    }
    return str.substring(start, maxLength+start)
}

fun main() {
    //println(longestStr("dvdf"))
    println(longestStr("abba"))

}