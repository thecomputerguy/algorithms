fun pivotIndex(data: IntArray): Int{
    requireNotNull(data){"input must not be null"}
    check(data.size > 0){"input must not be empty"}
    var total = 0
    for (element in data) {
        total += element
    }
    var index = 0
    var leftSum = 0
    while(index < data.size){
        if(index != 0){
            leftSum += data[index-1] 
        }

        //right sum                         //leftSum
        if(total - leftSum - data[index] == leftSum){
            return index
        }
        index++
    }

    return -1
}

fun main(args: Array<String>) {
    val result = pivotIndex(intArrayOf(1,7,3,6,5,6))
    println("Pivot element index is $result")
}