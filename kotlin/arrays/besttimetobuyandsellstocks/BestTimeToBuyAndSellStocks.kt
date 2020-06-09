fun maxProfit(data : Array<Int>): Int{
    var profit: Int = 0
    var min: Int = Int.MAX_VALUE
    
    for (element in data) {
        
        if(element < min){
            min = element
        }else if(profit < element - min){
            profit = element - min
        }
        
    }

    return profit
}

fun main(args: Array<String>) {
    val data = arrayOf(7,1,5,3,6,4)
    val result = maxProfit(data)
    println("max profit is : $result")
}