fun validAnagrams(s: String, t: String): Boolean{
    if(s == null || s.isEmpty() || t == null || t.isEmpty() || s.length != t.length) return false
    
    val countsMap = IntArray(128) { _ -> 0 }
    var index = 0
    while (index < s.length) {
        countsMap[s[index] - 'a']++
        countsMap[t[index] - 'a']--
        index++
    }
    for (element in countsMap) {
        if(element != 0){
            return false
        }
    }
    return true
}

fun main(args: Array<String>) {
    val s1 = "anagram"
    val t1 = "nagaram"
   val result = validAnagrams(s1, t1)
    println("is $t1 an anagram of $s1 : $result")
    
    val s2 = "rat"
    val t2 = "cat"
   val result2 = validAnagrams(s2, t2)
   println("is $t2 an anagram of $s2: $result2")
}