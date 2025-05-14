import { GameState, PlayerType } from "../../helper/enums";
import { WinningStrategy } from "../../helper/types";
import { Board } from "./Board";
import { Cell } from "./Cell";
import { Move } from "./Move";
import { Player } from "./Player";

export class Game {
  private listOfPlayers!: Player[];
  private board!: Board;
  private moves!: Move[];
  private winner: Player | null = null;
  private gameState!: GameState;
  private nextPlayerIndex!: number;
  private winningStrategy!: WinningStrategy[];

  constructor(
    listOfPlayers: Player[],
    dimension: number,
    winningStrategy: WinningStrategy[]
  ) {
    this.listOfPlayers = listOfPlayers;
    this.board = new Board(dimension);
    this.winningStrategy = winningStrategy;
    this.moves = [];
    this.gameState = GameState.IN_PROGRESS;
    this.nextPlayerIndex = 0;
  }

  public static getBuilder() {
    return new GameBuilder();
  }

  public getMoves(): Move[] {
    return this.moves;
  }
  public setMoves(moves: Move[]) {
    this.moves = moves;
  }
  public getWinner() {
    return this.winner;
  }
  public setWinner(winner: Player) {
    this.winner = winner;
  }
  public getGameState() {
    return this.gameState;
  }
  public setGameState(gameState: GameState) {
    this.gameState = gameState;
  }
  public getNextPlayerIndex() {
    return this.nextPlayerIndex;
  }
  public setNextPlayerIndex(nextPlayerIndex: number) {
    this.nextPlayerIndex = nextPlayerIndex;
  }
  public printBoard(): void {
    this.board.printBoard();
  }
  public makeMove(): void {
    const player: Player = this.listOfPlayers[this.getNextPlayerIndex()];
    const cell: Cell | null = player.makeMove(this.board)

    if(cell) {
      const move: Move = new Move(cell, player);
      this.getMoves().push(move);
  
      if(this.checkWinner(move, this.board)) {
        this.setGameState(GameState.SUCCESS)
        this.setWinner(player);
        return
      }
  
      if(this.getMoves().length === this.board.getSize() * this.board.getSize()) {
        this.setGameState(GameState.DRAW)
        return;
      }
  
      this.setNextPlayerIndex(this.getNextPlayerIndex() + 1);
      this.setNextPlayerIndex(this.getNextPlayerIndex() % this.listOfPlayers.length)
    }
  }
  public checkWinner(move: Move, board: Board): boolean {
    for(let i = 0; i < this.winningStrategy.length; i++) {
      if(this.winningStrategy[i].checkWinner(board, move)) {
        return true
      }
    }
    return false;
  }
}

class GameBuilder {
  private listOfPlayers!: Player[];
  private dimension!: number;
  private winningStrategy!: WinningStrategy[];

  public setListOfPlayers(listOfPlayers: Player[]): GameBuilder {
    this.listOfPlayers = listOfPlayers;
    return this;
  }
  public setDimension(dimension: number): GameBuilder {
    this.dimension = dimension;
    return this;
  }
  public setWinningStrategy(winningStrategy: WinningStrategy[]): GameBuilder {
    this.winningStrategy = winningStrategy;
    return this;
  }
  private validateBotCount() {
    let botCount = 0;
    for (let i = 0; i < this.listOfPlayers.length; i++) {
      if (this.listOfPlayers[i].getPlayerType() === PlayerType.BOT) {
        botCount++;
      }
    }
    if (botCount > 1) {
      throw new Error("Only one bot is allowed");
    }
  }
  private validateUniqueSymbolForPlayers() {
    let uniqueSymbols = new Set<string>();

    for (let i = 0; i < this.listOfPlayers.length; i++) {
      const curSymbol = this.listOfPlayers[i].getSymbol();
      if (uniqueSymbols.has(curSymbol)) {
        throw new Error("Duplicate symbol selected");
      }
      uniqueSymbols.add(curSymbol);
    }
  }
  private validateDimensionsAndPlayerCount() {
    if (this.listOfPlayers.length != this.dimension - 1) {
      throw new Error("Player count mismatch");
    }
  }
  public build(): Game {
    this.validateBotCount();
    this.validateUniqueSymbolForPlayers();
    this.validateDimensionsAndPlayerCount();
    return new Game(this.listOfPlayers, this.dimension, this.winningStrategy);
  }
}
