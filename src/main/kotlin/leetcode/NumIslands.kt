package leetcode

fun numIslands(grid: Array<CharArray>): Int {
    var count = 0
    for (i in grid.indices) {
        for (j in grid[i].indices) {
            if (grid[i][j] == '1') count++
            dfsLoop(grid,i,j)
        }
    }
    return count
}

// O (n * m)
// recursively
fun dfs(grid: Array<CharArray>, i : Int, j: Int) {
    if ( i < 0 || i >= grid.size) return
    if (j < 0 || j>= grid[0].size) return
    if (grid[i][j] == '0') return

    grid[i][j] = '0'
    dfs(grid, i+1, j) // bottom
    dfs(grid, i-1, j) // up
    dfs(grid, i, j+1) // right
    dfs(grid, i, j-1) // left
}

fun dfsLoop(grid : Array<CharArray>, i: Int, j: Int) {
    val stack = ArrayDeque<Pair<Int, Int>>()
    stack.addLast(Pair(i,j))
    grid[i][j] = '0'

    val directions = listOf<Pair<Int, Int>>(
        Pair(-1,0), Pair(1,0),
        Pair(0,-1), Pair(0,1)
    )

    while (stack.isNotEmpty()) {
        val (row, col) = stack.removeLast()
        for ((dr, dc) in directions) {
            val newRow = row + dr
            val newCol = col + dc
            if (newRow < 0 || newRow >= grid.size) continue
            if (newCol < 0 || newCol >= grid[0].size) continue
            if (grid[newRow][newCol] == '0') continue
            grid[newRow][newCol] = '0'
            stack.addLast(Pair(newRow,newCol))
        }
    }
}

fun main() {
    println(numIslands(arrayOf(
        charArrayOf('1','1','1','1','0'),
        charArrayOf('1','1','0','1','0'),
        charArrayOf('1','1','0','0','0'),
        charArrayOf('0','0','0','0','0'),
    )))
}
