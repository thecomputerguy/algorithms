function distributeCandies(candies, people){
    if (candies === 0) return []
    if(people === 0) return []

    let index = 0
    let loops = 0
    let result = []
    while(candies > 0){

        if(people === index){
            index = 0
            loops++
        }

        currentCandies = (loops * people) + (index + 1)
        if (candies - currentCandies < 0) {
            result.push(candies)
        }else{
            result.push(currentCandies)
        }
        index++
        candies = candies - currentCandies
    }
    return result
}

let candies1 = 2
let people1 = 4
let result1 = distributeCandies(candies1, people1)
console.log(result1)

let candies2 = 7
let people2 = 4
let result2 = distributeCandies(candies2, people2)
console.log(result2)