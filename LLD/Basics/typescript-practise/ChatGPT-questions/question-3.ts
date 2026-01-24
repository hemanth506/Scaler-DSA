type User = {
  name: string
  age: number
  greet: () => void
  setAge: (age: number) => void
}

type FunctionProps<T> = {
    [K in keyof T as T[K] extends (...args: any[]) => any ? K : never]: T[K]
}

// type FunctionProps<T> = Omit(T, string | 'age')

type UserFunctions = FunctionProps<User>

/*
UserFunctions should be:

{
  greet: () => void
  setAge: (age: number) => void
}
*/