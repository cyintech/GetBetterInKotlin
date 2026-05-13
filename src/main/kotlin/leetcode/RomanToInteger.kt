package leetcode

fun main() {
    println(romanToInteger("III"))
    println(romanToInteger("LVIII"))
    println(romanToInteger("MCMXCIV"))
    //println(romanToInteger("III"))
}

fun romanToInteger(s: String): Int {
    val romanMap = mapOf(
        'I' to 1, 'V' to 5, 'X' to 10,
        'L' to 50, 'C' to 100, 'D' to 500, 'M' to 1000
    )

    var result = 0
    var i = 0

    while (i < s.length) {
        when (s[i]) {
            'I' -> {
                if (i + 1 < s.length && (s[i+1] == 'V' || s[i+1] == 'X')) {
                    result += romanMap[s[i+1]]!! - romanMap[s[i]]!!
                    i++ // skip next char
                } else {
                    result += romanMap[s[i]]!!
                }
            }
            'X' -> {
                if (i + 1 < s.length && (s[i+1] == 'L' || s[i+1] == 'C')) {
                    result += romanMap[s[i+1]]!! - romanMap[s[i]]!!
                    i++
                } else {
                    result += romanMap[s[i]]!!
                }
            }
            'C' -> {
                if (i + 1 < s.length && (s[i+1] == 'D' || s[i+1] == 'M')) {
                    result += romanMap[s[i+1]]!! - romanMap[s[i]]!!
                    i++
                } else {
                    result += romanMap[s[i]]!!
                }
            }
            else -> result += romanMap[s[i]]!!
        }
        i++
    }
    return result
}

fun romanToIntegerOptimized(s: String): Int {
    val romanMap = mapOf(
        'I' to 1, 'V' to 5, 'X' to 10,
        'L' to 50, 'C' to 100, 'D' to 500, 'M' to 1000
    )

    var result = 0

    for (i in s.indices) {
        val curr = romanMap[s[i]]!!
        val next = if (i + 1 < s.length) romanMap[s[i + 1]]!! else 0

        if (curr < next) result -= curr
        else             result += curr
    }

    return result
}
