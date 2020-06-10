fun removeKDigits(digits: String, k: Int): String {
    if (digits == null || digits.length == 0) return "0"

    var stack = java.util.Stack<Int>()
    var kDigits: Int = k

    for (digit in digits) {
        var intVal = digit.toString().toInt()
        while (kDigits > 0 && !stack.isEmpty() && intVal < stack.peek()) {
            stack.pop()
            kDigits--;
        }
        stack.push(intVal)
    }

    var digitsFromStack = ""
    while (!stack.isEmpty()) {
        val digit = stack.pop()
        digitsFromStack += digit
    }

    var reversedString = digitsFromStack.reversed()
    while (reversedString.length > 1 && reversedString[0] == '0') {
        reversedString = reversedString.replace("0", "")
    }
    return reversedString;
}

fun main() {

    val result: String = removeKDigits("1432219", 3)
    println(result)
}