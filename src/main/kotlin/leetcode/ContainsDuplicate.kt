package leetcode

fun containsDuplicate(nums: IntArray) : Boolean {
    val mySet = mutableSetOf<Int>()
    for (num in nums) {
        val isFalse = mySet.add(num)
        if (!isFalse) return true
    }
    return false
}

fun main() {
    println(containsDuplicate(intArrayOf(1,2,3,1)))
    println(containsDuplicate(intArrayOf(1,2,3,4)))
    println(containsDuplicate(intArrayOf(1,1,1,3,3,4,3,2,4,2)))
}
