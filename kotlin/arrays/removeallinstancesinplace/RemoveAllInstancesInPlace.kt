fun removeAllInstances(data: IntArray, value: Int): Int{
    requireNotNull(data){"input must not be null"}
    check(data.size > 0){"input must not be empty"}
    var endPointer = 0
    var startPointer = 0
    while(endPointer < data.size){
        if(data[endPointer] != value){
            data[startPointer] = data[endPointer]
            startPointer++
        }
        endPointer++
    }
    return startPointer
}

fun main(args: Array<String>) {
   val result1 = removeAllInstances(intArrayOf(3,2,2,3), 3)
   println("size after removing all instances of the given value is : $result1")    
   val result2 = removeAllInstances(intArrayOf(0,1,2,2,3,0,4,2), 2)
   println("size after removing all instances of the given value is : $result2")
}