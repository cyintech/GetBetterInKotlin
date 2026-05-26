package general.practice

fun main() {
    val blocks = listOf(
        mapOf(
            "gym" to false,
            "school" to true,
            "store" to false
        ),
        mapOf(
            "gym" to true,
            "school" to false,
            "store" to false
        )
        ,
        mapOf(
            "gym" to true,
            "school" to true,
            "store" to false
        ),
        mapOf(
            "gym" to false,
            "school" to true,
            "store" to false
        ),
        mapOf(
            "gym" to false,
            "school" to true,
            "store" to true
        )
    )

    val reqs = listOf("gym", "school", "store")

    println(findBestBlock(blocks, reqs))
}

fun findBestBlock(blocks : List<Map<String, Boolean>>, reqs : List<String>) : Int {


    var distance = Int.MAX_VALUE
    val blockSet = mutableSetOf<String>()

    for ((i,block) in blocks.withIndex()) {

        distance = minOf(distance, performDFS(i, blockSet, 0, blocks, reqs))
    }

    return distance

}

fun performDFS(blockIndex : Int, blockSet : MutableSet<String>, currentDistance : Int, blocks : List<Map<String, Boolean>>, reqs : List<String>) : Int {
    if (blockIndex < 0 || blockIndex >= blocks.size) return currentDistance
    if (blockSet.size==reqs.size) return currentDistance

    for (item in reqs) {
        if (item !in blockSet) {
            if (blocks[blockIndex][item]==true) {
                blockSet.add(item)
            }
        }
    }
    return minOf(performDFS(blockIndex-1, blockSet, currentDistance+1, blocks, reqs), performDFS(blockIndex+1, blockSet, currentDistance+1, blocks, reqs))
}

