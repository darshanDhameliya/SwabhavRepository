package com.techlab.grid.button.listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JOptionPane;

import com.techlab.Exception.AllReadyMarkCellException;
import com.techlab.game.Game;
import com.techlab.game.play.frame.GamePlayFrame;

public class GridButtonListener implements ActionListener {

	private int indexOfCell;
	private Game game;
	private GamePlayFrame frame;
	private String playerName;
	private String gameStatus;

	public GridButtonListener(Game game, GamePlayFrame frame) {
		this.game = game;
		this.frame = frame;

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		JButton clickedButton = (JButton) e.getSource();
		String buttonIndex = clickedButton.getName();

		clickedButton.setText(game.getCurrentPlayer().getMark().toString());
		indexOfCell = Integer.parseInt(buttonIndex);
		try {
			game.setMarkInCellOfBoard(indexOfCell);
		} catch (AllReadyMarkCellException e1) {
			e1.printStackTrace();
		}

		playerName = game.getCurrentPlayer().getName() + " (" + game.getCurrentPlayer().getMark().toString() + ")";
		gameStatus = game.getResult();
		frame.setCurrentPlayerNameAndGameStatus(playerName, gameStatus);

		if (!gameStatus.equals("In_Progress")) {
			JOptionPane.showMessageDialog(frame, gameStatus, "Game Result", JOptionPane.PLAIN_MESSAGE);
			frame.dispose();
		}
	}

}
