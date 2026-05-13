package leetcode

fun anagramMapping(nums: IntArray, nums2 : IntArray): IntArray {
    val myMap = mutableMapOf<Int, Int>()
    val result = IntArray(nums.size)
    for ((i,num) in nums2.withIndex()) {
        myMap[num] = i
    }

    for ((i,num) in nums.withIndex()) {
        result[i] = myMap[num]!!
    }
    return result
}

fun main() {
    println(anagramMapping(intArrayOf(12,28,46,32,50), intArrayOf(50,12,32,46,28)).contentToString())
    println(anagramMapping(intArrayOf(84,46), intArrayOf(84,46)).contentToString())
}