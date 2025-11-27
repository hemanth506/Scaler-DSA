console.log('start');

var funcsVar = [];
for (var i = 0; i < 3; i++) {
  funcsVar.push(function () {
    console.log('funcVar', i);
  });
}

let funcsLet = [];
for (let j = 0; j < 3; j++) {
  funcsLet.push(function () {
    console.log('funcLet', j);
  });
}


funcsVar[0]();
funcsLet[0]();

// IIFE capturing current loop value
const iifeFuncs = [];
for (var a = 0; a < 3; a++) {
  iifeFuncs.push((function (v) {
    return function () {
      console.log('iife', v);
    };
  })(a));
}
iifeFuncs[1]();   // C

// Schedule macrotasks with var and let
for (var k = 0; k < 3; k++) {
  setTimeout(() => console.log('tvar', k), 0);
}
for (let m = 0; m < 3; m++) {
  setTimeout(() => console.log('tlet', m), 0);
}

// Microtasks
Promise.resolve()
  .then(() => console.log('microtask 1'))
  .then(() => console.log('microtask 2'));

// Async function with await (await null → microtask continuation)
async function foo() {
  console.log('async start');
  await null;
  console.log('async after await');
}
foo();

console.log('end');


/** OUTPUT 

start

funcVar 3
funcLet 0

iife 1

async start

end

microtask 1
microtask 2

async after start

tvar 3
tvar 3
tvar 3

tlet 0
tlet 1
tlet 2


 */