fun sortColors(data: IntArray): IntArray{
    requireNotNull(data){"Input must not be null"}
    check(data.size > 0){"Input must not be empty"}
    if(data.size == 1) return data
    //move zeros to the front and 2's to the end and 1's will automatically come at their correct position
    var start = 0
    var end = data.size - 1
    var i = 0

    while(i <= end && start < end){

        if(data[i] == 0){
            data[i] = data[start]
            data[start] = 0
            i++
            start++
        } else if (data[i] == 2) {
            data[i] = data[end]
            data[end] = 2
            end--
        }else{
            i++
        }
    }

    return data
}
fun main(args: Array<String>) {
    val sortedColors = sortColors(intArrayOf(2,0,2,1,1,0))
    for (color in sortedColors) {
        print("$color ")
    }
}