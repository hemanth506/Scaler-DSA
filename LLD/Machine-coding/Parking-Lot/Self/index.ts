import { VehicleIndexMap, VehicleType } from "./helper/enums";
import { ParkingLotController } from "./src/controllers/ParkingLotController";
import promptSync from "prompt-sync";
import { Transport } from "./src/models/Transport";

const prompt = promptSync();

const getVehicleDetailsToEnterTheLot = (): Transport | undefined => {
  let runExecution = true;
  while (runExecution) {
    const vehicleType = prompt(
      "Enter vehicle type? "
    ).toUpperCase() as VehicleType;
    const vehicleNumber = prompt("Enter vehicle number? ");
    const vehicleColor = prompt("Enter vehicle color? ");

    if (vehicleNumber && vehicleColor) {
      if (Object.values(VehicleType).includes(vehicleType)) {
        const vehicleTypeId = VehicleIndexMap[vehicleType];
        return new Transport(
          vehicleType,
          vehicleNumber,
          vehicleColor,
          vehicleTypeId
        );
      } else {
        console.log(
          "Invalid vehicle type. Please enter the vehicle details again!"
        );
      }
    } else {
      runExecution = false;
      console.log(
        "Invalid vehicle number or color. Please enter the vehicle details again!"
      );
    }
  }
};

const getVehicleNumberToExitTheLot = () => {
  let runExecution = true;
  while (runExecution) {
    const vehicleNumber = prompt("Enter vehicle number? ");
    if (vehicleNumber) {
      runExecution = false;
      return vehicleNumber;
    } else {
      console.log("Sorry I have missed the number!");
    }
  }
};

(() => {
  const noOfLevels = 3;
  const totalSpotsAllotedPerVehicleType: number[][] = [];
  totalSpotsAllotedPerVehicleType.push([0, 1, 0]);
  totalSpotsAllotedPerVehicleType.push([0, 0, 1]);
  totalSpotsAllotedPerVehicleType.push([1, 0, 0]);

  const parkingLotController = new ParkingLotController();
  const parkingLot = parkingLotController.initParkingLot(
    noOfLevels,
    totalSpotsAllotedPerVehicleType
  );

  let runExecution = true;
  console.log(`Available commands:
    enter/en: Enter the parking lot.
    exit/ex: Exit the parking lot.
    end/ed: End the execution.
  `);
  while (runExecution) {
    const command = prompt(`Enter the command: `);

    if (command === "enter" || command === "en") {
      const vehicle: Transport | undefined = getVehicleDetailsToEnterTheLot();
      if (vehicle) {
        parkingLotController.incomingVehicle(vehicle, parkingLot);
        parkingLotController.displayDashboard(parkingLot);
      }
    } else if (command === "exit" || command === "ex") {
      const vehicleNumber = getVehicleNumberToExitTheLot();
      if (vehicleNumber) {
        parkingLotController.exitingVehicle(parkingLot, vehicleNumber);
        parkingLotController.displayDashboard(parkingLot);
      }
    } else if (command === "end" || command === "ed") {
      console.log("Execution stopped");
      runExecution = false;
    } else {
      console.log(`Entered an invalid command, please try again!`);
    }
  }
})();
