interface SwitchedElectricalDevise {
  turnOn(): void
  turnOff(): void
}

class Projector implements SwitchedElectricalDevise {
  private inputSource?: string
  turnOn() { console.log("Projector is turned on..") }
  turnOff() { console.log("Projector is turned off") }
  setInputSource(inputSource: string) {
    this.inputSource = inputSource
    console.log(`Input source is set as ${this.inputSource}`)
  }
}

class WhiteScreen {
  lower(): void { console.log("White screen is lowering..") }
  raise(): void { console.log("White screen is raising.") }
}

class SoundSystem implements SwitchedElectricalDevise {
  private volume?: number
  turnOn(): void { console.log(`Sound System is turned on and the volume is set to ${this.volume || 50}`) }
  turnOff(): void { console.log("Sound system is turned off..") }
  setVolume(volume: number): void {
    this.volume = volume;
  }
}

class Lights implements SwitchedElectricalDevise {
  turnOn(): void { console.log("Lights are turned on..") }
  turnOff(): void { console.log("Lights are turned off..") }
  dim(): void { console.log("Lights are set to 50% brightness") }
}

class StreamingDevice implements SwitchedElectricalDevise {
  turnOn(): void { console.log("Streaming device powered ON."); }
  turnOff(): void { console.log("Streaming device powered OFF."); }
  playMovie(movieName: string): void { console.log(`Playing movie: ${movieName}`); }
  stopMovie(): void { console.log("Stopping movie..."); }
}


class MovieFacade {
  movieName: string
  private readonly sd: StreamingDevice
  private readonly lt: Lights
  private readonly ss: SoundSystem
  private readonly ws: WhiteScreen
  private readonly pj: Projector
  constructor(movieName: string, streamingDeviceObj: StreamingDevice, lightsObj: Lights, soundSystemObj: SoundSystem, whiteScreenObj: WhiteScreen, projectorObj: Projector) {
    this.movieName = movieName
    this.sd = streamingDeviceObj
    this.lt = lightsObj
    this.ss = soundSystemObj
    this.ws = whiteScreenObj
    this.pj = projectorObj
    this.ss.setVolume(75)
  }

  public startMovie(): void {
    console.log(`The movie ${this.movieName} is about to start.. hooohoo`);
    this.pj.turnOn()
    this.sd.turnOn()
    this.lt.turnOff()
    this.ss.turnOn()
    this.ws.lower()
    console.log("Enjoy your movie.")
  }

  public endMovie(): void {
    console.log(`the movie ${this.movieName} is paused and can be played later.`)
    this.lt.turnOn()
    this.ss.turnOff()
    this.sd.turnOff()
    this.pj.turnOff()
    this.ws.raise()
    console.log("Thank you!")
  }
}


const movie = new MovieFacade("Conjuring", new StreamingDevice(), new Lights(), new SoundSystem(), new WhiteScreen(), new Projector())
movie.endMovie()