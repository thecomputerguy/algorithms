fun nextGreaterElement(array1: IntArray, array2: IntArray): IntArray{
    requireNotNull(array1){"Array 1 must not be null"}
    requireNotNull(array2){"Array 2 must not be null"}
    check(array1.size > 1){"Array 1 must contain atleast 2 elements"}
    check(array2.size > 1){"Array 2 must contain atleast 2 elements"}
    //build mapping
    var mapping = mutableMapOf<Int, Int>()
    var stack = java.util.Stack<Int>()
    for (element in array2) {
        while(!stack.isEmpty() && element > stack.peek()){
            mapping.put(stack.pop(), element)
        }      
        stack.push(element)
    }

    for ((index,element) in array1.withIndex()) {
        if(mapping.containsKey(element)) array1[index] = mapping.get(element)!!
        else array1[index] = -1       
    }

    return array1
}

fun main(args: Array<String>) {
   val result: IntArray = nextGreaterElement(intArrayOf(4,1,2), intArrayOf(1,3,4,2))
   for (element in result) {
       print("$element ")
   }
}