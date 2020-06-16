fun maxProduct(data: IntArray): Int{
    requireNotNull(data){"input must not be empty"}
    check(data.size > 0){"input array must contain atleast one number"}
    
    var finalMax = data[0]
    var currentMax = data[0]
    var currentMin = data[0]

    for (index in 1 until data.size) {
        val temp = currentMax
        currentMax = maxOf(maxOf(currentMax * data[index], currentMin * data[index]), data[index])
        currentMin = minOf(minOf(currentMin * data[index], temp * data[index]), data[index])

        if(currentMax > finalMax){
            finalMax = currentMax
        }
    }

    return finalMax
}

fun main(args: Array<String>) {
   val maxProd = maxProduct(intArrayOf(2,3,-2,4))
   println("max prod: $maxProd")
}