import { Transaction } from "../dtos/Transaction";
import { GroupService } from "../services/group.service";

export class GroupController {
    private groupService: GroupService;

    constructor(groupService: GroupService) {
        this.groupService = groupService;
    }

    public settleUp(groupName: string): Transaction[] {
        return this.groupService.settleUp(groupName);
    }

    public addGroup(groupName: string) {
        this.groupService.addGroup(groupName)
    }
}