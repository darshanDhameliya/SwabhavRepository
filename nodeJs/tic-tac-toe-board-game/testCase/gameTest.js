let assert = require('assert');
let Game = require('../game');
let Player = require('../player');
let mark = require('../mark');
let expect = require('chai').expect;

let player1 = new Player();
player1.name = 'dr';
player1.mark = mark.O;
let player2 = new Player();
player2.name = 'mk';
player2.mark = mark.X;
describe('mocha game test', () => {
    it('should trow an nullPointerException if create Game object and pass null', () => {
        expect(() => new Game(null, null)).to.throw();
    });
    it('should trow an allReadyMarkException if you try to set mark on not empty cell', () => {
        let game = new Game(player1, player2);
        game.startGame();
        game.setMarkInCellOfBoard(0);
        expect(() => game.setMarkInCellOfBoard(0)).to.throw("cell is allready fill");
    });
    it('should match is draw if board in all cell fill', () => {
        let game = new Game(player1, player2);
        game.startGame();
        game.setMarkInCellOfBoard(0);
        game.setMarkInCellOfBoard(1);
        game.setMarkInCellOfBoard(2);
        game.setMarkInCellOfBoard(5);
        game.setMarkInCellOfBoard(3);
        game.setMarkInCellOfBoard(6);
        game.setMarkInCellOfBoard(4);
        game.setMarkInCellOfBoard(8);
        game.setMarkInCellOfBoard(7);
        assert.equal(game.getResult(), 'Draw');
    });
    it('should match is in_progress if board in all cell not fill', () => {
        let game = new Game(player1, player2);
        game.startGame();
        game.setMarkInCellOfBoard(0);
        game.setMarkInCellOfBoard(1);
        game.setMarkInCellOfBoard(2);
        game.setMarkInCellOfBoard(5);
        game.setMarkInCellOfBoard(3);
        assert.equal(game.getResult(), 'In_Progress');
    });
    it('should match result dr is win if dr pattern complate', () => {
        let game = new Game(player1, player2);
        game.startGame();
        game.setMarkInCellOfBoard(0);
        game.setMarkInCellOfBoard(1);
        game.setMarkInCellOfBoard(3);
        game.setMarkInCellOfBoard(4);
        game.setMarkInCellOfBoard(6);
        assert.equal(game.getResult(), 'dr is Win');
    });
    it('should dr(first player) turn over after current player is mk(second player)', () => {
        let game = new Game(player1, player2);
        game.startGame();
        game.setMarkInCellOfBoard(0);
        assert.equal(game.getCurrentPlayer().name, 'mk');
    });
});