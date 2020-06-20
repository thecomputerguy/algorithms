fun firstAndLastPosition(data: IntArray, element: Int): IntArray{
    requireNotNull(data){"data must not be null"}
    check(data.size > 0){"data must not be empty"}
    
    val first = firstPosition(data, element)
    val last = lastPosition(data, element)
    return intArrayOf(first, last)
}

fun firstPosition(data: IntArray, element: Int): Int{
    var left = 0
    var right = data.size - 1
    var index = -1
    while(left <= right){
        val mid = left + ((right - left) / 2)

        if(element <= data[mid]){
            right = mid - 1
        }else{
            left = mid + 1
        }

        if(data[mid] == element){
            index = mid
        }
    }
    return index
}

fun lastPosition(data: IntArray, element: Int): Int{
    var left = 0
    var right = data.size - 1
    var index = -1
    
    while(left <= right){
        val mid = left + ((right - left) / 2)
        
        if(element >= data[mid]){
            left = mid + 1
        }else{
            right = mid - 1
        }

        if(data[mid] == element){
            index = mid
        }
    }
    return index 
}

fun main(args: Array<String>) {
    val result = firstAndLastPosition(intArrayOf(5,7,7,8,8,10), 8)   
    println("first: ${result[0]} and last: ${result[1]}")
}