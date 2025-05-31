import { GroupController } from "../controllers/group.controller";
import { Command } from "./Command";

export class AddGroupCommand implements Command {
    private AddGroup: string = "AddGroup"
    private groupController: GroupController

    constructor(groupController: GroupController) {
        this.groupController = groupController
    }
    matches(input: string): boolean {
        const splitInput = input.split(" ");
        return splitInput[1] === this.AddGroup && splitInput.length === 3
    }
    execute(input: string): void {
        const splitInput = input.split(" ");
        this.groupController.addGroup(splitInput[2])
    }
}