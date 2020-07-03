class TreeNode{
    constructor(val){
        this.val = val
        this.left = null
        this.right = null
    }
}

let max = Number.MIN_VALUE
let prev = null
let count = 1
function modeInBinarySearchTree(rootNode){
    let modes = new Set()
    if(!rootNode) return modes
    traverse(rootNode, modes) 
    return modes
}

function traverse(node, modes){
    if(!node) return

    traverse(node.left, modes)
    
    if(prev){
        if(prev === node.val) count++
        else count = 1
    }

    if(count > max){
         max = count
         modes.clear()
         modes.add(node.val)
     }else if(count === max){
        modes.add(node.val)
     }

    prev = node.val
    
    traverse(node.right, modes)
}

const rootNode = new TreeNode(1)
rootNode.right = new TreeNode(2)
rootNode.right.left = new TreeNode(2)

let result = modeInBinarySearchTree(rootNode)
console.log(result)