var minimumTeachings = function(n, languages, friendships) {
    const arr = languages.map(language => new Set(language))

    let needTeach = new Set();
    for(let [f1, f2] of friendships) { // O(N * M)
        f1--; f2--;
        let canCommunicate = false
        for(let key of arr[f1]) {
            if(arr[f2].has(key)) {
                canCommunicate = true
                break
            }
        }
        if(!canCommunicate) {
            needTeach.add(f1)
            needTeach.add(f2)
        }
    }
    if (needTeach.size === 0) { return 0; }

    console.log('needTeach', needTeach); // U
    let minTeach = Infinity;
    for(let lang = 1; lang <= n; lang++) { // O(Lang * U)
        let teach = 0
        for(let user of needTeach) {
            if(!arr[user].has(lang)) {
                teach++
            }
        }
        console.log('teach', teach, lang);
        minTeach = Math.min(minTeach, teach)
    }

    return minTeach === Infinity ? 0 : minTeach
};

let n, languages, friendships;

// n = 2, languages = [[1],[2],[1,2]], friendships = [[1,2],[1,3],[2,3]]
// n = 3, languages = [[2],[1,3],[1,2],[3]], friendships = [[1,4],[1,2],[3,4],[2,3]]
// n = 11, languages = [[3,11,5,10,1,4,9,7,2,8,6],[5,10,6,4,8,7],[6,11,7,9],[11,10,4],[6,2,8,4,3],[9,2,8,4,6,1,5,7,3,10],[7,5,11,1,3,4],[3,4,11,10,6,2,1,7,5,8,9],[8,6,10,2,3,1,11,5],[5,11,6,4,2]], friendships = [[7,9],[3,7],[3,4],[2,9],[1,8],[5,9],[8,9],[6,9],[3,5],[4,5],[4,9],[3,6],[1,7],[1,3],[2,8],[2,6],[5,7],[4,6],[5,8],[5,6],[2,7],[4,8],[3,8],[6,8],[2,5],[1,4],[1,9],[1,6],[6,7]]
n = 2;
languages = [[2],[1],[2,1],[1],[1,2],[1],[2],[1],[1],[2],[1,2],[1,2],[1,2],[2,1],[1],[2],[1,2]];
friendships = [[15,16],[4,13],[3,16],[5,14],[1,7],[2,11],[3,15],[4,16],[7,9],[6,13],[6,16],[4,10],[6,9],[5,6],[7,12],[6,12],[3,7],[4,7],[8,10]]
console.log(minimumTeachings(n, languages, friendships));