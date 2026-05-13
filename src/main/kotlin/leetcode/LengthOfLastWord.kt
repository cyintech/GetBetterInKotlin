package leetcode

fun main() {
    val s = "Hello World"
    println(lengthOfLastWord(s))
}

fun lengthOfLastWord(s: String): Int {
    if (!s.contains(' ')) {
        return s.length
    }

    var r = s.length-1
    var count = 0
    while (r>=0) {
        if (s[r]==' ') {
            if (count > 0) {
                return count
            }
        } else {
            count++
        }
        r--
    }

    return count
}