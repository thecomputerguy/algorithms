function scoreOfParenthesis(S){
    if(!S || S.length == 0) return 0
    let score = 0
    let stack = []
    for (let index = 0; index < S.length; index++) {
        if(S[index] === '('){
            stack.push(score)
            score = 0
        }else{
            score = stack.pop() + Math.max(2*score, 1)
        }
    }
    return score
}

let S = "(())"
let result = scoreOfParenthesis(S)
console.log(result)


let S1 = "((()))"
let result1 = scoreOfParenthesis(S1)
console.log(result1)