function longestWord(words){
    if(!words || words.length == 0) return null
    words.sort()
    let holder = new Set()
    let index = 0
    let result = ""
    while(index < words.length){
        if(index == 0 || holder.has(words[index].substring(0, words[index].length - 1))){
            if(result. length < words[index].length){
                result = words[index]
            }
            holder.add(words[index])
        }
        index++
    }

    return result
}
let dictionary = ["w", "wo", "wor", "worl" , "world"]
let result = longestWord(dictionary)
console.log(result)