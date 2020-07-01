function validSudoku(board){

    if(!board || board.length === 0 || board[0].length === 0) return false
    
    let seen = new Set()
    for (let row = 0; row < board.length; row++) {
        for (let col = 0; col < board[row].length; col++) {
            let element = board[row][col]
            if (element !== ".") {
                
                let rowData = `${element} found in row ${row}`
                let colData = `${element} found in col ${col}`
                let subGridData = `${element} found in sub grid ${Math.floor(row/3)} - ${Math.floor(col/3)}`
                
                if (seen.has(rowData) || seen.has(colData) || seen.has(subGridData))
                    return false

                seen.add(rowData)
                seen.add(colData)
                seen.add(subGridData)
            
        }
    }
}
    return true
}
let board1 = [
    ["5","3",".",".","7",".",".",".","."],
    ["6",".",".","1","9","5",".",".","."],
    [".","9","8",".",".",".",".","6","."],
    ["8",".",".",".","6",".",".",".","3"],
    ["4",".",".","8",".","3",".",".","1"],
    ["7",".",".",".","2",".",".",".","6"],
    [".","6",".",".",".",".","2","8","."],
    [".",".",".","4","1","9",".",".","5"],
    [".",".",".",".","8",".",".","7","9"]
  ]
let result1 = validSudoku(board1)
console.log("is valid board? ", result1)

let board2 = [
    ["8","3",".",".","7",".",".",".","."],
    ["6",".",".","1","9","5",".",".","."],
    [".","9","8",".",".",".",".","6","."],
    ["8",".",".",".","6",".",".",".","3"],
    ["4",".",".","8",".","3",".",".","1"],
    ["7",".",".",".","2",".",".",".","6"],
    [".","6",".",".",".",".","2","8","."],
    [".",".",".","4","1","9",".",".","5"],
    [".",".",".",".","8",".",".","7","9"]
  ]
  let result2 = validSudoku(board2)
  console.log("is valid board?", result2)