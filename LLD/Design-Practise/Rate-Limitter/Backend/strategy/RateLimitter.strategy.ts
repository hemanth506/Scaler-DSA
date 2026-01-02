type ConfigDetails = { count: number; seconds: number }

interface RateLimittingStrategy {
    canAccess(clientId: string): boolean
}

export class FixedWindow implements RateLimittingStrategy {
    private window: Map<string, { startTime: number, count: number }>
    private config: ConfigDetails;

    constructor(config: ConfigDetails) {
        this.config = config
        this.window = new Map<string, { startTime: number, count: number }>()
    }

    public canAccess(clientId: string): boolean {
        const now = Date.now()
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

export class SlidingWindowLog implements RateLimittingStrategy {
    private window: Map<string, number[]>
    private config: ConfigDetails;

    constructor(config: ConfigDetails) {
        this.config = config
        this.window = new Map<string, number[]>()
    }
    public canAccess(clientId: string): boolean {
        const now = Date.now()
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

export class TokenBucket implements RateLimittingStrategy {
    lastRefillMap: Map<string, number>
    tokenMap: Map<string, number>
    private config: ConfigDetails;

    constructor(config: ConfigDetails) {
        this.config = config
        this.lastRefillMap = new Map<string, number>()
        this.tokenMap = new Map<string, number>()
    }

    public canAccess(clientId: string): boolean {
        const now = Date.now()
        const capacity = this.config.count
        const refillInterval = (this.config.seconds * 1000) / capacity

        let tokens = this.tokenMap.get(clientId) ?? capacity
        let lastRefill = this.lastRefillMap.get(clientId) ?? now
        const elapsed = now - lastRefill
        const tokensToAdd = Math.floor(elapsed / refillInterval)
        
        if (tokensToAdd > 0) {
            tokens = Math.min(capacity, tokens + tokensToAdd)
            lastRefill += tokensToAdd * refillInterval // this is the lastRefill time for this token, it should not be the request time.
        }
        
        if (tokens > 0) {
            this.tokenMap.set(clientId, tokens - 1)
            this.lastRefillMap.set(clientId, lastRefill)
            return true
        }
        this.tokenMap.set(clientId, tokens)
        this.lastRefillMap.set(clientId, lastRefill)
        return false
    }

}

