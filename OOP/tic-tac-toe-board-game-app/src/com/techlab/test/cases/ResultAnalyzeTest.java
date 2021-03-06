package com.techlab.test.cases;

import static org.junit.Assert.*;

import org.junit.Test;

import com.techlab.Exception.AllReadyMarkCellException;
import com.techlab.board.Board;
import com.techlab.board.Mark;
import com.techlab.result.analyze.ResultAnalyze;

public class ResultAnalyzeTest {
	private ResultAnalyze resultAnalyze;

	@Test(expected = NullPointerException.class)
	public void testResultAnalyzeConstractorPassingValueNull_PassBoardObject_ThrowNullPointerException() {
		resultAnalyze = new ResultAnalyze(null);
	}

	@Test
	public void testResultAnalyzeConstractorPassingValueNotNull_PassBoardObject_ShouldBeNotThrowNullPointerException() {
		resultAnalyze = new ResultAnalyze(new Board());
	}

	@Test
	public void testGenrateResultState_ThreeSameMarkInRow_ResultGetResultMatchWin() throws AllReadyMarkCellException {

		Board board = new Board();
		board.setBoardCellMark(0, Mark.O);
		board.setBoardCellMark(1, Mark.O);
		board.setBoardCellMark(2, Mark.O);
		ResultAnalyze resultAnalyze = new ResultAnalyze(board);

		String actual = resultAnalyze.genrateResultState().toString();
		String expected = "Win";
		assertEquals(expected, actual);

	}

	@Test
	public void testGenrateResultState_ThreeSameMarkInColumn_ResultGetResultMatchWin()
			throws AllReadyMarkCellException {

		Board board = new Board();
		board.setBoardCellMark(0, Mark.O);
		board.setBoardCellMark(3, Mark.O);
		board.setBoardCellMark(6, Mark.O);
		ResultAnalyze resultAnalyze = new ResultAnalyze(board);

		String actual = resultAnalyze.genrateResultState().toString();
		String expected = "Win";
		assertEquals(expected, actual);

	}

	@Test
	public void testGenrateResultState_BoardAllCellIsFill_ResultGetResultMatchDraw() throws AllReadyMarkCellException {

		Board board = new Board();
		board.setBoardCellMark(0, Mark.O);
		board.setBoardCellMark(1, Mark.X);
		board.setBoardCellMark(2, Mark.O);
		board.setBoardCellMark(3, Mark.O);
		board.setBoardCellMark(4, Mark.O);
		board.setBoardCellMark(5, Mark.X);
		board.setBoardCellMark(6, Mark.X);
		board.setBoardCellMark(7, Mark.O);
		board.setBoardCellMark(8, Mark.X);
		ResultAnalyze resultAnalyze = new ResultAnalyze(board);

		String actual = resultAnalyze.genrateResultState().toString();
		String expected = "Draw";
		assertEquals(expected, actual);

	}

	@Test
	public void testGenrateResultState_BoardAllCellIsNotFill_ResultGetResultMatchInProgress()
			throws AllReadyMarkCellException {

		Board board = new Board();
		board.setBoardCellMark(0, Mark.O);
		board.setBoardCellMark(1, Mark.X);
		board.setBoardCellMark(2, Mark.O);
		ResultAnalyze resultAnalyze = new ResultAnalyze(board);

		String actual = resultAnalyze.genrateResultState().toString();
		String expected = "In_Progress";
		assertEquals(expected, actual);

	}

	@Test
	public void testGetWiningPlayerSign_BoardAllCellInPutTheMark_ResultGetResultWiningPlayerSignO()
			throws AllReadyMarkCellException {

		Board board = new Board();
		board.setBoardCellMark(0, Mark.X);
		board.setBoardCellMark(1, Mark.X);
		board.setBoardCellMark(2, Mark.X);
		board.setBoardCellMark(3, Mark.X);
		board.setBoardCellMark(4, Mark.X);
		board.setBoardCellMark(5, Mark.O);
		board.setBoardCellMark(6, Mark.O);
		board.setBoardCellMark(7, Mark.X);
		board.setBoardCellMark(8, Mark.X);
		ResultAnalyze resultAnalyze = new ResultAnalyze(board);

		resultAnalyze.genrateResultState();
		String actual = resultAnalyze.getWiningPlayerSign();
		String expected = "X";

		assertEquals(expected, actual);
	}

}
