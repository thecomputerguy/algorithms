fun numberOfSegmentsInAString(data: String): Int{
    if(data == null || data.isEmpty()) return 0

    var index = 0
    var segments = 0
    while(index < data.length){
        if((index == 0 || data[index-1] == ' ') && data[index] != ' ') segments++
        index++
    }
    return segments
}

fun main(args: Array<String>) {
    var result = numberOfSegmentsInAString("hello, my name is varun")
    println("Number of segments in a string : $result")
}