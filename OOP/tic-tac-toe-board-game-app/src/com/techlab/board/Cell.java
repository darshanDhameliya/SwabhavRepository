package com.techlab.board;

import com.techlab.Exception.AllReadyMarkCellException;

public class Cell {

	private Mark cell;

	public Cell() {
		cell = Mark.EMPTY;
	}

	public Mark getCellState() {
		return cell;
	}

	public void setCellState(Mark cell) throws AllReadyMarkCellException {
		
			if (!checkEmptyCell(cell))
				throw new AllReadyMarkCellException("cell is allready fill");
		
		this.cell = cell;
	}

	private boolean checkEmptyCell(Mark cell) {
		if (this.cell.equals(Mark.EMPTY))
			return true;
		return false;
	}
}
