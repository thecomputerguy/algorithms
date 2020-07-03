function findJudge(N, trust){
    if(!trust || trust.length === 0 || trust[0] .length === 0 || !N) return 0
    let trustCount = new Array(N+1)
    trustCount.fill(0)
    for(let index = 0; index < trust.length; index++){
        let [personWhoIsTrusting, personWhoIsBeingTrusted] = trust[index]
        trustCount[personWhoIsBeingTrusted]++
        trustCount[personWhoIsTrusting]--
    }

    let judge = -1
    for (let index = 1; index < trustCount.length; index++) {
        if(trustCount[index] === (N-1)){
            judge = index
            break
        }
        
    }

    return judge
}
let N = 2
let trust = [[1,2]]
const judge = findJudge(N, trust)
console.log(judge)

let N1 = 3
let trust1 = [[1,3],[2,3]]
const judge1 = findJudge(N1, trust1)
console.log(judge1)

let N2 = 3
let trust2 = [[1,3],[2,3],[3,1]]
const judge2 = findJudge(N2, trust2)
console.log(judge2)