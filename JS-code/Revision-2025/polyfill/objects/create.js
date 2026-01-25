const personObj = {
    greet() {
        console.log(`Hello, how are you? Mr.${this.firstName} ${this.lastName}`);
    }
}

const john = Object.create(personObj)
john.firstName = 'John'
john.lastName = 'Paul'
john.greet()

// creating using constructor function
Object.myCreate = function(obj) {
    function F() {}
    F.prototype = obj;
    return new F();
}

const mj = Object.myCreate(personObj)
mj.firstName = 'Micheal'
mj.lastName = 'Jordan'
mj.greet()
