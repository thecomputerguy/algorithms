
fun lemonadeChange(data: IntArray): Boolean{
    requireNotNull(data){"Input must not be null"}
    check(data.size > 0){"Input must not be empty"}
    var fives = 0
    var tens = 0
    for (bill in data) {
        if(bill == 5){
            fives++
        }else if(bill == 10){
            fives--
            tens++
        }else if(tens > 0){
            fives--
            tens--
        }else{
            fives -= 3
        } 
    }

    if(fives >= 0) return true else return false
}

fun main(args: Array<String>) {
    val result = lemonadeChange(intArrayOf(5,5,5,10,20))
    println(result)
}