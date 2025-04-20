enum directionEnum {
  Left,
  Right,
}

enum indicatorSideEnum {
  up,
  down,
}

class VehicleClass {
  engineType?: string;
  engineNumber?: string;
  indicators?: indicatorSideEnum;
  exhaustCount?: number;
  airPurifier?: string;
  mudGuardCount?: number;
  breakType?: string;
  noOfWheels?: number;

  constructor(obj: VehicleClass) {
    this.airPurifier = obj.airPurifier;
    this.engineNumber = obj.engineNumber;
    this.engineType = obj.engineType;
    this.exhaustCount = obj.exhaustCount;
    this.indicators = obj.indicators;
    this.noOfWheels = obj.noOfWheels;
    this.mudGuardCount = obj.mudGuardCount;
    this.breakType = obj.breakType;
  }
}

class TwoWheelerClass extends VehicleClass {
  standCount?: number;
  backRest?: boolean;

  constructor(obj: TwoWheelerClass) {
    super(obj);
    this.standCount = obj.standCount;
    this.backRest = obj.backRest;
  }
}

class FourWheelerClass extends VehicleClass {
  viperCount?: number;
  seatBeltCount?: number;
  steeringSide?: directionEnum;
  noOfSeats?: number;

  constructor(obj: FourWheelerClass) {
    super(obj);
    this.viperCount = obj.viperCount;
    this.seatBeltCount = obj.seatBeltCount;
    this.steeringSide = obj.steeringSide;
    this.noOfSeats = obj.noOfSeats;
  }
}

const obj = {
  engineType: "Liquid Cool",
  engineNumber: "IFPS29DU2",
  indicators: indicatorSideEnum.down,
  exhaustCount: 2,
  airPurifier: "Liquid",
  noOfWheels: 2,
  mudGuardCount: 2,
  breakType: "disc",
  standCount: 2,
  backRest: true
};

const wheel2 = new TwoWheelerClass(obj);
console.log('🚀 --------------------------------🚀')
console.log('🚀 ~ vehicle.ts ~ wheel2:', wheel2)
console.log('🚀 --------------------------------🚀')
