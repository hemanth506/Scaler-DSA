import { Board } from "../src/models/Board";
import { Cell } from "../src/models/Cell";
import { Move } from "../src/models/Move";

export interface WinningStrategy {
    checkWinner(board: Board, move: Move): boolean;
    removeMove(move: Move): void
}

export interface BotPlayingStrategy {
    makeMove(board: Board): Cell | null
}