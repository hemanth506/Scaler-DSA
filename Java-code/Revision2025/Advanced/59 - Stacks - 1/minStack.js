function solve() {
    // Initalize your variables here
    this.minStack = []
    this.stack = []
};
solve.prototype.push = function (e) {
    this.stack.push(e)
    if(this.minStack.length === 0) {
        this.minStack.push(e)
    } else {
        if (this.minStack[this.minStack.length - 1] < e) {
            this.minStack.push(this.minStack[this.minStack.length - 1])
        } else {
            this.minStack.push(e)
        }
    }
};
solve.prototype.pop = function () {
    this.stack.pop()
    this.minStack.pop()
};
solve.prototype.top = function () {
    return this.stack.length > 0 ? this.stack[this.stack.length - 1] : -1
};
solve.prototype.getMin = function () {
    return this.minStack.length > 0 ? this.minStack[this.minStack.length - 1] : -1
};

