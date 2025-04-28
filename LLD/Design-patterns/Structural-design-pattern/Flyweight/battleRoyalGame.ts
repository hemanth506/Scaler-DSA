interface VehicleExtensiveModel {
  position: [number, number, number];
  fuelLevel: number;
  health: number;
  color: string;
  intensiveModel: VehicleIntensiveModel;
}

interface VehicleIntensiveModel {
  type: string;
  speed: string;
  noOfWheels: number;
  passengerCapacity: number;
}

class VehicleIntensive implements VehicleIntensiveModel {
  type: string;
  speed: string;
  noOfWheels: number;
  passengerCapacity: number;
  constructor(
    type: string,
    speed: string,
    noOfWheels: number,
    passengerCapacity: number
  ) {
    this.type = type;
    this.speed = speed;
    this.noOfWheels = noOfWheels;
    this.passengerCapacity = passengerCapacity;
  }
}

class VehicleExtensive implements VehicleExtensiveModel {
  position: [number, number, number];
  fuelLevel: number;
  color: string;
  health: number;
  intensiveModel: VehicleIntensiveModel;

  constructor(
    position: [number, number, number],
    fuelLevel: number,
    health: number,
    color: string,
    intensiveModel: VehicleIntensiveModel
  ) {
    this.position = position;
    this.fuelLevel = fuelLevel;
    this.health = health;
    this.intensiveModel = intensiveModel;
    this.color = color;
  }
}

const honda = new VehicleIntensive("Bike", "150", 2, 2);
const duke = new VehicleIntensive("Bike", "250", 2, 1);

const bikeVehicle1 = new VehicleExtensive([2, 4, 6], 49, 73, "Black", honda);
const bikeVehicle2 = new VehicleExtensive([52, 19, 17], 90, 25, "Red", duke);
const bikeVehicle3 = new VehicleExtensive([90, 65, 11], 76, 30, "Blue", honda);
honda.speed = "180"
console.log(bikeVehicle1.intensiveModel.speed); // now prints "180"
console.log(bikeVehicle3.intensiveModel.speed); // also prints "180"

interface BuildingExtensiveModel {
  position: [number, number, number];
  rotation: [number, number, number];
  damageLevel: number;
  intensiveModel: BuildingIntensiveModel;
}

interface BuildingIntensiveModel {
  buildingType: string;
  floors: number;
  width: number;
  height: number;
}

class BuildingExtensive implements BuildingExtensiveModel {
  position: [number, number, number];
  rotation: [number, number, number];
  damageLevel: number;
  intensiveModel: BuildingIntensiveModel;
  constructor(
    position: [number, number, number],
    rotation: [number, number, number],
    damageLevel: number,
    intensiveModel: BuildingIntensiveModel
  ) {
    this.position = position;
    this.rotation = rotation;
    this.damageLevel = damageLevel;
    this.intensiveModel = intensiveModel;
  }
}

class BuildingIntensive implements BuildingIntensiveModel {
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

const house = new BuildingIntensive("House", 2, 20, 30);
const office = new BuildingIntensive("Office", 5, 50, 100);

const houseBuilding1 = new BuildingExtensive([2, 4, 6], [0, 0, 0], 70, house);
const houseBuilding2 = new BuildingExtensive([5, 9, 1], [0, 0, 0], 20, office);
const houseBuilding3 = new BuildingExtensive([0, 5, 7], [0, 0, 0], 10, house);
house.buildingType = "Factory"
console.log(houseBuilding1.intensiveModel.buildingType);
console.log(houseBuilding3.intensiveModel.buildingType);
