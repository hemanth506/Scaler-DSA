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

const shallowCopy = (obj) => {
    const constructObj = {}
    Object.keys(obj).forEach(key => {
        constructObj[key] = obj[key]
    });

    return constructObj
}

const res = shallowCopy(complexObj)
console.log(res);
console.log(complexObj.scores === res.scores);
