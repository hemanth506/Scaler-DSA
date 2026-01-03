type ConfigType = { count: number; seconds: number }
type FixedWindowType = { startTime: number, count: number }
type BucketType = { lastRefill: number, tokens: number }
type LeakBucketType = { lastRefill: number, level: number }
type SlidingWindowCounterType = { previousWindowRequest: number, currentWindowStartTime: number, currentWindowRequest: number }

abstract class RateLimittingStrategy {
    abstract canAccess(clientId: string): boolean
    protected getNow() { return Date.now() }
}

export class FixedWindow extends RateLimittingStrategy {
    private window: Map<string, FixedWindowType>
    private config: ConfigType;

    constructor(config: ConfigType) {
        super()
        this.config = config
        this.window = new Map<string, FixedWindowType>()
    }

    public canAccess(clientId: string): boolean {
        console.log('FixedWindow');
        const now = this.getNow()
        const windowTime = this.config.seconds * 1000
        const entry = this.window.get(clientId)
        if (!entry || (now - entry.startTime) >= windowTime) {
            this.window.set(clientId, { startTime: now, count: 1 })
            return true
        }
        if (entry.count < this.config.count) {
            entry.count += 1
            return true
        }
        return false
    }
}

export class SlidingWindowLog extends RateLimittingStrategy {
    private window: Map<string, number[]>
    private config: ConfigType;

    constructor(config: ConfigType) {
        super()
        this.config = config
        this.window = new Map<string, number[]>()
    }
    public canAccess(clientId: string): boolean {
        console.log('SlidingWindowLog');
        const now = this.getNow()
        const windowTime = this.config.seconds * 1000
        if (!this.window.get(clientId)) {
            this.window.set(clientId, [])
        }
        const entry = this.window.get(clientId)!
        while (entry.length > 0 && (now - entry[0]) >= windowTime) {
            entry.shift()
        }

        if (entry.length < this.config.count) {
            entry.push(now)
            return true
        }
        return false
    }
}

export class TokenBucket extends RateLimittingStrategy {
    private config: ConfigType;
    private bucketMap: Map<string, BucketType>

    constructor(config: ConfigType) {
        super()
        this.config = config
        this.bucketMap = new Map<string, BucketType>()
    }

    public canAccess(clientId: string): boolean {
        console.log('TokenBucket');
        const now = this.getNow()
        const capacity = this.config.count
        const refillInterval = (this.config.seconds * 1000) / capacity

        let tokens = this.bucketMap.get(clientId)?.tokens ?? capacity
        let lastRefill = this.bucketMap.get(clientId)?.lastRefill ?? now
        const elapsed = now - lastRefill
        const tokensToAdd = Math.floor(elapsed / refillInterval)

        if (tokensToAdd > 0) {
            tokens = Math.min(capacity, tokens + tokensToAdd)
            lastRefill += tokensToAdd * refillInterval // this is the lastRefill time for this token, it should not be the request time.
        }

        let curBucket: BucketType = { lastRefill, tokens: tokens }

        if (tokens > 0) {
            curBucket = { lastRefill, tokens: curBucket.tokens - 1 }
            this.bucketMap.set(clientId, curBucket)
            return true
        }
        this.bucketMap.set(clientId, curBucket)
        return false
    }
}

export class LeakyBucket extends RateLimittingStrategy {
    private config: ConfigType;
    private bucketMap: Map<string, LeakBucketType>

    constructor(config: ConfigType) {
        super()
        this.config = config
        this.bucketMap = new Map<string, LeakBucketType>()
    }

    canAccess(clientId: string): boolean {
        console.log('LeakyBucket');
        const leakRate = this.config.seconds / this.config.count
        const now = this.getNow()
        if (!this.bucketMap.has(clientId)) {
            this.bucketMap.set(clientId, { lastRefill: now, level: 0 })
        }
        const bucket = this.bucketMap.get(clientId)!
        const elapsedTime = now - bucket.lastRefill
        const leakedRequest = Math.floor((elapsedTime * leakRate) / 1000)
        if (leakedRequest > 0) {
            bucket.level = Math.max(0, bucket.level - leakedRequest)
            bucket.lastRefill += leakedRequest * (1000 / leakRate) // this is the lastRefill time for this token, it should not be the request time.
        }

        if (bucket.level < this.config.count) {
            bucket.level += 1
            return true
        }
        return false
    }
}

export class SlidingWindowCounter extends RateLimittingStrategy {
    private config: ConfigType;
    private bucketMap: Map<string, SlidingWindowCounterType>

    constructor(config: ConfigType) {
        super()
        this.config = config
        this.bucketMap = new Map<string, SlidingWindowCounterType>()
    }

    canAccess(clientId: string): boolean {
        console.log('SlidingWindowCounter');
        const now = this.getNow()
        const windowTime = this.config.seconds * 1000
        if (!this.bucketMap.has(clientId)) {
            this.bucketMap.set(clientId, { previousWindowRequest: 0, currentWindowStartTime: now, currentWindowRequest: 0 })
        }
        const bucket = this.bucketMap.get(clientId)!

        const currentWindowStart = Math.floor(now / windowTime) * windowTime
        const windowDiff = (currentWindowStart - bucket.currentWindowStartTime) / windowTime

        if (windowDiff >= 2) {
            bucket.previousWindowRequest = 0
            bucket.currentWindowStartTime = currentWindowStart
            bucket.currentWindowRequest = 0
        } else if (windowDiff === 1) {
            bucket.previousWindowRequest = bucket.currentWindowRequest
            bucket.currentWindowStartTime = currentWindowStart
            bucket.currentWindowRequest = 0
        }
        const elapsedTime = now - bucket.currentWindowStartTime
        const percent = elapsedTime / windowTime

        const weight = ((1 - percent) * bucket.previousWindowRequest) + bucket.currentWindowRequest
        if ((weight + 1) <= this.config.count) {
            bucket.currentWindowRequest++
            return true
        }
        return false;
    }
}