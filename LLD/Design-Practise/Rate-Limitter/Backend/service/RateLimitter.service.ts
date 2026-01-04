import { FixedWindow, LeakyBucket, SlidingWindowCounter, SlidingWindowLog, TokenBucket } from "../strategy/RateLimitter.strategy.ts";
import { RateLimitConfig, UserTier } from "../utils/RateLimitter.utils.ts";
import { Resolver } from "./TierResolver.service.ts";

export class RateLimitter {
    private strategyByTier = {
        [UserTier.FREE]: new FixedWindow(RateLimitConfig.FREE),
        [UserTier.PREMIUM]: new SlidingWindowLog(RateLimitConfig.PREMIUM),
        [UserTier.PREMIUMPLUS]: new LeakyBucket(RateLimitConfig.PREMIUMPLUS),
        [UserTier.ENTERPRISE]: new TokenBucket(RateLimitConfig.ENTERPRISE),
        [UserTier.ENTERPRISEPLUS]: new SlidingWindowCounter(RateLimitConfig.ENTERPRISEPLUS),

    }
    private tierResolver: Resolver;
    constructor(tierResolver: Resolver) {
        this.tierResolver = tierResolver
    }

    public allowRequest(clientId: string, tier: string | UserTier): boolean {
        const normalized = this.tierResolver.normalize(tier)
        if (!normalized) {
            console.warn('Unknown tier provided to RateLimitter:', tier)
            return false
        }

        const strategy = this.getStrategyByClientTier(normalized)
        if (!strategy) {
            console.warn('No strategy found for tier:', normalized)
            return false
        }

        return strategy.canAccess(clientId)
    }

    private getStrategyByClientTier(tier: UserTier) {
        return this.strategyByTier[tier]
    }
}