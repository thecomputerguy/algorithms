function isSubsequence(S, T){
    if(!S || !T || S.length === 0 || T.length === 0) return 0

    let spointer = 0
    let tpointer = 0
    while(tpointer < T.length){
        if (S[spointer] === T[tpointer]) {
            spointer++
        }

        if (spointer === S.length) {
            return true
        }

        tpointer++
    }

    return false
}

const S = "abc"
const T = "ahbgdc"
let result = isSubsequence(S, T)
console.log(result)


const S1 = "axc"
const T1 = "ahbgdc"
let result1 = isSubsequence(S1, T1)
console.log(result1)