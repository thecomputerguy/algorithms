fun wordSubsets(A: Array<String>, B: Array<String>): List<String> {
    val result = mutableListOf<String>()
    if (input1 == null || input1.isEmpty() || input2 == null || input2.isEmpty()) return result

    //build the max char count of B array first. These are number of characters that each word should have
    //to be a universal word.
    val maxCharCount: IntArray = IntArray(26)
    for (word in B) {
        val currentWordCount: IntArray = buildCharCount(word)
        for (i in 0 until 26){
            maxCharCount[i] = maxOf(currentWordCount[i], maxCharCount[i])
        }
    }

    //iterate over A array and build the count of characters in each word
    //if the count of characters in the word is less than the count of character in the max characters array
    //then the word is not universal word as it does not have all the required characters.
    for (word in A) {

        val wordCharacterCount: IntArray = buildCharCount(word)
        var valid: Boolean = true;

        for (i in 0 until 26) {

            val count: Int = wordCharacterCount[i]
            val maxCount: Int = maxCharCount[i]
            if (maxCount > count){
                valid = false
                break
            }

        }

        if (valid) {
            result.add(word)
        }
    }

    return result
}

fun buildCharCount(word: String): IntArray {

    val mapping = IntArray(26)
    for (ch in word) {
        val key: Int = ch - 'a'
        mapping[key] = mapping[key] + 1
    }
    return mapping
}


fun main(args: Array<String>) {
    println("word subsets problem solution.")
    val input1: Array<String> = arrayOf("amazon", "facebook", "google", "netflix", "leetcode")
    val input2: Array<String> = arrayOf("e", "o")
    val result: List<String> = wordSubsets(input1, input2)
    println("Universal words are : ")
    println("size ${result.size}")
    result.stream().forEach(::println)
}