function marry () {
    let canMarry = new Set();
    return function (person) {
        if(canMarry.has(person)) {
            console.log('Sorry!, You are already married.');
            return;
        }

        console.log('Happy Married life', person);
        canMarry.add(person)
    }
}

const m = marry()

m('Hemanth')
m('Hemanth')

m('Ruchika')
m('Harish')



function one() {
  function two() {
    let x = 10;
    function three() {
      let x = 20;
      console.log("x from 3 = " + x);
    }
    console.log("x from 2 = " + x);
    three();
    console.log("x from 2 = " + x);
  }
  two();
}
one();


function outer() {
  let arrFn = [];
  let i;
  for (i = 0; i < 3; i++) {
    arrFn.push(function fn() {
      i++;
      console.log(i);
    })
  }
  return arrFn;
}
let arrFn = outer();
arrFn[0]();
arrFn[1]();
arrFn[2]();

