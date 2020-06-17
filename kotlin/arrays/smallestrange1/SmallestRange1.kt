fun smallestRange(data: IntArray, k : Int): Int{
    requireNotNull(data){"input array must not be null"}
    check(data.size > 1){"input array must contain at least 2 digits"}
    var minVal = data[0]
    var maxVal = data[0]
    for (element in data) {
        minVal = minOf(minVal, element)
        maxVal = maxOf(maxVal, element)
    }

    if((minVal + k) - (maxVal - k) > 0){
        return 0
    }

    return (maxVal - k) - (minVal + k)
}

fun main(args: Array<String>) {
    val result1 = smallestRange(intArrayOf(1,3,6), 3)
    println("Result: $result1")
    val result2 = smallestRange(intArrayOf(0,10), 2)
    println("Result: $result2")
}