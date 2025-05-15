import { CellState } from "../../helper/enums"
import { Player } from "./Player"

export class Cell {
    private row!: number
    private col!: number
    private cellState!: CellState
    private player: Player | null = null

    constructor(row: number, col: number) {
        this.row = row
        this.col = col
        this.cellState = CellState.EMPTY
    }

    public getRow() {
        return this.row
    }
    public setRow(row: number) {
        this.row = row
    }
    public getCol() {
        return this.col
    }
    public setCol(col: number) {
        this.col = col
    }
    public getCellState() { 
        return this.cellState
    }
    public setCellState(cellState: CellState) {
        this.cellState = cellState
    }
    public getPlayer() {
        return this.player
    }
    public setPlayer(player: Player | null) {
        this.player = player
    }
    public displayCell(): string {
        if(this.cellState === CellState.FILLED) {
            return `| ${this.player?.getSymbol()} |`;
        } else {
            return `| - |`;
        }
    }
}