function nextNumExists(element, data){
    for (let index = 0; index < data.length; index++) {
        if(data[index] === element) return true
    }
    return false
}

function longestConsecutiveSequence(input){
    if(!input || input.length === 0) return 0
    let maxSequenceLength = Number.MIN_VALUE
    for (let index = 0; index < input.length; index++) {
        let element = input[index]
        let currentSequenceLength = 1

        while(nextNumExists(element+1, input)){
            element = element+1
            currentSequenceLength++
        }
        maxSequenceLength = Math.max(maxSequenceLength, currentSequenceLength)
    }
    return maxSequenceLength
}

let input = [100,4,200,1,3,2]
let result = longestConsecutiveSequence(input)
console.log("Longest consecutive sequence is of length ", result)