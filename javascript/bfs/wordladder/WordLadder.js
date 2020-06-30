function wordSearch(beginWord, endWord, wordList){
    if (!beginWord || beginWord.length === 0  || !endWord || endWord.length === 0 || !wordList || wordList.length === 0) return 0
    let words = new Set(wordList)
    if (!words.has(endWord)) {
        return 0
    }

    let level = 1
    let queue = []
    queue.push(beginWord)
    while(queue.length > 0){
        let size = queue.length
        while(size > 0){
            let word = [...queue.shift()]
            for (let index = 0; index < word.length; index++) {
                //go through each character for transformations
                let originalChar = word[index]
                for (let c = 97; c < 97+26; c++) {
                    let char = String.fromCharCode(c)
                    if (word[index] === char) {
                        continue
                    }
                    word[index] = char
                    let newWord = word.join("")
                    console.log(`newWord: ${newWord} : typeof: ${typeof(newWord)} ----> endWord: ${endWord} : typeof: ${typeof(endWord)}`)
                    if (newWord === endWord) {
                        return level + 1
                    }
                    if (words.has(newWord)) {
                        queue.push(newWord)
                    }
                }
                word[index] = originalChar
            }        

            size--
        }
        level++
    }

    return 0
}

let result = wordSearch("hit", "cog", ["hot", "dot", "dog", "lot", "log", "cog"])
console.log(result)