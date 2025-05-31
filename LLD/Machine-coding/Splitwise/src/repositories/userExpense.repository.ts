import { UserExpenseType } from "../../helper/enums";
import { Expense } from "../models/Expense";
import { User } from "../models/User";
import { UserExpense } from "../models/UserExpense";

export class UserExpenseRepository {
    private userExpenses: UserExpense[];

    constructor() {
        this.userExpenses = [];
    }

    addUserExpense(user: User, expense: Expense, amount: number, userExpenseType: UserExpenseType) {
        const userExpense = new UserExpense(user, expense, amount, userExpenseType);
        this.userExpenses.push(userExpense);
    }

    getUserExpenses(): UserExpense[] {
        return this.userExpenses;
    }

    setUserExpense(userExpense: UserExpense[]) {
        this.userExpenses = userExpense;
    }

    findUserExpenseByExpenseId(expenseId: string): UserExpense[] {
        return this.userExpenses.filter(userExpense => userExpense.getExpense().getId() === expenseId);
    }
}