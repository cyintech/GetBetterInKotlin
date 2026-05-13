package leetcode

import BinaryTree

fun findMaxDepth(root: BinaryTree?) : Int {
    if (root == null) return 0
    return 1 + maxOf(findMaxDepth(root.left),findMaxDepth(root.right))
}

fun findMinDepth(root: BinaryTree?) : Int {
    if (root == null) return 0
    return 1+ minOf(findMinDepth(root.left), findMinDepth(root.right))
}

fun countAllNodes(root: BinaryTree?) : Int {
    if (root == null) return 0
    return 1+countAllNodes(root.left)+countAllNodes(root.right)
}

fun isSame(root1: BinaryTree?, root2: BinaryTree?): Boolean {
    if (root1 == null && root2 == null) return true
    if (root1 == null  || root2==null) return false
    if (root1.data!=root2.data) return false
    return isSame(root1.left, root2.left) && isSame(root1.right, root2.right)
}

fun invertTree(root: BinaryTree?) : BinaryTree? {
    if (root == null) return null
    val left = root.left
    root.left = root.right
    root.right = left
    invertTree(root.left)
    invertTree(root.right)
    return root
}

fun main() {
    val root1 = BinaryTree(5)
    root1.left = BinaryTree(3)
    root1.right = BinaryTree(7)
    root1.left?.left = BinaryTree(2)
    root1.left?.right = BinaryTree(4)
    root1.right?.left = BinaryTree(6)
    root1.right?.right = BinaryTree(8)

    println("max depth = ${findMaxDepth(root1)}")
    println("min depth = ${findMinDepth(root1)}")

    println(countAllNodes(root1))

    invertTree(root1)
}