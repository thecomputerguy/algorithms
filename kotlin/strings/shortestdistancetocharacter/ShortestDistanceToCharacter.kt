fun shortestDistance(data: String, c: Char): IntArray{
    requireNotNull(data){"input must not be null"}
    check(data.length > 0){"input must not be empty"}
    requireNotNull(c){"character must not be null"}
    val output = IntArray(data.length) { _ -> 0 }
    var charIndex = -data.length
    
    //first sweep from left to right
    for ((index,char) in data.withIndex()) {
        if(char == c){
            charIndex = index
        }
        output[index] = charIndex - index
    }

    //second sweep from right to left
    for(index in (data.length - 1) downTo 0){
        if(data[index] == c){
            charIndex = index
        }
        output[index] = minOf(Math.abs(output[index]), Math.abs(index - charIndex))
    }

    return output
}

fun main(args: Array<String>) {
   val distance =  shortestDistance("loveleetcode", 'e')
   for (element in distance) {
       print("$element ")
   }
}