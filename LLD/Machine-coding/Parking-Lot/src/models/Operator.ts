import { v4 as uuidv4 } from "uuid"

export class Operator {
    id: string
    name: string

    constructor(name: string) {
        this.id = uuidv4()
        this.name = name
    }
}

export const DEFAULT_OPERATOR = new Operator('Siva - Manager');