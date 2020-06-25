fun intersection(head1: Node?, head2: Node?): Node?{
    if(head1 == null || head2 == null) return null
    var current1: Node? = head1
    var current2: Node? = head2
    
    while(current1 != current2){
        if(current1 == null){
            current1 = head2
        }else{
            current1 = current1.next
        }

        if(current2 == null){
            current2 = head1
        }else{
            current2 = current2.next
        }
    }

    return current1
}

fun main(args: Array<String>) {
    
    val head: Node = Node(0)
    var node1 = Node(9)
    head.next = node1
    var node2 = Node(1)
    node1.next = node2
    var node3 = Node(2)
    node2.next = node3
    var node4 = Node(4)
    node3.next = node4
    var node5 = Node(3)
    node5.next = node3
    
   val node = intersection(head, node5)
   println(node?.data)
}

class Node(var data: Int){
    var next: Node? = null
}