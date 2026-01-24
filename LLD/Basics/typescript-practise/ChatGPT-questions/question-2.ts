type User = {
  name: string
  age: number
  city: string
}

type NullableProps<T> = {
    [K in keyof T]?: T[K] | null 
}

type NullableUser = NullableProps<User>