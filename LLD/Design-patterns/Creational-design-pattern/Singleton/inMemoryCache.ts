class InMemoryCache {
    public cache: Map<string, string> = new Map();
    private static instance: InMemoryCache | null = null;

    private constructor () { }

    public static initialize(): InMemoryCache {
        if (InMemoryCache.instance === null) {
            InMemoryCache.instance = new InMemoryCache();
        }
        return InMemoryCache.instance;
    }

    public setValue(key: string, value: string) {
        this.cache.set(key, value);
    }

    public getValue(key: string): string | undefined {
        if(!this.cache.has(key)) {
            return "Not found";
        }
        return this.cache.get(key);
    }

}

const imc = InMemoryCache.initialize();
imc.setValue("h", "hemanth")
imc.setValue("r", "ruchika")
console.log(imc.cache);
imc.setValue("l", "latha")
console.log(imc.getValue("l"));

const imc2 = InMemoryCache.initialize();
imc2.setValue('g', 'giri')
console.log(imc.cache);
console.log(imc === imc2)

// const imc3 = new InMemoryCache();