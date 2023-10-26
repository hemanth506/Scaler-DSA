class Student {
  name;
  age = 30;
  constructor(name) {
    this.name = name;
  }

  getName() {
    return this.name;
  }

  getAge() {
    return this.age;
  }
}

const std1 = new Student("hemanth");
// console.log("🚀 ~ file: fundamentals.js:19 ~ std1.getName():", std1.getName());
// console.log("🚀 ~ file: fundamentals.js:19 ~ std1.getAge():", std1.getAge());

class DoubleLinkedList {
  leftNode;
  rightNode;
  data;
  constructor(data) {
    this.leftNode = null;
    this.rightNode = null;
    this.data = data;
  }
}

class Node {
  next;
  data;
  constructor(data) {
    this.data = data;
    this.next = null;
  }
}

const main = (x) => {
  let head = new Node(1);
  const temp = head;
  for (let i = 2; i <= x; i++) {
    head.next = new Node(i);
    head = head.next;
  }

  return temp;
};

// const headNode = main(20);
// console.log("🚀 ~ file: fundamentals.js:53 ~ main(10);:", headNode);

const getSizeOfLL = (headNode) => {
  let head = headNode;
  let size = 0;
  while (head != null) {
    console.log(
      "🚀 ~ file: fundamentals.js:61 ~ getSizeOfLL ~ head:",
      head.data
    );
    size++;
    head = head.next;
  }
  return size;
};

// const size = getSizeOfLL(headNode);
// console.log("🚀 ~ file: fundamentals.js:69 ~ size:", size)

// ==================================================================

const stack = new Array();
for (let i = 0; i < 9; i++) {
  stack.push(i);
}

console.log(stack);
const poppedELt = stack.pop();
console.log("🚀 ~ file: fundamentals.js:80 ~ poppedELt:", poppedELt);
console.log(stack);

const top = stack[stack.length - 1];
console.log("🚀 ~ file: fundamentals.js:84 ~ stackTop:", stackTop);
console.log(stack);