package leetcode

fun main() {
    //println(addBinary("111111","1"))
//    val freq = IntArray(26)
//    for (c in "abaaacd") freq[c - 'a']++
//    println(freq.contentToString())
}

fun addBinary(s1: String, s2: String): String {
    val sum = StringBuilder()
    var carry = 0
    var l = s1.lastIndex
    var r = s2.lastIndex

    while (l >= 0 || r >= 0 || carry == 1) {
        val a = if (l>=0) s1[l--].digitToInt() else 0
        val b = if (r>=0) s2[r--].digitToInt() else 0
        val res = a + b + carry
        carry = res / 2
        sum.append(res % 2)
    }

    return sum.reverse().toString()
}