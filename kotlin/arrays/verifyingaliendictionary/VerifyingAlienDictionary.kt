fun isSorted(words: Array<String>, order: String): Boolean{
    requireNotNull(words){"words must not be null"}
    check(words.size > 0){"words must not empty"}
    requireNotNull(order){"order must not be null"}
    check(order.length > 0){"order must not be empty"}
    val mapping = buildMappingForChars(order)
    var index = 1
    while (index < words.size) {
        if(compare(words[index-1], words[index], mapping) > 0){
            return false
        }
        index++
    }
    return true
}

fun buildMappingForChars(order: String): IntArray{
    val mapping = IntArray(26)
    for ((index, char) in order.withIndex()) {
        val charIndex: Int = char - 'a'
        mapping[charIndex] = index 
    }
    return mapping
}

fun compare(first: String, second: String, mapping: IntArray): Int{
    var firstPointer = 0
    var secondPointer = 0
    var compareVal = 0
    while(firstPointer < first.length && secondPointer < second.length && compareVal == 0){
        compareVal = mapping[first[firstPointer]-'a'] - mapping[second[secondPointer]-'a']
        firstPointer++
        secondPointer++
    }

    if(compareVal == 0){
        return first.length - second.length
    }else{
        return compareVal
    }

}

fun main(args: Array<String>) {
    val result1 = isSorted(arrayOf<String>("hello", "leetcode"), "hlabcdefgijkmnopqrstuvwxyz")
    println("is sorted? $result1")
    val result2 = isSorted(arrayOf<String>("word", "world", "row"), "worldabcefghijkmnpqstuvxyz")
    println("is sorted? $result2")
}