import { CellState } from "../../helper/enums";
import { BotPlayingStrategy } from "../../helper/types";
import { Board } from "./Board";
import { Cell } from "./Cell";

export class EasyBotPlayingStrategy implements BotPlayingStrategy {
  public makeMove(board: Board): Cell | null {
    for (let i = 0; i < board.getSize(); i++) {
      for (let j = 0; j < board.getSize(); j++) {
        if (board.getBoard()[i][j].getCellState() === CellState.EMPTY) {
          return board.getBoard()[i][j];
        }
      }
    }
    return null;
  }
}

export class MediumBotPlayingStrategy implements BotPlayingStrategy {
  public makeMove(board: Board): Cell | null {
    throw new Error("Method not implemented.");
  }
}

export class HardBotPlayingStrategy implements BotPlayingStrategy {
  public makeMove(board: Board): Cell | null {
    throw new Error("Method not implemented.");
  }
}
