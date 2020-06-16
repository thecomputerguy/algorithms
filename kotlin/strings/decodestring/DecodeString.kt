fun decodeString(data: String): String{
    requireNotNull(data){"input must not be null"}
    check(data.length > 0){"input must not be empty"}
    var countStack = java.util.Stack<Int>()
    var valueStack = java.util.Stack<String>()
    var res = ""
    var index = 0
    while(index < data.length) {
        if(Character.isDigit(data[index])){
            //digit
            var currentVal = 0
            while(Character.isDigit(data[index])){
                val charValue = data[index].toString().toInt()
                currentVal = (10 * currentVal) + charValue
                index++        
            }
            println("currentValue : $currentVal")
            countStack.push(currentVal)
            
        }else if(data[index] == '['){
            //opening bracket
            valueStack.push(res)
            res = ""
            index++
        }else if(data[index] == ']'){
            //closing bracket
            var count = countStack.pop()
            var builder = StringBuilder(valueStack.pop())
            while(count > 0){
                builder.append(res)
                count--
            }
            res = builder.toString() 
            index++
        }else{
            //character
            res += data[index]
            index++
        }
    }
    return res
}

fun main(args: Array<String>) {
   val result = decodeString("3[a]2[bc]")
   println("result $result")
}