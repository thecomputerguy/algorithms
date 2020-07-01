function longestPalindromicSubstring(S){
    if(!S || S.length === 0) return ""

    let start = 0
    let end = 0
    for (let index = 0; index < S.length; index++) {
        let len1 = expandFromMiddle(S, index, index)
        let len2 = expandFromMiddle(S, index, index+1)
        
        let len = Math.max(len1, len2)
        if (len > (end-start)) {
            start = index - Math.floor(len/2)
            end = index + Math.floor(len/2) 
        }
    }
    console.log(`start: ${start} -> end: ${end}`)
    return S.substring(start, end+1)
}

function expandFromMiddle(S, left, right){
    if(S == null || left > right) return 0
    console.log(`S[left] = ${S[left]} : S[right] : ${S[right]} ----> ${S[left] === S[right]}`)
    while(left >= 0 && right < S.length && S[left] === S[right]){
        left--
        right++
    }
    return right - (left + 1)
}

let S = "babad"
let result = longestPalindromicSubstring(S)
console.log(result)