import { GateType, ResponseType, vehicleIndexMap, VehicleType } from "./helper/enums";
import { ParkingLotController } from "./src/controllers/ParkingLotController";
import promptSync from "prompt-sync";
import { Transport } from "./src/models/Transport";
import { DEFAULT_ENTRY_GATE, Gate } from "./src/models/Gate";
import { Operator } from "./src/models/Operator";
import { TicketController } from "./src/controllers/TicketController";
import { Ticket } from "./src/models/Ticket";

const prompt = promptSync();

const getVehicleDetailsToEnterTheLot = (): Transport | undefined => {
  let runExecution = true;
  while (runExecution) {
    const vehicleType = prompt(
      "Enter vehicle type? "
    ).toUpperCase() as VehicleType;
    const vehicleNumber = prompt("Enter vehicle number? ");

    if (vehicleNumber) {
      if (Object.values(VehicleType).includes(vehicleType)) {
        const vehicleTypeId = vehicleIndexMap[vehicleType];
        return new Transport(
          vehicleType,
          vehicleNumber,
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
        "Invalid vehicle number. Please enter the vehicle details again!"
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

  const operator1 = new Operator("Hemanth")
  const operator2 = new Operator("Ruchika")
  const operator3 = new Operator("Harish")
  const operator4 = new Operator("Latha")

  const entryGate1 = new Gate(1, GateType.ENTRY, operator1);
  const entryGate2 = new Gate(2, GateType.ENTRY, operator2);
  const exitGate1 = new Gate(3, GateType.EXIT, operator3);
  const exitGate2 = new Gate(4, GateType.EXIT, operator4);


  const parkingLotController = new ParkingLotController();
  const parkingLot = parkingLotController.initParkingLot(
    noOfLevels,
    totalSpotsAllotedPerVehicleType
  );
  const ticketController = new TicketController();
  const ticket = new Ticket();

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
        const gate = (Math.floor(Math.random() * 10) % 2) === 0 ? entryGate1 : entryGate2;
        const responseType = parkingLotController.incomingVehicle(vehicle, parkingLot, gate);
        if (responseType === ResponseType.SLOT_ALLOTED) {
          ticketController.issueTicket(ticket, vehicle, gate)
        }
        parkingLotController.displayDashboard(parkingLot);
      }
    } else if (command === "exit" || command === "ex") {
      const vehicleNumber = getVehicleNumberToExitTheLot();
      if (vehicleNumber) {
        const response = parkingLotController.exitingVehicle(parkingLot, vehicleNumber);
        if (response) {
          const { status, poppedVehicle } = response
          if (status === ResponseType.SLOT_ALLOTED_FOR_QUEUED_VEHICLE && poppedVehicle) {
            ticketController.issueTicket(ticket, poppedVehicle, DEFAULT_ENTRY_GATE)
          }
        }
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
