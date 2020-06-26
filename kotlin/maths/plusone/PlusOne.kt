fun plusOne(data: IntArray): IntArray{
    if(data == null || data.size == 0) return data
     for (index in data.size-1 downTo 0) {
         if(data[index] < 9){
            data[index]++
            return data
         }

         data[index] = 0
     }
     val result = IntArray(data.size + 1) { 0 }
     result[0] = 1
     return result
}

fun printArray(data: IntArray){

    for (element in data) {
        print("$element ")    
      }
      println()
}

fun main(args: Array<String>) {
  val result1 = plusOne(intArrayOf(1,2,3))
  printArray(result1)
  val result2 = plusOne(intArrayOf(9,9,9))
  printArray(result2) 
  val result3 = plusOne(intArrayOf(1,9,9))
  printArray(result3)
}