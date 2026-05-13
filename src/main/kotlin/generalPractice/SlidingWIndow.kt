package generalPractice

fun main() {
    //sliding window technique to find max sum of 3 consecutive numbers

    val nums = intArrayOf(2, 4, 1, 7, 3, 5)
    println("max sum of 3 consecutive: ${slidingWindowMaxSum(nums,3)}")
}

fun slidingWindowMaxSum(nums : IntArray, k : Int) : Int {

    var temp = 0
    for (i in 0 until k) {
        temp += nums[i]
    }

    var maxSum = temp

    for (j in k until nums.size) {
        temp -= nums[j-k]
        temp += nums[j]
        maxSum = maxOf(maxSum, temp)
    }
    return maxSum
}