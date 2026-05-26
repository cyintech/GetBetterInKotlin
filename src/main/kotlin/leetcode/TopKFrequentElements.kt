package leetcode

fun main() {
    println(topKFrequentElements(intArrayOf(1,1,1,2,2,3), 2).contentToString())
    println(topKFrequentElements2(intArrayOf(1,1,1,2,2,3), 2).contentToString())
}

fun topKFrequentElements(nums : IntArray, k : Int) : IntArray {
    val freq = HashMap<Int, Int>()
    for (num in nums) {
        freq[num] = (freq[num] ?: 0) + 1
    }

    return freq.keys.sortedByDescending {
        freq[it]
    }.take(k).toIntArray()

}

fun topKFrequentElements2(nums : IntArray, k : Int) : IntArray {
    val freq = HashMap<Int, Int>()
    for (num in nums) {
        freq[num] = (freq[num] ?: 0) + 1
    }

    return freq.keys.sortedBy {
        freq[it]
    }.takeLast(k).toIntArray()

}