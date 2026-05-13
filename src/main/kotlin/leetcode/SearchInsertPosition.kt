package leetcode

fun main() {
    println(searchInsert(intArrayOf(1,2,3,4,5,6), 5))
}

fun searchInsert(nums: IntArray, target: Int): Int {
    var low = 0
    var high = nums.size-1
    var mid = 0
    while (low<=high) {
        mid = low+(high-low)/2
        if (target==nums[mid]) return mid
        else if(target > nums[mid]) low = mid+1
        else high = mid-1
    }

    return low
}