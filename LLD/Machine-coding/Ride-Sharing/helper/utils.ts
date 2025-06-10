export const getRandom = () => {
    const value = Math.random() * 10; 
    const rounded = Number(value.toFixed(3));
    return rounded
}