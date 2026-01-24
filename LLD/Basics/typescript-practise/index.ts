const n: number = 10;
// console.log(n);

// type assertion

let variable: any = 'Hello'
// console.log((variable as string).length); // new syntax
// console.log((<string>variable).length); // old syntax

let arr = 123 as const;
// console.log(arr);


let arrVal: readonly number[] = [2345] 


