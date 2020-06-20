fun maxConsecutive(data: IntArray, k: Int): Int{
    requireNotNull(data){"input must not be null"}
    checkNotNull(data.size > 0){"input must not be empty"}
    check(k > 0){"max changes must not be negative or 0"}
    
    var endPointer = 0
    var startPointer = 0
    var maxChanges = k
    while(endPointer < data.size){
        if(data[endPointer] == 0){
            maxChanges--
        }

        if(maxChanges < 0 && data[startPointer++] == 0){
            maxChanges++
        }
        endPointer++
    }

    return endPointer - startPointer
}

fun main(args: Array<String>) {
    val result = maxConsecutive(intArrayOf(1,1,1,0,0,0,1,1,1,1,0), k = 2)    
    println("Maxconsecutive ones are: $result")
}