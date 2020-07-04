function queensThatCanAttack(king, seen, result){
    let directions = [-1, 0, 1]
    for (let dx of directions) {
        for (let dy of directions) {
            if(dx === 0 && dy === 0) continue
            let [row, col] = king
            while(row+dx >= 0 && row+dx < seen.length && col+dy >= 0 && col+dy < seen[row+dx].length){
                row += dx
                col += dy
                if(seen[row][col]){
                    result.push([row, col])
                    break
                }
            }
        }
    }
}

function markQueensPosition(seen, queens){
    for (let index = 0; index < queens.length; index++) {
        let [row, col] = queens[index]
        seen[row][col] = true
    }
}

function initializeSeen(seen){
    for (let index = 0; index < 8; index++) {
        let row = new Array(8)
        row.fill(false)
        seen.push(row)
    }
}

function queensThatCanAttackTheKing(queens, king){
    let result = []
    if(!queens || queens.length === 0 || queens[0].length === 0 || !king || king.length != 2) return result
    let seen = []
    initializeSeen(seen)
    markQueensPosition(seen, queens)
    queensThatCanAttack(king, seen, result)
    return result 
}

let queens = [[0,0],[1,1],[2,2],[3,4],[3,5],[4,4],[4,5]]
let king = [3,3]
let positionOfQueensThatCanAttack = queensThatCanAttackTheKing(queens, king)
console.log(positionOfQueensThatCanAttack)