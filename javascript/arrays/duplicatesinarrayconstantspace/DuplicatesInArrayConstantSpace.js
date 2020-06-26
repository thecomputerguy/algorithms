function duplicates(data){
    if(!data) return []
    const result = []
    for (let index = 0; index < data.length; index++) {
        const element = Math.abs(data[index]) - 1;
        if(data[element] < 0){
            result.push(element + 1)
        }
        else {
            data[element] = -data[element]
        }
    }
    return result
}

const displayResult = (data) => {
    if(!data) return
    let result = ""
    for (let index = 0; index < data.length; index++) {
        const element = data[index];
        result = result + " " + element
    }
    console.log(`result: ${result}`)
}

let result = duplicates([4,3,2,7,8,2,3,1])
displayResult(result)