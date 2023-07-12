class Person {
    constructor(name, age) {
        this.name = name;
        this.age = age;
    }

    isAdult() {
        return this.age >= 18;
    }

    isOverAged() {
        return this.age > 59; 
    }
}

let p1 = new Person("Hemanth", 25);
console.log(p1.isAdult())
console.log(p1.isOverAged())
