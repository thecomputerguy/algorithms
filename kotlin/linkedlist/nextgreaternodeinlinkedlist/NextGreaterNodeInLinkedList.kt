fun nextGreaterNode(head: Node): IntArray{
    requireNotNull(head){"Head must not be null"}
    requireNotNull(head.next){"head.next must not be null"}
    var list = mutableListOf<Int>()
    var current: Node? = head

    while(current != null){
        list.add(current.data)
        current = current.next
    }
        
    var stack = java.util.Stack<Int>()
    var answer = IntArray(list.size) { _ -> 0 }    
    for((index, element) in list.withIndex()){    
        
        while(!stack.isEmpty() && element > list.get(stack.peek())){
            answer[stack.pop()] = element
        }

        stack.push(index)
    }
    return answer
}

fun main(args: Array<String>) {

    println("Next greater node problem solution.")
    val head: Node = Node(1)
    var node1 = Node(2)
    head.next = node1
    var node2 = Node(3)
    node1.next = node2
    var node3 = Node(4)
    node2.next = node3
    var node4 = Node(5)
    node3.next = node4

   val answer = nextGreaterNode(head)
   for (element in answer) {
       print("$element ")
   }
}

class Node(var data: Int){
    var next: Node? = null
}