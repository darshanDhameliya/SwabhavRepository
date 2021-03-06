package com.techlab.test.cases;

import static org.junit.Assert.*;
import org.junit.Test;

import com.techlab.Exception.AllReadyMarkCellException;
import com.techlab.board.Cell;
import com.techlab.board.Mark;

public class CellTest {
	private Cell cell = new Cell();

	@Test
	public void testCellContractor_CreateObjectOfCell_CellStateShouldBeEmpty() {
		cell = new Cell();
		String actual = cell.getCellState().toString();
		String expected = "-";
		assertEquals(expected, actual);
	}

	@Test
	public void testSetCellState_SetCellStateValueGivenInX_CellStateShouldBeX() throws AllReadyMarkCellException {
		cell.setCellState(Mark.X);
		String actual = cell.getCellState().toString();
		String expected = "X";
		assertEquals(expected, actual);
	}

	@Test
	public void testSetCellState_SetCellStateValueIsNotEmpty_ThrowAllReadyMarkCellException() throws AllReadyMarkCellException {
		cell.setCellState(Mark.X);
		cell.setCellState(Mark.O);
	}

	@Test
	public void testGetCellState_GetCellState_ResultCellStateShouldBeEmpty() {
		String actual=cell.getCellState().toString();
		String expected="-";
		assertEquals(expected, actual);
	}

}
