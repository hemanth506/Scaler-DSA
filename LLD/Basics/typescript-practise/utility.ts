interface User {
    name: string
    age?: number
    email: string
}

type PartialUser = Partial<User>

type RequiredUser = Required<User>

type ReadOnlyUser = Readonly<User>

type PickUserNameAndEmail = Pick<User, 'name' | 'email'>

type OmitUserEmail = Omit<User, 'email'>

type Nullable = string | null | unknown
type NonNullableString = NonNullable<Nullable>

// ----------------------------------------

type Fruit = 'apple' | 'banana' | 'graph'
type FruitType = number

type FruitRecord = Record<Fruit, FruitType>

const fruitObj: FruitRecord = {
    apple: 0,
    banana: 0,
    graph: 0
}

type Result = string | number extends string ? "yes" : "no"

// ----------------------------------------

type CommonKeys<T, U> = keyof T & keyof U

type A = {
  id: number
  name: string
}

type B = {
  id: number
  age: number
}

type R = CommonKeys<A, B>