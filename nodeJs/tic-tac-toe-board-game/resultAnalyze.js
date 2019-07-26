'use strict';
let Board = require('./board');
let Cell = require('./cell');
let Result = require('./result');

class ResultAnalyze {
    constructor(board) {
        if (board == null)
            throw new NullPoleterException();
        this._board = board;
        this.MAXIMUM_INDEX_BOARD = 9;
        this._winingSign = null;
        this._boardCells = [];
        for (let index = 0; index < this.MAXIMUM_INDEX_BOARD; index++) {
            this._boardCells.push(new Cell());
        }
    }
    genrateResultState() {
        this._boardCells = this._board.getBoardState();
        if (this.checkResultWinMatch()) {
            return Result.WIN;
        }
        if (this.checkDrawMatchOrInProgress() == "Draw" && this.checkResultWinMatch() == false) {
            return Result.DRAW;
        }
        return Result.IN_PROGRESS;
    }

    getWiningPlayerSign() {
        return this._winingSign;
    }

    checkDrawMatchOrInProgress() {
        for (const cell of this._boardCells) {
            if (cell.cellState.toString() == "-") {
                return "In-Progress";
            }
        }
        return "Draw";
    }

    checkResultWinMatch() {
        this.checkDiagonalPatternCreate();
        if (this._winingSign == null)
            this.checkVerticalPatternCreate();
        if (this._winingSign == null)
            this.checkHorizontalPatternCreate();
        if (this._winingSign == null)
            return false;
        return true;
    }

    checkHorizontalPatternCreate() {
        let startPosition = 0;
        let increasePosition = 1;
        let increaseStartposition = 3;
        this._winingSign = this.checkPattern(startPosition, increasePosition, increaseStartposition);

    }

    checkDiagonalPatternCreate() {
        let startPosition = 0;
        let increasePosition = 4;
        let increaseStartposition = 4;
        this._winingSign = this.checkPattern(startPosition, increasePosition, increaseStartposition);
        if (this._winingSign != null)
            return;

        startPosition = 2;
        increasePosition = 2;
        increaseStartposition = 4;
        this._winingSign = this.checkPattern(startPosition, increasePosition, increaseStartposition);
    }

    checkVerticalPatternCreate() {
        let startPosition = 0;
        let increasePosition = 3;
        let increaseStartposition = 1;
        this._winingSign = this.checkPattern(startPosition, increasePosition, increaseStartposition);

    }

    checkPattern(startPosition, increasePosition, increaseStartposition) {

        for (let index = startPosition; index + increasePosition +
            increasePosition < this.MAXIMUM_INDEX_BOARD; index += increaseStartposition) {
            if (this._boardCells[index].cellState == this._boardCells[index + increasePosition].cellState &&
                this._boardCells[index].cellState == this._boardCells[index + increasePosition + increasePosition].cellState &&
                this._boardCells[index].cellState.toString() != "-")

                return this._boardCells[index].cellState.toString();
        }
        return null;
    }

}
module.exports = ResultAnalyze;