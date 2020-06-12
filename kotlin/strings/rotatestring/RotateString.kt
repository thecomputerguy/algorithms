fun rotateString(A: String, B: String): Boolean{
    if (A.length == B.length && (A+A).contains(B)) return true else return false
}

fun main() {

    val result: Boolean = rotateString("abcde", "cdeab")
    println(result)
}