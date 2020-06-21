fun removeLinkedListElements(head: Node, target: Int): Node?{
    requireNotNull(head){"Head must not be null"}
    var mutableHead: Node? = head
    while(mutableHead?.data == target) mutableHead = mutableHead.next
    
    var current: Node? = mutableHead
    
    while(current != null && current.next != null){
        var next: Node? = current.next
        if(next?.data == target) current.next = current.next?.next
        else current = current.next
    }
    return mutableHead
}

fun display(node: Node?){
    var current: Node? = node
    while(current != null){
        print("${current.data} -> ")
        current = current.next
    }
}

fun main(args: Array<String>) {
    val head: Node = Node(1)
    var node1 = Node(2)
    head.next = node1
    var node2 = Node(3)
    node1.next = node2
    var node3 = Node(3)
    node2.next = node3
    var node4 = Node(5)
    node3.next = node4

    val node = removeLinkedListElements(head, 3)
    display(node)
}

public class Node(var data: Int){
    var next: Node? = null
}