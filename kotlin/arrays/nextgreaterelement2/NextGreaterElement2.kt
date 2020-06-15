fun nextGreater(data: IntArray): IntArray{
    requireNotNull(data){"input must not be null"}
    check(data.size > 1){"input must contain atleast 1 element"}
    val stack = java.util.Stack<Int>()
    val output = IntArray(data.size) { _ -> -1 }
    for (index in 0 until data.size * 2) {
        
        while(!stack.isEmpty() && data[index % data.size] > data[stack.peek()]){
            output[stack.pop()] = data[index % data.size]
        }
        if(index < data.size) stack.push(index)
    }

    return output
}

fun main(args: Array<String>) {
   val result = nextGreater(intArrayOf(1,2,1))
   for (element in result) {
       print("$element ")
   }
}