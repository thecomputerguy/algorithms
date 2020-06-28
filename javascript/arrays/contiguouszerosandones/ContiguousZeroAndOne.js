
function contiguousArray(data){
    if(!data || data.length == 0) return 0
    let counts = {}
    counts[0] = -1
    let count = 0
    let maxLen = Number.MIN_VALUE
    for (let index = 0; index < data.length; index++) {
        if(data[index] === 0){
            count += -1
        }else{
            count += 1
        }

        if(counts[count]){
            maxLen = Math.max(maxLen, index - counts[count])
        }else{
            counts[count] = index
        }
    }

    return maxLen
}

let result1 = contiguousArray([0, 1])
console.log(result1)


let result2 = contiguousArray([0, 1, 0])
console.log(result2)