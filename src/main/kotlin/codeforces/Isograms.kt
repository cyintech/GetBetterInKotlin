package codeforces

fun main() {
    println(isIsogram("Dermatoglyphics"))
    println(isIsogram("aba"))
    println(isIsogram("moOse"))
    println(isIsogram(""))
    println(isIsogram("  "))
}

fun isIsogram(s : String) : Boolean {
    if (s.isEmpty()) return true

    val freq = mutableMapOf<Char, Int>()

    s.forEach { c ->
        freq[c] = freq.getOrDefault(c.lowercaseChar(), 0) +1
    }

    return freq.values.count { it > 1 } == 0
}