import { FixedWindow, SlidingWindowLog, TokenBucket } from "../strategy/RateLimitter.strategy";
import { RateLimitConfig, UserTier } from "../utils/RateLimitter.utils";
import { Resolver, TierResolver } from "./TierResolver.service";

export class RateLimitter {
    private strategyByTier = {
        [UserTier.FREE]: new FixedWindow(RateLimitConfig.FREE),
        [UserTier.PREMIUM]: new SlidingWindowLog(RateLimitConfig.PREMIUM),
        [UserTier.ENTERPRISE]: new TokenBucket(RateLimitConfig.ENTERPRISE),
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