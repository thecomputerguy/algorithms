
fun pushDominoes(data: String): String{
    requireNotNull(data){"Input must not be null"}
    check(data.length > 0){"Input must not be empty"}
    var N = data.length
    var force = 0
    var forces = IntArray(N) { _ -> 0 }
    var i = 0
    //Left sweep
    while(i < N){
        if(data[i] == 'R'){
            force = N
        }else if(data[i] == 'L'){
            force = 0
        }else{
            force = maxOf(force - 1, 0)
        }
        forces[i] += force
        i++
    }

    var j = N-1
    force = 0
    while(j >= 0){
        if(data[j] == 'R'){
            force = 0
        }else if(data[j] == 'L'){
            force = N
        }else{
            force = maxOf(force - 1, 0)
        }
        forces[j] -= force
        j--
    }

    var builder = StringBuilder()
    for (value in forces) {
        if(value > 0){
            builder.append('R')
        }else if(value < 0){
            builder.append('L')
        }else{
            builder.append('.')
        }
    }

    return builder.toString()
}

fun main(args: Array<String>) {
    val result = pushDominoes(".L.R...LR..L..")
    println("$result")
}