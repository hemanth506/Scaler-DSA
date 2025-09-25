var mincostTickets = function(days, costs) {
    const n = days.length
    const dp = new Map()

    function solve(i, expDate) {
        if(i === n) {
            return 0
        }

        const str = i+"_"+expDate
        if(!dp.has(str)) {
            if(expDate > days[i]) { // pass valid
                const minCost = solve(i+1, expDate)
                dp.set(str, minCost)
            } else {
                const oneDay = solve(i+1, days[i] + 1) + costs[0]
                const sevenDay = solve(i+1, days[i] + 7) + costs[1]
                const thirtyDay = solve(i+1, days[i] + 30) + costs[2]

                const minCost = Math.min(oneDay, sevenDay, thirtyDay)
                dp.set(str, minCost)
            }
        }
        return dp.get(str)
    }
    const minCost = solve(0, 0)
    return minCost
};


var mincostTicketsold = function(days, costs) {
    const n = days.length
    const dp = Array(n).fill(-1)
    let minCost = Infinity

    function solve(i, expDate, cost) {
        console.log(i , n)
        if(i === n) {
            minCost = Math.min(cost, minCost)
            return 
        }

        

        solve(i+1, days[i] + 1, cost + costs[0])
        solve(i+1, days[i] + 7, cost + costs[1]) 
        solve(i+1, days[i] + 30, cost + costs[2])
        return
    }
    console.log(dp)
    solve(0, days[0])
    console.log(minCost)
};

let days, costs;

days = [1,2,3,4,5,6,7,8,9,10,30,31]
// days = [1,4, 6,7,8,20]

costs = [2,7,15]

mincostTickets(days, costs)