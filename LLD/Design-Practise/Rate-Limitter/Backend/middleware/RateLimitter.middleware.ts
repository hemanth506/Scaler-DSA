import { Request, Response, NextFunction } from "express"
import { RateLimitter } from "../service/RateLimitter.service"
import { TierResolver } from "../service/TierResolver.service"

const rateLimmitterService = new RateLimitter(new TierResolver())

export function rateLimitterMiddleware(req: Request, res: Response, next: NextFunction) {
    const userTier = req.body.tier
    const userId = req.body.userId

    const allowAccess = rateLimmitterService.allowRequest(userId, userTier)
    if (!allowAccess) {
        return res.status(429).json({
            message: "Too many requests",
        });
    }
    next()
}