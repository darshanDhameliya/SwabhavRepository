let assert = require('assert');
let expect = require('chai').expect;

let Board = require('../board');
let Cell = require('../cell');
let mark = require('../mark');
let boardCells = [];

describe('mocha board test', () => {
    it('board all cell value should be empty when board object create', () => {
        let board = new Board();
        let boardCells = board.getBoardState();

        for (const cell of boardCells) {
            assert.equal(cell.cellState, '-');
        }
    });
    it('board in 5 index cell value should be X when board 5 index cell value set X', () => {
        let board = new Board();
        board.setBoardCellMark(5, mark.X);
        assert.equal(board.getBoardCellMark(5).cellState, mark.X);
    });

    it('should throw an indexOutOfBoundException if you try to set value of index getter than 8', () => {
        let board = new Board();
        expect(() => board.setBoardCellMark(9, mark.X)).to.throw('index out of bound');
    });
});