function schedule(tasks, idleTime){
    if(!tasks) return 0
    let countsMap = new Array(26)
    countsMap.fill(0)
    for (let index = 0; index < tasks.length; index++) {
        let countsIndex = tasks[index].charCodeAt(0)
        countsMap[countsIndex-65]++
    }
    countsMap.sort((a,b) => a-b)
    let max = countsMap[countsMap.length-1] - 1
    let idleSlots = max * idleTime
    for (let index = countsMap.length-2; index >= 0; index--) {
        idleSlots -= Math.min(countsMap[index], max)
    }
    return idleSlots > 0 ? idleSlots + tasks.length : tasks.length
}

let tasks = ["A", "A", "A", "B", "B", "B"]
let result = schedule(tasks, 2)
console.log(result)