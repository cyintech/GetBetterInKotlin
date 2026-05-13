package generalPractice

fun main() {
    val bst = BinarySearchTree()
    bst.insert(5)
    bst.insert(2)
    bst.insert(6)
    bst.insert(3)
    bst.insert(7)
    bst.insert(8)
    bst.insert(9)

    //println("${bst.root?.key} -> ${bst.root?.left?.key} -> ${bst.root?.right?.key}")
    bst.printTree(bst.root)
    bst.delete(7)
    println("\n")
    bst.printTree(bst.root)
}

data class Node(var data: Int) {
    var left: Node? = null
    var right: Node? = null
}

class BinarySearchTree{
    var root: Node? = null

    fun insert(data: Int) {
        root = insertItem(root, data)
    }

    private fun insertItem(node: Node?, data: Int) : Node? {
        if (node == null) {
            return Node(data)
        }

        if (data < node.data) {
             node.left = insertItem(node.left, data)
        } else {
             node.right = insertItem(node.right, data)
        }
        return node
    }

    fun delete(data: Int) {
        root = deleteItem(root, data)
    }

    private fun deleteItem(node: Node?, data: Int) : Node?{
        if (node == null) {
            return null
        }

        if (data < node.data) {
            node.left = deleteItem(node.left, data)
        } else if (data > node.data) {
            node.right = deleteItem(node.right, data)
        } else {
            if (node.left == null) return node.right
            if (node.right == null) return node.left

            //if two nodes are present
            val successor = findMin(node.right!!)
            // replace current node's value with successor
            node.data = successor?.data!!
            node.right = deleteItem(node.right, successor.data)
        }
        return node
    }

    private fun findMin(node: Node?) : Node? {
        if (node?.left == null) return null
        return findMin(node.left)
    }

    fun printTree(node: Node?) {
        if (node == null) return
        printTree(node.left)
        print("${node.data} -> ")
        printTree(node.right)
    }

}