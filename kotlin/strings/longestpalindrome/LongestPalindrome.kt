fun longestPalindrome(data: String): Int{
    requireNotNull(data){"input must not be null"}
    check(data.length > 0){"input must not be empty"}
    val charCounts = buildCharCounts(data)
    var len = 0
    for (count in charCounts) {
        len += ((count / 2) * 2)
        if((len % 2 == 0) && (count % 2 == 1)){
            len += 1
        }
    }
    return len
}

fun buildCharCounts(data: String): IntArray{
    val charCounts = IntArray(128){_ -> 0}
    for (char in data) {
        charCounts[char.toInt()]++
    }
    return charCounts
}

fun main(args: Array<String>) {
    val result = longestPalindrome("abccccdd")
    println("Longest palindrome length: $result")
}