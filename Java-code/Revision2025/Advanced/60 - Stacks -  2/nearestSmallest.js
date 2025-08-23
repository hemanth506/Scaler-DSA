function NearestElt(A) {
    if (A.length === 1) {
        return [-1];
    }
    const N = A.length
    const stack = new Array(A).fill(-1);
    const gElt = [];
    for (let i = 0; i < A.length; i++) {
        while (stack.length !== 0 && stack[stack.length - 1] >= A[i]) {
            stack.pop();
        }
        if (stack.length !== 0) {
            gElt[i] = stack[stack.length - 1];
        }
        stack.push(A[i]);
    }
    return gElt;
}

NearestElt([34, 35, 27, 42, 5, 28, 39, 20, 28]);
