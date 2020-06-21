fun sumOfEvenNumbersAfterQueries(A: IntArray, queries: Array<IntArray>): IntArray{
    requireNotNull(A){"input array must not be null"}
    requireNotNull(queries){"queries must not be null"}
    check(A.size > 0){"A must not be empty"}
    check(queries.size > 0){"queries must not be empty"}

    //sum of even numbers
    var sumOfEvenNumbers = 0
    for (element in A) {
        if(element % 2 == 0){
            sumOfEvenNumbers += element
        }
    }

    var i = 0
    var result = IntArray(A.size) { _ -> 0 }
    while(i < queries.size){
       val value = queries[i][0]
       val index = queries[i][1]
       if(A[index] % 2 == 0) sumOfEvenNumbers = sumOfEvenNumbers - A[index]
       A[index] += value
       if(A[index] % 2 == 0) sumOfEvenNumbers = sumOfEvenNumbers + A[index]
       result[i] = sumOfEvenNumbers 
       i++
    }
    return result
}

fun main(args: Array<String>) {
    val row1 = intArrayOf(1,0) 
    val row2 = intArrayOf(-3,1)
    val row3 = intArrayOf(-4,0)
    val row4 = intArrayOf(2,3)
    val data: Array<IntArray> = arrayOf(row1, row2, row3, row4)
    val result = sumOfEvenNumbersAfterQueries(intArrayOf(1,2,3,4), data)
    for (element in result) {
        print("$element ")
    }
}