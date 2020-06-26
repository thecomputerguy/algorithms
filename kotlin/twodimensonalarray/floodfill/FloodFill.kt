fun floodFill(image: Array<IntArray>, sr: Int, sc: Int, newColor: Int): Array<IntArray>{
    if(sr < 0 || sr >= image.size || sc < 0 || sc >= image[sr].size || image[sr][sc] == newColor) return image    
    var oldColor = image[sr][sc]
    floodFillHelper(image, sr, sc, oldColor, newColor)
    return image
}

fun floodFillHelper(image: Array<IntArray>, sr: Int, sc: Int, oldColor: Int, newColor: Int): Unit{
    if(sr < 0 || sr >= image.size || sc < 0 || sc >= image[sr].size || image[sr][sc] == newColor || image[sr][sc] != oldColor) return
    
    image[sr][sc] = newColor

    floodFillHelper(image, sr-1, sc, oldColor, newColor)
    floodFillHelper(image, sr+1, sc, oldColor, newColor)
    floodFillHelper(image, sr, sc-1, oldColor, newColor)
    floodFillHelper(image, sr, sc+1, oldColor, newColor)
}

fun displayImage(image: Array<IntArray>){
    for (row in image) {
        for (cell in row) {
            print("$cell  ")
        }
        println()
    }
}

fun main(args: Array<String>) {
    var row1 = intArrayOf(1,1,1)
    var row2 = intArrayOf(1,1,0)
    var row3 = intArrayOf(1,0,1)
    var image: Array<IntArray> = arrayOf(row1, row2, row3)
    var result = floodFill(image, 1, 1, 2)
    displayImage(result)
}