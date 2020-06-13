fun fruitsInTheBasket(trees: IntArray): Int{
    check(trees.size > 0){"There must be atleast one tree"}
    var lastFruit: Int = 0
    var secondLastFruit: Int = -1
    var max: Int = 0
    var currentMax: Int = 0
    var lastFruitCount: Int = 0
    for (fruit in trees){
        if (fruit == lastFruit || fruit == secondLastFruit){
            currentMax++
        }else{
            currentMax = lastFruitCount + 1
        }

        if (lastFruit == fruit){
            lastFruitCount++
        }else{
            lastFruitCount = 1
        }

        if (fruit != lastFruit && fruit != secondLastFruit){
            secondLastFruit = lastFruit
            lastFruit = fruit
        }

        max = maxOf(currentMax, max)
    }
    return max
}

fun main() {
    val trees: IntArray = intArrayOf(1,2,1)
    val fruits: Int = fruitsInTheBasket(trees)
    println(fruits)
}