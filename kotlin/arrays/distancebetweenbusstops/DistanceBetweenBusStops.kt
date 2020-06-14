fun distanceBetweenBusStops(distance: IntArray, start: Int, destination: Int): Int{
    requireNotNull(distance){"Distance array must not be null"}
    check(distance.size > 0){"Distance array must not be empty"}
    var clockwiseDistance: Int = 0
    var totalDistance: Int = 0
    for ((index, element) in distance.withIndex()) {
        //clockwise
        if(start < destination && (index >= start && index < destination)){
            clockwiseDistance += element
        }
        //Counter clockwise
        if(start > destination && (index >= start || index < destination)){
            clockwiseDistance += element
        }
        totalDistance += element
    }
    return minOf(clockwiseDistance, totalDistance-clockwiseDistance)
}

fun main(args: Array<String>) {
    
    val distance = distanceBetweenBusStops(intArrayOf(1,2,3,4), 0, 2)
    println("Distance between start and destination is $distance")
}