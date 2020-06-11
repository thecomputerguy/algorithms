fun reverseLinkedList(node: Node): Node?{
    if (node == null) return node
    var current: Node? = node
    var prev: Node? = null
    while (current != null){
        var nextNode: Node? = current.next
        current.next = prev
        prev = current
        current = nextNode
    }

    return prev
}

fun display(node: Node?): Unit{
    if (node == null) return
    var current: Node? = node
    while (current != null){
        print("${current.data} ")
        current = current.next
    }
}

fun main() {
    println("Reverse a linked list soltion.")
    //Create a linked list
    val head: Node = Node(1)
    var node1 = Node(2)
    head.next = node1
    var node2 = Node(3)
    node1.next = node2
    var node3 = Node(4)
    node2.next = node3
    //reverse the linked list
    val node: Node? = reverseLinkedList(head)
    display(node)
}

class Node(var data: Int){
    var next: Node? = null

}