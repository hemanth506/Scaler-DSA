export const UserTier = {
    FREE: "Free",
    PREMIUM: "Premium",
    PREMIUMPLUS: "PremiumPlus",
    ENTERPRISE: "Enterprise",
    ENTERPRISEPLUS: "EnterprisePlus"
} as const;

export type UserTier = (typeof UserTier)[keyof typeof UserTier];


export const RateLimitConfig = {
  FREE: { count: 3, seconds: 5 },
  PREMIUM: { count: 5, seconds: 5 },
  PREMIUMPLUS: { count: 8, seconds: 5 },
  ENTERPRISE: { count: 10, seconds: 5 },
  ENTERPRISEPLUS: { count: 12, seconds: 5 },
} as const