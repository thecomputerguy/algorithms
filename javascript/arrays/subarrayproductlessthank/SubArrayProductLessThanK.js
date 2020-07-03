function subArrayProductLessThanK(nums, k){
    if(!nums || nums.length <= 1) return 0
    let left = 0
    let right = 0
    let product = 1
    let result = 0
    while(right < nums.length){
        product = product * nums[right]

        while(product >= k){
            product = Math.floor(product / nums[left])
            left++
        }
        result += (right - left) + 1
        right++
    }
    return result
}

let nums = [10,5,2,6]
let k = 100
let result = subArrayProductLessThanK(nums, k)
console.log(result)