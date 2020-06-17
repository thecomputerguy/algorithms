fun fib(n: Int, cache: Array<Int>): Int{
    if(cache.size > n &&  cache[n] >= 0){
         return cache[n]
    }

    if(n == 0) {
        cache[0] = 0
        return 0
    }

    if(n == 1) {
        cache[1] = 1
        return 1
    }
    
    cache[n] = fib(n-1, cache) + fib(n-2, cache)
    return cache[n]
}

fun main(args: Array<String>) {

    println("Fibonacci sequence recursive solution.")
    val cache = Array<Int>(9){_ -> -1}
    fib(8, cache)
    for (element in cache) {
        print("$element ")
    }
}