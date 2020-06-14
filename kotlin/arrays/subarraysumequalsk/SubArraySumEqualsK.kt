fun subArraySum(data: IntArray, k: Int): Int{
    checkNotNull(data){"given data should not be null"}
    require(data.size > 0){"given data cannot be empty"}
    var sum = 0
    var result = 0
    val map = mutableMapOf<Int, Int>()
    map.put(0, 1)
    
    for (element in data) {
        sum += element

        if(map.containsKey(sum-k)){
            result += map.get(sum-k)!!
        }
        map.put(sum, map.getOrDefault(sum, 0) + 1)
    }

    return result
}

fun main(args: Array<String>) {
    val sum = subArraySum(intArrayOf(1,1,1), 2)
    println("SubArray sum equals k is: $sum")
}