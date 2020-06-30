class TreeNode{
    constructor(data){
        this.data = data
        this.left = null
        this.right = null
    }
}

function sortedArrayToBinarySearchTree(data){
    if(!data && data.length == 0) return null
    let left = 0
    let right = data.length - 1
    let node = convertToBinarySearchTree(data, left, right)
    return node
}

function convertToBinarySearchTree(data, left, right){
    if (left > right) {
        return null        
    }
    let mid = left + Math.floor((right-left)/2)
    let node = new TreeNode(data[mid])
    node.left = convertToBinarySearchTree(data, left, mid-1)
    node.right = convertToBinarySearchTree(data, mid + 1, right)
    return node
}

function displayTree(node){
    if(!node) return
    let queue = []
    queue.push(node)
    while(queue.length > 0){
        let size = queue.length
        let result = ""
        while(size > 0){
            let currentNode = queue.shift()
            result = result + currentNode.data + " -> "
            if(currentNode.left) queue.push(currentNode.left)
            if(currentNode.right) queue.push(currentNode.right)
            size--
        }
        console.log("Result ", result)
        result = ""
    }
}

let sortedArray = [-10,-3,0,5,9]
let node = sortedArrayToBinarySearchTree(sortedArray)
console.log(node)
console.log(node.left)
console.log(node.right)
displayTree(node)