package com.techlab.board;

import com.techlab.Exception.AllReadyMarkCellException;

public class Board {
	private Cell[] boardCells;
	private int MAXIMUM_POSITION_BOARD = 9;

	public Board() {
		boardCells = new Cell[9];
		for (int index = 0; index < MAXIMUM_POSITION_BOARD; index++) {
			boardCells[index] = new Cell();
		}
	}

	public void setBoardCellMark(int position, Mark mark) throws AllReadyMarkCellException {
		if (!checkBoardCellPosition(position))
			throw new IndexOutOfBoundsException();
		boardCells[position].setCellState(mark);
	}

	public Cell getBoardCellMark(int position) {
		return boardCells[position];
	}

	public Cell[] getBoardState() {
		return boardCells;
	}

	private boolean checkBoardCellPosition(int position) {
		if (position < MAXIMUM_POSITION_BOARD)
			return true;
		return false;
	}
}
