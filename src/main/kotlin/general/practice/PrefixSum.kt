package general.practice

fun prefixSum(nums : IntArray, k : Int, j : Int) : Int {
    if (nums.size==1) {
        return nums[0]
    }
    if (k<0 || nums.isEmpty()) {
        return -1
    }

    val res = IntArray(nums.size)
    res[0] = nums[0]
    for (i in 1..<nums.size) {
        res[i] = nums[i] + res[i-1]
    }

    return if (k>0) res[j]-res[k-1] else res[j]
}

fun main() {
    println(prefixSum(intArrayOf(2, 4, 1, 7, 3, 5), 2,4))
    println(prefixSum(intArrayOf(2, 4, 1, 7, 3, 5), 0,3))
    println(prefixSum(intArrayOf(2, 4, 1, 7, 3, 5), 0,5))
}