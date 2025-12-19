import { PriorityQueue } from "datastructures-js";

var findAllPeople = function(n, meetings, firstPerson) {
    const vis = Array(n).fill(false)
    const adjList = new Map()
    for(let [u, v, time] of meetings) {
        if(!adjList.has(u)) adjList.set(u, []);
        adjList.get(u).push([time, v])

        if(!adjList.has(v)) adjList.set(v, []);
        adjList.get(v).push([time, u])
    }

    const mh = new PriorityQueue((a, b) => a[0] - b[0])
    mh.enqueue([0, 0])
    mh.enqueue([0, firstPerson])

    while(mh.size() > 0) {
        const [curT, u] = mh.dequeue()
        if(!vis[u]) {
            vis[u] = true
            for(let [t, v] of adjList.get(u) || []) {
                if(curT <= t && !vis[v]) {
                    mh.enqueue([t, v])
                }
            }
        }
    }
    console.log(vis);
    const allKnowPeople = [0]
    for(let i = 1; i < n; i++) {
        if(vis[i]) {
            allKnowPeople.push(i)
        }
    }
    return allKnowPeople
};

let n, meetings, firstPerson;
n = 6, meetings = [[1,2,5],[2,3,8],[1,5,10]], firstPerson = 1
// n = 4, meetings = [[3,1,3],[1,2,2],[0,3,3]], firstPerson = 3
// n = 5, meetings = [[3,4,2],[1,2,1],[2,3,1]], firstPerson = 1

console.log(findAllPeople(n, meetings, firstPerson));