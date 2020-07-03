function captureSurroundedRegions(board){
    if(!board || board.length === 0 || board[0].length == 0) return board
    const rows = board.length
    const cols = board[0].length
    for (let row = 0; row < rows; row++) {
         if(board[row][0] === 'O') boundryDFS(board, row, 0)
         if(board[row][cols-1] === 'O') boundryDFS(board, row, cols-1)
        
    }
    for (let col = 0; col < cols; col++) {
        if(board[0][col] === 'O') boundryDFS(board, 0, col)
        if(board[rows-1][col] === 'O') boundryDFS(board, rows-1, col)
   }

   for (let row = 0; row < rows; row++) {
       for (let col = 0; col < cols; col++) {
        if(board[row][col] === 'O') board[row][col] = 'X'
        if(board[row][col] === '*') board[row][col] = 'O'   
       }
   }

   return board
}

function boundryDFS(board, row, col){
    if(row < 0 || row >= board.length || col < 0 || col >= board[row].length) return
    if(board[row][col] === 'O') board[row][col] = '*'
    if(row > 0 && board[row-1][col] === 'O') boundryDFS(board, row-1, col)
    if(row < board.length-1 && board[row+1][col] === 'O') boundryDFS(board, row+1, col)
    if(col > 0 && board[row][col-1] === 'O') boundryDFS(board, row, col-1)
    if(col < board[row].length-1 && board[row][col+1] === 'O') boundryDFS(board, row, col+1)
}

let board = [
    ['X','X','X','X'],
    ['X','O','O','X'],
    ['X','X','O','X'],
    ['X','O','X','X']
]
const result = captureSurroundedRegions(board)
console.log(result)