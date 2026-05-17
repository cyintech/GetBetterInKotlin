package general.practice

import BinaryTree


fun main() {
    val root = BinaryTree(5)
    root.left = BinaryTree(3)
    root.right = BinaryTree(7)
    root.left?.left = BinaryTree(2)
    root.left?.right = BinaryTree(4)
    root.right?.left = BinaryTree(6)
    root.right?.right = BinaryTree(8)

    //find min in a binary tree
    // do a preorder fetch
//    println(findMinInBinarySTree(root))
//    println(findMaxInBinarySTree(root))
//    println(findMinInAnyBinaryTree(root))
//    println(findMaxInAnyBinaryTree(root))

//    preOrder(root)
//    println()
//    inOrder(root)
//    println()
//    postOrder(root)
//    preOrderLoop(root)
//    println()
//    inOrderLoop(root)
//    println()
//    postOrderLoop(root)
   // println(findMaxDepth(root))
   // println(countNodes(root))
    println(levelOrderBfs(root))
}

fun findMinInBinarySTree(root: BinaryTree?) : Int? {
    if (root?.left == null) return root?.data
    return findMinInBinarySTree(root.left)
}

fun findMaxInBinarySTree(root: BinaryTree?) : Int? {
    if (root?.right==null) return root?.data
    return findMaxInBinarySTree(root.right)
}

fun findMinInAnyBinaryTree(root: BinaryTree?) : Int? {
    if (root == null) return null
    val left = findMinInAnyBinaryTree(root.left)
    val right = findMinInAnyBinaryTree(root.right)
    return listOfNotNull(root.data, left, right).min()
}

fun findMaxInAnyBinaryTree(root : BinaryTree?) : Int? {
    if (root == null) return null
    val left = findMinInAnyBinaryTree(root.left)
    val right = findMaxInAnyBinaryTree(root.right)
    return listOfNotNull(root.data, left, right).max()
}

fun preOrder(root : BinaryTree?) {
    if (root == null) return
    print("${root.data} ")
    preOrder(root.left)
    preOrder(root.right)
}

fun inOrder(root : BinaryTree?) {
    if (root == null) return
    inOrder(root.left)
    print("${root.data} ")
    inOrder(root.right)
}

fun postOrder(root : BinaryTree?) {
    if (root == null) return
    postOrder(root.left)
    postOrder(root.right)
    print("${root.data} ")
}

//preOrder iteratively
fun preOrderLoop(root: BinaryTree?) {
    if (root == null) return
    val stack = ArrayDeque<BinaryTree>()
    stack.addLast(root)

    while (stack.isNotEmpty()) {
        val node = stack.removeLast()
        print("${node.data} ")
        if (node.right != null) stack.addLast(node.right!!)
        if (node.left != null) stack.addLast(node.left!!)
    }
}

//inOrder iteratively
fun inOrderLoop(root: BinaryTree?) {
    if (root == null) return
    val stack = ArrayDeque<BinaryTree>()
    var curr = root

    while (curr != null || stack.isNotEmpty()) {
        while (curr != null) {
            stack.addLast(curr)
            curr = curr.left
        }

        curr = stack.removeLast()
        print("${curr.data} ")
        curr = curr.right
    }
}

fun postOrderLoop(root: BinaryTree?) {
    if (root == null) return
    val stack = ArrayDeque<BinaryTree>()
    stack.addLast(root)
    val result = mutableListOf<Int>()
    while (stack.isNotEmpty()) {
        val node  = stack.removeLast()
        if (node.left != null) stack.addLast(node.left!!)
        if (node.right != null) stack.addLast(node.right!!)
        result.add(node.data)
    }
    println(result.reversed().joinToString(" "))
}

fun findMaxDepth(root: BinaryTree?) : Int {
    if (root == null) return 0
    return 1 + maxOf(findMaxDepth(root.left),findMaxDepth(root.right))
}

fun countNodes(root : BinaryTree?) : Int {
    if (root == null) return 0
    return 1 + countNodes(root.left) + countNodes(root.right)
}

fun levelOrderBfs(root: BinaryTree?) : List<List<Int>> {
    if (root == null) return emptyList()
    val queue = ArrayDeque<BinaryTree>()
    queue.addLast(root)
    val totalNodes = mutableListOf<MutableList<Int>>()
    while (queue.isNotEmpty()) {
        val levelSize = queue.size
        val nodesOnSameLevel = mutableListOf<Int>()
        repeat(levelSize) {
            val node = queue.removeFirst()!!
            nodesOnSameLevel.add(node.data)
            if (node.left != null) queue.addLast(node.left!!)
            if (node.right != null) queue.addLast(node.right!!)
        }

        totalNodes.add(nodesOnSameLevel)
    }

    return totalNodes
}