fun assignCookies(greed: IntArray, cookiesSize: IntArray): Int{
    if(greed == null || greed.size == 0) return 0
    if(cookiesSize == null || cookiesSize.size == 0) return 0
    
    greed.sort()
    cookiesSize.sort()
    var greedPointer = 0
    var cookiePointer = 0
    while(greedPointer < greed.size && cookiePointer < cookiesSize.size){
        if(greed[greedPointer] <= cookiesSize[cookiePointer]){
            greedPointer++
            cookiePointer++
        }else{
            cookiePointer++
        }
    }
    return greedPointer
}

fun main(args: Array<String>) {

   val contentChildren = assignCookies(intArrayOf(1,2,3), intArrayOf(1,1))
    println("Content children: $contentChildren")
}