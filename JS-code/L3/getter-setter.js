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

    // Getting will return the value
    get firstName() {
        return this.name.split(" ")[0];
    }
    get lastName() {
        return this.name.split(" ")[1];
    }

    // Setter will modify the value
    set firstName(value) {
        const wordNames = this.name.split(" ");
        wordNames[0] = value;
        this.name = wordNames.join(" ")
    }
}

let p1 = new Person("Hemanth Raaj", 25);
console.log(p1.firstName);
console.log(p1.lastName);

p1.firstName = "Ruchika";
console.log(p1);
