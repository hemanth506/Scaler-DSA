import { ExpenseType, UserExpenseType } from "../../helper/enums";
import { Transaction } from "../dtos/Transaction";
import { Expense } from "../models/Expense";
import { SettleUpStrategy } from "../models/SettleUpStrategy";
import { User } from "../models/User";
import { GroupRepository } from "../repositories/group.repository";
import { UserExpenseRepository } from "../repositories/userExpense.repository";

export class UserService {
    groupRepository = new GroupRepository();
    userExpenseRepository = new UserExpenseRepository();
    settleUpStrategy: SettleUpStrategy
    constructor(groupRepo: GroupRepository, userExpRepo: UserExpenseRepository, strategy: SettleUpStrategy) {
        this.groupRepository = groupRepo;
        this.userExpenseRepository = userExpRepo;
        this.settleUpStrategy = strategy;
    }

    public settleUpUser(userToSettle: User, groupName: string): Transaction[] {
        /*
        1, get the group by groupName
        2, get the all expenses in the group
        3, filter only regular expenses
        4, get the expenses of the user in the list of expenses
        5, calculate the total amount owed by the user
        6, calculate the total amount owed to the user
        7, create transactions to settle the debts
        8, return the transactions
        */
        
        const expenses: Expense[] | undefined = this.groupRepository.findExpensesByGroupName(groupName) // Eg: Dinner, tickets etc
        const extraAmounts: Map<User, number> = new Map<User, number>();

        for (const expense of expenses || []) {
            if (expense.expenseType !== ExpenseType.REGULAR) {
                continue;
            }
            const userExpenses = this.userExpenseRepository.findUserExpenseByExpenseId(expense.getId()); // Details of userExpense for that expense Eg: A => 500, B => 500

            for(const userExpense of userExpenses) {
                const user = userExpense.getUser();
                if(!extraAmounts.has(user)) {
                    extraAmounts.set(user, 0);
                }

                let amount = extraAmounts.get(user) || 0;
                if(userExpense.getUserExpenseType() === UserExpenseType.PAID_BY) {
                    amount = amount + userExpense.getAmount()
                } else {
                    amount = amount - userExpense.getAmount()
                }
                extraAmounts.set(user, amount);
            }
        }

        // find the transaction using extra amount;
        const groupTransactions = this.settleUpStrategy?.settleUpUsers(extraAmounts);

        const userTransactions: Transaction[] = []
        for(let transaction of groupTransactions || []) {
            if (transaction.getFrom() === userToSettle || transaction.getTo() === userToSettle) {
                userTransactions.push(transaction)
            }
        }

        return userTransactions;
    }

    public addMember(groupName: string, memberName: string) {
        const newUser = new User(memberName, "", "");
        const group = this.groupRepository.getGroup(groupName);
        group?.addMember(newUser);
    }
}