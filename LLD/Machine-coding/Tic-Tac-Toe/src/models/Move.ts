import { Cell } from "./Cell";
import { Player } from "./Player";

export class Move {
    private cell!: Cell
    private player!: Player

    constructor(cell: Cell, player: Player) {
        this.cell = cell;
        this.player = player;
    }

    public getCell() {
        return this.cell
    }
    public setCell(cell: Cell) {
        this.cell = cell;
    }
    
    public getPlayer() {
        return this.player;
    }
    
    public setPlayer(player: Player) {
        this.player = player;
    }
    
}