export const useLocalStorage = (key, value) => {
    if (!value) {
        return localStorage.getItem(key)
    }
    localStorage.setItem(key, value)
    return
}
