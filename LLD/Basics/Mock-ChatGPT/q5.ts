type Original = {
  syncAdd: (a: number, b: number) => number;
  name: string;
  multiply: (x: number, y: number) => number;
}

type Asyncify<T> = {
    [K in keyof T]: T[K] extends (...args: infer L) => infer U 
        ? (...args: L) => Promise<U> 
        : T[K]
}

type AsyncOriginal = Asyncify<Original>;

/* Expected:
type AsyncOriginal = {
  syncAdd: (a: number, b: number) => Promise<number>;
  name: string;
  multiply: (x: number, y: number) => Promise<number>;
}
*/


for (var i = 0; i < 3; i++) {
    (function(i) {
        setTimeout(() => {
          console.log(i);
        }, 100);
    })(i)
}