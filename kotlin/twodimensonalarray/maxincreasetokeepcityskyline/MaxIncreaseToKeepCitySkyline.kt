fun maxIncreaseToKeepCitySkyLine(grid: Array<IntArray>): Int{
    checkNotNull(grid){"Grid cannot be null"}
    require(grid.size > 0){"Grid must have some data in it."}
    
    //Build max arrays for max in each row and max in each column
    var rowMaxArray = IntArray(grid.size)
    var colMaxArray = IntArray(grid[0].size)
    println("rowMaxArraySize ${rowMaxArray.size}")
    println("colMaxArraySize ${colMaxArray.size}")
    var rowSize = grid.size
    var colSize = grid[0].size
    println("rowSize $rowSize")
    println("colSize $colSize")
    var maxIncreaseSum = 0

    for (i in 0 until rowSize) {
        for(j in 0 until colSize){
            rowMaxArray[i] = maxOf(grid[i][j], rowMaxArray[i])
            colMaxArray[i] = maxOf(grid[j][i], colMaxArray[i])
        }
    }

    for(row in 0 until grid.size){
        for(col in 0 until grid[row].size){
            maxIncreaseSum += minOf(rowMaxArray[row], colMaxArray[col]) - grid[row][col]
        }
    }

    return maxIncreaseSum
}

fun main(args: Array<String>) {
    val row1 = intArrayOf(3,0,8,4)
    val row2 = intArrayOf(2,4,5,7)
    val row3 = intArrayOf(9,2,6,3)
    val row4 = intArrayOf(0,3,1,0)
    val grid: Array<IntArray> = arrayOf(row1, row2, row3, row4)
    val maxIncrease:Int = maxIncreaseToKeepCitySkyLine(grid)
    println("Max increase to keep city skyline is $maxIncrease")  
}