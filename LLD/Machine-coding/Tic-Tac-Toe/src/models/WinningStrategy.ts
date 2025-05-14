import { WinningStrategy } from "../../helper/types";
import { Board } from "./Board";
import { Move } from "./Move";

export class RowWiseStrategy implements WinningStrategy {
    checkWinner(board: Board, move: Move): boolean {
        return false;
    }
}


export class ColumnWiseStrategy implements WinningStrategy {
    checkWinner(board: Board, move: Move): boolean {
        return false;
    }
}


export class DiagonalWiseStrategy implements WinningStrategy {
    checkWinner(board: Board, move: Move): boolean {
        return false;
    }
}