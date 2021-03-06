package com.techlab.game;

import com.techlab.Exception.AllReadyMarkCellException;
import com.techlab.board.Board;
import com.techlab.board.Mark;
import com.techlab.player.Player;
import com.techlab.result.analyze.Result;
import com.techlab.result.analyze.ResultAnalyze;

public class Game {
	private Player player1;
	private Player player2;
	private Board board;
	private ResultAnalyze resultAnalyze;
	private Mark playerSign;

	public Game(Player player1, Player player2) {
		if (player1.equals(null) || player2.equals(null)) {
			throw new NullPointerException();
		}
		this.player1 = player1;
		this.player2 = player2;
	}

	public void startGame() {
		board = new Board();
		resultAnalyze = new ResultAnalyze(board);
		playerSign = player1.getMark();
	}

	public void setMarkInCellOfBoard(int position) throws AllReadyMarkCellException {

		board.setBoardCellMark(position, playerSign);
		playerSign = changePlayerSign();

	}

	private Mark changePlayerSign() {
		if (playerSign.equals(Mark.X))
			return Mark.O;
		if (playerSign.equals(Mark.O))
			return Mark.X;
		return null;
	}

	public Player getCurrentPlayer() {
		if (player1.getMark().equals(playerSign))
			return player1;
		return player2;
	}

	public String getResult() {

		Result result = resultAnalyze.genrateResultState();
		if (result.equals(Result.WIN)) {
			return checkWhichPlayerIsWin();
		}
		return result.toString();
	}

	private String checkWhichPlayerIsWin() {
		if (player1.getMark().toString().equals(resultAnalyze.getWiningPlayerSign().toString())) {
			return player1.getName() + " is Win";
		}
		return player2.getName() + " is Win";
	}

}
