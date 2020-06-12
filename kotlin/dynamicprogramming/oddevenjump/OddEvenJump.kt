fun oddEvenJump(data: IntArray): Int {
    if (data == null || data.size == 0) return 0

    var goodIndexes: Int = 1
    val lower: Array<Boolean> = Array(data.size, {_ -> false})
    val higher: Array<Boolean> = Array(data.size, {_ -> false})
    val holder: java.util.TreeMap<Int?, Int?> = java.util.TreeMap()

    holder.put(data[data.size - 1], data.size-1)
    higher[data.size-1] = true
    lower[data.size-1] = true
    val end: Int = data.size - 2

    for(i in end downTo 0){
        val higherEntry  = holder.ceilingEntry(data[i])
        val lowerEntry  = holder.floorEntry(data[i])
        if (higherEntry != null) {
            higher[i] = lower[higherEntry.value!!]
        }
        if (lowerEntry != null){
            lower[i] = higher[lowerEntry.value!!]
        }

        if (higher[i]) goodIndexes++

        holder.put(data[i], i)
    }

    return goodIndexes
}

fun main() {
    val data: IntArray = intArrayOf(10,13,12,14,15)
    val goodIndexes: Int = oddEvenJump(data)
    println(goodIndexes)
}