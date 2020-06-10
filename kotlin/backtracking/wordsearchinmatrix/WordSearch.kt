fun searchWord(data: Array<CharArray>, word: String): Boolean{
    if (data == null || data.size == 0 || word == null || word.length == 0) return false
    val rows = data.size
    val columns = data[0].size
    for (row in 0 until rows){
        for (col in 0 until columns){
            if (data[row][col] == word[0].toChar()){
                val visited: Array<BooleanArray> = Array(rows, { BooleanArray(columns) })
                val result: Boolean = searchWord(data, row, col, word, 0, visited)
                if (result) return true
            }
        }
    }
    return false
}

fun searchWord(data: Array<CharArray>, row: Int, col: Int, word: String, len: Int, visited: Array<BooleanArray>): Boolean{

    if (len == word.length) return true
    if (    row < 0
            || row >= data.size
            || col < 0
            || col >= data[row].size
            || visited[row][col]
            || data[row][col] != word[len]
    ){
        return false
    }
    visited[row][col] = true
    if (       searchWord(data, row+1, col, word, len+1, visited)
            || searchWord(data, row-1, col, word, len+1, visited)
            || searchWord(data, row, col+1, word, len+1, visited)
            || searchWord(data, row, col-1, word, len+1, visited)
    ){ return true }

    visited[row][col] = false
    return false
}

fun main() {
    val row1: CharArray = charArrayOf('A', 'B', 'C', 'E')
    val row2: CharArray = charArrayOf('S', 'F', 'C', 'S')
    val row3: CharArray = charArrayOf('A', 'D', 'E', 'E')
    val data: Array<CharArray> = arrayOf(row1, row2, row3)
    val result1: Boolean = searchWord(data, "ABCCED")
    println(result1)
    val result2: Boolean = searchWord(data, "ABCB")
    println(result2)
}