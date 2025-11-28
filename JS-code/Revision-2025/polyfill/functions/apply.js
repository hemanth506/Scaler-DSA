class Animal {
    constructor(name, type) {
        this.name = name;
        this.type = type;
    }

    run() {
        console.log(`${this.name} is running`);
    }
}

const tiger = new Animal('Mufasa', 'tiger')


function makeToSwim(location, feet) {
    return console.log(`${this.name} is a ${this.type} trying to swim in the ${location} which is ${feet} feet deep..`)
}

// ------ Actual methods --------
makeToSwim.apply(tiger, ['Atlantic ocean', 12000])


// --------- method declaration -----------
Function.prototype.myApply = function(obj, [...args]) {
    obj.function = this;

    return obj.function(...args)
}


console.log(Function.prototype);

// --------- Polyfill -----------
makeToSwim.myApply(tiger, ['Pacific ocean', 11000]);


