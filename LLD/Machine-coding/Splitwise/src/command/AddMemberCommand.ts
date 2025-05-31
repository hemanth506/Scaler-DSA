import { UserController } from "../controllers/user.controller";
import { Command } from "./Command";

export class AddMemberCommand implements Command {
    private AddMember: string = "AddMember"
    private userController: UserController

    constructor(userController: UserController) {
        this.userController = userController
    }
    matches(input: string): boolean {
        const splitInput = input.split(" ");
        return splitInput[1] === this.AddMember && splitInput.length === 4
    }
    execute(input: string): void {
        const splitInput = input.split(" ");
        this.userController.addMember(splitInput[2], splitInput[3])
    }
}