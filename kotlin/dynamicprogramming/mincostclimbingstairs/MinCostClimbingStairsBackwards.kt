fun minCostClimbingStairs(costs: IntArray): Int{
    requireNotNull(costs){"Costs must not be null"}
    check(costs.size > 0){"Costs array must not be empty"}
    var step1 = 0
    var step2 = 0

    var i = costs.size - 1
    while(i >= 0){
        var step0 = costs[i] + minOf(step1, step2)
        step2 = step1
        step1 = step0
        i--
    }
    return minOf(step1, step2)
}

fun main(args: Array<String>) {
   val minCost = minCostClimbingStairs(intArrayOf(10,15,20))
    println("Min cost: $minCost")
}