let Cell = require('./cell');

"use strict";
class Board {
    constructor() {
        this.MAXIMUM_INDEX_BOARD = 9;
        this._boardCells = [];
        for (let index = 0; index < this.MAXIMUM_INDEX_BOARD; index++) {
            this._boardCells.push(new Cell());
        }
    }
    setBoardCellMark(index, mark) {
        if (index >= this.MAXIMUM_INDEX_BOARD)
            throw new Error('index out of bound');
        this._boardCells[index].cellState = mark;
    }
    getBoardCellMark(index) {
        return this._boardCells[index];
    }
    getBoardState() {
        return this._boardCells;
    }
    displayBoard() {
        console.log("\n\t -----------board---------------");

        console.log("\t\t" + this._boardCells[0].cellState + "   | " + this._boardCells[1].cellState + "  | " + this._boardCells[2].cellState);
        console.log("\t\t ------------ ");
        console.log("\t\t" + this._boardCells[3].cellState + "   | " + this._boardCells[4].cellState + "  | " + this._boardCells[5].cellState);
        console.log("\t\t ------------ ");
        console.log("\t\t" + this._boardCells[6].cellState + "   | " + this._boardCells[7].cellState + "  | " + this._boardCells[8].cellState + "\n");
    }
}
module.exports = Board;