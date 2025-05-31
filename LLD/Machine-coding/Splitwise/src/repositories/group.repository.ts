import { Expense } from "../models/Expense";
import { Group } from "../models/Group";

export class GroupRepository {
    private groups: Map<string, Group>;

    constructor() {
        this.groups = new Map<string, Group>();
    }

    addGroup(groupName: string, group: Group) {
        this.groups.set(groupName, group);
    }

    removeGroup(groupName: string) {
        this.groups.delete(groupName);
    }

    getGroup(groupName: string): Group | undefined {
        return this.groups.get(groupName);
    }

    getAllGroups(): Map<string, Group> {
        return this.groups;
    }

    findExpensesByGroupName(groupName: string): Expense[] | undefined {
        return this.getGroup(groupName)?.getExpenses()
    }
}