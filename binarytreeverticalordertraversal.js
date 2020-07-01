//Objective is to do a vertical order traversal of a binary tree.


//O(n) solution that uses BFS and a queue. Every time we go left, the 'level'
//decrements, and every time we go right, the 'level' increments.

if (!root) {
    return []
}

let map = new Map()
let queue = []
queue.push({node: root, level: 0})

//Keep track of the lowest and highest level for iteration later
let min = 0
let max = 0

while (queue.length > 0) {
    let curr = queue.shift() 
    
    if (!map.has(curr.level)) {
        map.set(curr.level, [])
    }
    map.get(curr.level).push(curr.node.val)
    
    min = Math.min(min, curr.level)
    max = Math.max(max, curr.level)
    
    if (curr.node.left) {
        queue.push({node: curr.node.left, level: curr.level - 1})
    }
    
    if (curr.node.right) {
        queue.push({node: curr.node.right, level: curr.level + 1})
    }
}

let result = []

//We do 'i - min' here since 'i' might be negative
for (let i = min; i <= max; i++) {
    result[i - min] = map.get(i)
}

return result