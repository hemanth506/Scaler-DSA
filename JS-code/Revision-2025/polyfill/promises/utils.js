export const resolveFn = (s) => {
    return new Promise((res, rej) => {
        setTimeout(() => res(s), s * 1000)
    })
}

export const rejectFn = (s) => {
    return new Promise((res, rej) => {
        setTimeout(() => rej(s), s * 1000)
    })
}