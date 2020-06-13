fun threeSum(data: IntArray): List<List<Int>> {
    require(data != null) { "must not be null" }
    check(data.size > 0) { "must have atleast one element" }
    data.sort()
    var list = mutableListOf<List<Int>>()
    for (index in 0 until data.size - 2) {
        if (index == 0 || ((index > 0) && data[index] != data[index - 1])) {
            var left = index + 1
            var right = data.size - 1
            var sum = 0 - data[index]

            while (left < right) {

                if (data[left] + data[right] == sum) {
                    list.add(listOf(data[index], data[left], data[right]))
                    while (left < right && data[left] == data[left + 1]) left++
                    while (left < right && data[right] == data[right - 1]) right--
                    left++
                    right--
                } else if (data[left] + data[right] > sum) {
                    right--
                } else {
                    left++
                }

            }
        }
    }
    return list
}

fun display(data: List<List<Int>>): Unit {
    data.asSequence().forEach {
        println(it.toString())
    }
}

fun main() {
    val data: IntArray = intArrayOf(-1, 0, 1, 2, -1, -4)
    val result: List<List<Int>> = threeSum(data)
    display(result)
}