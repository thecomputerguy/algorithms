
function uniqueOccurrences(data){
    if(!data || data.length === 0) return false
    let countsMap = {}
    for (let index = 0; index < data.length; index++) {
        if(data[index] in countsMap) countsMap[data[index]] = countsMap[data[index]] + 1
        else countsMap[data[index]] = 1
    }

    let values = new Set(Object.values(countsMap))
    return values.size == Object.keys(countsMap).length
}

let result = uniqueOccurrences([1,2,2,1,1,3])
console.log("Occurrences are unique? ", result)

let result2 = uniqueOccurrences([1,2])
console.log("Occurrences are unique? ", result2)