import { Board } from "../src/models/Board";
import { Cell } from "../src/models/Cell";
import { Move } from "../src/models/Move";

export interface WinningStrategy {
    checkWinner(board: Board, move: Move): boolean;
}

export interface BotPlayingStrategy {
    makeMove(board: Board): Cell | null
}