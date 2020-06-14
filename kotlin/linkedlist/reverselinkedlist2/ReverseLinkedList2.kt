fun reverseLinkedListTwo(head: Node, m: Int, n:Int): Node{
    
    requireNotNull(head){"linked list cannot be empty!"}
    check(m < n){"starting position of the linked list cannot be greater than ending position."}
    var start = m
    var end = n
    var current: Node? = head
    var prev: Node? = current
    //Move current so that current points to the starting position
    //of the list and prev points to connection(i.e 1 element before the starting position of part to be reversed)
    while(start > 0){
        prev = current
        current = current?.next
        start--
        end--
    }
    var connection = prev
    var tail = current
    //Move the while n > 0. while n > 0 we want to reverse the sub list.
    while(end > 0){
        var next = current?.next
        current?.next = prev
        prev = current
        current = next
        end--
    }

    //connect the first half to the reversed sub list.
    if(connection != null){
        connection.next = prev
    }

    //connect the tail of the reversed sub list to the end of the original list 
    tail?.next = current
    
    //return the head
    return head
}

fun display(head: Node): Unit{
    
    requireNotNull(head){"Head of the list cannot be null."}
    var current: Node? = head
    while(current != null){
        print("${current.data} -> ")
        current = current.next
    } 
}

fun main(args: Array<String>) {

    println("Linked list two solution.")
    val head: Node = Node(1)
    var node1 = Node(2)
    head.next = node1
    var node2 = Node(3)
    node1.next = node2
    var node3 = Node(4)
    node2.next = node3
    var node4 = Node(5)
    node3.next = node4

    val node = reverseLinkedListTwo(head, 2, 5)
    display(node)
}

class Node(var data: Int){
    var next: Node? = null
}