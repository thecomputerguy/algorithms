fun longestSubstringWithoutRepeatingCharacters(data: String): Int{
    require(data != null){"input cannot be null"}
    check(data.length > 0){"There must be atleast one character in the given input"}
    var max = 0
    var left: Int = 0
    var right: Int = 0
    var hashSet = mutableSetOf<Char>()

    while (right < data.length){
        if (!hashSet.contains(data[right])){
            hashSet.add(data[right])
            right++
            max = maxOf(max, hashSet.size)
        }else{
            hashSet.remove(data[left])
            left++
        }
    }
    return max
}

fun main() {
    val result: Int = longestSubstringWithoutRepeatingCharacters("abcabcbb")
    println(result)
}