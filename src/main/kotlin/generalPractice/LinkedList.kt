package generalPractice

fun main() {
    val list1 = DataNode(1)
    list1.next = DataNode(2)
    list1.next?.next = DataNode(3)
    list1.next?.next?.next = DataNode(4)
    //list1.next?.next?.next?.next = DataNode(5)
    //list1.next?.next?.next?.next?.next = list1.next?.next?.next?.next
    println(returnMidNode(list1)?.value)
    //println(hasCycle(list1))
//    val res = reverseLLoop(list1)
//    var curr = res
//    while (curr != null) {
//        print("${curr.value} -> ")
//        curr = curr.next
//    }

}

// Given a ll, return the middle node, it two middles exist return the second one
fun returnMidNode(ll : DataNode?) : DataNode? {
    var slow = ll
    var fast = ll
    //var curr = ll
    while (fast!=null && fast.next != null) {
        //curr = curr?.next
        slow = slow?.next
        fast = fast.next?.next
    }

    return slow
}

// reverse a linked list
fun reverseLLoop(ll: DataNode?) : DataNode? {
    var prev : DataNode? = null
    var current = ll

    while (current!=null) {
        val next = current.next
        current.next = prev
        prev = current
        current = next
    }

    return prev
}

//detect cycle in linkedlist
fun hasCycle(head : DataNode?) : Boolean {
    var slow = head
    var fast = head

    while (fast!=null && fast.next!=null) {
        slow = slow?.next
        fast = fast.next?.next

        if (slow == fast) {
            return true
        }
    }
    return false
}

class DataNode(val value : Int) {
    var next : DataNode? = null
}