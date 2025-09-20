var decodeCiphertext = function(encodedText, col) {
    if(col === 1) return encodedText

    const n = encodedText.length
    const rowLen = Math.floor(n / col)
    const times = rowLen + 1

    let str = ""
    for(let i = 0; i < rowLen; i++) {
        for(let j = i; j < n; j += times) {
            str +=encodedText.charAt(j)
        }
    }

    let m = str.length - 1
    while (str.charAt(m) === " ") {
        str = str.substring(0, m);
        m -= 1
    }
    return str
};


// decodeCiphertext("iveo    eed   l te   olc", 4)

// decodeCiphertext("ch   ie   pr", 3)

// decodeCiphertext("complate", 1)

decodeCiphertext("wmihfwf bddhzaizuzhbuoovyyjstardqceaqzafdzihjbj ywly amkeemr jmvsfaavbpgiafgxzciwmrrtasthc hqfrtwoizoilw", 2)
