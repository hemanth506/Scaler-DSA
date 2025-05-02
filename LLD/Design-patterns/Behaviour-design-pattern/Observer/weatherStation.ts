// abstracts / interfaces / types

type weatherData = {
  temperature: string;
  humidity: string;
  windSpeed: string;
};

interface Observer {
  sendNotification(data: weatherData): void;
}

abstract class Publisher {
  protected abstract observers?: Observer[];
  protected weatherData?: weatherData;
  abstract notify(): void;
}

// ------------------------------------------------

class WeatherStation extends Publisher {
  protected observers?: Observer[];
  protected weatherData?: weatherData;
  constructor(observers: Observer[], data: weatherData) {
    super();
    this.observers = observers;
    this.weatherData = data;
  }
  notify(): void {
    if (this.observers && this.weatherData) {
      for (let i = 0; i < this.observers.length; i++) {
        this.observers[i].sendNotification(this.weatherData);
      }
    }
  }
}

class MobileApp implements Observer {
  sendNotification(data: weatherData): void {
    console.log(
      `🚀 ~ Mobile notification sent. ${data.humidity} || ${data.temperature} || ${data.windSpeed}`
    );
  }
}

class DashboardDisplay implements Observer {
  sendNotification(data: weatherData): void {
    console.log(
      `🚀 ~ Dashboard notified. ${data.humidity} || ${data.temperature} || ${data.windSpeed}`
    );
  }
}

class EmergencyAlert implements Observer {
  sendNotification(data: weatherData): void {
    console.log(
      `🚀 ~ Emergency alert notified. ${data.humidity} || ${data.temperature} || ${data.windSpeed}`
    );
  }
}

const data: weatherData = {
  temperature: "40`c",
  humidity: "25`c",
  windSpeed: "50km/ph",
};
const ma = new MobileApp();
const dd = new DashboardDisplay();
const ea = new EmergencyAlert();
const ws = new WeatherStation([ea, dd], data);
ws.notify();
