fun removeNthNodeFromEnd(node: Node, n: Int): Node{
    requireNotNull(node){"Node cannot be null"}
    var limit = n+1
    var slow: Node? = node
    var fast: Node? = node
    while(limit > 0){
        fast = fast?.next
        limit--
    }
    
    while(fast != null){
        fast = fast.next
        slow = slow?.next
    }
    slow?.next = slow?.next?.next

    return node
}

fun printList(head: Node): Unit{
    requireNotNull(head){"Head cannot be null"}
    var current: Node? = head
    while(current != null){
        print("${current.data} ->")
        current = current.next
    }
}

fun main(args: Array<String>) {
    
    println("Remove nth element from the end solution.")
    val head: Node = Node(1)
    var node1 = Node(2)
    head.next = node1
    var node2 = Node(3)
    node1.next = node2
    var node3 = Node(4)
    node2.next = node3
    var node4 = Node(5)
    node3.next = node4
    val node = removeNthNodeFromEnd(head, 2)
    printList(node)
}

class Node(var data: Int){
    var next: Node? = null
}