fun rectangleOverlap(rect1: IntArray, rect2: IntArray): Boolean{
    requireNotNull(rect1){"rectangle 1 must not be null"}
    requireNotNull(rect2){"rectange 2 must not be null"}
    check(rect1.size > 0){"rectangle 1 must not be empty"}
    check(rect2.size > 0){"rectange 2 must not be empty"}

    return rect1[0] < rect2[2] && rect1[1] < rect2[3] && rect1[2] > rect2[0] && rect1[3] > rect2[1]
}

fun main(args: Array<String>) {
    val result1 = rectangleOverlap(intArrayOf(0,0,2,2), intArrayOf(1,1,3,3))
    println("Rectangle overlap? $result1")
    
    val result2 = rectangleOverlap(intArrayOf(0,0,1,1), intArrayOf(1,0,2,1))
    println("Rectangle overlap? $result2")
}