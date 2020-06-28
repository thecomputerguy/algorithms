class ListNode{
    constructor(val = -1, key = -1){
        this.key = key
        this.val = val
        this.next = null
        this.prev = null
    }
}

class LRUCache{

    constructor(capacity){
        this.capacity = capacity
        this.map = new Map()
        this.head = new ListNode()
        this.tail = new ListNode()
        this.head.next = this.tail
        this.tail.prev = this.head
    }

    put(key, value){
        let node = this.map.get(key)
        if(node){
            this.remove(node)
            node.val = value
            this.add(node)
        }else{
            if (this.map.size === this.capacity) {
                this.map.delete(this.tail.prev.key)
                this.remove(this.tail.prev)
            }
            node = new ListNode(key,value)
            this.add(node)
            this.map.set(key, node)
        }
        this.printList(this.head)
        this.printMap(this.map)
    }

    get(key){
        let result = -1
        let node = this.map.get(key)
        if (node) {
            result = node.val
            this.remove(node)
            this.add(node)
        }
        this.printList(this.head)
        this.printMap(this.map)
        return result
    }

    printMap(map){
        let result = ""
        for(let [key,value] of map){
            result = result + key + " : "  + value.val + ", "
        }
        console.log(result)
    }

    printList(head){
        let current = head.next
        let result = ""
        while(current.val != -1){
            result = result + current.val + " -> "
            current = current.next
        }
        console.log(result)
    }

    add(newNode){
       let headNext = this.head.next
       this.head.next = newNode
       newNode.prev = this.head
       newNode.next = headNext
       headNext.prev = newNode
    }

    remove(node){
        let nextNode = node.next
        let prevNode = node.prev
        prevNode.next = nextNode
        nextNode.prev = prevNode
        
    }

}

let cache = new LRUCache(5)
cache.put(1,1)
cache.put(2,2)
cache.put(3,3)
cache.put(4,4)
cache.put(5,5)
cache.put(6,6)
console.log("pulled out of cache", cache.get(1))
console.log("pulled out of cache", cache.get(2))
console.log("pulled out of cache", cache.get(3))
console.log("pulled out of cache", cache.get(4))
console.log("pulled out of cache", cache.get(5))
console.log("pulled out of cache", cache.get(6))