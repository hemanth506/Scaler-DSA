const mulBy2 = ([a]) => {
  return [a * 2, a];
}

const mulBy3 = ([b]) => {
  return [b * 3, b];
}

const mul = ([x, y]) => {
  return [x * y, y];
}

const executeAllMulfunction = (...fns) => {
  return (...args) => {
    let result = [...args]
    for (let i = fns.length - 1; i >= 0; i--) {
      result = fns[i](result);
    }
    return result
  };
}

const compositeMul = executeAllMulfunction(mulBy2, mulBy2, mul, mulBy3, mul, mul, mul, mulBy3);
// console.log(compositeMul(3, 3)[0]);






const addBy2 = (a) => {
  return a + 2;
}

const addBy3 = (b) => {
  return b + 3;
}

const add = (x, y) => {
  return x + y;
}

const executeAllAddfunction = (...fns) => {
  return (...args) => {
    return fns.reduce((prev, cur) => [cur(...prev)], args)[0]
  };
}

const compositeAdd = executeAllAddfunction(add, addBy2, addBy3);
console.log(compositeAdd(3, 3));










