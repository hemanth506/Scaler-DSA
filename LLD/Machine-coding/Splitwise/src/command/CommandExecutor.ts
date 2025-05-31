import { Command } from "./Command";

export class CommandExecutor {
    commands: Command[] = []
    public addCommand(command: Command): void {
        this.commands.push(command);
    }

    public removeCommand(command: Command) {
        const index = this.commands.indexOf(command);
        if (index !== -1) {
            this.commands.splice(index, 1);
        }
    }

    public execute(input: string) {
        for (let command of this.commands) {
            if (command.matches(input)) {
                command.execute(input);
                break;
            }
        }
    }
}