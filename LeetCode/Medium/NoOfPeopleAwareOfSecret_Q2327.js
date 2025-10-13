var peopleAwareOfSecret = function (n, delay, forget) { // Slight issue
    const daysMap = new Map()
    let day = 1;
    let peopleKnown = 1, peopleForgot = 0;
    daysMap.set(day + delay, [day + forget]);

    for (day = 2; day <= n; day++) {
        if (!daysMap.has(day)) continue

        let arr = daysMap.get(day)
        for (let curForget of arr) {
            if(day === curForget) {
                peopleForgot += 1
                continue
            }
            peopleKnown += 1
            let newDelay = day + delay
            let newForget = day + forget
            if(newDelay <= n) {
                if (!daysMap.has(newDelay)) daysMap.set(newDelay, [])
                daysMap.get(newDelay).push(newForget)
            }

            let nextDay = day + 1
            if (nextDay < curForget) {
                if (!daysMap.has(nextDay)) daysMap.set(nextDay, [])
                daysMap.get(nextDay).push(curForget)
            } 
        }
        daysMap.delete(day)
    }
    return peopleKnown - peopleForgot
};

var peopleAwareOfSecret = function (n, delay, forget) { // correct but TLE
    const MOD = 1e9 + 7;
    const daysMap = new Map();

    function pushDay(dayKey, dayVal) {
        if (dayKey > n) return;
        if (!daysMap.has(dayKey)) {
            daysMap.set(dayKey, []);
        }
        daysMap.get(dayKey).push(dayVal);
    }

    let peopleKnown = 1, peopleForgot = 0;
    const start = 1 + delay, forgetDay = 1 + forget;

    for (let d = start; d <= Math.min(forgetDay - 1, n); d++) {
        pushDay(d, forgetDay);
    }
    pushDay(forgetDay, forgetDay);

    for (let day = 2; day <= n; day++) {
        if (!daysMap.has(day)) continue;
        const arr = daysMap.get(day);

        for (const curForget of arr) {
            if (day === curForget) {
                peopleForgot += 1;
                continue;
            }
            peopleKnown++;

            const newStart = day + delay;
            const newForget = day + forget;

            for (let d = newStart; d <= Math.min(newForget - 1, n); d++) {
                pushDay(d, newForget);
            }
            pushDay(newForget, newForget);
        }

        daysMap.delete(day);
    }

    return ((peopleKnown - peopleForgot) % MOD + MOD) % MOD;
};

var peopleAwareOfSecret = function (n, delay, forget) { // working DP
    const MOD = 1e9 + 7;
    const dp = Array(n)
    dp[0] = 1

    let window = 0
    for(let i = 1; i < n; i++) {
        if(i - delay >= 0) {
            window = (window + dp[i - delay]) % MOD
        }

        if(i - forget >= 0) {
            window = (window - dp[i - forget]) % MOD
        }
        dp[i] = window % MOD
    }

    let day = 0
    let i = n - 1
    let result = 0
    while (day < forget) {
        result = (result + dp[i] +  MOD) % MOD
        i--
        day++
    }

    return result % MOD
};



let n, delay, forget
// n = 6, delay = 2, forget = 4
// n = 4, delay = 1, forget = 3
n = 4, delay = 1, forget = 4

console.log(peopleAwareOfSecret(n, delay, forget))