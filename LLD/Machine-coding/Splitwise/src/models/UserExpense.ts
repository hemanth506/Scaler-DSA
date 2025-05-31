import { UserExpenseType } from "../../helper/enums";
import { Expense } from "./Expense";
import { User } from "./User";

export class UserExpense {
    user: User
    expense: Expense
    amount: number
    userExpenseType: UserExpenseType

    constructor(user: User, expense: Expense, amount: number, userExpenseType: UserExpenseType) {
        this.user = user;
        this.expense = expense;
        this.amount = amount;
        this.userExpenseType = userExpenseType;
    }

    getUser() {
        return this.user;
    }

    setUser(user: User) {
        this.user = user;
    }
    getExpense() {
        return this.expense;
    }
    setExpense(expense: Expense) {
        this.expense = expense;
    }
    getAmount() {
        return this.amount;
    }
    setAmount(amount: number) {
        this.amount = amount;
    }
    getUserExpenseType() {
        return this.userExpenseType;
    }
    setUserExpenseType(userExpenseType: UserExpenseType) {  
        this.userExpenseType = userExpenseType;
    }
}