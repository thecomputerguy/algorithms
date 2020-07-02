function findAllAnagramsInAString(S, P){
    if(!S || S.length === 0 || !P || P.length === 0) return []
    
    let charCount = Array(26)
    charCount.fill(0)
    for (let index = 0; index < P.length; index++) {
        charCount[P.charCodeAt(index)-97]++
    }

    let result = []
    let left = 0
    let right = 0
    let count = P.length
    while(right < S.length){
        if(charCount[S.charCodeAt(right++)-97]-- >= 1) count--
        if(count === 0) result.push(left)
        if(right-left === P.length && charCount[S.charCodeAt(left++)-97]++ >= 0) count++
    }

    return result
}

let S = "cbaebabacd"
let P = "abc"
let result = findAllAnagramsInAString(S, P)
console.log(result)