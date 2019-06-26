package com.techlab.result.analyze;

public enum Result {
	WIN, DRAW, IN_PROGRESS;
	public String toString() {
		switch (this) {
		case WIN:
			return "Win";
		case DRAW:
			return "Draw";
		case IN_PROGRESS:
			return "In_Progress";
		}
		return null;
	}
}
