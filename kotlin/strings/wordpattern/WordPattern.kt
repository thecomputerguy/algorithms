fun wordPattern(pattern: String, data: String): Boolean{
    if(pattern == null || pattern.isEmpty() || data == null || data.isEmpty()) return false
    val words = data.split(" ")
    if(pattern.length != words.size) return false
    val mapping = mutableMapOf<Char, String>()
    var index = 0
    while (index < pattern.length) {
        if(mapping.containsKey(pattern[index])){
            if(mapping.get(pattern[index]) != words[index]){
                return false
            }
        }else{
            if(mapping.containsValue(words[index])){
                return false
            }
            mapping.put(pattern[index], words[index])
        }
        index++
    }
    return true
}

fun main(args: Array<String>) {
   val result = wordPattern("abba", "dog cat cat dog")
   println("result: $result")
   val result2 = wordPattern("abba", "dog cat cat fish")
   println("result: $result2")
}