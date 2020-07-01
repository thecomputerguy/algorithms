function monotonicArray(data){
    if(!data || data.length < 1) return false
    for (let index = 1; index < data.length; index++) {
        if ((data[1] >= data[0] && data[index] < data[index-1]) || (data[1] <= data[0] && data[index] > data[index-1])) {
            return false
        }
    }
    return true
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