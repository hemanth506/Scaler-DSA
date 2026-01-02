import { UserTier } from "../utils/RateLimitter.utils";

export interface Resolver {
    normalize(tier: string | UserTier): UserTier | undefined
}

export class TierResolver implements Resolver{
    public normalize(tier: string | UserTier): UserTier | undefined {
        const t = String(tier || '').toLowerCase()
        switch (t) {
            case 'free':
                return UserTier.FREE
            case 'premium':
                return UserTier.PREMIUM
            case 'enterprise':
                return UserTier.ENTERPRISE
            default:
                return undefined
        }
    }
}