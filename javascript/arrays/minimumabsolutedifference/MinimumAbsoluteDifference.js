function minimumAbsoluteDifference(data){
    if(!data || data.length == 0) return [[]]
    data.sort((a,b) => a-b)
    console.log("data after sorting ", data)
    let min = Number.MAX_VALUE
    for (let index = 1; index < data.length; index++) {
        let diff = data[index] - data[index - 1]
        console.log("diff ", diff)
        min = Math.min(min, diff)    
    }
    console.log("min ", min)
    let result = []
    for (let index = 1; index < data.length; index++) {
        if (data[index] - data[index - 1] === min) {
            result.push([data[index - 1], data[index]])
        }
    }
    return result
}

let dataset1 = [4,2,1,3]
const result = minimumAbsoluteDifference(dataset1)
console.log(result)

let dataset2 = [1,3,6,10,15]
const result2 = minimumAbsoluteDifference(dataset2)
console.log(result2)