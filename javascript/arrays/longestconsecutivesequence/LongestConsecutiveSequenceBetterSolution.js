function buildConstantTimeLookup(input){
    let holder = new Set(input)
    return holder
}

function longestConsecutiveSequence(input){
    if(!input || input.length === 0) return 0
    
    let holder = buildConstantTimeLookup(input)
    let maxSequenceLength = Number.MIN_VALUE

    for (let index = 0; index < input.length; index++) {
        let element = input[index]
        let currentSequenceLength = 1

        //only check for consecutive elements if it's the smallest element in the sequence
        if(!holder.has(element-1)){
            while(holder.has(element+1)){
                element = element+1
                currentSequenceLength++
            }
        }
        maxSequenceLength = Math.max(currentSequenceLength, maxSequenceLength)
    }
    return maxSequenceLength
}

let input = [100,4,200,1,3,2]
let result = longestConsecutiveSequence(input)
console.log("Longest consecutive sequence length is ", result)