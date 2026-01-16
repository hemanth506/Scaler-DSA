var maximizeSquareArea = function (row, col, hFences, vFences) {
    const MOD = 1000000007
    hFences.push(1); hFences.push(row)
    vFences.push(1); vFences.push(col)
    hFences.sort((a, b) => a - b)
    vFences.sort((a, b) => a - b)

    const hSet = new Set()
    let hLen = hFences.length
    for (let i = 0; i < hLen; i++) {
        for (let j = i + 1; j < hLen; j++) {
            hSet.add(hFences[j] - hFences[i])
        }
    }

    let maxSquare = -1
    let vLen = vFences.length
    for (let i = 0; i < vLen; i++) {
        for (let j = i + 1; j < vLen; j++) {
            const dist = vFences[j] - vFences[i]
            if (hSet.has(dist)) {
                maxSquare = Math.max(maxSquare, dist)
            }
        }
    }

    if (maxSquare === -1) return -1
    return Number((BigInt(maxSquare) * BigInt(maxSquare) % BigInt(MOD)))
};