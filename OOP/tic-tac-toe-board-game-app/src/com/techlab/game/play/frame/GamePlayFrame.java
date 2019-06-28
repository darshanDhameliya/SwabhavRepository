package com.techlab.game.play.frame;

import java.awt.Color;
import java.awt.Font;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import com.techlab.board.Mark;
import com.techlab.game.Game;
import com.techlab.grid.button.listener.GridButtonListener;
import com.techlab.player.Player;

public class GamePlayFrame extends JFrame {
	private ArrayList<JButton> listButton = new ArrayList<JButton>();
	private int TOTAL_BUTTON = 9;
	private String buttonName;
	private int BUTTON_WIDTH = 100;
	private int BUTTON_HEIGHT = 100;
	private int buttonXPosition = 0;
	private int buttonYPosition = 105;
	private int INCREASE_BUTTON_POSITION = 105;
	private Game game;
	private GridButtonListener gridButtonListener;
	private JLabel gameStatus;
	private JLabel playerName;
	private Font markFont = new Font("Arial", Font.PLAIN, 40);
	private Font playerNameFont = new Font("Arial", Font.PLAIN, 20);

	public GamePlayFrame(Player playerOne, Player playerTwo) {
		game = new Game(playerOne, playerTwo);
		gridButtonListener = new GridButtonListener(game, this);
		game.startGame();
		this.setSize(600, 600);
		this.getContentPane().setBackground(Color.lightGray);
		this.setTitle("Game Play");
		this.setLayout(null);
		this.setVisible(true);
		setButtonAndLabel();
	}

	private void setButtonAndLabel() {
		playerName = new JLabel("current player");
		playerName.setBounds(15, 15, 150, 40);
		playerName.setFont(playerNameFont);

		gameStatus = new JLabel("game status");
		gameStatus.setBounds(15, 45, 150, 40);
		gameStatus.setFont(playerNameFont);

		this.add(gameStatus);
		this.add(playerName);

		for (int index = 0; index < TOTAL_BUTTON; index++) {
			buttonName = Integer.toString(index);
			listButton.add(new JButton(buttonName));
			listButton.get(index).setName(buttonName);
			listButton.get(index).setFont(markFont);
			listButton.get(index).addActionListener(gridButtonListener);
		}
		for (int index = 0; index < TOTAL_BUTTON; index = index + 3) {
			listButton.get(index).setBounds(buttonXPosition, buttonYPosition, BUTTON_WIDTH, BUTTON_HEIGHT);
			this.add(listButton.get(index));

			listButton.get(index + 1).setBounds(buttonXPosition + INCREASE_BUTTON_POSITION, buttonYPosition,
					BUTTON_WIDTH, BUTTON_HEIGHT);
			this.add(listButton.get(index + 1));

			listButton.get(index + 2).setBounds(buttonXPosition + INCREASE_BUTTON_POSITION + INCREASE_BUTTON_POSITION,
					buttonYPosition, BUTTON_WIDTH, BUTTON_HEIGHT);
			this.add(listButton.get(index + 2));

			buttonYPosition = buttonYPosition + INCREASE_BUTTON_POSITION;
		}

		playerName
				.setText(game.getCurrentPlayer().getName() + " (" + game.getCurrentPlayer().getMark().toString() + ")");
		gameStatus.setText(game.getResult());
	}

	public void setCurrentPlayerNameAndGameStatus(String playerName, String gameStatus) {
		this.playerName.setText(playerName);
		this.gameStatus.setText(gameStatus);
	}

}
