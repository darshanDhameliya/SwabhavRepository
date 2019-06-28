package com.techlab.game.play.frame;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import com.techlab.grid.button.listener.PlayButtonListener;

public class GetPlayerInformationFrame extends JFrame {

	private Font font = new Font("Arial", Font.PLAIN, 20);
	private PlayButtonListener playButtonListener = new PlayButtonListener(this);
	private JTextField secondPlayerNameText;
	private JTextField firstPlayerNameText;
	private JLabel secondPlayerNameLabel;
	private JLabel firstPlayerNameLabel;
	private JButton playButton;

	public GetPlayerInformationFrame() {
		this.setSize(600, 600);
		this.getContentPane().setBackground(Color.lightGray);
		this.setTitle("Tic Tac Toe");
		this.setLayout(null);
		this.setVisible(true);

		playButton = new JButton("Play");
		playButton.setName("Play");
		playButton.setFont(font);
		playButton.setBounds(120, 150, 150, 50);
		playButton.addActionListener(playButtonListener);
		this.add(playButton);

		firstPlayerNameLabel = new JLabel("First Player Name : ");
		firstPlayerNameLabel.setBounds(40, 15, 200, 40);
		firstPlayerNameLabel.setFont(font);
		secondPlayerNameLabel = new JLabel("Second Player Name : ");
		secondPlayerNameLabel.setBounds(15, 75, 220, 40);
		secondPlayerNameLabel.setFont(font);

		this.add(firstPlayerNameLabel);
		this.add(secondPlayerNameLabel);

		firstPlayerNameText = new JTextField();
		firstPlayerNameText.setName("firstPlayerName");
		firstPlayerNameText.setFont(font);
		firstPlayerNameText.setBounds(240, 15, 150, 30);
		this.add(firstPlayerNameText);
		secondPlayerNameText = new JTextField();
		secondPlayerNameText.setName("secondPlayerName");
		secondPlayerNameText.setFont(font);
		secondPlayerNameText.setBounds(240, 75, 150, 30);
		this.add(secondPlayerNameText);
	}

	public String getFirstPlayerName() {
		return firstPlayerNameText.getText();
	}

	public String getSecondPlayerName() {
		return secondPlayerNameText.getText();
	}
}
