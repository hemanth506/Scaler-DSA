type API = {
  getName: () => string
  getAge: () => number
  isLoggedIn: boolean
}

type Asyncify<T> = {
    [K in keyof T]: T[K] extends ((...args: infer W) => infer U)  
        ? (...args: W) => Promise<U> 
        : T[K]
}

type AsyncAPI = Asyncify<API>