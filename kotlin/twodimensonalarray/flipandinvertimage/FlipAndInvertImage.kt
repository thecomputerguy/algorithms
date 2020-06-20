fun flipAndInvertImage(data: Array<IntArray>){
    requireNotNull(data){"input must not be empty"}
    check(data.size > 0){"input must have at least one row"}
    var i = 0
    while(i < data.size) {
        var left = 0
        var right = (data[i].size - 1)
        while(left <= right){
            println("left: $left and right: $right")
            if(data[i][left] == data[i][right]){
                println("before -> data[i][left]: ${data[i][left]} and data[i][right]: ${data[i][right]}")
                data[i][left] = 1 - data[i][left]
                data[i][right] = data[i][left]
                println("after -> data[i][left]: ${data[i][left]} and data[i][right]: ${data[i][right]}")
            }
            left++
            right--
        }
        i++
    }
}

fun display(data: Array<IntArray>){
    for (row in data) {
        for (item in row) {
            print("$item ")
        }
        println()
    }
}

fun main(args: Array<String>) {
    val row1 = intArrayOf(1,1,0)
    val row2 = intArrayOf(1,0,1)
    val row3 = intArrayOf(0,0,0)
    val data: Array<IntArray> = arrayOf(row1, row2, row3) 
    println("Before flipping")
    display(data)
    flipAndInvertImage(data)
    println("After flipping")
    display(data)
}