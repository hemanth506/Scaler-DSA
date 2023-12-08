const arr = [2, 3, 4, 5];
const reducer = (a, b) => {
  return a + b;
};

function reduceFunc(arr, fn) {
  if (!fn) return;
  let lenArr = arr.length;
  let val = arr[0];
  for (let i = 1; i < lenArr; i++) {
    val = fn(val, arr[i]);
    console.log("🚀 ~ file: index.js:12 ~ reduceFunc ~ val:", val);
  }
  console.log(lenArr);
  return val;
}

let result = arr[0];
for (let i = 1; i < arr.length; i++) {
  result = reducer(result, arr[i]);
}
return result;

const reduce = reduceFunc(arr, reducer);
console.log("🚀 ~ file: index.js:11 ~ reduce:", reduce);
