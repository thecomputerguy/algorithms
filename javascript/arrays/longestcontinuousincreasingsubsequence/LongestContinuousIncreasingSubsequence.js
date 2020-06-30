function longestContinuousIncreasingSubsequence(data){
    if(!data || data.length === 0) return 0
    let start = 0
    let end = 1
    let maxLen = Number.MIN_VALUE
    
    while(end < data.length){
        if (data[end] < data[end-1]) {
            start = end
        }
        maxLen = Math.max(maxLen, end - start + 1)
        end++   
    }
    return maxLen
}

let data = [1,3,5,4,7]
let result = longestContinuousIncreasingSubsequence(data)
console.log(result)