package leetcode

fun groupAnagram(strs : Array<String>) : List<List<String>> {

    if (strs.isEmpty()) return listOf(emptyList())

    val hmap = mutableMapOf<String, MutableList<String>>()
    for (s in strs) {
        val key = s.toCharArray().sorted().joinToString("")
        if (key in hmap) {
            hmap[key]!!.add(s)
        } else hmap[key] = mutableListOf(s)
    }

    return hmap.values.toList()
}

//fun getFreq(s: String) : Map<Char, Int> {
//    val freq = mutableMapOf<Char, Int>()
//    for (c in s) {
//        freq[c] = freq.getOrDefault(c,0)+1
//    }
//    return freq.toMap()
//}

fun main() {
    println(groupAnagram(arrayOf("eat","tea","tan","ate","nat","bat")))
    println(groupAnagram(arrayOf("")))
}