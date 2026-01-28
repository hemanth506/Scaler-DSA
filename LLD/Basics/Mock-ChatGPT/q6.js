const log = () => console.log('Called!');

function debounce(fn, delay) {
    let timer = null
    return function() {
        if(timer !== null) {
            clearTimeout(timer)
        }
        timer = setTimeout(() => {
            fn() 
        }, delay)
    }
}


const debouncedLog = debounce(log, 200);

debouncedLog();
debouncedLog();
debouncedLog();

// "Called!" should be printed only once, 200ms after the last call


