package com.techlab.test.cases;

import static org.junit.Assert.*;

import org.junit.Test;

import com.techlab.board.Mark;
import com.techlab.player.Player;

public class PlayerTest {
private Player player;
	@Test(expected=NullPointerException.class)
	public void testPlayerConstractorPassingValueNull_PassValueOfPlayerNameAndMark_ThrowNullPointerException() {
		player=new Player(null,null);
	}
	@Test
	public void testPlayerConstractorPassingValueNotNull_PassValueOfPlayerNameAndMark_ShouldNotThrowNullPointerException() {
		player=new Player("Darshan",Mark.O);
	}
	@Test
	public void testGetPlayerName_CreatePlayerObjectAndPassNameDarshan_PlayerNameValueShouldBeDarshan()
	{
		player=new Player("Darshan",Mark.O);
		
		String actual=player.getName();
		String expected="Darshan";
		assertEquals(expected, actual);
	}
	@Test
	public void testGetPlayerMark_CreatePlayerObjectAndPassMarkO_PlayerMarkValueShouldBeO()
	{
		player=new Player("Darshan",Mark.O);
		
		Mark actual=player.getMark();
		Mark expected=Mark.O;
		assertEquals(expected, actual);
	}

}
