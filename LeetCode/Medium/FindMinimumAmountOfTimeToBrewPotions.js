var minTime = function(skill, mana) {
    const n = skill.length
    const m = mana.length
    const done = Array(n).fill(0)

    for(let potion = 0; potion < m; potion++) {
        for(let wizard = 0; wizard < n; wizard++) {
            if(wizard === 0) {
                done[wizard] = (skill[wizard] * mana[potion]) + done[wizard]
            } else {
                done[wizard] = (skill[wizard] * mana[potion]) + Math.max(done[wizard - 1], done[wizard])
            }

            for(let wiz =  n - 2; wiz >= 0; wiz--) {
                done[wiz] = done[wiz + 1] - (skill[wiz + 1] * mana[potion])
            }
        }
    }
    console.log(done)
    return done[n-1]
};