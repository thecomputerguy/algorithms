class TreeNode{

    constructor(val){
        this.val = val
        this.children = null
    }
}

function maxDepth(rootNode){
    if (!rootNode) return 0
    let level = 0
    let queue = []
    queue.push(rootNode)
    
    while (queue.length > 0) {
        let size = queue.length
        while(size > 0){
            let node = queue.shift()
            if (node.children) {
                node.children.forEach(child => {
                    queue.push(child)    
                });
            }
            size--
        }
        level++
    }
    return level
}

//Create a tree
let rootNode = new TreeNode(1)
let level1Node1 = new TreeNode(2)
let level1Node2 = new TreeNode(3)
let level1Node3 = new TreeNode(4)
let level1Children = [level1Node1, level1Node2, level1Node3]
rootNode.children = level1Children

let level2Node1 = new TreeNode(5)
let level2Node2 = new TreeNode(6)
let level2Node3 = new TreeNode(7)
let level2Children = [level2Node1, level2Node2, level2Node3]
level1Node1.children = level2Children

let result = maxDepth(rootNode)
console.log("Max depth of nary tree ", result)