let assert = require('assert');
let expect = require('chai').expect;

let cellAllReadyMarkException = require('../cellAllReadyMarkException');
let Cell = require('../cell');
let mark = require('../mark');

describe('mocha cell test', () => {
    it('should cell is Empty if cell object create', () => {
        let cell = new Cell();
        assert.equal(cell.cellState, '-');
    });
    it('should cellState value X if set cellState value X', () => {
        let cell = new Cell();
        cell.cellState = mark.X;
        assert.equal(cell.cellState, 'X');
    });
    it('should throw an cellAllReadyMarkException if you try to set mark on not empty cell', () => {
        let cell = new Cell();
        cell.cellState = mark.X;

        expect(() => cell.cellState = mark.X).to.throw("cell is allready fill");
    });
});