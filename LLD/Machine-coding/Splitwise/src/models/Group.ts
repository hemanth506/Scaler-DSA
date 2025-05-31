import { Expense } from "./Expense";
import { User } from "./User";

export class Group {
    name: string;
    members: User[]
    expenses: Expense[]

    constructor(name: string) {
        this.name = name;
        this.members = [];
        this.expenses = [];
    }

    getName() {
        return this.name;
    }
    setName(name: string) {
        this.name = name;
    }
    getMembers() {
        return this.members;
    }
    setMembers(members: User[]) {
        this.members = members
    }

    addMember(user: User) {
        if (!this.members.includes(user)) {
            this.members.push(user);
        }
    }
    removeMember(user: User) {
        const index = this.members.indexOf(user);
        if (index > -1) {
            this.members.splice(index, 1);
        }
    }
    getExpenses() {
        return this.expenses;
    }
    
    addExpense(expense: Expense) {
        if (!this.expenses.includes(expense)) {
            this.expenses.push(expense);
        }
    }
    removeExpense(expense: Expense) {
        const index = this.expenses.indexOf(expense);
        if (index > -1) {
            this.expenses.splice(index, 1);
        }
    }
}