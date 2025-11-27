const one = () => {
  console.log("one")
  return 1;
}

const two = () => {
  console.log("two")
  return 2;
}

const three = () => {
  console.log("three")
  return 3;
}


const executeAllfunction = (...fns) => {
  return () => {
    let result;
    for (let i = 0; i < fns.length; i++) {
      result = fns[i](result);
    }
    return result
  };
}

const composite = executeAllfunction(one, two, three, three, three);
composite()