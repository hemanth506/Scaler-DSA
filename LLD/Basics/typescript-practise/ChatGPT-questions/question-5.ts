type User = {
  name: string
  age: number | null
  city?: string
  email: string | null
}

type NullableKeys<T> = {
  [K in keyof T] -?: 
    null extends T[K] 
        ? K 
        : undefined extends T[K] 
            ? K 
            : never
}[keyof T]

type NullableUserKeys = NullableKeys<User>