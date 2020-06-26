fun addBinary(first: String, second: String): String{
    if(first == null || first.isEmpty() || second == null || second.isEmpty()) return ""
    var firstPointer = first.length-1
    var secondPointer = second.length-1
    var carry = 0
    var result = StringBuilder()
    while(firstPointer >= 0 || secondPointer >= 0){
        var sum = 0
        sum += carry
        if(firstPointer >= 0){ 
            sum = sum + (first[firstPointer] - '0')
            firstPointer--
        }
        if(secondPointer >= 0){ 
            sum = sum + (second[secondPointer] - '0')
            secondPointer--
        }
        result.append(sum%2)
        carry = (sum / 2)
    }

    if(carry > 0) result.append(carry)
    return result.reverse().toString()
}

fun main(args: Array<String>) {
    val first = "1010"
    var second = "1011"
    //result = "10101"
    val result = addBinary("1010", "1011")
    println(first)
    print("+ ")
    println(second)
    println(result)
}