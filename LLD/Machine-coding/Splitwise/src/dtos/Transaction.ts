import { User } from "../models/User";

export class Transaction {
    private from: User;
    private to: User;
    private amount: number;

    constructor(from: User, to: User, amount: number) {
        this.from = from;
        this.to = to;
        this.amount = amount;
    }
    getFrom(): User {
        return this.from;
    }
    setFrom(from: User): void {
        this.from = from;
    }
    getTo(): User {
        return this.to;
    }
    setTo(to: User): void {
        this.to = to;
    }
    getAmount(): number {
        return this.amount;
    }
    setAmount(amount: number): void {
        this.amount = amount;
    }
}