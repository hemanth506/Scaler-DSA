import { UserController } from "../controllers/user.controller";
import { User } from "../models/User";
import { Command } from "./Command";

export class SettleUpUserCommand implements Command {
    private SettleUp: string = "SettleUp"
    private userController: UserController
    private user: User[]

    constructor(userController: UserController, user: User[]) {
        this.userController = userController
        this.user = user
    }
    matches(input: string): boolean {
        const splitInput = input.split(" ");
        return splitInput[1] === this.SettleUp && splitInput.length === 2
    }
    execute(input: string): void {
        const splitInput = input.split(" ");
        let currentUser;
        for (let user of this.user) {
            if (user.getName() === splitInput[0]) {
                currentUser = user
            }
        }
        if (currentUser) {
            this.userController.settleUpUser(currentUser, splitInput[1])
        }
    }
}