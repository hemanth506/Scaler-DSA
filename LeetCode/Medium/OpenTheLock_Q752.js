var openLock = function (deadends, target) {
    const deadSet = new Set(deadends)

    const start = '0000'

    if (start === target) return 0

    if (deadSet.has(start)) return -1

    const visited = new Set()
    const que = []
    que.push([start, 0])

    let idx = 0
    while (que.length > idx) {
        const [curNode, level] = que[idx++]

        if (deadSet.has(curNode)) continue

        let curArr = curNode.split("").map(Number)
        let nextArr = [...curArr];
        for (let k = 0; k < 4; k++) {
            nextArr[k] = nextArr[k] === 0 ? 9 : nextArr[k] - 1
            const nn = nextArr.join("")
            if (nn === target) return level + 1

            if (!visited.has(nn) && !deadSet.has(nn)) {
                visited.add(nn)
                que.push([nn, level + 1])
            }
            nextArr[k] = nextArr[k] === 9 ? 0 : nextArr[k] + 1
        }

        nextArr = [...curArr];
        for (let k = 0; k < 4; k++) {
            nextArr[k] = nextArr[k] === 9 ? 0 : nextArr[k] + 1
            const nn = nextArr.join("")
            if (nn === target) return level + 1
            if (!visited.has(nn) && !deadSet.has(nn)) {
                visited.add(nn)
                que.push([nn, level + 1])
            }
            nextArr[k] = nextArr[k] === 0 ? 9 : nextArr[k] - 1
        }
    }
    return -1
};


let deadends, target


// deadends = ["0201", "0101", "0102", "1212", "2002"], target = "0202"
// deadends = ["8888"], target = "0009"

deadends = ["8887","8889","8878","8898","8788","8988","7888","9888"], target = "8888"
console.log(openLock(deadends, target))