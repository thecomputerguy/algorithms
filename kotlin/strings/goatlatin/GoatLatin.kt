fun goatLatin(data: String): String{
    requireNotNull(data){"input must not be null"}
    check(data.length > 0){"input must not be empty"}
    val words = data.split("\\s".toRegex())
    val vowels = mutableSetOf<Char>()
    for (char in "AEIOUaeiou") {
        vowels.add(char)    
    }

    val builder = StringBuilder()
    for ((index,word) in words.withIndex()) {
        var count = index + 1
        if(index > 0){
            builder.append(" ")
        }
        if(vowels.contains(word[0]) ){
            builder.append(word + "ma")
        }else{
            builder.append(word.substring(1) + word[0] + "ma")
        }
        while(count > 0){
            builder.append("a")
            count--
        }
    }

    return builder.toString()
}

fun main(args: Array<String>) {
   val result = goatLatin("I speak Goat Latin")
   println(result)
}