"use strict";

function partitionLabels(input){
    if(!input) return []
    const output = []
    const endings = []
    for (let index = 0; index < input.length; index++) {
        endings[input.charCodeAt(index) - 97] = index
    }

    let start = 0
    let end = 0
    let index = 0
    while(index < input.length){
        let endIndex = input.charCodeAt(index) - 97
        end = Math.max(endings[endIndex], end)
        if(end === index){
            output.push(end - start + 1)
            start = index + 1
        }
        index++
    }
    return output
}

function displayResult(data){
    if(!data) return
    let result = ""
    data.forEach(element => {
        result = result + " " + element
    });
    console.log(result)
}

const result = partitionLabels("ababcbacadefegdehijhklij")
displayResult(result)