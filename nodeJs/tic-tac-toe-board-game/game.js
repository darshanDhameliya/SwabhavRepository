'use strict';
let Player = require('./player');
let Board = require('./board');
let ResultAnalyze = require('./resultAnalyze');
let Mark = require('./mark');
let Result = require('./result');

class Game {

    constructor(player1, player2) {
        if (player1 == null || player2 == null)
            throw new NullPointerException();
        this._player1 = player1;
        this._player2 = player2;
        this._board = null;
        this._resultAnalyze = null;
        this._playerSign = null;
        this._result = null;
    }
    startGame() {
        this._board = new Board();
        this._resultAnalyze = new ResultAnalyze(this._board);
        this._playerSign = this._player1.mark;
    }

    setMarkInCellOfBoard(index) {

        this._board.setBoardCellMark(index, this._playerSign);
        this._playerSign = this.changePlayerSign();

    }

    changePlayerSign() {
        if (this._playerSign == Mark.X)
            return Mark.O;
        if (this._playerSign == Mark.O)
            return Mark.X;
        return null;
    }

    getCurrentPlayer() {
        if (this._player1.mark == this._playerSign)
            return this._player1;
        return this._player2;
    }
    displayBoard() {
        this._board.displayBoard();
    }

    getResult() {

        this._result = this._resultAnalyze.genrateResultState();
        if (this._result == Result.WIN)
            return this.checkWhichPlayerIsWin();

        return this._result.toString();
    }

    checkWhichPlayerIsWin() {
        if (this._player1.mark.toString() == this._resultAnalyze.getWiningPlayerSign().toString())
            return this._player1.name + " is Win";
        return this._player2.name + " is Win";
    }
}
module.exports = Game;