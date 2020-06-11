fun removeAdjacentDuplicates(data: String): String{
    if (data == null || data.length == 0) return ""
    val stack = java.util.Stack<Char>()
    for (ch in data){
        if (!stack.isEmpty() && stack.peek() == ch){
            stack.pop()
        }else{
            stack.add(ch)
        }
    }
    var result: String = ""
    if (!stack.isEmpty() && stack.size > 1) stack.reverse()
    while (!stack.isEmpty()){
        result += stack.pop()
    }
    return result
}

fun main() {
    val data: String = "abbaca"
    val result: String = removeAdjacentDuplicates(data)
    println(result)
}