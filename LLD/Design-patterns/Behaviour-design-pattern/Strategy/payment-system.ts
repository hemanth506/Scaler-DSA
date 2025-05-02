abstract class PaymentStrategy {
  protected abstract transactionFee: number;
  protected abstract totalAmount?: number;
  public abstract pay(amount: number): void;
  protected abstract authenticate(token: number): boolean;
}

class CreditCardPayment extends PaymentStrategy {
  transactionFee: number = 1.75;
  totalAmount?: number;
  protected authenticate(token: number): boolean {
    return token % 2 === 0;
  }
  pay(amount: number): void {
    this.totalAmount = amount + this.transactionFee;
    console.log(
      `🚀 ~ Credit card payment paid Rs.${this.totalAmount} which includes Rs.${this.transactionFee} transaction charges`
    );
  }
}

class PayPalPayment extends PaymentStrategy {
  transactionFee: number = 0.95;
  totalAmount?: number;
  protected authenticate(token: number): boolean {
    return token % 5 === 0;
  }
  pay(amount: number): void {
    this.totalAmount = amount + this.transactionFee;
    console.log(
      `🚀 ~ Paypal payment paid Rs.${this.totalAmount} which includes Rs.${this.transactionFee} transaction charges`
    );
  }
}

class CryptoWalletPayment extends PaymentStrategy {
  transactionFee: number = 2.15;
  totalAmount?: number;
  protected authenticate(token: number): boolean {
    return token % 3 === 0;
  }
  pay(amount: number): void {
    this.totalAmount = amount + this.transactionFee;
    console.log(
      `🚀 ~ Crypto wallet paid Rs.${this.totalAmount} which includes Rs.${this.transactionFee} transaction charges`
    );
  }
}

class FactoryPaymentMode {
  static cc = new CreditCardPayment();
  static pp = new PayPalPayment();
  static cw = new CryptoWalletPayment();
  static getClass(mode: string): PaymentStrategy {
    switch (mode) {
      case "CreditCard":
        return this.cc;
      case "PayPal":
        return this.pp;
      case "Crypto":
      default:
        return this.cw;
    }
  }
}

class PaymentContext {
  private strategy: PaymentStrategy;

  constructor(strategy: PaymentStrategy) {
    this.strategy = strategy;
  }

  public setStrategy(strategy: PaymentStrategy): void {
    this.strategy = strategy;
  }

  public pay(amount: number): void {
    this.strategy.pay(amount);
  }
}

const strategy: PaymentStrategy = FactoryPaymentMode.getClass("PayPal");
const context = new PaymentContext(strategy);
context.pay(30);

context.setStrategy(new CreditCardPayment());
context.pay(50)


