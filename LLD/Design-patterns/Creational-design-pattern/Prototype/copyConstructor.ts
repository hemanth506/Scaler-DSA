interface Prototype<T> {
    clone(): T;
}

class Student implements Prototype<Student>{
    name: string;
    age: number;
    batch: number;
    psp: number;
    univName: string;

    constructor(name: string, age: number, batch: number, psp: number, univName: string) {
        this.name = name
        this.age = age
        this.batch = batch
        this.psp = psp
        this.univName = univName;
    }

    public clone(): Student {
        return new Student(this.name, this.age, this.batch, this.psp, this.univName)
    }
}

class BrightStudent extends Student implements Prototype<BrightStudent> {
    iq: number

    constructor(iq: number, name: string, age: number, batch: number, psp: number, univName: string) {
        super(name, age, batch, psp, univName)
        this.iq = iq
    }

    public clone(): BrightStudent {
        return new BrightStudent(this.iq, this.name, this.age, this.batch, this.psp, this.univName)
    }
}

const getRandomClass = (): BrightStudent | Student => {
    const randomValue = Math.floor(Math.random() * 10) + 1;

    if (randomValue % 2 === 0) {
        return new BrightStudent(99, "Ruchika", 27, 2020, 68.5, "Anna University")
    }
    return new Student("Hemanth", 28, 2019, 63.5, "Anna University")
}

const currentClass: BrightStudent | Student = getRandomClass();
const newObj = currentClass.clone()
console.log('🚀 ~ newObj:', newObj, ' \n currentClass', currentClass)

