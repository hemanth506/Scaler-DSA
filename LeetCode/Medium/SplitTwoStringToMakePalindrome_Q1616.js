var checkPalindromeFormation = function(a, b) {
    console.log(a, b)
    const n = a.length
    if(n === 1) {
        return true
    }
    
    function checkPalindrome(word) {
        let nw = word.length
        let w1 = 0, w2 = nw-1
        while (w1 <= w2) {
            if(word.charAt(w1) !== word.charAt(w2)) {
                return false
            }
            w1++
            w2--
        }

        return true
    }

    let p1 = 0, p2 = n-1
    while (p1 <= p2) {
        if(a.charAt(p1) !== b.charAt(p2)) {
            break
        }
        p2--
        p1++
    }
    console.log(p1, p2)

    const aSplit1 = a.slice(0, p1)
    const bSplit1 = b.slice(0, p1)
    const aSplit2 = a.slice(p1)
    const bSplit2 = b.slice(p1)

    const concatA1 = aSplit1 +""+ bSplit2
    const concatB1 = bSplit1 +""+ aSplit2
    // console.log('concatA1', concatA1)
    // console.log('concatB1', concatB1)

    const bSplit1p2 = b.slice(0, p2+1)
    const aSplit2p2 = a.slice(p2-1)

    const aSplit1p2 = a.slice(0, p2+1)
    const bSplit2p2 = b.slice(p2+1)
    console.log('aSplit1p2', aSplit1p2)
    console.log('bSplit2p2', bSplit2p2)


    const concatA1p2 = aSplit1p2 +""+ bSplit2p2
    const concatB1p2 = bSplit1p2 +""+ aSplit2p2
    console.log('concatA1p2', concatA1p2)
    // console.log('concatB1p2', concatB1p2)


    if(checkPalindrome(concatA1) || checkPalindrome(concatB1) || checkPalindrome(concatA1p2) || checkPalindrome(concatB1p2)) {
        return true
    }


    let x1 = 0, x2 = n-1
    while (b.charAt(x1) === a.charAt(x2) && x1 <= x2) {
        x2--
        x1++
    }

    const aSplit3 = a.slice(0, x1)
    const bSplit3 = b.slice(0, x1)
    const aSplit4 = a.slice(x1)
    const bSplit4 = b.slice(x1)

    const concatA2 = aSplit3 +""+ bSplit4
    const concatB2 = bSplit3 +""+ aSplit4

    const aSplit3x2 = a.slice(0, x2+1)
    const bSplit3x2 = b.slice(0, x2+1)
    const aSplit4x2 = a.slice(x2+1)
    const bSplit4x2 = b.slice(x2+1)

    const concatA2x2 = aSplit3x2 +""+ bSplit4x2
    const concatB2x2 = bSplit3x2 +""+ aSplit4x2

    if(checkPalindrome(concatA2) || checkPalindrome(concatB2) || checkPalindrome(concatA2x2) || checkPalindrome(concatB2x2)) {
        return true
    }

    return false
};



let a, b;
// a = "x", b = "y"
// a = "xbdef", b = "xecab"
// a = "ulacfd", b = "jizalu"
// a = "ulaalu", b = "jizdwq"
a = "aejbaalflrmkswrydwdkdwdyrwskmrlfqizjezd", b = "uvebspqckawkhbrtlqwblfwzfptanhiglaabjea"


console.log(checkPalindromeFormation(a, b))