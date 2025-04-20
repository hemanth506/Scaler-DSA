class Student {
    name?: string;
    age?: number;
    batch?: number;
    psp?: number;
    univName?: string;

    constructor(name?: string, age?: number, batch?: number, psp?: number, univName?: string) {
        this.age = age
        this.name = name
        this.univName = univName;
        this.batch = batch
        this.psp = psp
    }

    public static copyConstructor(sd: Student) {
        return new Student(sd.name, sd.age, sd.batch, sd.psp, sd.univName)
    }
}

let sd = new Student("Hemanth", 27, 2019, 63.5, "Anna University")
let sd2 = Student.copyConstructor(sd)
console.log(sd)
console.log(sd2)
console.log(sd === sd2)


class BrightStudent extends Student {
    iq?: number
    
    constructor(iq?: number) {
        super()
        this.iq = iq
    }
}


const getRandomClass = ():  BrightStudent | Student => {
    const randomValue = Math.floor(Math.random() * 10) + 1;

    if(randomValue % 2 === 0) {
        return new BrightStudent(23)
    } 
    return new Student()
}

const currentClass: BrightStudent = getRandomClass();
if(currentClass instanceof BrightStudent) {
    console.log('🚀 ~ currentClass:', currentClass.iq)
}

