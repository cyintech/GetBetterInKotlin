package leetcode

fun main() {
    println(climbStairs(1)) // 1
    println(climbStairs(2)) // 2
    println(climbStairs(3)) // 3
    println(climbStairs(4)) // 5
    println(climbStairs(5)) // 8
    println(climbStairs(6)) // 13
}

fun climbStairs(n: Int): Int {
    val steps : MutableMap<Int, Int> = mutableMapOf()
    fun climb(n : Int) : Int {
        if (n<=2) return n
        return steps.getOrPut(n) {
            climb(n-1) + climb(n-2)
        }
    }
    return climb(n)

}

