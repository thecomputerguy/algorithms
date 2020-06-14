fun reverse(node: Node?): Node?{
    var prev: Node? = null
    var current: Node? = node
    
    while(current != null){
        var next = current.next
        current.next = prev
        prev = current
        current = next
    }
    
    return prev
}

fun merge(head: Node, reversed: Node?): Unit{

    var left: Node? = head
    var right: Node? = reversed
    
    while(left != null){
        var leftNext = left.next
        var rightNext = right?.next

        left.next = right
        if(leftNext == null){
            break
        }
        right?.next = leftNext
        left = leftNext
        right = rightNext
    }
}

fun display(node: Node): Unit{
    requireNotNull(node){"node cannot be null!"}
    var current: Node? = node
    while(current != null){
        println(current.data)
        current = current.next
    }
}

fun reorder(head: Node): Node{
    requireNotNull(head){"Head cannot be null"}
    var slow: Node? = head
    var fast: Node? = head
    var prev: Node? = null
    while(fast != null && fast.next != null){
        prev = slow
        slow = slow?.next
        fast = fast.next?.next
    }
    prev?.next == null
    var reversed = reverse(slow)
    merge(head, reversed)
    return head
}

fun main(args: Array<String>) {
 
    println("Reorder a linked list solution.")
    //Create a linked list
    val head: Node = Node(1)
    var node1 = Node(2)
    head.next = node1
    var node2 = Node(3)
    node1.next = node2
    var node3 = Node(4)
    node2.next = node3
    
    val node = reorder(head)
    display(node)
}

class Node(var data: Int){
    var next: Node? = null
}