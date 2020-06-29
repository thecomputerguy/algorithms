function reshapeMatrix(matrix, r, c){
    if (!matrix || matrix.length == 0 || matrix[0].length == 0) return matrix
    let rows = matrix.length
    let cols = matrix[0].length
    if((rows * cols) !== (r*c)) return matrix
    let result = Array(r)
    for (let index = 0; index < r; index++) {
        result[index] = []
    }

    let rowIndex = 0
    let colIndex = 0
    for (let row = 0; row < matrix.length; row++) {
        for (let col = 0; col < matrix[row].length; col++) {
            result[rowIndex][colIndex++] = matrix[row][col]
            if (colIndex == c) {
                colIndex = 0
                rowIndex++
            }
        }
    }
    return result
}

let matrix = [[1,2], [3,4]]
let result = reshapeMatrix(matrix, 1, 4)
console.log(result)