function generateParenthesis(max){
    if(max <= 0) return []
    let output = []
    generateParenthesisHelper(output, "", 0, 0, max)
    return output
}

function generateParenthesisHelper(output, S, open, close, max){
    console.log("incoming String ", S)
    if (S.length === (max*2)) {
        output.push(S)
        return
    }

    if(open < max) generateParenthesisHelper(output, S + "(", open+1, close, max)
    if(close < open) generateParenthesisHelper(output, S + ")", open, close+1, max)
}

let max = 3
let result = generateParenthesis(max)
console.log(result)