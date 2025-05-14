import { PlayerType } from "../../helper/enums";
import { WinningStrategy } from "../../helper/types";
import { Game } from "../models/Game";
import { Player } from "../models/Player";

export class GameController {
  public initGame(
    dimensions: number,
    players: Player[],
    winningStrategy: WinningStrategy[]
  ): Game {
    return Game.getBuilder()
      .setDimension(dimensions)
      .setListOfPlayers(players)
      .setWinningStrategy(winningStrategy)
      .build();
  }

  public printBoard(game: Game): void {
    game.printBoard()
  }

  public makeMove(game: Game): void {
    game.makeMove()
  }

  public startGame(game: Game): void {
    game.makeMove()
  }
}
