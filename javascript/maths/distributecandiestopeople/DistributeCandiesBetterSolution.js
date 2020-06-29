function distributeCandies(candies, people){
    let result = new Array(people)
    result.fill(0)
    for (let index = 0; candies > 0; index++) {
        result[index % people] += Math.min(candies, index + 1)
        candies = candies - (index + 1)
    }
    return result
}

let people = 4
let candies = 7
let result = distributeCandies(candies, people)
console.log(result)