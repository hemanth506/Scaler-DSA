class Animal {
    constructor(name, type) {
        this.name = name;
        this.type = type;
    }

    run() {
        console.log(`${this.name} is running`);
    }
}

const lion = new Animal('Simba', 'lion')


function makeToSwim(location, feet) {
    return console.log(`${this.name} is a ${this.type} trying to swim in the ${location} which is ${feet} feet deep..`)
}

// ------ Actual methods --------
makeToSwim.bind(lion)('Pacific ocean', 15000)


// --------- method declaration -----------
Function.prototype.myBind = function(obj) {
    obj.function = this;

    return function(...args) {
        return obj.function(...args)
    }
}


// console.log(Function.prototype);

// --------- Polyfill -----------
makeToSwim.myBind(lion)('Pacific ocean', 15000);


