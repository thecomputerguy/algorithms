"use strict";

function productOfArrayExceptSelf(data) {
    if(!data) return []
    
    const N = data.length - 1
    console.log(`length of data is ${N + 1}`)
    const result = []
    const leftElementsProduct = []
    leftElementsProduct[0] = 1
    const rightElementsProduct = []
    rightElementsProduct[N] = 1

    for (let index = 1; index < data.length; index++) {
        leftElementsProduct[index] = data[index - 1] * leftElementsProduct[index - 1]
    }

    for (let index = N-1; index >= 0; index--) {
        rightElementsProduct[index] = data[index+1] * rightElementsProduct[index+1]
    }

    for (let index = 0; index < data.length; index++) {
        result[index] = leftElementsProduct[index] * rightElementsProduct[index]
        
    }
    return result
}

function printResult(data) {
    if (!data) return
    let result = ""
    data.forEach(element => {
        result = result + " " + element
    });
    console.log(`${result} `)    
}

const result = productOfArrayExceptSelf([1,2,3,4])
printResult(result)