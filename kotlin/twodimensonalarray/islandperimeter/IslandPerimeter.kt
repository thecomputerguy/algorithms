fun islandPerimeter(data: Array<IntArray>): Int{
    if (data == null || data.size == 0 || data[0].size == 0) return 0
    val rows: Int = data.size
    val cols: Int = data[0].size
    var perimeter: Int = 0
    for (row in 0 until rows){
        for (col in 0 until cols){
            if (data[row][col] == 1){
                perimeter += 4
                if (row > 0 && data[row-1][col] == 1) perimeter -= 2
                if (col > 0 && data[row][col-1] == 1) perimeter -= 2
            }
        }
    }
    return perimeter
}

fun main() {
    val row1: IntArray = intArrayOf(0,1,0,0)
    val row2: IntArray = intArrayOf(1,1,1,0)
    val row3: IntArray = intArrayOf(0,1,0,0)
    val row4: IntArray = intArrayOf(1,1,0,0)
    var data: Array<IntArray> = arrayOf(row1, row2, row3, row4)
    val perimeter: Int = islandPerimeter(data)
    println(perimeter)
}