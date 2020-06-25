fun isValid(data: String): Boolean{
    if(data == null || data.length == 0) return false
    
    var stack = java.util.Stack<Char>()
    for (char in data) {
        when(char){
            '(', '[', '{' -> stack.push(char)
            ')' -> if(!isValid(stack, '(')) return false
            ']' -> if(!isValid(stack, '[')) return false
            '}' -> if(!isValid(stack, '{')) return false
            else -> return false
        }
    }
    return stack.isEmpty()
}

fun isValid(stack: java.util.Stack<Char>, char: Char): Boolean{
    if(stack.isEmpty())  return false
    if(stack.pop() == char){
        return true
    }
    return false
}

fun main(args: Array<String>) {
   val result1 = isValid("(){}[]")
   println("is valid? $result1")
   val result2 = isValid("()][{}")
   println("is valid? $result2")
}