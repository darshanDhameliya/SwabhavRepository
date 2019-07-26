let mark = require('./mark');
let cellAllReadyMarkException = require('./cellAllReadyMarkException');

"use strict";
class Cell {
    constructor() {
        this._cell = mark.EMPTY;
    }
    set cellState(mark) {
        if (!this.checkEmptyCell(this._cell))
            throw new cellAllReadyMarkException("cell is allready fill");
        this._cell = mark;
    }
    get cellState() {
        return this._cell;
    }
    checkEmptyCell(cell) {
        if (cell == mark.EMPTY)
            return true;
        return false;
    }
}
module.exports = Cell;