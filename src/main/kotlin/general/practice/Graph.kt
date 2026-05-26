package general.practice

fun main() {
    val graph = mapOf(1 to listOf(2,3), 2 to listOf(4), 3 to listOf(5), 4 to listOf(), 5 to listOf())
    //printNodesOnGraph(graph, 1, mutableSetOf())
    bfsPrintNodes(graph)
}

fun printNodesOnGraph(graph : Map<Int, List<Int>>, node : Int, visited : MutableSet<Int>) {
    if (node in visited) {
        return
    }
    visited.add(node)
    println(node)
    for (neighbor in graph[node] ?: emptyList()) {
        printNodesOnGraph(graph, neighbor, visited)
    }
}

fun bfsPrintNodes(graph : Map<Int, List<Int>>) {
    val queue = ArrayDeque<Int>()
    val visited = mutableSetOf<Int>()
    queue.add(1)
    visited.add(1)

    while(queue.isNotEmpty()) {

        val currentNode = queue.removeFirst()
        println(currentNode)
        for (node in graph[currentNode] ?: emptyList()) {
            if (node !in visited) {
                visited.add(currentNode)
                queue.addLast(node)
            }
        }
    }

}

