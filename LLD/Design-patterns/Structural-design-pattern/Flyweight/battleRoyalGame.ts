// vehicles
interface VehicleExtrinsicModel {
  position: [number, number, number];
  fuelLevel: number;
  health: number;
  intrinsicModel: VehicleIntrinsicModel;
}

interface VehicleIntrinsicModel {
  color: string;
  type: string;
  speed: string;
  noOfWheels: number;
  passengerCapacity: number;
}

class VehicleIntrinsic implements VehicleIntrinsicModel {
  type: string;
  speed: string;
  noOfWheels: number;
  passengerCapacity: number;
  color: string;
  constructor(
    type: string,
    speed: string,
    noOfWheels: number,
    passengerCapacity: number,
    color: string,
  ) {
    this.type = type;
    this.speed = speed;
    this.noOfWheels = noOfWheels;
    this.passengerCapacity = passengerCapacity;
    this.color = color
  }
}

class VehicleExtrinsic implements VehicleExtrinsicModel {
  position: [number, number, number];
  fuelLevel: number;
  health: number;
  intrinsicModel: VehicleIntrinsicModel;

  constructor(
    position: [number, number, number],
    fuelLevel: number,
    health: number,
    intrinsicModel: VehicleIntrinsicModel
  ) {
    this.position = position;
    this.fuelLevel = fuelLevel;
    this.health = health;
    this.intrinsicModel = intrinsicModel;
  }
}

const hondaBlack = new VehicleIntrinsic("Bike", "150", 2, 2, 'Black');
const dukeRed = new VehicleIntrinsic("Bike", "250", 2, 1, 'Red');

const bikeVehicle1 = new VehicleExtrinsic([2, 4, 6], 49, 73, hondaBlack);
const bikeVehicle2 = new VehicleExtrinsic([52, 19, 17], 90, 25, dukeRed);
const bikeVehicle3 = new VehicleExtrinsic([90, 65, 11], 76, 30, hondaBlack);
hondaBlack.speed = "180"
console.log(bikeVehicle1.intrinsicModel.speed); // now prints "180"
console.log(bikeVehicle3.intrinsicModel.speed); // also prints "180"


// Buildings
interface BuildingExtrinsicModel {
  position: [number, number, number];
  rotation: [number, number, number];
  damageLevel: number;
  intrinsicModel: BuildingIntrinsicModel;
}

interface BuildingIntrinsicModel {
  buildingType: string;
  floors: number;
  width: number;
  height: number;
}

class BuildingExtrinsic implements BuildingExtrinsicModel {
  position: [number, number, number];
  rotation: [number, number, number];
  damageLevel: number;
  intrinsicModel: BuildingIntrinsicModel;
  constructor(
    position: [number, number, number],
    rotation: [number, number, number],
    damageLevel: number,
    intrinsicModel: BuildingIntrinsicModel
  ) {
    this.position = position;
    this.rotation = rotation;
    this.damageLevel = damageLevel;
    this.intrinsicModel = intrinsicModel;
  }
}

class BuildingIntrinsic implements BuildingIntrinsicModel {
  buildingType: string;
  floors: number;
  width: number;
  height: number;
  constructor(
    buildingType: string,
    floors: number,
    width: number,
    height: number
  ) {
    this.buildingType = buildingType;
    this.floors = floors;
    this.width = width;
    this.height = height;
  }
}

const house = new BuildingIntrinsic("House", 2, 20, 30);
const office = new BuildingIntrinsic("Office", 5, 50, 100);

const houseBuilding1 = new BuildingExtrinsic([2, 4, 6], [0, 0, 0], 70, house);
const houseBuilding2 = new BuildingExtrinsic([5, 9, 1], [0, 0, 0], 20, office);
const houseBuilding3 = new BuildingExtrinsic([0, 5, 7], [0, 0, 0], 10, house);
house.buildingType = "Factory"
console.log(houseBuilding1.intrinsicModel.buildingType);
console.log(houseBuilding3.intrinsicModel.buildingType);
