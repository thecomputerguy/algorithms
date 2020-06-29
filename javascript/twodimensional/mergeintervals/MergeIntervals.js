function mergeIntervals(intervals){
    if(!intervals || intervals.length < 2 || intervals[0].length < 2) return [[]]
    let result = []
    let currentInterval = intervals[0]
    result.push(currentInterval)
    for (let index = 1; index < intervals.length; index++) {
        let currentBegin = currentInterval[0]
        let currentEnd = currentInterval[1]
        let next = intervals[index]
        let nextBegin = next[0]
        let nextEnd = next[1]

        if(currentEnd >= nextBegin){
            currentInterval[1] = Math.max(currentEnd, nextEnd)
        }else{
            currentInterval = next
            result.push(currentInterval)
        }
    }

    return result
}

let intervals = [[1,3],[2,6],[8,10],[15,18]]
console.log("Before merging ", intervals)
const result = mergeIntervals(intervals)
console.log("After merging ", result)