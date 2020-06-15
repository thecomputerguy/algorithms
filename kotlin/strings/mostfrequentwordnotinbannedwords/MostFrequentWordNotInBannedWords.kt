fun buildMapping(word: String, mapping: MutableMap<String, Int>, bannedWords: Set<String>): Unit{

    if(!bannedWords.contains(word)){
            mapping.put(word, mapping.getOrDefault(word, 0) + 1)
    }
    
}

fun mostFrequentword(paragraph: String, bannedWords: MutableSet<String>): String{
    
    //Validate request.
    requireNotNull(bannedWords){"Paragraph must not be null"}
    requireNotNull(bannedWords){"Set of banned words must not be null"}
    check(paragraph.isNotBlank()){"Paragraph must not be blank"}
    check(bannedWords.size != 0){"Set of banned words must not be empty"}
    
    //build mapping
    var words = paragraph.toLowerCase().split("\\W+".toRegex())
    println("words: $words")
    var mapping: MutableMap<String, Int> = mutableMapOf()
    words.asSequence().forEach { buildMapping(it, mapping, bannedWords) }
    println("Mapping: $mapping")
    //Iterate and get the most common word
    var frequency = 0
    var mostCommonWord = ""
    mapping.entries.asSequence().forEach { if(it.value > frequency){
        mostCommonWord = it.key
        frequency = it.value
    } 
}
    return mostCommonWord
}

fun main(args: Array<String>) {
 val mostCommon = mostFrequentword("Bob hit a ball, the hit BALL flew far after it was hit.", mutableSetOf("hit"))
 println("most common word is : ${mostCommon} ")
}