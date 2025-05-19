import { GateType } from "../../helper/enums";
import { DEFAULT_OPERATOR, Operator } from "./Operator";

export class Gate {
  id: number;
  gateType: GateType;
  operator: Operator;

  constructor(id: number, gateType: GateType, operator: Operator) {
    this.id = id;
    this.gateType = gateType;
    this.operator = operator;
  }
}

export const DEFAULT_ENTRY_GATE = new Gate(0, GateType.ENTRY, DEFAULT_OPERATOR);
