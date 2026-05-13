package generalPractice

fun main() {
//    val grid = arrayOf(
//        intArrayOf(0, 0, 0),
//        intArrayOf(1, 1, 0),
//        intArrayOf(0, 0, 0)
//    )

   // println(bfs(grid, Pair(2,2)))

    val grid = arrayOf(
        charArrayOf('1','0','1'),
        charArrayOf('0','0','0'),
        charArrayOf('1','0','1')
    )

    var count = 0

    for (i in grid.indices) {
        for (j in grid[i].indices) {
            if (grid[i][j]=='1') {
                count++
                dfs2(grid, i, j)
            }

        }
    }
    println(count)
}

fun dfs2(grid: Array<CharArray>, i: Int, j: Int) {
    if (i < 0 || i >=grid.size) return
    if (j <0 || j>=grid[i].size) return
    if (grid[i][j] == '0') return
    grid[i][j] = '0'

    dfs2(grid, i-1, j)
    dfs2(grid, i, j+1)
    dfs2(grid,i+1, j)
    dfs2(grid, i, j-1)
}

fun bfs(grid : Array<IntArray>, target : Pair<Int, Int>) : Int{
    val queue = ArrayDeque<Triple<Int, Int, Int>>()
    queue.addLast(Triple(0,0,1))
    grid[0][0] = 1

    val directions = listOf(
        Pair(-1,0), Pair(1,0),
        Pair(0,1), Pair(0,-1)
        )

    while (queue.isNotEmpty()) {
        val (row, col, dist) = queue.removeFirst()
        for ((dr, dc) in directions) {
            val newRow = row + dr
            val newCol = col + dc
            if (newRow < 0 || newRow >= grid.size) continue
            if (newCol < 0 || newCol >= grid[0].size) continue
            if (grid[newRow][newCol] == 1) continue
            if (newRow == target.first && newCol == target.second) return dist
            grid[newRow][newCol] = 1
            queue.addLast(Triple(newRow, newCol, dist+1))
        }
    }
    return -1
}