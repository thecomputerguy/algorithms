function shortestUnsortedSubArray(data){
    if(!data || data.length === 0) return 0
    let min = Number.MAX_VALUE
    let max = Number.MIN_VALUE
    let unsorted = false
    for (let index = 1; index < data.length; index++) {
        if(data[index] < data[index-1]) 
            unsorted = true

        if(unsorted){ 
            min = Math.min(min, data[index])
        }
    }

    unsorted = false
    for (let index = data.length-2; index >= 0; index--) {
        if(data[index] > data[index+1]) unsorted = true

        if(unsorted){
            max = Math.max(data[index], max)
        }
        
    }

    let left = 0
    for (let index = 0; index < data.length; index++) {
        if(min < data[index]){
            left = index
            break
        }
        
    }

    let right = 0
    for (let index = data.length-1; index >= 0; index--) {
        if(max > data[index]){
            right = index
            break
        }
    }

    return (right - left + 1) < 0 ? 0 : (right - left + 1)
}

let data = [2,6,4,8,10,9,15]
let result = shortestUnsortedSubArray(data)
console.log(result)