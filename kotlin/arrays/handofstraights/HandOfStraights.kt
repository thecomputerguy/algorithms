fun buildCount(treeMap: java.util.TreeMap<Int, Int>, hand: IntArray): Unit{
    for (element in hand) {
        if(treeMap.containsKey(element)){
            treeMap.put(element, treeMap.get(element)!!.plus(1))
        }else{
            treeMap.put(element, 1)
        }
    }
}

fun handOfStraights(hand: IntArray, W: Int): Boolean{
    if(hand == null || hand.size == 0 || hand.size % W != 0) return false
    
    val treeMap = java.util.TreeMap<Int, Int>()
    buildCount(treeMap, hand)

    while(treeMap.size > 0){
        val firstKey = treeMap.firstKey()
        val group = IntArray(W) { _ -> 0 }
        var index = 0
        
        for (key in firstKey until (firstKey + W)) {
            val value = treeMap.get(key)

            if(value == null) return false
            
            if(value == 1){
                group[index++] = key
                treeMap.remove(key)
            }else if(value > 1){
                group[index++] = key
                treeMap.put(key, treeMap.get(key)!!.minus(1))
            }else{
                return false
            }
        }
    }
    return true
}

fun main(args: Array<String>) {
    val hand = intArrayOf(1,2,3,6,2,3,4,7,8)
    val W = 3
    val result = handOfStraights(hand, W)
    println("Can rearrange? : $result")

    val hand1 = intArrayOf(1,2,3,4,5)
    val W1 = 4
    val result1 = handOfStraights(hand1, W1)
    println("Can rearrange? : $result1")
}