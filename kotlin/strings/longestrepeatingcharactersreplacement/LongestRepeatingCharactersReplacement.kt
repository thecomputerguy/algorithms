fun longestRepeatingCharactersReplacement(data: String, k: Int): Int{
    requireNotNull(data) { "input must not be null" }
    check(data.length > 0){ "input must not ne empty" }
    check(k > 0){ "k must be greater than 0" }
    val charCounts = IntArray(26){ _ -> 0}
    var endPointer = 0
    var startPointer = 0
    var maxCount = 0
    var maxLength = 0

    while(endPointer < data.length){
        charCounts[data[endPointer] - 'A']++
        val currentCharacterCount = charCounts[data[endPointer] - 'A']
        maxCount = maxOf(currentCharacterCount, maxCount)
        while(endPointer - startPointer - maxCount + 1 > k){
            charCounts[startPointer]--
            startPointer++
        }
        maxLength = maxOf(maxLength, endPointer - startPointer + 1)
        endPointer++
    }
    return maxLength
}

fun main(args: Array<String>) {
    val result = longestRepeatingCharactersReplacement("ABAB", 2)
    println("longest repeating characters: $result")
}