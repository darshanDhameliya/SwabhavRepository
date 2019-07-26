let Player = require('./player');
let Mark = require('./mark');
let Game = require('./game');
let readlineSync = require('readline-sync');

let cellPosition;

let player1 = new Player();
let player2 = new Player();

let game = new Game(player1, player2);

let firstPlayerName = readlineSync.question('Enter First Player Name : ');
player1.name = firstPlayerName;
player1.mark = Mark.O;
let secondPlayerName = readlineSync.question('Enter Second Player Name : ');
player2.name = secondPlayerName;
player2.mark = Mark.X;

game.startGame();

while (game.getResult() == "In_Progress") {
    cellPosition = readlineSync.question('entered position : ');
    game.setMarkInCellOfBoard(cellPosition);

    game.displayBoard();
}
console.log(game.getResult());