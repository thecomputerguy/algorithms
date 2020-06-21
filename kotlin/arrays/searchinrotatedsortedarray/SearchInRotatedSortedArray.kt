fun searchInRotatedSortedArray(data: IntArray, target: Int): Int{
    requireNotNull(data){"input must not be null"}
    check(data.size > 0){"input must not be empty"}
    var left = 0
    var right = data.size - 1
    while(left < right){
        val mid = left + ((right - left) / 2)
        if(data[mid] > data[right]) left = mid + 1
        else right = mid
    }
    var start = left
    left = 0
    right = data.size - 1
    if(target >= data[start] && target <= data[right]){
        left = start
    }else{
        right = start
    }

    while(left <= right){
        val mid = left + ((right - left)/2)
        if(data[mid] == target){
            return mid
        }else if(target < data[mid]){
            right = mid - 1
        }else{
            left = mid + 1
        }
    }
    return -1
}

fun main(args: Array<String>) {
   val result = searchInRotatedSortedArray(intArrayOf(4,5,6,7,0,1,2), target = 0)
   println("result: $result")
}