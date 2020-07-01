
function monotonicArray(data){
    if(!data || data.length <= 1) return fasle
    let increasing = true
    let decreasing = true
    for (let index = 0; index < data.length-1; index++) {
        if(data[index] < data[index+1]) decreasing = false
        if(data[index] > data[index+1]) increasing = false
    }

    if(increasing) return true
    if(decreasing) return true
    return false
}

let data = [1,2,2,3]
let result = monotonicArray(data)
console.log(result)

let data1 = [6,5,5,4]
let result1 = monotonicArray(data1)
console.log(result1)

let data2 = [1,3,2]
let result2 = monotonicArray(data2)
console.log(result2)