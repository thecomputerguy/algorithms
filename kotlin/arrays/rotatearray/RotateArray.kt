fun rotateArray(data: IntArray, k: Int): IntArray{
    requireNotNull(data){"input must not be null"}
    check(data.size > 0) { "input must not be empty" }
    var rotations = k % data.size
    reverse(data, from = 0, to = data.size-1)
    reverse(data, from = 0, to = rotations-1)
    reverse(data, from = data.size - rotations - 1, to = data.size - 1)
    return data
}

fun reverse(data: IntArray, from: Int, to: Int): Unit{
    var left  = from
    var right = to
    
    while(left < right){
        val temp = data[left]
        data[left] = data[right]
        data[right] = temp
        left++
        right--
    }
}

fun main(args: Array<String>) {
    val result = rotateArray(intArrayOf(1,2,3,4,5,6,7), 3)
    for (element in result) {
        print("$element ")
    }
}