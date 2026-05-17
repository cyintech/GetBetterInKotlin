package general.practice

fun commonNums(arr1 : IntArray, arr2 : IntArray) : String {
    var left = 0
    var right = 0
    val res = ArrayList<Int>()
    while (left < arr1.size && right < arr2.size) {
        when {
            arr1[left]==arr2[right]-> {
                res.add(arr1[left])
                left++
                right++
            }
            arr1[left]<arr2[right] -> left++
            else -> right++
        }
    }
    return res.toString()
}

fun main() {
    println(commonNums(intArrayOf(1,2,3), intArrayOf(1,3,5)))
    println(commonNums(intArrayOf(1,1,1), intArrayOf(1,1)))
}