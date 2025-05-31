import { Expense } from "../models/Expense";

export class ExpenseRepository {
    private expenses: Expense[];
    
    constructor() {
        this.expenses = [];
    }

    addExpense(expense: Expense) {
        this.expenses.push(expense);
    }

    removeExpense(expense: Expense) {
        const index = this.expenses.indexOf(expense);
        if (index > -1) {
            this.expenses.splice(index, 1);
        }
    }

    getExpenses() {
        return this.expenses;
    }
}