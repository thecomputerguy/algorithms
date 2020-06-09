fun minSizeSubArraySum(s:Int, data: IntArray): Int  {

    if (data == null || data.size == 0) return 0
    var sum:Int = 0
    var left:Int = 0
    var minSize:Int = Int.MAX_VALUE
    //logic for calculating the min size subarray sum.
    for ((index, item) in data.withIndex()){
        sum += item

        while (sum >= s){
            minSize = minOf(minSize, (index + 1) - left)
            sum -= data[left]
            left++
        }
    }

    return if(minSize == Int.MAX_VALUE)  0 else minSize
}

fun main(args: Array<String>) {
    println("Minimum size subarray problem solution.")
    val data = intArrayOf(2,3,1,2,4,3)
    val s:Int = 7
    val sum: Int = minSizeSubArraySum(s, data)
    println("sum is $sum")
}