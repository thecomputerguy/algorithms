fun letterCombinations(numbers: String): List<String>{
    checkNotNull(numbers){"Input cannot be null"}
    require(numbers.length > 1){"Input string must have alteast 1 character"}
    val result = java.util.LinkedList<String>()
    result.add("")

    for ((index,ch) in numbers.withIndex()) {
        val num = ch.toString().toInt()
        println("index: $index and char: $ch and num: $num")
        while(index == result.peek().length){
            println("index : $index and peek : ${result.peek()} and peeked size: ${result.peek().length}")
            var permutation = result.remove()
            println("permutation: $permutation")
            val mapping = getMapping(num);
            println("mapping: $mapping")
            for (char in mapping) {
                println("new char : $char")
                result.add(permutation + char)
                println("result: $result")
            }
            
        }
    }

    return result
}

fun getMapping(num: Int): String{
    val mapping: Array<String> = arrayOf("0", "1", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz")
    return mapping[num]
}

fun main(args: Array<String>) {
   
    val combinations: List<String> = letterCombinations("23")
    combinations.asSequence().forEach { print("$it ") }
}