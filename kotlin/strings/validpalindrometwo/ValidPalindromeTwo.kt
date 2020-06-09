import java.util.*

fun isValidPalindrome(data: String): Boolean {
    if (data == null || data.isEmpty()) return false
    //iterate ove the characters from front to end and compare the characters.
    var start: Int = 0;
    var end: Int = data.length-1;
    while (start <= end){
        if (data[start] != data[end]){
            return isValidPalindromeHelper(data, start+1, end) || isValidPalindromeHelper(data, start, end-1);
        }

        start++;
        end--;
    }

    return true
}

fun isValidPalindromeHelper(data: String, start: Int, end: Int): Boolean {

    var left: Int = start
    var right: Int = end

    while (left <= right){
        if (data[left] != data[right]){
            return false;
        }
        left++;
        right--;
    }

    return true;
}

fun main(args: Array<String>) {

    println("valid palindrome two solution")
    println("Enter the string to find if it is valid palindrome if extacly one character is removed.")
    val data1 = "raceacar"
    println("You have entered: $data1")
    val result1 : Boolean = isValidPalindrome(data1)

    println(result1)
    val data2 = "tesfgt"
    println("You have entered: $data2")
    val result2 : Boolean = isValidPalindrome(data2)

    println(result2)
}
