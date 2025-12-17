interface Device {
  deviceType: string;
  turnOn(): void;
  turnOff(): void;
}

abstract class DeviceClass implements Device {
  abstract deviceType: string;
  public turnOn(): void {
    console.log(`${this.deviceType} is turning On..`);
  }
  public turnOff(): void {
    console.log(`${this.deviceType} is turning Off..`);
  }
}

class TV extends DeviceClass {
  private resolution?: string;
  private noOfHDMIs?: number;
  public deviceType: string = "TV";

  public setResolution(resolution: string) {
    this.resolution = resolution;
  }

  public getResolution = () => this.resolution;

  public setHDMIsCount(count: number) {
    this.noOfHDMIs = count;
  }

  public getHDMIsCount = () => this.noOfHDMIs;
}

class SmartLight extends DeviceClass {
  private color: string = "Yellowish White";
  public deviceType: string = "Smart Light";

  public setColor = (color: string) => (this.color = color);
  public getCOlor = () => this.color;
}

class RemoteControl {
  protected device: Device;
  constructor(device: Device) {
    this.device = device;
  }
  public turnOn = () => {
    console.log(`Turning on ${this.device.deviceType}`);
    this.device.turnOn();
  };
  public turnOff = () => {
    console.log(`Turning off ${this.device.deviceType}`);
    this.device.turnOff();
  };
}

class AdvanceRemoteControl extends RemoteControl {
  private volumeOrBrightness: number = 50;
  constructor(device: Device) {
    super(device);
  }
  public setVolumeOrBrightness = (level: number) => {
    this.volumeOrBrightness = level;
    console.log(`Setting ${this.device.deviceType} volume/brightness to ${level}`);
  };
  public getVolumeOrBrightness = () => {
    console.log("The brightness or volume level is ", this.volumeOrBrightness);
  };
}

const sl: SmartLight = new SmartLight();
console.log('sl.getCOlor()', sl.getCOlor());
const slRemote = new AdvanceRemoteControl(sl);
slRemote.turnOn();
slRemote.setVolumeOrBrightness(75);

console.log('----------------------------');

const tv: TV = new TV();
tv.setResolution("500")
console.log('tv.getResolution()', tv.getResolution());
const tvRemote = new AdvanceRemoteControl(tv);
tvRemote.turnOff();
tvRemote.setVolumeOrBrightness(35);
tvRemote.getVolumeOrBrightness()
