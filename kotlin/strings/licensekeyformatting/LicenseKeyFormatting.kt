fun formatLicensekey(data: String, k: Int): String{
    require(data.length > 1){"data length must be greater than 1"}
    val lowerCaseString = data.toUpperCase()
    val withoutUnderscore = lowerCaseString.replace("-", "")
    val end: Int = withoutUnderscore.length - k
    val builder = java.lang.StringBuilder(withoutUnderscore)
    for (i in end downTo 1 step 4){
        builder.insert(i, "-")
    }
    return builder.toString()
}

fun main() {
    val formattedString: String = formatLicensekey("5f3z-2e-9-w", 4)
    println(formattedString)
}