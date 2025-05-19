import { GateType } from "../../helper/enums"

export class Gate {
    id: number
    gateType: GateType
    operatorName: string

    constructor(id: number, gateType: GateType, operatorName: string) {
        this.id = id
        this.gateType = gateType
        this.operatorName = operatorName
    }

    // todo need to add this gate data in ticket, which might need for billing.
}