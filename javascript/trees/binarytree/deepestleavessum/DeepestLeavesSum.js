
class TreeNode{
    constructor(val){
        this.val = val
        this.left = null
        this.right = null
    }       
}

function deepestLeavesSum(treeRoot){
    if(!treeRoot) return 0
    const queue = []
    queue.push(treeRoot)
    let result = 0

    while(queue.length > 0){
        let size = queue.length
        let levelSum = 0
        while(size > 0){
            let node = queue.shift()
            levelSum += node.val
            if(node.left) queue.push(node.left)
            if(node.right) queue.push(node.right)
            size--
        }
        result = levelSum
    }
    return result
}

const treeRoot = new TreeNode(1)
treeRoot.left = new TreeNode(2)
treeRoot.right = new TreeNode(3)
treeRoot.left.left = new TreeNode(4)
treeRoot.right.right = new TreeNode(5)
const result = deepestLeavesSum(treeRoot)
console.log(result)
