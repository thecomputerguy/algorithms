class TreeNode{
 constructor(val){
    this.val = val
    this.left = null
    this.right = null
 }   
}

function binaryTreePaths(rootNode){
    let result = []
    if(!rootNode) return result
    let currentPath = rootNode.val
    if(!rootNode.left && !rootNode.right) result.push(currentPath)
    if(rootNode.left) dfs(rootNode.left, currentPath + "-->", result)
    if(rootNode.right) dfs(rootNode.right, currentPath + "-->", result)

    return result
}

function dfs(node, currentPath, result){
    currentPath += node.val
    if(!node.left && !node.right){
        result.push(currentPath)
        return
    }
    if(node.left) dfs(node.left, currentPath + "-->", result)
    if(node.right) dfs(node.right, currentPath + "-->", result)
}

const rootNode = new TreeNode(1)
rootNode.left = new TreeNode(2)
rootNode.right = new TreeNode(3)
rootNode.left.left = new TreeNode(4)
rootNode.left.right = new TreeNode(5)
rootNode.right.left = new TreeNode(6)
rootNode.right.right = new TreeNode(7)

const result = binaryTreePaths(rootNode)
console.log(result)