import java.util.Queue
import java.util.LinkedList
import java.util.HashSet

fun openLock(deadends: Array<String>, target: String): Int{
    requireNotNull(deadends){"input must not be null"}
    check(deadends.size > 0){"input must not be empty"}
    requireNotNull(target){"target string must not be null"}
    check(target.length > 0){"target string must not be empty"}
    
    val initialState = "0000"
    val queue: Queue<String> = LinkedList()
    queue.offer(initialState)
    val deadendsSet: Set<String> = buildSet(deadends)
    var level = 0
    val visited = mutableListOf<String>()

    while(queue.isNotEmpty()){
        
        val size = queue.size
        var i = 0
        while(i < size){
            val item = queue.poll()
            if(deadendsSet.contains(item)){
                i++
                continue
            }
            if(item == target){
                return level
            }


            for ((index,char) in item.withIndex()) {
                
                var inc = char.toString().toInt() + 1
                var dec = char.toString().toInt() - 1
                if(inc > 9){
                    inc = 0
                }
                if(dec < 0){
                    dec = 9
                }
                val s1 = item.substring(0,index) + inc.toString() + item.substring(index+1)
                val s2 = item.substring(0, index) + dec.toString() + item.substring(index+1)
                if(!visited.contains(s1)){
                    queue.offer(s1)
                    visited.add(s1)
                }
                if(!visited.contains(s2)){
                    queue.offer(s2)
                    visited.add(s2)
                }

            }
        
            i++
        }
        level++
    }

    return -1
}

fun buildSet(deadends: Array<String>): Set<String>{
     return deadends.asSequence().toCollection(HashSet<String>())
}

fun main(args: Array<String>) {
    val data = arrayOf<String>("0201","0101","0102","1212","2002")
    val target = "0202"
    val turns = openLock(data, target)
    println("number of turns taken to open the lock is $turns")
}