import { Transaction } from "../dtos/Transaction";
import { User } from "../models/User";
import { UserService } from "../services/user.service";

export class UserController {
    private userService: UserService;

    constructor(userService: UserService) {
        this.userService = userService;
    }

    public settleUpUser(user: User, groupName: string): Transaction[] {
        return this.userService.settleUpUser(user, groupName);
    }

    public addMember(groupName: string, memberName: string): void {
        this.userService.addMember(groupName, memberName)
    }
}