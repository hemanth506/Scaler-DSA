function checkBracketsExpression(A, B) {
  function getSign(sign1, sign2) {
    if (sign1 === sign2) {
      return "+";
    }
    return "-";
  }

  function deSerialize(serializedStr) {
    const alphaArr = new Array(26).fill(null);
    const stack = ["+"];
    const aCode = "a".charCodeAt(0);
    const zCode = "z".charCodeAt(0);

    for (let i = 0; i < serializedStr.length; i++) {
      const peekElt = stack[stack.length - 1];
      const curChar = serializedStr.charAt(i);
      if (curChar.charCodeAt(0) >= aCode && curChar.charCodeAt(0) <= zCode) {
        if (i === 0) {
          alphaArr[curChar.charCodeAt(0) - aCode] = peekElt;
          continue;
        }

        let sign = getSign(
          peekElt,
          serializedStr.charAt(i - 1) === "("
            ? "+"
            : serializedStr.charAt(i - 1)
        );
        alphaArr[curChar.charCodeAt(0) - aCode] = sign;
      } else if (curChar === "(") {
        if (i > 0 && serializedStr.charAt(i - 1) !== "(") {
          const arrElt = serializedStr.charAt(i - 1);
          const sign = getSign(peekElt, arrElt);
          stack.push(sign);
        }
      } else if (curChar === ")") {
        stack.pop();
      }
    }

    console.log("alphaArr ::", alphaArr);
    console.log("stack ::", stack);

    return alphaArr;
  }

  const aStr = deSerialize(A);
  const bStr = deSerialize(B);

  for (let i = 0; i < 26; i++) {
    if (aStr[i] !== bStr[i]) {
      return 0;
    }
  }

  return 1;
}

checkBracketsExpression("a-(b-(c-(d-e+f)-g)+h)", "a-b+c-d+e-f+g+h")