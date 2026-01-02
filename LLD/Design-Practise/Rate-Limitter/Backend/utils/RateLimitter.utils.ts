export const UserTier = {
    FREE: "Free",
    PREMIUM: "Premium",
    ENTERPRISE: "Enterprise",
} as const;

export type UserTier = (typeof UserTier)[keyof typeof UserTier];


export const RateLimitConfig = {
  FREE: { count: 5, seconds: 5 },
  PREMIUM: { count: 8, seconds: 5 },
  ENTERPRISE: { count: 10, seconds: 5 },
} as const