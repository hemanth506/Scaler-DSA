import { WinningStrategy } from "../../helper/types";
import { Board } from "./Board";
import { Move } from "./Move";

export class RowWiseStrategy implements WinningStrategy {
  fullRowMap: Map<number, Map<string, number>> = new Map();
  checkWinner(board: Board, move: Move): boolean {
    const rowNumber = move.getCell().getRow();
    const symbol = move.getPlayer().getSymbol();

    if (!this.fullRowMap.has(rowNumber)) {
      const rowMap = new Map<string, number>();
      this.fullRowMap.set(rowNumber, rowMap);
    }

    const curRowMap = this.fullRowMap.get(rowNumber);
    if (curRowMap) {
      if (!curRowMap.has(symbol)) {
        curRowMap.set(symbol, 0);
      }

      let curSymbolCount = curRowMap.get(symbol);
      if (curSymbolCount !== undefined) {
        curSymbolCount += 1;
        curRowMap.set(symbol, curSymbolCount);
        if (curSymbolCount === board.getSize()) {
          return true;
        }
      }
    }
    return false;
  }
  removeMove(move: Move): void {
    const rowNumber = move.getCell().getRow();
    const symbol = move.getPlayer().getSymbol();
    const currentCount = this.fullRowMap.get(rowNumber)?.get(symbol);
    if (currentCount) {
      this.fullRowMap.get(rowNumber)?.set(symbol, currentCount - 1);
    }
  }
}

export class ColumnWiseStrategy implements WinningStrategy {
  fullColMap: Map<number, Map<string, number>> = new Map();
  checkWinner(board: Board, move: Move): boolean {
    const colNumber = move.getCell().getCol();
    const symbol = move.getPlayer().getSymbol();

    if (!this.fullColMap.has(colNumber)) {
      const colMap = new Map<string, number>();
      this.fullColMap.set(colNumber, colMap);
    }

    const curColMap = this.fullColMap.get(colNumber);
    if (curColMap) {
      if (!curColMap.has(symbol)) {
        curColMap.set(symbol, 0);
      }

      let curSymbolCount = curColMap.get(symbol);
      if (curSymbolCount !== undefined) {
        curSymbolCount = curSymbolCount + 1;
        curColMap.set(symbol, curSymbolCount);
        if (curSymbolCount === board.getSize()) {
          return true;
        }
      }
    }

    return false;
  }
  removeMove(move: Move): void {
    const colNumber = move.getCell().getCol();
    const symbol = move.getPlayer().getSymbol();
    const currentCount = this.fullColMap.get(colNumber)?.get(symbol);
    if (currentCount) {
      this.fullColMap.get(colNumber)?.set(symbol, currentCount - 1);
    }
  }
}

export class DiagonalWiseStrategy implements WinningStrategy {
  l_to_r_map: Map<string, number> = new Map();
  r_to_l_map: Map<string, number> = new Map();
  boardSize?: number;

  checkWinner(board: Board, move: Move): boolean {
    const rowNumber = move.getCell().getRow();
    const colNumber = move.getCell().getCol();
    const symbol = move.getPlayer().getSymbol();
    this.boardSize = board.getSize();

    if (rowNumber === colNumber) {
      if (!this.l_to_r_map.has(symbol)) {
        this.l_to_r_map.set(symbol, 0);
      }

      let curSymbolCount = this.l_to_r_map.get(symbol);
      if (curSymbolCount !== undefined) {
        this.l_to_r_map.set(symbol, curSymbolCount + 1);
        if (this.l_to_r_map.get(symbol) === board.getSize()) {
          return true;
        }
      }
    }

    if (rowNumber + colNumber + 1 === board.getSize()) {
      if (!this.r_to_l_map.has(symbol)) {
        this.r_to_l_map.set(symbol, 0);
      }

      let curSymbolCount = this.r_to_l_map.get(symbol);
      if (curSymbolCount !== undefined) {
        this.r_to_l_map.set(symbol, curSymbolCount + 1);
        if (this.r_to_l_map.get(symbol) === board.getSize()) {
          return true;
        }
      }
    }
    return false;
  }
  removeMove(move: Move): void {
    const rowNumber = move.getCell().getRow();
    const colNumber = move.getCell().getRow();
    const symbol = move.getPlayer().getSymbol();

    if (rowNumber === colNumber) {
      const currentCount = this.l_to_r_map.get(symbol);
      if (currentCount !== undefined) {
        this.l_to_r_map.set(symbol, currentCount - 1);
      }
    }

    if (rowNumber + colNumber + 1 === this.boardSize) {
      const currentCount = this.r_to_l_map.get(symbol);
      if (currentCount !== undefined) {
        this.r_to_l_map.set(symbol, currentCount - 1);
      }
    }
  }
}
