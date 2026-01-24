type User = {
  name: string
  age: number
}
type PrefixedOptional<T, U extends string> = {
    [K in keyof T as `${U}${K & string}`] ?: T[K]
}

type PrefixedUser = PrefixedOptional<User, "user_">