package leetcode

fun twoSum(nums : IntArray, target: Int) : IntArray {
    val myMap = mutableMapOf<Int,Int>()
    for (i in nums.indices) {
        val targetValue = target-nums[i]
        if (targetValue in myMap.keys) {
            return intArrayOf(myMap[targetValue]!!,i)
        } else {
            myMap[nums[i]] = i
        }
    }
    return intArrayOf(-1)
}

fun main() {
    println(twoSum(intArrayOf(2,7,11,15), 9).contentToString())
    println(twoSum(intArrayOf(3,2,4), 6).contentToString())
    println(twoSum(intArrayOf(3,3), 6).contentToString())
}