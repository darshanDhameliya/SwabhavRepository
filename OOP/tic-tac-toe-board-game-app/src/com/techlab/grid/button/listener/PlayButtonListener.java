package com.techlab.grid.button.listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;

import com.techlab.board.Mark;
import com.techlab.game.play.frame.GamePlayFrame;
import com.techlab.game.play.frame.GetPlayerInformationFrame;
import com.techlab.player.Player;

public class PlayButtonListener implements ActionListener {
	private Player firstPlayer;
	private Player secondPlayer;
	private String firstPlayerName;
	private String secondPlayerName;
	private GetPlayerInformationFrame getPlayerInformationFrame;

	public PlayButtonListener(GetPlayerInformationFrame getPlayerInformationFrame) {
		this.getPlayerInformationFrame=getPlayerInformationFrame;
	}

	@Override
	public void actionPerformed(ActionEvent e) {

		firstPlayerName=getPlayerInformationFrame.getFirstPlayerName();
		secondPlayerName=getPlayerInformationFrame.getSecondPlayerName();
		firstPlayer = new Player(firstPlayerName, Mark.O);
		secondPlayer = new Player(secondPlayerName, Mark.X);
		getPlayerInformationFrame.dispose();
		GamePlayFrame gamePlayFrame = new GamePlayFrame(firstPlayer, secondPlayer);

	}

}
