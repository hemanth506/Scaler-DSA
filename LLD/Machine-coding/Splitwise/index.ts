import { ExpenseType, UserExpenseType } from "./helper/enums";
import { UserController } from "./src/controllers/user.controller";
import { Expense } from "./src/models/Expense";
import { Group } from "./src/models/Group";
import { HeapSettleUp, SettleUpStrategy } from "./src/models/SettleUpStrategy"
import { User } from "./src/models/User";
import { UserExpense } from "./src/models/UserExpense";
import { ExpenseRepository } from "./src/repositories/expense.repository";
import { GroupRepository } from "./src/repositories/group.repository";
import { UserRepository } from "./src/repositories/user.repository";
import { UserExpenseRepository } from "./src/repositories/userExpense.repository";
import { UserService } from "./src/services/user.service";

export class Init {

    private settleUpStrategy?: SettleUpStrategy

    setSettleUpStrategy(strategy: SettleUpStrategy) {
        this.settleUpStrategy = strategy
    }

    testStrategy() {
        const heapSettleUp = new HeapSettleUp()
        const users: Map<string, number> = new Map();

        users.set("hemanth", 100);
        users.set("prak", -50);
        users.set("ravi", -50);



        // users.set("hemanth", 300);
        // users.set("prak", 200);
        // users.set("ravi", 50);

        // users.set("ruchi", -500);
        // users.set("ruchika", -50);

        heapSettleUp.settleUps(users)
    }

    execute() {
        // create users
        const hemanth = new User("Hemanth", "9962644103", "hemanth")
        const ruchika = new User("Ruchika", "9025473907", "ruchika")
        const harish = new User("Harish", "91711459117", "harish")
        const latha = new User("Latha", "8939184787", "latha")

        const goaGuys: User[] = [hemanth, ruchika, harish, latha]

        // create group and add members
        const goaTrip = new Group("GOA-TRIP")
        goaTrip.setMembers(goaGuys)

        // Go for Dinner (Expense)
        const dinnerExpense = new Expense("exp-1", "Dinner", 5000, ExpenseType.REGULAR);

        // expenses per member
        const hemanthShare = new UserExpense(hemanth, dinnerExpense, 2000, UserExpenseType.HAD_TO_PAY);
        const ruchikaShare = new UserExpense(ruchika, dinnerExpense, 1000, UserExpenseType.HAD_TO_PAY);
        const harishShare = new UserExpense(harish, dinnerExpense, 1000, UserExpenseType.HAD_TO_PAY);
        const lathaShare = new UserExpense(latha, dinnerExpense, 1000, UserExpenseType.HAD_TO_PAY);

        // expense paid by
        const paidByHemanth = new UserExpense(hemanth, dinnerExpense, 1000, UserExpenseType.PAID_BY);
        const paidByRuchika = new UserExpense(ruchika, dinnerExpense, 4000, UserExpenseType.PAID_BY);


        // add expenses to the group
        goaTrip.addExpense(dinnerExpense)

        // add all details to repo.
        const userRepo = new UserRepository();
        const userExpenseRepo = new UserExpenseRepository()
        const groupRepo = new GroupRepository()
        const expenseRepo = new ExpenseRepository()

        userRepo.setUsers(goaGuys);
        userExpenseRepo.setUserExpense([hemanthShare, ruchikaShare, harishShare, lathaShare, paidByHemanth, paidByRuchika])
        groupRepo.addGroup(goaTrip.getName(), goaTrip)
        expenseRepo.addExpense(dinnerExpense)

        const userController = new UserController(new UserService(groupRepo, userExpenseRepo, this.settleUpStrategy || new HeapSettleUp()));
        
        // all hemanth's transactions
        const hemanthTransactions = userController.settleUpUser(hemanth, goaTrip.getName());
        console.log("🚀 ~ Transactions to settle for user:", hemanth.getName());
        for (const transaction of hemanthTransactions) {
            console.log(`${transaction.getFrom().getName()} pays ${transaction.getTo().getName()} an amount of ${transaction.getAmount()}`);
        }

        // all ruchika's transactions
        const ruchikaTransactions = userController.settleUpUser(ruchika, goaTrip.getName());
        console.log("🚀 ~ Transactions to settle for user:", ruchika.getName());
        for (const transaction of ruchikaTransactions) {
            console.log(`${transaction.getFrom().getName()} pays ${transaction.getTo().getName()} an amount of ${transaction.getAmount()}`);
        }
    }
}

const init = new Init();
init.setSettleUpStrategy(new HeapSettleUp())
init.execute()