import { User } from "../models/User";

export class UserRepository {
    private users: User[];

    constructor() {
        this.users = [];
    }

    addUser(user: User) {
        this.users.push(user);
    }



    removeUser(user: User) {
        const index = this.users.indexOf(user);
        if (index > -1) {
            this.users.splice(index, 1);
        }
    }

    getUsers() {
        return this.users;
    }

    setUsers(users: User[]) {
        this.users = users
    }
}