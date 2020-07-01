function houseRobber(houses){
    if(!houses || houses.length === 0) return 0
    let dp = []
    dp[0] = 0
    dp[1] = houses[0]
    for (let index = 1; index < houses.length; index++) {
        dp[index+1] = Math.max(dp[index], dp[index-1] + houses[index])    
    }
    return dp[houses.length]
}

let houses = [1,2,3,1]
let result = houseRobber(houses)
console.log(result)