package com.techlab.test.cases;

import static org.junit.Assert.*;

import org.junit.Test;

import com.techlab.Exception.AllReadyMarkCellException;
import com.techlab.board.Board;
import com.techlab.board.Cell;
import com.techlab.board.Mark;

public class BoardTest {
	private Board board = new Board();

	@Test
	public void testBoardConstractor_CreateObjectOfBoard_BoardAllCellValueShouldBeEmpty() {
		board = new Board();
		Cell[] actuals = board.getBoardState();
		String expected = "-";
		for (Cell actual : actuals) {
			assertEquals(expected, actual.getCellState().toString());
		}
	}

	@Test
	public void testSetBoardCellValue_SetBoard5IndexCellValueGivenInX_ResultBoard5IndexCellValueShouldBeX() throws AllReadyMarkCellException {
		int cellIndex = 5;
		board.setBoardCellMark(cellIndex, Mark.X);
		Cell actual = board.getBoardCellMark(cellIndex);
		String expected = "X";
		assertEquals(expected, actual.getCellState().toString());
	}

	@Test(expected = IndexOutOfBoundsException.class)
	public void testSetBoardCellValue_SetBoard9IndexCellValueGivenInX_ThrowIndexOutOfBoundException() throws AllReadyMarkCellException {
		int cellIndex = 9;
		board.setBoardCellMark(cellIndex, Mark.X);
	}

	@Test
	public void testGetBoardCellValue_GetValue5IndexCellOfBoard_ResultBoard5IndexCellValueShouldBeX() throws AllReadyMarkCellException {
		int cellIndex = 5;
		board.setBoardCellMark(cellIndex, Mark.X);
		Cell actual = board.getBoardCellMark(cellIndex);
		String expected = "X";
		assertEquals(expected, actual.getCellState().toString());
	}

	@Test
	public void testGetBoardState_GetValueCellsOfBoard_ResultBoardCellsValueShouldBeEmpty() {
		Cell[] actuals = board.getBoardState();
		String expected = "-";
		for (Cell actual : actuals) {
			assertEquals(expected, actual.getCellState().toString());
		}
	}
}
