class CounterService {
  private count: number = 0;
  private static instance: CounterService | null = null;
  private constructor() {}

  public static initiateCounter(): CounterService {
    if (CounterService.instance === null) {
      CounterService.instance = new CounterService();
    }
    return CounterService.instance;
  }

  public increment(): void {
    this.count++;
  }

  public getCount(): number {
    return this.count;
  }
}

const cs = CounterService.initiateCounter();
cs.increment();
cs.increment();
cs.increment();
// cs.increment();
console.log(cs.getCount());
