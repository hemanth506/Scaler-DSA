export enum Feature {
  THREE_DIMENSION,
  TWO_DIMENSION,
  DOLBY_ATMOS,
}

export enum SeatStatus {
  BOOKED,
  AVAILABLE, LOCKED
}

export enum BookingStatus {
  CANCELLED,
  BOOKED,
  INPROGRESS,
}

export enum PaymentStatus {
  SUCCESS,
  FAILURE,
  WAITING,
}

export enum PaymentGateWayProviders {
  GOOGLE_PAY,
  PHONE_PAY,
  APPLE_PAY,
}

export enum PaymentMode {
  UPI,
  NET_BANKING,
  CARD,
}
