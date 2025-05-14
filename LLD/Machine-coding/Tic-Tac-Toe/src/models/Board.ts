import { Cell } from "./Cell";

export class Board {
  private size!: number;
  private board!: Cell[][];

  constructor(size: number) {
    this.size = size;
    const board: Cell[][] = [];
    for (let i = 0; i < size; i++) {
      const row: Cell[] = [];
      for (let j = 0; j < size; j++) {
        row.push(new Cell(i, j));
      }
      board.push(row);
    }
    this.board = board;
  }

  public getSize() {
    return this.size;
  }
  public setSize(size: number) {
    this.size = size;
  }
  public getBoard() {
    return this.board;
  }
  public setFloor(board: Cell[][]) {
    this.board = board;
  }

  public printBoard() {
    if(this.board) {
      for(let i = 0; i < this.board.length; i++) {
        let rowCell = ''
        for(let j = 0; j < this.board[i].length; j++) {
          if(this.board[i]) {
            rowCell += this.board[i][j].displayCell();
          }
        }
        console.log(rowCell)
      }
    }
  }
}
