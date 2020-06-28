let TreeNode = require('./TreeNode.js')
class MaxPathSum{
    
    constructor(maxPathSum = 0){
        this.maxPathSum = maxPathSum
    }
    
    pathSumHelper(node){
        if(!node) return 0
        let left = this.pathSumHelper(node.left)
        let right = this.pathSumHelper(node.right)
        this.maxPathSum = Math.max(this.maxPathSum, left + right + node.val)
        return left + right + node.val
    }

    pathSum(node){
        if(!node) return 0
        
        this.pathSumHelper(node)
        return this.maxPathSum
    }

}

let solver = new MaxPathSum()
let node = new TreeNode(1)
node.left = new TreeNode(2)
node.right = new TreeNode(3)
let result = solver.pathSum(node)
console.log(result)