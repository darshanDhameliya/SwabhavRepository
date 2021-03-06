package com.techlab.result.analyze;


import com.techlab.board.Board;
import com.techlab.board.Cell;

public class ResultAnalyze {
	private Board board;
	private Cell[] boardCells = new Cell[9];
	private int MAXIMUM_POSITION_BOARD = 9;
	private String winingSign = null;

	public ResultAnalyze(Board board) {
		if (board.equals(null))
			throw new NullPointerException();
		this.board = board;
	}

	public Result genrateResultState() {
		boardCells = board.getBoardState();
		if (checkResultWinMatch())
		{
			return Result.WIN;
		}	
		if (checkDrawMatchOrInProgress().equals("Draw")&&!checkResultWinMatch()) {
			return Result.DRAW;
		}
		return Result.IN_PROGRESS;
	}

	public String getWiningPlayerSign()
	{
		return winingSign;
	}

	private String checkDrawMatchOrInProgress() {
		for (Cell cell : boardCells) {
			if (cell.getCellState().toString().equals("-")) {
				return "In-Progress";
			}
		}
		return "Draw";
	}

	private boolean checkResultWinMatch() {
		checkDiagonalPatternCreate();
		if (winingSign == null)
			checkVerticalPatternCreate();
		if (winingSign == null)
			checkHorizontalPatternCreate();
		if (winingSign == null)
			return false;
		return true;
	}

	private void checkHorizontalPatternCreate() {
		int startPosition = 0;
		int increasePosition = 1;
		int increaseStartposition = 3;
		winingSign = checkPattern(startPosition, increasePosition, increaseStartposition);

	}

	private void checkDiagonalPatternCreate() {
		int startPosition = 0;
		int increasePosition = 4;
		int increaseStartposition = 4;
		winingSign = checkPattern(startPosition, increasePosition, increaseStartposition);
		if (winingSign != null)
			return;

		startPosition = 2;
		increasePosition = 2;
		increaseStartposition = 4;
		winingSign = checkPattern(startPosition, increasePosition, increaseStartposition);
	}

	private void checkVerticalPatternCreate() {
		int startPosition = 0;
		int increasePosition = 3;
		int increaseStartposition = 1;
		winingSign = checkPattern(startPosition, increasePosition, increaseStartposition);

	}

	private String checkPattern(int startPosition, int increasePosition, int increaseStartposition) {
		for (int index = startPosition; index + increasePosition
				+ increasePosition < MAXIMUM_POSITION_BOARD; index += increaseStartposition) {
			if (boardCells[index].getCellState().equals(boardCells[index + increasePosition].getCellState())
					&& boardCells[index].getCellState()
							.equals(boardCells[index + increasePosition + increasePosition].getCellState())
					&& !boardCells[index].getCellState().toString().equals("-"))

				return boardCells[index].getCellState().toString();
		}
		return null;
	}
	
}
