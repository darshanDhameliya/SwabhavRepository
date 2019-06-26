package com.techlab.game.test;

import java.util.Scanner;

import com.techlab.Exception.AllReadyMarkCellException;
import com.techlab.board.Mark;
import com.techlab.game.Game;
import com.techlab.player.Player;

public class GameTest {

	public static void main(String args[]) throws AllReadyMarkCellException {
		Player player1 = new Player("Darshan", Mark.O);
		Player player2 = new Player("Vivek", Mark.X);

		Scanner inputPosition = new Scanner(System.in);
		
		int cellPosition;

		Game game = new Game(player1, player2);
		game.startGame();
				
		while (game.getResult().equals("In_Progress")) {
			System.out.println("entered position : ");
			cellPosition = inputPosition.nextInt();
			game.setMarkInCellOfBoard(cellPosition);
		}
		System.out.println(game.getResult());
	}
	
}
