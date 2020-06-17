fun longPressedName(name: String, typed: String): Boolean{
    requireNotNull(name){"Name must not be null"}
    requireNotNull(typed){"Typed must not be null"}
    if(name.length == typed.length) return true
    if(name.length > typed.length) return false
    var i = 0
    var j = 0
    while(j < typed.length){

        if(i < name.length && name[i] == typed[j]){
            i++
        }else if(j == 0 || typed[j] != typed[j-1]){
            return false
        }

        j++
    }

    return i == name.length
}

fun main(args: Array<String>) {
    val result1 = longPressedName("leelee", "lleeelee")
    println("$result1")
    val result2 = longPressedName("saeed", "ssaaedd")
    println("$result2")
}