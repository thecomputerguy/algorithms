function globalAndLocalInversion(data){
    if(!data || data.length === 0) return 0
    let max = -1
    for (let index = 0; index < data.length-2; index++) {
        max = Math.max(max, data[index])
        if (max > data[index+2]) {
            return false
        }
    }
    return true
}

let data = [1,2,0]
let result = globalAndLocalInversion(data)
console.log(result)

let data1 = [1,0,2]
let result1 = globalAndLocalInversion(data1)
console.log(result1)