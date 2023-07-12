function Person(name, age) {
    this.name = name
    this.age = age
    return this;
}

let p1 = Person("Hemanth", 25);
let p2 = new Person("Hemanth", 25);
p1.name = "Ruchi"
p2.name = "Ruchika"

p1.study = "BE"
p2.study = "BE"
console.log(p1)
console.log(p2)

let str1 = new String("Adsvs");
let str2 = "1234";
console.log(str1);
console.log(str2);

str1 = new String("3465");
str2 = "4567";
console.log(str1);
console.log(str2);



