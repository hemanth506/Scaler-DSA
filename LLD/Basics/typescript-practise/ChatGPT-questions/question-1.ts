type Input = {
    fn: () => {}
    name: string
    address: {
        city: string
        zip: number
    }
    tags: string[]
}



/*
ReadonlyInput should be:
{
  readonly name: string
  readonly address: {
    readonly city: string
    readonly zip: number
  }
  readonly tags: readonly string[]
}
*/

// type DeepReadonly <T> = {
//   readonly [K in keyof T]: T[K] extends Object ? DeepReadonly<T[K]> : T[K]
// }

type DeepReadonly<T> = T extends Function 
    ? T 
    : T extends Array<infer U> 
        ? DeepReadonly<U>[] 
        : T extends Object 
            ? { readonly [K in keyof T]: DeepReadonly<T[K]> }
            : T

type ReadonlyInput = DeepReadonly<Input>