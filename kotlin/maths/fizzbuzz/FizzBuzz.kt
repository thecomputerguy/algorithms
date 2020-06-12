fun fizzBuzz(start: Int, end: Int): Unit{
    if (start <= 0 || end <= 0 || start > end) return

    for (num in start until end){
        if ((num % 3) == 0 && (num % 5) == 0){
            println("fizzbuzz")
        }else if((num % 3) == 0){
            println("fizz")
        }else if((num % 5) == 0){
            println("buzz")
        }
    }
}

fun main() {
    fizzBuzz(1, 16)
}