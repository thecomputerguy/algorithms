fun deleteDuplicates(head: Node): Node{
    var current: Node? = head
    while(current != null && current.next != null){

        if(current.data == current.next?.data){
            current.next = current.next?.next
        }else{
            current = current.next
        }
    }
    return head
}

fun display(node: Node): Unit{

    var current: Node? = node
    while(current != null){
        print("${current.data} ->")
        current = current.next
    }
    println()
}

fun main(args: Array<String>) {
    
    val head: Node = Node(1)
    var node1 = Node(2)
    head.next = node1
    var node2 = Node(2)
    node1.next = node2
    var node3 = Node(4)
    node2.next = node3
    var node4 = Node(4)
    node3.next = node4
    println("Before removing duplicates.")
    display(head)
    val node = deleteDuplicates(head)
    println("After removing duplicates.")
    display(node)
}

class Node(var data: Int){
    var next: Node? = null
}