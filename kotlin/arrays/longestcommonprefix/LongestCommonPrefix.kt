fun longestCommonPrefix(data: Array<String>): String{
    if(data == null || data.size == 0) return ""
    
    var prefix = data[0]
    var index = 1
    while(index < data.size){
        var element = data[index]
        while(element.indexOf(prefix) != 0){
            prefix = prefix.substring(0, prefix.length - 1)
        }
        index++
    }
   return prefix
}

fun main(args: Array<String>) {
    val data1 :Array<String> = arrayOf("flower", "flow", "flight")
    val prefix1 = longestCommonPrefix(data1)
    println("prefix: $prefix1")

    val data2 :Array<String> = arrayOf("dog", "racecar", "car")
    val prefix2 = longestCommonPrefix(data2)
    println("prefix: $prefix2")
}