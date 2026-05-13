package leetcode

import kotlin.math.abs

fun containsDuplicateII(nums : IntArray, k : Int) : Boolean {
    val myMap = mutableMapOf<Int,Int>()
    for (i in nums.indices) {
        if (nums[i] in myMap.keys) {
            if(abs(myMap[nums[i]]!!-i)<=k) {
                return true
            } else {
                myMap[nums[i]] = i
            }
        } else {
            myMap[nums[i]] = i
        }
    }
    return false
}

fun main() {
    println(containsDuplicateII(intArrayOf(1,2,3,1), 3))
    println(containsDuplicateII(intArrayOf(1,0,1,1), 1))
    println(containsDuplicateII(intArrayOf(1,2,3,1,2,3), 2))
}