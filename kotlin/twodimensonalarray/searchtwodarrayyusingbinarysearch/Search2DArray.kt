class Search2DArray {

    fun search(data: Array<IntArray>, target: Int): Boolean{
        if (data == null || data.size == 0) return false
        var left: Int = 0
        val rows = data.size
        val columns = data[0].size
        var right: Int = rows * columns

        while (left <= right){
            val mid: Int = left + (right - left)/2
            val element: Int = data[mid/columns][mid%columns]
            if (element == target) return true
            else if (element > target) right = mid - 1
            else left = mid + 1
        }
        return false
    }
}

fun main() {
    val search2DArray: Search2DArray = Search2DArray()
    var row1: IntArray = intArrayOf(1,3,5,7)
    var row2: IntArray = intArrayOf(10,11,16,20)
    var row3: IntArray = intArrayOf(23,30,34,50)
    var data: Array<IntArray> = arrayOf(row1, row2, row3)
    val target1: Int = 23
    val result1: Boolean = search2DArray.search(data, target1)
    println(result1)
    val target2: Int = 24
    val result2: Boolean = search2DArray.search(data, target2)
    println(result2)
}