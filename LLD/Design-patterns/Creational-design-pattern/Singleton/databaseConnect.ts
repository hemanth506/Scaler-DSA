/*
Static variables can be accessed only inside static methods


*/

class Postgres {
  private username: string;
  private host: string;
  private password: string;
  private port: number;
  public constructor(username: string, host: string, password: string, port: number) {
    this.username = username;
    this.host = host;
    this.password = password;
    this.port = port
  }

  public connect() {}
}

class DatabaseConnection {
  private static instance: DatabaseConnection | null = null;
  private static username: string = "";
  private username: string;
  private host: string;
  private password: string;
  private port: number;

  private constructor(username: string, host: string, password: string, port: number) {
    this.username = username;
    this.host = host;
    this.password = password;
    this.port = port
    console.log("Inside constructor");
    let pg = new Postgres(username, host, password, port)
  }

  public static getDbConnection(username: string, host: string, password: string, port: number): DatabaseConnection {
    this.username = username + " raaj";
    if (this.instance === null) {
      this.instance = new DatabaseConnection(username, host, password, port);
      console.log('static username :: ' + this.username)
    }
    return this.instance;
  }
}

let dbc = DatabaseConnection.getDbConnection("Hemanth", "https://google.com", "password", 3000);
console.log("🚀 ~ databaseConnect.ts ~ dbc:", dbc);

let dbc1 = DatabaseConnection.getDbConnection("Ruchika", "https://yahoo.com", "pass", 3001);
console.log("🚀 ~ databaseConnect.ts ~ dbc1:", dbc1);

const sharedBuffer = new SharedArrayBuffer(4); // 4 bytes for Int32
const lock = new Int32Array(sharedBuffer);
console.log('🚀 ~ databaseConnect.ts ~ lock:', lock)
console.log(Atomics)

