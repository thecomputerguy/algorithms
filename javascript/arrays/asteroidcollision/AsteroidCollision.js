function asteroidCollision(asteroids){
    if(!asteroids || asteroids.length == 0) return []
    
    let stack = []
    for (let index = 0; index < asteroids.length; index++) {
        const asteroid = asteroids[index];
        if(stack.length == 0 || asteroid > 0){
            stack.push(asteroid)
        }else{
            while (true) {
                let peek = stack[stack.length-1]
                if (peek < 0) {
                    stack.push(asteroid)
                    break
                }else if (peek == -asteroid) {
                    stack.pop()
                    break
                }else if (peek > -asteroid) {
                    break                    
                }else{
                    stack.pop()
                    if(stack.length == 0){
                        stack.push(asteroid)
                        break
                    }
                }
            }
        }
    }

    let output = []
    while (stack.length > 0) {
        output.push(stack.pop())
    }
    return output
}

let result1 = asteroidCollision([5,10,-5])
console.log(result1)


let result2 = asteroidCollision([8,-8])
console.log(result2)