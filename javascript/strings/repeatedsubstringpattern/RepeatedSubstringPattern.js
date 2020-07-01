"use strict";

function repeatedSubstringPattern(S){
    if (!S || S.length < 2) return false
    
    let len = S.length
    let mid = Math.floor(S.length/2)

    for (let index = mid; index >= 1; index--) {
        if ((len%index) === 0) {
            let repeatitions = Math.floor(len/2)
            let part = S.substring(0,index)
            let stringFromParts = ""
            for (let rep = 0; rep < repeatitions; rep++) {
                stringFromParts += part
            }
            if (stringFromParts === S) {
                return true
            }
        }
    }
    
    return false
}

let S = "abab"
let result = repeatedSubstringPattern(S)
console.log(result)