function minimumRemoveToMakeParenthesisValid(S){
    if(!S || S.length === 0) return S
    let builder = ""
    let open = 0
    for (let index = 0; index < S.length; index++) {
        let currentChar = S[index]
        if(currentChar === '('){
            open++
        }else if(currentChar === ')'){
            if(open <= 0) continue
            open--
        }
        builder = builder + currentChar
    }

    let result = ""
    for (let index = builder.length-1; index >= 0; index--) {
        let currentChar = builder[index]
        if(currentChar === '(' && open-- > 0) continue
        result = result + currentChar
   }

   return result.split("").reverse().join("")
}

let S = "lee(t(c)o)de)"
let result = minimumRemoveToMakeParenthesisValid(S)
console.log(result)