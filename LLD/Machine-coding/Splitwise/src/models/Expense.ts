import { ExpenseType } from "../../helper/enums"
import { Group } from "./Group"

export class Expense {
    id: string
    description: string
    amount: number
    expenseType: ExpenseType

    constructor(id: string, description: string, amount: number, expenseType: ExpenseType) {
        this.id = id
        this.description = description
        this.amount = amount
        this.expenseType = expenseType
    }
    getId() {
        return this.id
    }
    setId(id: string) {
        this.id = id
    }
    getDescription() {
        return this.description
    }
    setDescription(description: string) {
        this.description = description
    }
    getAmount() {
        return this.amount
    }
    setAmount(amount: number) {
        this.amount = amount
    }
    getExpenseType() {
        return this.expenseType
    }
    setExpenseType(expenseType: ExpenseType) {
        this.expenseType = expenseType
    }
}