fun twoSum(data: IntArray, target: Int): IntArray{
    val result: IntArray = IntArray(2)
    if (data == null || data.size == 0) return result
    var left: Int = 0
    var right: Int = data.size-1
    while (left < right){
        if (data[left] + data[right] > target) right--
        else if (data[left] + data[right] < target) left++
        else {
            result[0] = left
            result[1] = right
            return result
        }
    }
    return result
}

fun main() {
    val data: IntArray = intArrayOf(2,7,11,15)
    val result:IntArray = twoSum(data, 21)
    println("${result[0]} ${result[1]} ")
}