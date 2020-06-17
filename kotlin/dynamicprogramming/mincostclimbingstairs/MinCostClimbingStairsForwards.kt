fun minCostForwards(costs: IntArray): Int{
    requireNotNull(costs){"input must not be null"}
    check(costs.size > 0){"input must not be empty"}
    
    var index = 2
    while(index < costs.size){
        costs[index]  = costs[index] + minOf(costs[index-1], costs[index-2])
        index++
    }    
    return minOf(costs[costs.size-1], costs[costs.size-2])
}
fun main(args: Array<String>) {
    val minCost = minCostForwards(intArrayOf(10,15,20));
    println("min cost : $minCost")
}