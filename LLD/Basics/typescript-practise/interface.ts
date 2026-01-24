type MathOpType = (x: number, y: number) => number

const add: IMathOp = (x: number, y: number) => x + y

// console.log(add(3,5));

// ----------------------------------------

interface IMathOp {
    (x: number, y: number): number
}

interface AdditionalOp extends IMathOp { // function overloading
    (a: string, b: string, c: string): string
}

// const addNew: AdditionalOp = (x: string, y: string, g: string) => x + y

// console.log(addNew('dsv', 'dv', 'sdv'));
// console.log(addNew('a', 'b', 'c'));

// ----------------------------------------

interface Person {
    name: string
}

interface Person {
    age: number
}

// ---- interfaces with the same name merges => works fine
const details: Person = {
    name: "Hemanth",
    age: 0
}

type peronType = {
    name: string
}

// ---- merging won't happen in type
// type peronType = {
//     name: string
// }

// ----------------------------------------

type A = { a: string }
type B = { a: number }

type C = A & B

// ---- Won't be able to recoginize which to use
// const t: C = "10"
// console.log(t);

// ----------------------------------------


type NonNullable<T, I> = {
    [K in keyof T]: T[K];
} & {
    address: {
        [K in keyof I]: I[K];
    };
}

type User = {
    name: string
    age: number
}

type Address = {
    city: string
    state: string
}

const userDetails: NonNullable<User, Address> = {
    name: "Hemanth",
    age: 27,
    address: {
        city: "",
        state: ""
    }
}

// ------------------In interface----------------------
// can use this way and can use extendas way in oops
interface UserWithAddress<T, I> {
    data: T;
    address: I;
}


type User2 = {
    name: string
    age: number
}

type Address2 = {
    city: string
    state: string
}

const userDetails2: UserWithAddress<User2, Address2> = {
    data: {
        name: "",
        age: 0
    },
    address: {
        city: "",
        state: ""
    }
}

// ----------------------------------------

interface Person {
    name: string
    age: number
}

type PersonType = Person
type PersonDetails = PersonType & ({ bloodGroup: string } | { city: string })
const personDetail: PersonDetails = {
    name: "Hemanth",
    age: 27,
    bloodGroup: "O+ve"
}

type nameType = {NAME: string}
type nameTyp = keyof nameType
const name: nameTyp = "NAME"
console.log(name);

// ----------------------------------------

function update<T, K extends keyof T>(
  obj: T,
  key: K,
  value: T[K]
) {
  obj[key] = value
}

type School = {
    name: string
    year: number
}

