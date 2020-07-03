class TreeNode{
    constructor(val){
        this.val = val
        this.left = null
        this.right = null
    }
}

function constructABinaryTree(preorder, inorder){
    if(!preorder || preorder.length === 0 || !inorder || inorder.length === 0) return null
    let treeRoot = buildTree(0, 0, inorder.length-1, preorder, inorder)
    return treeRoot
}

function buildTree(preStart, inStart, inEnd, preorder, inorder){
    if(preStart > preorder.length-1 || inStart > inEnd) return null
     let treeNode = new TreeNode(preorder[preStart])
     let inIndex = 0
     for(let index = inStart; index <= inEnd; index++){
        if(treeNode.val === inorder[index]) {
            inIndex = index
            break
        }
     }
     treeNode.left = buildTree(preStart + 1, inStart, inIndex-1, preorder, inorder)
     treeNode.right = buildTree(preStart + inIndex - inStart + 1, inIndex+1, inEnd, preorder, inorder)
     return treeNode
}

function traverse(treeNode){
    if(!treeNode) return
    traverse(treeNode.left)
    console.log(treeNode.val)
    traverse(treeNode.right)
}

let preorder = [3,9,20,15,7]
let inorder = [9,3,15,20,7]
let rootNode = constructABinaryTree(preorder, inorder)
traverse(rootNode)