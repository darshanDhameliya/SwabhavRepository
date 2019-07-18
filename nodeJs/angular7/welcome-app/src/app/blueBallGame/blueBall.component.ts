import { Component } from '@angular/core';
import { IBall } from './IBall';

@Component({
    selector:'swabhav-blueBall-game',
    templateUrl:'./blueBall.component.html'
})

export class BlueBall{
    private ballList:IBall[]=[];
    private totalBall:number=50;
    private answer:number;
    private chances:number;
    private gameStatus:string;
    private rules:string[];
    private mainMenuHidden:boolean=false;
    private gameBoardHidden:boolean=true;

    constructor(){
        this.rules = ['You will get only three chances',
        'If you guess lower number than expected the balls will turn green',
        'If you guess Higher number than expected the balls will turn run'];
    };
    loadGame(){
        console.log("game load");
        this.mainMenuHidden=true;
        this.gameBoardHidden=false;
        this.chances=3;
        this.gameStatus="In Progress";
        for (let index = 0; index < this.totalBall; index++) {
            this.ballList.push({ballNumber:index+1,ballColor:"gray"});
        }  
        this.answer=Math.floor(Math.random() * Math.floor(this.totalBall+1));
        console.log("Answer Is : "+this.answer);
    }
    processPlayerInput(event) {
        
        this.checkAnswer(event.target.id);

        this.checkGameOver();
        this.chances--;
    };
    checkGameOver() {
        if (this.chances <= 1 && this.gameStatus=="In Progress"){
            this.gameStatus = "game over";
            this.ballList[this.answer-1].ballColor = '#2e86d9';
            alert("Game Over");
            this.resetGame();
        }
    };
    checkGameWin(number)
    {
        if (number == this.answer) {
            this.ballList[number - 1].ballColor = '#2e86d9';
            this.gameStatus = "win";
            alert("Win");
            this.resetGame();
        }
    }
    checkAnswer(number) {
        
        this.checkGameWin(number);
        if (number < this.answer)
        this.ballList[number - 1].ballColor = '#34a84f';
        if (number > this.answer)
        this.ballList[number - 1].ballColor = '#f22440';
    };

    resetGame(){
        setTimeout(()=>{
            window.location.reload();
        },3000);
    }
}