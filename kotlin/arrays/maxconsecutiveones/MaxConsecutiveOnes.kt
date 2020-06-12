fun maxConsecutiveOnes(data: IntArray): Int{
    if (data == null || data.size == 0) return 0
    var maxCount: Int = 0
    var currentCount: Int = 0
    for ((index, element) in data.withIndex()){
        if (element == 1){
            currentCount++
            maxCount = maxOf(currentCount, maxCount)
        }else{
            currentCount = 0
        }
    }
    return maxCount
}

fun main() {
    val data: IntArray = intArrayOf(1,1,0,1,1,1)
    val ones = maxConsecutiveOnes(data)
    println(ones)
}