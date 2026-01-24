interface Box<T, k> {
    (x: T, y: k): T
}

const addBoxFun: Box<number, number> = (x, y) => x + y
console.log(addBoxFun(10, 11));

const concatBoxFun: Box<string, string> = (x, y) => x + y
console.log(concatBoxFun("10", "11"));

const crossBoxFun: Box<string, number> = (x, y) => x + y
console.log(concatBoxFun("10", "11"));

type User = {
  id: number
  name: string
  isAdmin: boolean
}

type Getters<T> = {
  [K in keyof T as `get${Capitalize<string & K>}`]: () => T[K]
}

type UserGetters = Getters<User>

const userDet: UserGetters = {
    getId: function (): number {
        throw new Error("Function not implemented.");
    },
    getName: function (): string {
        throw new Error("Function not implemented.");
    },
    getIsAdmin: function (): boolean {
        throw new Error("Function not implemented.");
    }
}

type id = User['id']

// -----------------Accept only positive numbers-----------------------

type OnlyPositive<T extends number> = `${T}` extends `-${string}` ? never : T

function square<T extends number>(val: OnlyPositive<T>) {
    return val * val
}

square(5);
square(0);
// square(-5); // this will error out



// -----------------Accept only email-----------------------

type OnlyEmail<T extends string> = `${T}` extends (`${string}.com` | `${string}.io`) ? T : never

function validateEmail<T extends string>(str: OnlyEmail<T>) {
    return str
}
validateEmail('hemanthraaj@gmail.com')
validateEmail('hemanthraaj@gmail.io')
// validateEmail('hemanthraaj@gmail')
