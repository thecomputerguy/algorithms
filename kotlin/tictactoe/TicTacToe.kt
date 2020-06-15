class TicTacToe(val n: Int) {
    var rowSum = IntArray(n)
    var colSum = IntArray(n)
    var diagonalSum = 0
    var antiDiagonalSum = 0

    fun move(row: Int, col: Int, player: Int): Int{
        
        var playerValue: Int
        if(player == 1)  playerValue = 1 else if(player == 2) playerValue = -1 else throw IllegalArgumentException("player value can only be 1 or 2")
        
        if(row < 0 || row >= rowSum.size || col < 0 || col >= colSum.size){
            throw IllegalArgumentException("row or column value is not within bounds.")
        }

        if(row == col){
            diagonalSum = diagonalSum + playerValue
        }

        if(col == (colSum.size - 1 - row)){
            antiDiagonalSum = antiDiagonalSum + playerValue
        }
        
        rowSum[row] = rowSum[row] + playerValue
        colSum[col] = colSum[col] + playerValue
        
        if(Math.abs(diagonalSum) == n ||
            Math.abs(antiDiagonalSum) == n ||
            Math.abs(rowSum[row]) == n ||
            Math.abs(colSum[col]) == n){
                println("diagonalSum: $diagonalSum antidiagonalSum: $antiDiagonalSum rowSum: $rowSum[row] and colSum: $colSum[col]")
                return player
        }

        return 0
    }
}

fun main(args: Array<String>) {
    
    println("Tic tac toe game.")
    val ticTacToe = TicTacToe(3)
    var result = ticTacToe.move(0, 0, 1)
    println("result: $result")
    if(result != 0) println("palyer $result won!")
    result = ticTacToe.move(1, 0, 2)
    if(result != 0) println("palyer $result won!")
    result = ticTacToe.move(0, 1, 1)
    if(result != 0) println("palyer $result won!")
    result = ticTacToe.move(1, 1, 2)
    if(result != 0) println("palyer $result won!")
    result = ticTacToe.move(0, 2, 1)
    if(result != 0) println("palyer $result won!")
}