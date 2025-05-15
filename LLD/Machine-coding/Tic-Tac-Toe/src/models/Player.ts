import { CellState, DifficultyLevel, PlayerType } from "../../helper/enums";
import { BotPlayingStrategy } from "../../helper/types";
import { Board } from "./Board";
import {
  EasyBotPlayingStrategy,
  HardBotPlayingStrategy,
  MediumBotPlayingStrategy,
} from "./BotPlayingStrategy";
import { Cell } from "./Cell";
import promptSync from "prompt-sync";
import { Game } from "./Game";

export class Player {
  private symbol!: string;
  private name!: string;
  private id!: number;
  private playerType!: PlayerType;
  private prompt!: any;

  constructor(
    symbol: string,
    name: string,
    id: number,
    playerType: PlayerType
  ) {
    this.symbol = symbol;
    this.name = name;
    this.id = id;
    this.playerType = playerType;
    this.prompt = promptSync();
  }

  public getSymbol() {
    return this.symbol;
  }

  public setSymbol(symbol: string) {
    this.symbol = symbol;
  }

  public getName() {
    return this.name;
  }

  public setName(name: string) {
    this.name = name;
  }

  public getId() {
    return this.id;
  }

  public setId(id: number) {
    this.id = id;
  }

  public getPlayerType() {
    return this.playerType;
  }

  public setPlayerType(playerType: PlayerType) {
    this.playerType = playerType;
  }

  public makeMove(board: Board, game: Game): Cell | null {
    console.log(
      `${this.getName()}, It's your turn please make a move, enter row and column!`
    );
    let rowInput = this.prompt("Row: ");
    if (rowInput === "q") {
      game.undoMove();
      return null;
    }

    let colInput = this.prompt("Column: ");
    if (colInput === "q") {
      game.undoMove();
      return null;
    }
    while (
      Number.isNaN(rowInput) ||
      Number.isNaN(colInput) ||
      !this.validateMove(board, rowInput, colInput)
    ) {
      console.log(
        `Invalid entry. Please try again by entering a valid row and column, or 'q' to quit.`
      );

      rowInput = this.prompt("Row: ");
      if (rowInput === "q") {
        game.undoMove();
        return null;
      }

      colInput = this.prompt("Column: ");
      if (colInput === "q") {
        game.undoMove();
        return null;
      }
    }
    rowInput = parseInt(rowInput);
    colInput = parseInt(colInput);

    if (Number.isInteger(rowInput) && Number.isInteger(colInput)) {
      const cell: Cell = board.getBoard()[rowInput][colInput];
      cell.setCellState(CellState.FILLED);
      cell.setPlayer(this);
      return cell;
    }
    return null;
  }

  public validateMove(board: Board, row: number, col: number): boolean {
    if (row < 0 || col < 0) {
      return false;
    }

    if (row >= board.getSize()) {
      return false;
    }

    if (col >= board.getSize()) {
      return false;
    }

    if (board.getBoard()[row][col].getCellState() !== CellState.EMPTY) {
      return false;
    }

    return true;
  }
}

export class Bot extends Player {
  private difficultyLevel!: DifficultyLevel;
  private botPlayingStrategy?: BotPlayingStrategy;

  constructor(
    symbol: string,
    name: string,
    id: number,
    playerType: PlayerType,
    difficultyLevel: DifficultyLevel
  ) {
    super(symbol, name, id, playerType);
    this.difficultyLevel = difficultyLevel;
    this.botPlayingStrategy =
      BotPlayingStrategyFactory.getStrategy(difficultyLevel);
  }

  public getDifficultyLevel() {
    return this.difficultyLevel;
  }

  public setDifficultyLevel(difficultyLevel: DifficultyLevel) {
    this.difficultyLevel = difficultyLevel;
  }

  public makeMove(board: Board): Cell | null {
    if (this.botPlayingStrategy) {
      console.log("Now", this.getName(), "made her move!");
      const cell: Cell | null = this.botPlayingStrategy.makeMove(board);
      if (cell) {
        cell.setCellState(CellState.FILLED);
        cell.setPlayer(this);
        return cell;
      }
    }
    return null;
  }
}

class BotPlayingStrategyFactory {
  public static getStrategy(
    difficultyLevel: DifficultyLevel
  ): BotPlayingStrategy {
    switch (difficultyLevel) {
      case DifficultyLevel.EASY: {
        return new EasyBotPlayingStrategy();
      }
      case DifficultyLevel.MEDIUM: {
        return new MediumBotPlayingStrategy();
      }
      default:
      case DifficultyLevel.HARD: {
        return new HardBotPlayingStrategy();
      }
    }
  }
}
