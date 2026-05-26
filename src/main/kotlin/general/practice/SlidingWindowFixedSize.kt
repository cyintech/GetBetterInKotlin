package general.practice

fun main() {
    println(subArraySumFixed(intArrayOf(1,2,3,7,4,1), 3))
}

// find the largest sum among all subarrays of length k
fun subArraySumFixed(nums : IntArray, k : Int) : Int {
    var maxSum = Int.MIN_VALUE
    var currentSum = 0

    for (i in 0..<k) {
        currentSum += nums[i]
    }

    for (i in k..<nums.size) {
        currentSum -= nums[i-k]
        currentSum += nums[i]
        maxSum = maxOf(maxSum, currentSum)
    }

    return maxSum
}