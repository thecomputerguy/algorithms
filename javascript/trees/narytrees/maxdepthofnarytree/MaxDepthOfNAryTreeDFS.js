"use strict";

class TreeNode{

    constructor(val){
        this.val = val
        this.children = null
    }
}

let maxDepthOfTree = Number.MIN_VALUE
function maxDepth(node){
    if(!node) return 0
    return maxDepthHelper(node, 0)
}

function maxDepthHelper(node, depth){
    if(!node) return 0
    let childDepth = 0
    if(node.children){
        node.children.forEach(child => {
            maxDepthHelper(child, depth+1)
        });
    }
    maxDepthOfTree = Math.max(maxDepthOfTree, depth + 1)
    return depth + 1
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

maxDepth(rootNode)
console.log("Max depth of nary tree ", maxDepthOfTree)