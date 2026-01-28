const a = { id: 1, name: 'John' };
const b = { age: 30, name: 'Jane' };


function mergeObjects<T extends object, U extends object>(a: T, b: U): T & U {
    return {
        ...a,
        ...b
    }
}

const result = mergeObjects(a, b);
console.log(result);