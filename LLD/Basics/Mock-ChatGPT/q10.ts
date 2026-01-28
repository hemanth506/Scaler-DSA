type A = {
  readonly id: number;
  readonly meta: {
    readonly name: string;
  };
};

type Mutable<T> = 
    T extends (...args: any[]) => any 
        ? T 
        : T extends object 
            ? {-readonly [K in keyof T]: Mutable<T[K]>} 
            : T
    


type Mutable2<T> =
  T extends (...args: any[]) => any
    ? T
    : T extends object
      ? { -readonly [K in keyof T]: Mutable2<T[K]> }
      : T;



type B = Mutable<A>;
/*
{
  id: number;
  meta: {
    name: string;
  };
}
*/
