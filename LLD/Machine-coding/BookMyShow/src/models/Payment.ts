import {
  PaymentMode,
  PaymentStatus,
  PaymentGateWayProviders,
} from "../../helper/enums";
import { GlobalClass } from "./GlobalClass";

export class Payment extends GlobalClass {
  _refNo: number;
  _status: PaymentStatus;
  _amount: number;
  _paymentGateWayProvider: PaymentGateWayProviders[];
  _paymentMode: PaymentMode;

  constructor(
    id: string,
    refNo: number,
    status: PaymentStatus,
    amount: number,
    paymentGateWayProvider: PaymentGateWayProviders[],
    paymentMode: PaymentMode
  ) {
    super(id);
    this._refNo = refNo;
    this._status = status;
    this._amount = amount;
    this._paymentGateWayProvider = paymentGateWayProvider;
    this._paymentMode = paymentMode;
  }
}
