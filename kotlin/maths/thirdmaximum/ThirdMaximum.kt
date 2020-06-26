fun thirdMaximum(data: IntArray): Int{
    if(data == null || data.size == 0) return Int.MIN_VALUE
    
    var first = Int.MIN_VALUE
    var second = Int.MIN_VALUE
    var third = Int.MIN_VALUE

    for (element in data) {
        if(element > first){
            third = second
            second = first
            first = element
        }else if(element > second){
            third = second
            second = element
        }else if(element > third){
            third = element
        }
    }
    return third
}

fun main(args: Array<String>) {
    val result = thirdMaximum(intArrayOf(2,3,1))
    println("result: $result")
}