class PayPalSDK {
  constructor(private userEmail: string) {}

  makePayment(amountInDollars: number): void {
    console.log(
      `PayPal payment of $${amountInDollars} successful for ${this.userEmail}`
    );
  }

  refundPayment(amountInDollars: number): void {
    console.log(`Refund of $${amountInDollars} initiated to ${this.userEmail}`);
  }
}

class StripeSDK {
  constructor(private userToken: string) {}

  processPaymentInCents(amountInCents: number): void {
    console.log(
      `Stripe payment of $${amountInCents / 100} successful for token: ${
        this.userToken
      }`
    );
  }

  refundInCents(amountInCents: number): void {
    console.log(
      `Stripe refund of $${amountInCents / 100} initiated for token: ${
        this.userToken
      }`
    );
  }
}

interface PaymentProcessor {
  pay(amount: number): void;
  refund(amount: number): void;
}

class PayPalAdaptor implements PaymentProcessor {
  private paypalSdk?: PayPalSDK;
  constructor(userEmail: string) {
    this.paypalSdk = new PayPalSDK(userEmail);
  }
  pay(amount: number): void {
    this.paypalSdk?.makePayment(amount);
  }
  refund(amount: number): void {
    this.paypalSdk?.refundPayment(amount);
  }
}

class StripeAdaptor implements PaymentProcessor {
  private stripeSdk?: StripeSDK;
  constructor(userToken: string) {
    this.stripeSdk = new StripeSDK(userToken);
  }
  pay(amount: number): void {
    this.stripeSdk?.processPaymentInCents(amount * 100);
  }
  refund(amount: number): void {
    this.stripeSdk?.refundInCents(amount * 100);
  }
}



const pAdaptor: PaymentProcessor = new PayPalAdaptor("hemanthraaj@gmail.com")
pAdaptor.pay(415)
pAdaptor.refund(109)

const sAdaptor: PaymentProcessor = new StripeAdaptor("lokjlkjnljkcsi")
sAdaptor.pay(103)
sAdaptor.refund(55)
