fun maxArea(data: Array<IntArray>): Int{
    if (data == null || data.size == 0) return 0

    var maxAreaOfIsland: Int = 0
    val visited: Array<BooleanArray> = Array(data.size, { BooleanArray(data[0].size) })
    for (row in 0 until data.size){
        for (col in 0 until data[row].size){
            if (data[row][col] == 1){
                maxAreaOfIsland = maxOf(maxAreaOfIsland, area(data, row, col, visited))
            }
        }
    }
    return maxAreaOfIsland
}

fun area(data: Array<IntArray>, row: Int, col: Int, visited: Array<BooleanArray>): Int {
    if (       row < 0
            || row >= data.size
            || col < 0
            || col >= data[row].size
            || visited[row][col]
            || data[row][col] == 0
    ) return 0
    visited[row][col] = true
    return 1 + area(data, row+1, col, visited) + area(data, row-1, col, visited) + area(data, row, col+1, visited) + area(data, row, col-1, visited)
}

fun main() {
    //Build a matrix
    val row1: IntArray = intArrayOf(0,0,1,0,0,0,0,1,0,0,0,0,0)
    val row2: IntArray = intArrayOf(0,0,0,0,0,0,0,1,1,1,0,0,0)
    val row3: IntArray = intArrayOf(0,1,1,0,1,0,0,0,0,0,0,0,0)
    val row4: IntArray = intArrayOf(0,1,0,0,1,1,0,0,1,0,1,0,0)
    val row5: IntArray = intArrayOf(0,1,0,0,1,1,0,0,1,1,1,0,0)
    val row6: IntArray = intArrayOf(0,0,0,0,0,0,0,0,0,0,1,0,0)
    val row7: IntArray = intArrayOf(0,0,0,0,0,0,0,1,1,1,0,0,0)
    val row8: IntArray = intArrayOf(0,0,0,0,0,0,0,1,1,0,0,0,0)
    val data: Array<IntArray> = arrayOf(row1, row2, row3, row4, row5, row6, row7, row8)

    //call the maxAreaOfIsland function
    val area: Int = maxArea(data)

    //display the result
    println("maxArea is $area")
}