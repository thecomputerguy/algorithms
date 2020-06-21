fun noOfLinesAndWidth(widths: IntArray, data: String): IntArray{
    requireNotNull(widths){"widths must not be null"}
    requireNotNull(data){"data must not be null"}
    check(widths.size > 0){"widths must not be empty"}
    check(data.length > 0){"data must not be empty"}
    val result = IntArray(2) { _ -> 0 }
    var lineWidth = 0
    var lines = 1
    for (char in data) {
        val index = char - 'a'
        val width = widths[index]
        lineWidth += width
        if(lineWidth > 100){
            lineWidth = 0
            lineWidth += width
            lines++
        }
    }
    result[0] = lines
    result[1] = lineWidth
    return result
}

fun main(args: Array<String>) {
    val widths = intArrayOf(10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10)
    val data = "abcdefghijklmnopqrstuvwxyz"
    val result = noOfLinesAndWidth(widths, data)
    println("No. of lines: ${result[0]} and width of last line ${result[1]}")
}