"use strict";

const productExceptSelf = (nums) => {
    if(!nums) return []
    const N = nums.length
    const result = []
    result[0] = 1
    for(let index = 1; index < N; index++){
        result[index] = result[index-1] * nums[index-1]
    }

    let rightProduct = 1
    for (let index = N-1; index >= 0; index--) {
        result[index] = result[index] * rightProduct;
        rightProduct = rightProduct * nums[index]
    }
    return result
}

const printResult = (data) => {
    if (!data) return
    let result = ""
    data.forEach(element => {
        result = result + " " + element
    });
    console.log(result)
}

const result = productExceptSelf([1,2,3,4])
printResult(result)