import { DifficultyLevel, GameState, PlayerType } from "./helper/enums";
import { WinningStrategy } from "./helper/types";
import { GameController } from "./src/controllers/GameController";
import { Bot, Player } from "./src/models/Player";
import { ColumnWiseStrategy, DiagonalWiseStrategy, RowWiseStrategy } from "./src/models/WinningStrategy";

(() => {
    const dimensions = 3;
    const players: Player[] = [];
    players.push(new Player('O', 'Hemanth', 0, PlayerType.HUMAN));
    players.push(new Bot('X', 'GPT', 1, PlayerType.BOT, DifficultyLevel.EASY));
    // players.push(new Player('P', 'Ruchika', 2, PlayerType.HUMAN));

    
    const winningStrategy: WinningStrategy[] = [];
    winningStrategy.push(new RowWiseStrategy());
    winningStrategy.push(new ColumnWiseStrategy());
    winningStrategy.push(new DiagonalWiseStrategy());
    
    const gc: GameController = new GameController();
    const game = gc.initGame(dimensions, players, winningStrategy);
    while(game.getGameState() === GameState.IN_PROGRESS) {
        gc.printBoard(game);
        gc.makeMove(game);
    }

    if(game.getGameState() === GameState.SUCCESS) {
        console.log(`${game.getWinner()?.getName()} Congrats, You won the game!`)
    }

    if(game.getGameState() === GameState.DRAW) {
        console.log(`Game tied`)
    }
})();