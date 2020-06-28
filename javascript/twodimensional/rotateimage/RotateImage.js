function rotateImage(image){
    if(!image || image.length == 0 || image[0].length == 0) return image
    console.log("original")
    displayImage(image)
    transpose(image)
    console.log("transpose")
    displayImage(image)
    flipHorizontally(image)
    return image
}

function transpose(image){
    for (let row = 0; row < image.length; row++) {
        for (let col = row; col < image[row].length; col++) {
            let temp = image[row][col]
            image[row][col] = image[col][row]
            image[col][row] = temp
        }
    }
}

function flipHorizontally(image){
    for (let row = 0; row < image.length; row++) {
        for (let col = 0; col < (image.length/2); col++) {
            let elementFrombeginning = image[row][col]
            image[row][col] = image[row][(image[row].length - 1) - col]
            image[row][(image[row].length - 1) - col] = elementFrombeginning
        }
    }
}

function displayImage(image){
    let result = ""
    for (let row = 0; row < image.length; row++) {
        for (let col = 0; col < image[row].length; col++) {
            result = result + image[row][col] + " " 
        }
        result = result + "\n"
    }
    console.log(result)
}

const image = rotateImage([[1,2,3],[4,5,6],[7,8,9]])
console.log("flipped")
displayImage(image)