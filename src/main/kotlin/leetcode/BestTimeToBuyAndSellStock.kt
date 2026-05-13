package leetcode

fun main() {
//    println(maxProfit(intArrayOf(7,1,5,3,6,4)))
//    println(maxProfit(intArrayOf(7,6,4,3,1)))
//    println(maxProfit(intArrayOf(2,4,1)))

    val colors = listOf("Red", "Green", "Blue")

}

fun maxProfit(prices : IntArray) : Int {
    if (prices.isEmpty() ) return 0

    var minPrice = Int.MAX_VALUE
    var maxProfit = Int.MIN_VALUE

    for (price in prices) {
        minPrice = minOf(minPrice, price)
        maxProfit = maxOf(maxProfit, price - minPrice)
    }

    return maxProfit
}