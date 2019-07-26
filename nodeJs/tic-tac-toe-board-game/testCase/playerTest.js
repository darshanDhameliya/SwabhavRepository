let assert = require('assert');
let Player = require('../player');
let mark = require('../mark');

describe('mocha player test', () => {
    it('should player name is darshan if set player name darshan', () => {
        let player = new Player();
        player.name = 'darshan';
        assert.equal(player.name, 'darshan');
    });
    it('should player mark is X if set player mark X', () => {
        let player = new Player();
        player.mark = mark.X;

        assert.equal(player.mark, mark.X);
    });
});