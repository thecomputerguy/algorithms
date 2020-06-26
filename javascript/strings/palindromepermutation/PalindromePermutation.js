"use strict";

function palindromePermutation(input) {
    if (!input) return false
    const charCountLength = 128
    const charCount = new Array(charCountLength)
    charCount.fill(0)
    let index = 0
    //build a char count
    while (index < input.length) {
        charCount[input.charCodeAt(index++)]++ 
    }

    index = 0
    let sum = 0
    while(index < charCountLength){
        sum += charCount[index++] % 2
    }

    return sum <= 1
}

const result1 = palindromePermutation("code")
console.log(`is palindrome permutation:  ${result1}`)

const result2 = palindromePermutation("aab")
console.log(`is palindrome permutation:  ${result2}`)