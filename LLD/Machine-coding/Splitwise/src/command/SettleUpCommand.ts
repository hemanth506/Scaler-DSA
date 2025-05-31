import { GroupController } from "../controllers/group.controller";
import { Command } from "./Command";

export class SettleUpCommand implements Command {
    private SettleUp: string = "SettleUp"
    private groupController: GroupController

    constructor(groupController: GroupController) {
        this.groupController = groupController
    }
    matches(input: string): boolean {
        const splitInput = input.split(" ");
        return splitInput[1] === this.SettleUp && splitInput.length === 3
    }
    execute(input: string): void {
        const splitInput = input.split(" ");
        this.groupController.settleUp(splitInput[2])
    }
}