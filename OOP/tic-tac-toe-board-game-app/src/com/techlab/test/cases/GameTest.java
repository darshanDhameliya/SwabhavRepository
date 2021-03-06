package com.techlab.test.cases;

import static org.junit.Assert.*;

import org.junit.Test;

import com.techlab.Exception.AllReadyMarkCellException;
import com.techlab.board.Mark;
import com.techlab.game.Game;
import com.techlab.player.Player;

public class GameTest {
	Player player1 = new Player("Darshan", Mark.O);
	Player player2 = new Player("Vivek", Mark.X);
	Game game = new Game(player1, player2);

	@Test(expected = NullPointerException.class)
	public void testGameConstractorPassingValueNull_PassTwoPlayerObject_ThrowNullPointerException() {
		game = new Game(null, null);
	}

	@Test
	public void testGameConstractorPassingValueNotNull_PassTwoPlayerObject_ShouldBeNotThrowNullPointerException() {
		game = new Game(player1, player2);
	}

	@Test(expected = AllReadyMarkCellException.class)
	public void testSetMarkInCellOfBoard_AllReadyCellFillAndPlayerSecondTimePutMark_ThrowAllReadyMarkCellException()
			throws AllReadyMarkCellException {
		game.startGame();
		game.setMarkInCellOfBoard(0);
		game.setMarkInCellOfBoard(0);

	}

	@Test
	public void testSetMarkInCellOfBoardAndGetResultPassPositionOfCell_BoardInAllCellFillAnyPlayerNotWin_ResultMatchIsDraw()
			throws AllReadyMarkCellException {
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

		String actual = game.getResult();
		String expected = "Draw";
		assertEquals(expected, actual);
	}

	@Test
	public void testSetMarkInCellOfBoardAndGetResultPassPositionOfCell_BoardInAllCellNotFillAnyPlayerNotWin_ResultMatchIsInProgress()
			throws AllReadyMarkCellException {
		game.startGame();
		game.setMarkInCellOfBoard(0);
		game.setMarkInCellOfBoard(1);
		game.setMarkInCellOfBoard(2);
		game.setMarkInCellOfBoard(5);
		game.setMarkInCellOfBoard(3);
		game.setMarkInCellOfBoard(6);
		game.setMarkInCellOfBoard(4);
		String actual = game.getResult();
		String expected = "In_Progress";
		assertEquals(expected, actual);
	}

	@Test
	public void testSetMarkInCellOfBoardAndGetResultPassPositionOfCell_DarshanPatternComplete_ResultDarshanIsWin()
			throws AllReadyMarkCellException {
		game.startGame();
		game.setMarkInCellOfBoard(0);
		game.setMarkInCellOfBoard(1);
		game.setMarkInCellOfBoard(3);
		game.setMarkInCellOfBoard(4);
		game.setMarkInCellOfBoard(6);

		String actual = game.getResult();
		String expected = "Darshan is Win";
		assertEquals(expected, actual);
	}

	@Test
	public void testCurrentPlayer_FirstDarshanTurnOver_ResultVivekTurn() throws AllReadyMarkCellException {
		game.startGame();
		game.setMarkInCellOfBoard(0);

		String actual = game.getCurrentPlayer().getName();
		String expected = "Vivek";
		assertEquals(expected, actual);
	}

}
