fun wordSubsets(input1: Array<String>, input2: Array<String>): List<String> {
    val result = mutableListOf<String>()
    if(input1 == null || input1.isEmpty() || input2 == null || input2.isEmpty()) return result;

    val charCount: IntArray = IntArray(26)
    buildCharCount(charCount, input2)

    for(data in input1){

        val wordCharacterCount: IntArray = IntArray(26)
        buildCharCount(wordCharacterCount, data)
        var index: Int = 0;

        for(value in charCount){
           
            val count: Int = wordCharacterCount[index]
            if(value > count) break
            index++
        }

        if(index == 26){
            result.add(data)
        }
    }


    return result;
}

fun buildCharCount(mapping: IntArray , input1: String): Unit{

    for(ch in input1){
        val key: Int = ch - 'a'
        mapping[key] = mapping[key] + 1
    }
}

fun buildCharCount(mapping: IntArray , input2: Array<String>): Unit{

    for(ch in input2){
        val key: Int = ch.get(0) - 'a'
        mapping[key] = mapping[key] + 1
    }
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