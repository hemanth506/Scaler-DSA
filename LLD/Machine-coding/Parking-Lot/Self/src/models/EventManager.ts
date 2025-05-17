type EventType = "SPOT_FREED";

type Callback = (payload: any) => void;

export class EventManager {
  private listeners: Map<EventType, Callback[]> = new Map();

  public subscribe(event: EventType, callback: Callback) {
    if (!this.listeners.has(event)) {
      this.listeners.set(event, []);
    }
    this.listeners.get(event)!.push(callback);
  }

  public publish(event: EventType, payload: any) {
    const subs = this.listeners.get(event) || [];
    for (const cb of subs) {
      cb(payload);
    }
  }
}
