package com.techlab.player;

import com.techlab.board.Mark;

public class Player {

	private String name;
	private Mark mark;

	public Player(String name, Mark mark) {
		if (name.equals(null)&&mark.equals(null))
			throw new NullPointerException();
		this.name = name;
		this.mark = mark;
	}

	public String getName() {
		return name;
	}

	public Mark getMark() {
		return mark;
	}
}
