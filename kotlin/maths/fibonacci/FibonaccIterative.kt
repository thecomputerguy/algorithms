
fun fibonacci(N: Int){
    if(N < 0) return
    var first = 0
    print("$first ")
    var second = 1
    print("$second ")
    var i = 2
    while(i <= N){
        var third = first + second
        print("$third ")
        first = second
        second = third
        i++
    }
}

fun main(args: Array<String>) {
    println("Fibonacci sequence")
    fibonacci(8)
}