fun getTotalLength(words: Array<String>, characters: String): Int {
    if (words == null || words.size == 0 || characters == null || characters.length == 0) return 0
    //Build charCount
    val charCount: IntArray = buildCharCount(characters)
    var totalLength: Int = 0
    //iterate over words and build charCount for each word
    for (word in words){
        val wordCharCount: IntArray = buildCharCount(word)
        var valid: Boolean = true
        for (index in 0 until 26){
            if (wordCharCount[index] > charCount[index]) {
                valid = false
                break
            }
            //charCount[index] -= wordCharCount[index]
        }

        if (valid) totalLength += word.length
    }
    return totalLength
}
fun buildCharCount(characters: String): IntArray {
    val charCount: IntArray = IntArray(26)
    for (ch in characters){
       val index =  ch - 'a'
        charCount[index] += 1
    }
    return charCount
}

fun main() {
    val words1: Array<String> = arrayOf("cat", "bt", "hat", "tree")
    val characters1: String = "atach"
    val totalLength1: Int = getTotalLength(words1, characters1)
    println(totalLength1)

    val words2: Array<String> = arrayOf("hello", "world", "leetcode")
    val characters2: String = "welldonehoneyr"
    val totalLength2: Int = getTotalLength(words2, characters2)
    println(totalLength2)
}