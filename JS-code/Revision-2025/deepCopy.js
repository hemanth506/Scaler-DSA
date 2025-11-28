const complexObj = {
    name: "Hemanth",
    age: 27,
    active: true,
    scores: [10, 20, { x: 99, y: [1, 2, 3] }],

    meta: {
        created: new Date("2023-01-01"),
        updated: new Date(),
        regex: /test\d+/gi,
    },

    nested: {
        level1: {
            level2: {
                level3: {
                    arr: [{ id: 1 }, { id: 2 }],
                    func: function greet() { return "hello"; }
                }
            }
        }
    },

    typedArrays: {
        int8: new Int8Array([1, 2, 3]),
        float32: new Float32Array([1.2, 3.4])
    }
};

function isPlainObject(value) {
    return Object.prototype.toString.call(value) === '[object Object]';
}

const deepCopy = (obj) => {
    function solve(curObj) {
        const constructObj = {};
        Object.keys(curObj).forEach((key) => {
            if (isPlainObject(curObj[key])) {
                constructObj[key] = solve(curObj[key])
            } else if (Array.isArray(curObj[key])) {
                constructObj[key] = [...curObj[key]]
            } else if (curObj[key] instanceof Date) {
                constructObj[key] = new Date(curObj[key])
            } else if (curObj[key] instanceof RegExp) {
                constructObj[key] = new RegExp(curObj[key])
            } else {
                constructObj[key] = curObj[key]
            }
        })
        return constructObj;
    }

    return solve(obj);
}

console.log(complexObj);

const rs = deepCopy(complexObj)
console.log(rs);
console.log(complexObj.nested.level1.level2.level3.func);
console.log(rs.nested.level1.level2.level3.func);
console.log(complexObj.nested.level1.level2.level3.func === rs.nested.level1.level2.level3.func);
