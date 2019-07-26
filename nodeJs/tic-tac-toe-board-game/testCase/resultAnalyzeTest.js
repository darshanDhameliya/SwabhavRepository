let assert = require('assert');
let expect = require('chai').expect;
let ResultAnalyze = require('../resultAnalyze');
let Board = require('../board');
let mark = require('../mark');

describe('mocha resultAnalyze test', () => {
    it('should throw an nullPointerException if you create object of resultAnalyze in pass null', () => {
        expect(() => new ResultAnalyze(null)).to.throw();
    });
    it('should result is win if three same mark in row', () => {
        let board = new Board();
        board.setBoardCellMark(0, mark.O);
        board.setBoardCellMark(1, mark.O);
        board.setBoardCellMark(2, mark.O);
        let resultAnalyze = new ResultAnalyze(board);

        assert.equal(resultAnalyze.genrateResultState(), 'Win');
    });
    it('should result is win if three same mark in column', () => {
        let board = new Board();
        board.setBoardCellMark(0, mark.O);
        board.setBoardCellMark(3, mark.O);
        board.setBoardCellMark(6, mark.O);
        let resultAnalyze = new ResultAnalyze(board);

        assert.equal(resultAnalyze.genrateResultState(), 'Win');
    });
    it('should result is draw if board all cell is fill', () => {
        let board = new Board();
        board.setBoardCellMark(0, mark.O);
        board.setBoardCellMark(1, mark.X);
        board.setBoardCellMark(2, mark.O);
        board.setBoardCellMark(3, mark.O);
        board.setBoardCellMark(4, mark.O);
        board.setBoardCellMark(5, mark.X);
        board.setBoardCellMark(6, mark.X);
        board.setBoardCellMark(7, mark.O);
        board.setBoardCellMark(8, mark.X);
        let resultAnalyze = new ResultAnalyze(board);

        assert.equal(resultAnalyze.genrateResultState(), 'Draw');
    });
    it('should result is in_progress if board all cell is not fill', () => {
        let board = new Board();
        board.setBoardCellMark(0, mark.O);
        board.setBoardCellMark(1, mark.X);
        board.setBoardCellMark(2, mark.O);
        let resultAnalyze = new ResultAnalyze(board);

        assert.equal(resultAnalyze.genrateResultState(), 'In_Progress');
    });

    it('should wining sign is X if X sign is Win', () => {
        let board = new Board();
        board.setBoardCellMark(0, mark.X);
        board.setBoardCellMark(1, mark.X);
        board.setBoardCellMark(2, mark.X);
        let resultAnalyze = new ResultAnalyze(board);

        resultAnalyze.genrateResultState();
        assert.equal(resultAnalyze.getWiningPlayerSign(), mark.X);
    });
});