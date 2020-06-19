fun openLock(data: Array<String>): Int{
    
}

fun main(args: Array<String>) {
    val data = arrayOf<String>("0201","0101","0102","1212","2002")
    val target = "0202"
    val turns = openLock(data, target)
    println("number of turns taken to open the lock is $turns")
}