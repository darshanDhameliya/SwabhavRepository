package com.techlab.board;

public enum Mark {
	X, O, EMPTY;
	public String toString()
	{
		switch (this) {
		case X: return "X";
		case O: return "O";
		case EMPTY: return "-";
		}
		return null;
	}
}
