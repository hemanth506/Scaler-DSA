interface VehicleIfc<T> {
  clone(): T;
}

class Vehicle implements VehicleIfc<Vehicle> {
  private engineType?: string;
  private exhaustCount?: number;
  private breakType?: string;
  private brand?: string;
  private version?: string;
  private madeIn?: string;

  constructor(obj?: Vehicle) {
    this.breakType = obj?.breakType;
    this.engineType = obj?.engineType;
    this.exhaustCount = obj?.exhaustCount;
  }

  public clone(): this {
    return new Vehicle(this) as this;
  }

  setEngineType(engineType: string) {
    this.engineType = engineType;
  }

  setExhaustCount(exhaustCount: number) {
    this.exhaustCount = exhaustCount;
  }

  setBreakType(breakType: string) {
    this.breakType = breakType;
  }

  setBrand(brand: string) {
    this.brand = brand;
  }

  setVersion(version: string) {
    this.version = version;
  }

  setMadeIn(madeIn: string) {
    this.madeIn = madeIn;
  }

  getEngineType() {
    return this.engineType;
  }

  getExhaustCount() {
    return this.exhaustCount;
  }

  getBreakType() {
    return this.breakType;
  }

  getBrand() {
    return this.brand;
  }

  getVersion() {
    return this.version;
  }

  getMadeIn() {
    return this.madeIn;
  }
}

class LCTwoWheeler extends Vehicle implements VehicleIfc<LCTwoWheeler> {
  private standCount?: number;
  private backRest?: boolean;
  private noOfWheels?: number;
  private vehicleType?: string;

  constructor(obj?: LCTwoWheeler) {
    super(obj);
    this.backRest = obj?.backRest;
    this.standCount = obj?.standCount;
    this.noOfWheels = obj?.noOfWheels;
  }

  public clone(): this {
    return new LCTwoWheeler(this) as this;
  }

  setNoOfWheels(noOfWheels: number) {
    this.noOfWheels = noOfWheels;
  }

  setBackRest(backRest: boolean) {
    this.backRest = backRest;
  }

  setStandCount(standCount: number) {
    this.standCount = standCount;
  }

  getNoOfWheels(): number | undefined {
    return this.noOfWheels;
  }

  getBackRest(): boolean | undefined {
    return this.backRest;
  }

  getStandCount(): number | undefined {
    return this.standCount;
  }

  setVehicleType(vehicleType: string) {
    this.vehicleType = vehicleType;
  }

  getVehicleType(): string | undefined {
    return this.vehicleType;
  }
}

class LCFourWheeler extends Vehicle implements VehicleIfc<LCFourWheeler> {
  private seatBeltCount?: number;
  private noOfSeats?: number;
  private noOfWheels?: number;

  constructor(obj?: LCFourWheeler) {
    super(obj);
    this.seatBeltCount = obj?.seatBeltCount;
    this.noOfSeats = obj?.noOfSeats;
    this.noOfWheels = obj?.noOfWheels;
  }

  public clone(): this {
    return new LCFourWheeler(this) as this;
  }

  setSeatBeltCount(seatBeltCount: number) {
    this.seatBeltCount = seatBeltCount;
  }

  setNoOfSeats(noOfSeats: number) {
    this.noOfSeats = noOfSeats;
  }

  setNoOfWheels(noOfWheels: number) {
    this.noOfWheels = noOfWheels;
  }

  getNoOfWheels(): number | undefined {
    return this.noOfWheels;
  }

  getSeatBeltCount(): number | undefined {
    return this.seatBeltCount;
  }

  getNoOfSeats(): number | undefined {
    return this.noOfSeats;
  }
}

abstract class RegistryTemplate<T> {
  abstract register(key: string, className: T): void;
  abstract get(key: string): T | undefined;
}

// Since we used the parent class as generics, all the child class will accept that.
class Registry<Vehicle> implements RegistryTemplate<Vehicle> {
  private registryName?: string;
  private registryMap?: Map<string, Vehicle>;
  constructor(registryName: string) {
    this.registryName = registryName;
    this.registryMap = new Map<string, Vehicle>();
  }
  register(key: string, className: Vehicle): void {
    this.registryMap?.set(key, className);
  }
  get(key: string): Vehicle | undefined {
    return this.registryMap?.get(key);
  }
  fillRegistryName(): string | undefined {
    return this.registryName;
  }
}

const fillRegistry = () => {
  const vehiclePrototype = new Vehicle();
  vehiclePrototype.setEngineType("Liquid Cool");
  vehiclePrototype.setBreakType("Liquid");
  vehiclePrototype.setExhaustCount(1);

  const lcWheel2Prototype = new LCTwoWheeler();
  lcWheel2Prototype.setEngineType("Liquid Cool");
  lcWheel2Prototype.setBreakType("Liquid");
  lcWheel2Prototype.setExhaustCount(1);
  lcWheel2Prototype.setBackRest(true);
  lcWheel2Prototype.setNoOfWheels(2);
  lcWheel2Prototype.setStandCount(2);

  const lcWheel4Prototype = new LCFourWheeler();
  lcWheel4Prototype.setEngineType("Liquid Cool");
  lcWheel4Prototype.setBreakType("Liquid");
  lcWheel4Prototype.setExhaustCount(2);
  lcWheel4Prototype.setNoOfSeats(4);
  lcWheel4Prototype.setNoOfWheels(4);
  lcWheel4Prototype.setSeatBeltCount(2);

  const vehicleRegistry = new Registry<Vehicle>("VehicleRegistry");
  vehicleRegistry.register("lc-vehicle", vehiclePrototype);
  vehicleRegistry.register("lc-2-wheel", lcWheel2Prototype);
  vehicleRegistry.register("lc-4-wheel", lcWheel4Prototype);

  return { vehicleRegistry };
};

const client = () => {
  const { vehicleRegistry } = fillRegistry();
  const vehicle = vehicleRegistry.get("lc-vehicle")?.clone();
  console.log("🚀 ~ vehicle 1:", vehicle);
  vehicle?.setBrand("TATA");
  vehicle?.setMadeIn("India");
  vehicle?.setVersion("3.4");
  console.log("🚀 ~ vehicle 2:", vehicle);
  console.log(vehicle?.getEngineType());

  const twoWheel = vehicleRegistry.get("lc-2-wheel")?.clone();
  console.log("🚀 ~ twoWheel 1:", twoWheel);
  if (twoWheel instanceof LCTwoWheeler) {
    twoWheel?.setVehicleType("Scooter");
  }
  console.log("🚀 ~ twoWheel 2:", twoWheel);
};

client();
