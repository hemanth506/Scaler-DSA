// Enforce positive numbers only at compile time.

type Positive<T extends number> = `${T}` extends `-${string}` ? never : T 
const posNum = -1234
const n: Positive<typeof posNum> = posNum
console.log('n', n);

// type PositiveNumber = number & { __brand: 'positive' };

// function makePositive(n: number): PositiveNumber {
//   if (n <= 0) {
//     throw new Error('Not a positive number');
//   }
//   return n as PositiveNumber;
// }

// const p = makePositive(-10);
// console.log(p);

