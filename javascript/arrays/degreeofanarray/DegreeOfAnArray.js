function degreeOfAnArray(data) {
    if(!data || data.length == 0) return 0
    
    let minLen = Number.MAX_VALUE
    let countsMap = new Map()
    let firstSeen = new Map()
    let degree = 0
    for (let index = 0; index < data.length; index++) {
        if(!firstSeen.has(data[index])) firstSeen.set(data[index], index)
        if(countsMap.has(data[index])) countsMap.set(data[index] , countsMap.get(data[index]) + 1)
        else countsMap.set(data[index], 1)
        
        if(countsMap.get(data[index]) > degree){
            degree = countsMap.get(data[index])
            minLen = (index - firstSeen.get(data[index]) + 1)
        }else if(countsMap.get(data[index]) === degree){
            minLen = Math.min(minLen, index - firstSeen.get(data[index]) + 1)
        }
    }
    return minLen
}

let result = degreeOfAnArray([1,2,2,3,1])
console.log(result)


let result2 = degreeOfAnArray([1,2,2,3,1,4,2])
console.log(result2)