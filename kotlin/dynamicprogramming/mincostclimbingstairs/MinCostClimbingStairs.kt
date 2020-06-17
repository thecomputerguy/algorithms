fun minCostClimbingStairs(costs: IntArray): Int{
    requireNotNull(costs){"Costs must not be null"}
    check(costs.size > 0){"Costs array must not be empty"}
    var f1 = 0
    var f2 = 0

    var i = costs.size - 1
    while(i >= 0){
        var f0 = costs[i] + minOf(f1, f2)
        f2 = f1
        f1 = f0
        i--
    }
    return minOf(f1, f2)
}

fun main(args: Array<String>) {
   val minCost = minCostClimbingStairs(intArrayOf(10,15,20))
    println("Min cost: $minCost")
}