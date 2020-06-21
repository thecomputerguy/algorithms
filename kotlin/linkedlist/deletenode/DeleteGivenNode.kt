fun deleteNode(node: Node){
    node.data = node.next!!.data
    node.next = node.next?.next
}

fun display(node: Node){
    var current: Node? = node
    while(current != null){
        print("${current.data} ->")
        current = current.next
    }
}

fun main(args: Array<String>) {
    val head: Node = Node(1)
    var node1 = Node(2)
    head.next = node1
    var node2 = Node(3)
    node1.next = node2
    var node3 = Node(4)
    node2.next = node3
    var node4 = Node(5)
    node3.next = node4


    deleteNode(node2)
    display(head)
}

class Node(var data: Int?){
    var next: Node? = null
}