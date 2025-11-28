class Animal {
    constructor(name, type) {
        this.name = name;
        this.type = type;
    }

    run() {
        console.log(`${this.name} is running`);
    }
}

const elephant = new Animal('Gaint', 'elephant')


function makeToSwim(location, feet) {
    return console.log(`${this.name} is a ${this.type} trying to swim in the ${location} which is ${feet} feet deep..`)
}

// ------ Actual methods --------
makeToSwim.call(elephant, 'Artic ocean', 9000)

// --------- method declaration -----------
Function.prototype.myCall = function(obj, ...args) {
    obj.function = this;

    return obj.function(...args)
}

console.log(Function.prototype);

// --------- Polyfill -----------
makeToSwim.myCall(elephant, 'Atlantic ocean', 11000);


