class FrequencyTracker {
    constructor() {
        this.freqMap = new Map()
        this.existMap = new Map()
    }
    deleteOldExistCount(number) {
        let curFreq = this.freqMap.get(number)
        const decExistVal = this.existMap.get(curFreq) - 1
        if (decExistVal === 0) {
            this.existMap.delete(curFreq)
        } else {
            this.existMap.set(curFreq, decExistVal)
        }
    }

    add(number) {
        if (this.freqMap.has(number)) {
            this.deleteOldExistCount(number)
        }
        let newFreq = (this.freqMap.get(number) || 0) + 1
        this.freqMap.set(number, newFreq)
        this.existMap.set(newFreq, (this.existMap.get(newFreq) || 0) + 1)
    }

    deleteOne(number) {
        if (this.freqMap.has(number)) {
            this.deleteOldExistCount(number)

            const decVal = this.freqMap.get(number) - 1
            if (decVal === 0) {
                this.freqMap.delete(number)
            } else {
                this.freqMap.set(number, decVal)
            }

            this.existMap.set(decVal, (this.existMap.get(decVal) || 0) + 1)
        }
    }

    hasFrequency(frequency) {
        if (this.existMap.has(frequency)) return true;
        return false;
    }
}