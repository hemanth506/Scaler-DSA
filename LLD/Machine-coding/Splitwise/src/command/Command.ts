export interface Command {
    matches(input: string): boolean
    execute(input: string): void 
}

