
fun buddyStrings(A: String, B: String): Boolean {
    requireNotNull(A){"A must not be null"}
    requireNotNull(B){"B must not be null"}
    if(A.length != B.length){
        return false
    }

    if(A.equals(B)){
        val hashSet = mutableSetOf<Char>()
        for (char in A) {
            hashSet.add(char)
        }
        if(hashSet.size < A.length){
            return true
        }else{
            return false
        }
    }

    val diff = mutableListOf<Int>()
    var index = 0
    while(index < A.length){
        if(A[index] != B[index]) diff.add(index)
        index++
    }

    if((diff.size == 2) && (A[diff[0]] == B[diff[1]]) && (A[diff[1]] == B[diff[0]])) return true
    
    return false 
}

fun main(args: Array<String>) {
    
    val result1 = buddyStrings("ab", "ba")
    println("buddy? $result1")

    val result2 = buddyStrings("a", "a")
    println("buddy? $result2")
}