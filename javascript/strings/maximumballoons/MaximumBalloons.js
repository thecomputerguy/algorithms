function maxBalloons(data){
    if(!data || data.length == 0) return 0
    let charCounts = new Array(26).fill(0)
    for (let index = 0; index < data.length; index++) {
        charCounts[data.charCodeAt(index) - 97]++;
    }
    
    let min = charCounts[1] //b
    min = Math.min(min, charCounts[0]) //a
    min = Math.min(min, charCounts[11]) //l
    min = Math.min(min, charCounts[14]) //o
    min = Math.min(min, charCounts[13]) //n
    return min
}

let result1 = maxBalloons("nlaebolko")
console.log("max balloons ", result1)

let result2 = maxBalloons("loonbalxballpoon")
console.log("max balloons ", result2)