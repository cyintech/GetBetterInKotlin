package leetcode

fun longestCommonPrefix(strs: Array<String>): String {
    if (strs.isEmpty() || strs.contains("")) return ""

    val res = StringBuilder()
    var k = 0
    for (c in strs[0]) {
        for (j in 1..<strs.size) {
            if (k>=strs[j].length ||  c!=strs[j][k]) {
                return res.toString()
            }
        }
        res.append(c)
        k++
    }
    return strs[0]

}

fun main() {
    println(longestCommonPrefix(arrayOf("flower","flow")))

    //println(longestCommonPrefix(arrayOf("dog","racecar","car")))
}